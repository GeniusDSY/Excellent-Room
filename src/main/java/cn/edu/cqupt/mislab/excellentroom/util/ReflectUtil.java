package cn.edu.cqupt.mislab.excellentroom.util;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 反射的工具集，主要用于对对象的复制操作
 */
public class ReflectUtil {

    /*
     ******************************************************
     * 基础的用于支持反射解析的解析结果缓存，使用软引用实现
     ******************************************************
     */
    private static final Map<Class<?>,SoftReference<Map<String,Field>>> resolvedClassCache = new ConcurrentHashMap<>();

    /*
     ****************************************
     * 获取一个对象指定条件字段名称的工具方法
     ****************************************
     */

    /**
     * 获取一个对象里面字段为null的字段名称集合
     */
    public static String[] getNullValueFieldNames(Object source){

        //非空校验：NullPointerException
        Objects.requireNonNull(source);

        Class<?> sourceClass = source.getClass();

        //从缓存里面获取，如果缓存里面没有就会进行第一次反射解析
        Map<String,Field> classFieldMap = getClassFieldMapWithCache(sourceClass);

        List<String> nullValueFieldNames = new ArrayList<>();

        classFieldMap.forEach(
                (fieldName,field) -> {

                    try{
                        //挑选出值为null的字段名称
                        if(field.get(source) == null){
                            nullValueFieldNames.add(fieldName);
                        }
                    }catch(IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
        );

        return nullValueFieldNames.toArray(new String[]{});
    }

    /**
     * 获取一个对象里面字段不为null的字段名称集合
     */
    public static String[] getNonNullValueFieldNames(Object source){

        //非空校验
        Objects.requireNonNull(source);

        //获取空值字段名称
        String[] nullValueFieldNames = getNullValueFieldNames(source);

        Map<String,Field> classFieldMap = getClassFieldMapWithCache(source.getClass());

        //获取全部的字段名称，因为原数据没办法修改，所以需要重新建立一个集合来进行判断
        Set<String> allFieldNames = new HashSet<>(classFieldMap.keySet());

        //移除掉值为null的字段名称
        allFieldNames.removeAll(Arrays.asList(nullValueFieldNames));

        return allFieldNames.toArray(new String[]{});
    }

    /*
     ***************************************************************
     * 复制一个对象的相关工具方法，注意事项如下：
     * 1、只能复制字段名称相同且数据类型兼容的字段数据
     * 2、只能复制这个对象实际类（运行时动态类型）里面声明的各种字段
     ***************************************************************
     */

    /**
     * 将一个对象里面字段相同、类型兼容的数据复制到另外一个对象去
     * 1、只复制类的运行时类型的声明的全部访问权限的字段
     * @param source：从这个对象复制
     * @param target：复制到这个对象来
     */
    public static void copyPropertiesSimple(Object source,Object target){

        copyObjectProperties(
                source,new HashMap<>(getClassFieldMapWithCache(source.getClass())),
                target,new HashMap<>(getClassFieldMapWithCache(target.getClass())));
    }

    /**
     * 除实现 copyPropertiesSimple 的功能外，会忽略掉原对象的指定字段的复制
     * @param ignoreFieldNames：需要忽略的原对象字段名称集合
     */
    public static void copyPropertiesWithIgnoreSourceFields(Object source,Object target,String ...ignoreFieldNames){

        Map<String,Field> sourceFieldMap = new HashMap<>(getClassFieldMapWithCache(source.getClass()));

        filterByFieldName(sourceFieldMap,ignoreFieldNames);

        copyObjectProperties(source,sourceFieldMap,target,new HashMap<>(getClassFieldMapWithCache(target.getClass())));
    }

    /**
     * 除实现 copyPropertiesSimple 的功能外，会忽略掉原对象字段值为null的字段
     */
    public static void copyPropertiesWithNonNullSourceFields(Object source,Object target){

        Map<String,Field> sourceFieldMap = new HashMap<>(getClassFieldMapWithCache(source.getClass()));

        filterByFieldValue(source,sourceFieldMap,true);

        copyObjectProperties(source,sourceFieldMap,target,new HashMap<>(getClassFieldMapWithCache(target.getClass())));
    }

    /**
     * 除实现 copyPropertiesSimple 的功能外，会忽略掉目标对象的指定字段的复制
     * @param ignoreFieldNames：需要忽略的原对象字段名称集合
     */
    public static void copyPropertiesWithIgnoreTargetFields(Object source,Object target,String ...ignoreFieldNames){

        Map<String,Field> targetFieldMap = new HashMap<>(getClassFieldMapWithCache(target.getClass()));

        filterByFieldName(targetFieldMap,ignoreFieldNames);

        copyObjectProperties(source,new HashMap<>(getClassFieldMapWithCache(source.getClass())),target,targetFieldMap);
    }

    /**
     * 除实现 copyPropertiesSimple 的功能外，如果目标对象的属性值不为null将不进行覆盖
     */
    public static void copyPropertiesWithTargetFieldNonOverwrite(Object source,Object target){

        Map<String,Field> targetFieldMap = new HashMap<>(getClassFieldMapWithCache(target.getClass()));

        filterByFieldValue(target,targetFieldMap,false);

        copyObjectProperties(source,new HashMap<>(getClassFieldMapWithCache(source.getClass())),target,targetFieldMap);
    }

    /**
     * 进行复制的完全定制复制
     * @param source：源对象
     * @param target：目标对象
     * @param ignoreSourceFieldNames：需要忽略的原对象字段名称集合
     * @param ignoreTargetFieldNames：要忽略的目标对象字段集合
     * @param isSourceFieldValueNullAble：是否在源对象的字段为null的时候仍然进行赋值
     * @param isTargetFiledValueOverwrite：是否在目标对象的值不为null的时候仍然进行赋值
     */
    public static void copyPropertiesWithConditions(Object source,Object target
            ,String[] ignoreSourceFieldNames,String[] ignoreTargetFieldNames
            ,boolean isSourceFieldValueNullAble,boolean isTargetFiledValueOverwrite){

        Map<String,Field> sourceFieldMap = new HashMap<>(getClassFieldMapWithCache(source.getClass()));
        Map<String,Field> targetFieldMap = new HashMap<>(getClassFieldMapWithCache(target.getClass()));

        if(!isSourceFieldValueNullAble){

            filterByFieldValue(source,sourceFieldMap,true);
        }

        if(!isTargetFiledValueOverwrite){

            filterByFieldValue(target,targetFieldMap,false);
        }

        filterByFieldName(sourceFieldMap,ignoreSourceFieldNames);

        filterByFieldName(targetFieldMap,ignoreTargetFieldNames);

        copyObjectProperties(source,sourceFieldMap,target,targetFieldMap);
    }

    /*
     ******************************
     * 内部工具方法或者内部兼容方法
     ******************************
     */

    /**
     * 同步解析字节码对象，将解析的结果放入到缓存 1、解析后的字段对象全部 accessAble
     * 1、返回的集合不支持修改，要修改请记得自己重新建一个复制的副本
     * @param sourceClass：需要解析的字节码对象
     */
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public static Map<String,Field> resolveClassFieldMap(final Class<?> sourceClass){

        SoftReference<Map<String,Field>> softReference = resolvedClassCache.get(sourceClass);

        //判断是否已经被初始化
        if(softReference == null || softReference.get() == null){

            //对同一个字节码对象的解析是同步的，但是不同字节码对象的解析是并发的
            synchronized(sourceClass){

                softReference = resolvedClassCache.get(sourceClass);

                if(softReference == null || softReference.get() == null){

                    Map<String,Field> fieldMap = new HashMap<>();

                    /*
                    Returns an array of Field objects reflecting all the fields declared by the class or interface represented by this
                    Class object. This includes public, protected, default access, and private fields, but excludes inherited fields
                    */
                    Field[] declaredFields = sourceClass.getDeclaredFields();

                    if(declaredFields != null && declaredFields.length > 0){

                        for(Field field : declaredFields){

                            /*
                            Set the accessible flag for this object to the indicated boolean value.
                            */
                            field.setAccessible(true);

                            fieldMap.put(field.getName(),field);
                        }
                    }

                    //设置为不变Map
                    fieldMap = Collections.unmodifiableMap(fieldMap);

                    softReference = new SoftReference<>(fieldMap);

                    /*
                    更新缓存，将解析后的数据加入到缓存里面去
                     */
                    resolvedClassCache.put(sourceClass,softReference);

                    return fieldMap;
                }
            }
        }

        /*
        运行到这里来的时候要么早就存在，要么就是已经被其他的线程给初始化了
         */
        return softReference.get();
    }

    /**
     * 确保正确的从缓存里面获取解析后的数据
     * 1、返回的集合不支持修改，要修改请记得自己重新建一个复制的副本
     * @param sourceClass：需要解析的字节码对象
     */
    public static Map<String,Field> getClassFieldMapWithCache(Class<?> sourceClass){

        //查看缓存里面有没有已经解析完毕的现成的数据
        SoftReference<Map<String,Field>> softReference = resolvedClassCache.get(sourceClass);

        //确保classFieldMap的正确初始化和缓存
        if(softReference == null || softReference.get() == null){

            //解析字节码对象
            return resolveClassFieldMap(sourceClass);
        }else {

            //从缓存里面正确的取出数据
            return softReference.get();
        }
    }

    /**
     * 将一个可变参数集合转换为List集合，当为空的时候返回空集合
     */
    public static <T> List<T> resolveArrayToList(T ...args){

        List<T> result = new ArrayList<>();

        if(args != null && args.length > 0){

            result = Arrays.asList(args);
        }

        return result;
    }

    /**
     * 进行属性的基本复制操作
     * @param source：源对象
     * @param sourceFieldMap：原对象解析结果
     * @param target：目标对象
     * @param targetFieldMap：目标对象解析结果
     */
    public static void copyObjectProperties(Object source,Map<String,Field> sourceFieldMap,Object target,Map<String,Field> targetFieldMap){

        //进行属性值复制
        sourceFieldMap.forEach(
                (fieldName,sourceField) -> {

                    //查看目标对象是否存在这个字段
                    Field targetField = targetFieldMap.get(fieldName);

                    if(targetField != null){

                        try{
                            //对目标字段进行赋值操作
                            targetField.set(target,sourceField.get(source));
                        }catch(IllegalAccessException e){
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    /**
     * 忽略掉对象里面的某些字段
     */
    public static void filterByFieldName(Map<String,Field> fieldMap,String ... ignoreFieldNames){

        //需要忽略的对象字段
        List<String> ignoreNames = ReflectUtil.<String>resolveArrayToList(ignoreFieldNames);

        //移除忽略的对象字段
        fieldMap.keySet().removeAll(ignoreNames);
    }

    /**
     * 忽略掉非空的字段或者空的字段
     */
    public static void filterByFieldValue(Object object,Map<String,Field> fieldMap,boolean filterNullAble){

        Iterator<String> iterator = fieldMap.keySet().iterator();

        if(filterNullAble){

            while(iterator.hasNext()){

                try{
                    //移除值为null的字段
                    if(fieldMap.get(iterator.next()).get(object) == null){
                        iterator.remove();
                    }
                }catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }else {

            while(iterator.hasNext()){

                try{
                    //移除字段不为null的字段
                    if(fieldMap.get(iterator.next()).get(object) != null){
                        iterator.remove();
                    }
                }catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
