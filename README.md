# <center>优房</center>

## 分支命名

- 后端

  - 每一个人新建自己的开发分支(例如：hsy-dev、sl-dev)
  - 每隔一段时间向dev分支发起pull request，我审核通过后进行merge，否则打回
  - commit要有意义

- 前端

  - 除了命名是 front-wss-dev之外 其他要求同上

## 项目结构

```$xslt
└─excellentroom
  ├─config
  ├─constant
  ├─controller
  ├─dao
  ├─damain
  │ ├─dto
  │ ├─po
  │ └─vo
  ├─exception
  ├─service
  │ └─impl
  └─util
```

## 项目结构说明

- config 

    存放自定义配置

- constant

    项目中有很多地方需要常量，为了避免魔法值，我们将这些常量以接口或者枚举的方式定义在这个包下

- dao

    数据库访问层，映射mapper文件，连通数据库

- exception

    异常处理，自定义异常并进行全局异常处理，将出现的异常拦截，根据自己的方式进行处理返回

- service 

    逻辑处理层

- util 

    工具包，可以复用的函数存放处

## 注意

- 单元测试必须要写，使用MySQL回滚技术

    - dao层测试

- 接口测试使用swagger2

- 尽量做好日志的记录
- 编码规范按照阿里巴巴编码规范进行(idea有一个阿里巴巴编码规范插件)
- dao层、service层，写接口函数时需要添加注释；util包下添加工具类 也需要添加相应的注释
- 变量命令能够做到间其名知其义；希望函数能够单一责任，即一个函数只完成一个功能
- 最好在编码过程是使用lamda表达式
- 单元测试做完整
- git 我们都在dev分支上进行开发，记得当你准备开始进行coding的时候，一定切换到dev分支
- git的每次的提交，我不要求别的但是我希望每次的提交能够写清楚你这次的提交完成的工作
