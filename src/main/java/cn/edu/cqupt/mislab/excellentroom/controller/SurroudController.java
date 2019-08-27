package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Landscape;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.PublicUtility;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.service.SurroundService;
import cn.edu.cqupt.mislab.excellentroom.util.FileUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/8/27 下午12:24
 */

@EnableRedisHttpSession
@RestController
@RequestMapping("surroundManagement")
@Api("楼盘周边管理接口文档")
public class SurroudController {
    @Autowired
    private SurroundService surroundService;

    @Value("${filepath}")
    private String filePath;

    @PostMapping("addLandscape")
    @ApiOperation("增加园林景观图片")
    public ResultJson addLandscape(HttpServletRequest request,@RequestParam(value = "file") MultipartFile imageFile, @RequestParam String text) {
        try {
            String projectId = (String) request.getSession().getAttribute("projectId");
            if (projectId == null || imageFile.isEmpty() || text == null) {
                return ResultUtil.isNull();
            } else {
                FileUtil.upload(imageFile, filePath);
                Boolean result = surroundService.addLandscape(projectId, FileUtil.fileUrl(imageFile, filePath), text);
                if (result) {
                    return ResultUtil.success(FileUtil.fileUrl(imageFile,filePath));
                } else {
                    return ResultUtil.error();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @DeleteMapping("deleteLandscape")
    @ApiOperation("删除样板间图片")
    public ResultJson deleteLandscapeById(HttpServletRequest request,@RequestParam Integer id){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null||id==null){
                return ResultUtil.isNull();
            }else {
                Boolean result = surroundService.deleteLandscapeById(projectId,id);
                if (result){
                    return ResultUtil.success();
                }else {
                    return ResultUtil.error();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("addPublicUtility")
    @ApiOperation("增加园林景观图片")
    public ResultJson addPublicUtility(HttpServletRequest request, @RequestParam(value = "file") MultipartFile imageFile, @RequestParam String text) {
        try {
            String projectId = (String) request.getSession().getAttribute("projectId");
            if (projectId == null || imageFile.isEmpty() || text == null) {
                return ResultUtil.isNull();
            } else {
                FileUtil.upload(imageFile, filePath);
                Boolean result = surroundService.addPublicUtility(projectId, FileUtil.fileUrl(imageFile, filePath), text);
                if (result) {
                    return ResultUtil.success(FileUtil.fileUrl(imageFile,filePath));
                } else {
                    return ResultUtil.error();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @DeleteMapping("deletePublicUtility")
    @ApiOperation("删除样板间图片")
    public ResultJson deletePublicUtilityById(HttpServletRequest request,@RequestParam Integer id){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null||id==null){
                return ResultUtil.isNull();
            }else {
                Boolean result = surroundService.deletePublicUtilityById(projectId,id);
                if (result){
                    return ResultUtil.success();
                }else {
                    return ResultUtil.error();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("findAllLandscape")
    @ApiOperation("展示所有园林景观图片")
    public ResultJson findAllLandscape(HttpServletRequest request){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null){
                return ResultUtil.isNull();
            }else {
                List<Landscape> landscapes = surroundService.findAllLandscape(projectId);
                return ResultUtil.success(landscapes);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("findAllPublicUtility")
    @ApiOperation("展示所有公共设施图片")
    public ResultJson findAllPublicUtility(HttpServletRequest request){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null){
                return ResultUtil.isNull();
            }else {
                List<PublicUtility> publicUtilities = surroundService.findAllPublicUtility(projectId);
                return ResultUtil.success(publicUtilities);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }


}
