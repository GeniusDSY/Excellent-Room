package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.RoomType;
import cn.edu.cqupt.mislab.excellentroom.service.RoomTypeService;
import cn.edu.cqupt.mislab.excellentroom.util.FileUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HanSiyue
 * @Date 2019/8/26 下午10:59
 */

@EnableRedisHttpSession
@RestController
@RequestMapping("roomTypeManagement")
@Api("户型展示接口文档")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @Value("${filepath}")
    private String filePath;

    @PostMapping("addRoomType")
    @ApiOperation("增加户型")
    public ResultJson addRoomType(HttpServletRequest request, @RequestParam Integer type){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null||type == null){
                return ResultUtil.isNull();
            }else {
                Boolean reult = roomTypeService.addRoomType(projectId,type);
                if (reult){
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

    @DeleteMapping("deleteRoomType")
    @ApiOperation("删除户型")
    public ResultJson deleteRoomTypeById(HttpServletRequest request, @RequestParam Integer id){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null||id == null){
                return ResultUtil.isNull();
            }else {
                Boolean result = roomTypeService.deleteRoomTypeById(projectId,id);
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

    @PostMapping("updateRoomType")
    @ApiOperation("切换户型")
    public ResultJson updateRoomType(HttpServletRequest request, @RequestParam Integer type){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (type==null||projectId==null){
                return ResultUtil.isNull();
            }else {
                request.getSession().setAttribute("RoomType",type);
                RoomType roomType = roomTypeService.selectRoomTypeById(projectId,type);
                return ResultUtil.success(roomType);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("addSimplePic")
    @ApiOperation("增加样板间图片")
    public ResultJson addSimplePic(HttpServletRequest request, @RequestParam(value = "file") MultipartFile imageFile){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            Integer type = (Integer) request.getSession().getAttribute("RoomType");
            if (projectId==null||type==null||imageFile.isEmpty()){
                return ResultUtil.isNull();
            }else {
                FileUtil.upload(imageFile, filePath);
                Boolean result = roomTypeService.addSimplePic(projectId,type,FileUtil.fileUrl(imageFile, filePath));
                if (result){
                    return ResultUtil.success(FileUtil.fileUrl(imageFile, filePath));
                }else {
                    return ResultUtil.error();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @DeleteMapping("deleteSimplePic")
    @ApiOperation("删除样板间图片")
    public ResultJson deleteSimplePicById(HttpServletRequest request,@RequestParam Integer id){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId==null||id==null){
                return ResultUtil.isNull();
            }else {
                Boolean result = roomTypeService.deleteSimplePicById(projectId,id);
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

    @PostMapping("updateLayout")
    @ApiOperation("修改户型图片")
    public ResultJson updateLayout(HttpServletRequest request,@RequestParam(value = "file") MultipartFile imageFile){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            Integer type = (Integer) request.getSession().getAttribute("RoomType");
            if (projectId==null||type==null||imageFile.isEmpty()){
                return ResultUtil.isNull();
            }else {
                FileUtil.upload(imageFile, filePath);
                RoomType roomType = roomTypeService.updateLayout(projectId,type,FileUtil.fileUrl(imageFile, filePath));
                return ResultUtil.success(roomType.getLayoutUrl());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("updatePanorama")
    @ApiOperation("修改全景图图片")
    public ResultJson updatePanorama(HttpServletRequest request, @RequestParam(value = "file") MultipartFile vrFile){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            Integer type = (Integer) request.getSession().getAttribute("RoomType");
            if (projectId==null||type==null||vrFile.isEmpty()){
                return ResultUtil.isNull();
            }else {
                FileUtil.upload(vrFile, filePath);
                RoomType roomType = roomTypeService.updatePanorama(projectId,type,FileUtil.fileUrl(vrFile, filePath));
                return ResultUtil.success(roomType.getPanoramaUrl());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("getSimplePic")
    @ApiOperation("展示样板间图片")
    public ResultJson selectSimplePicById(HttpServletRequest request, @RequestParam Integer id){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (id==null||projectId==null){
                return ResultUtil.isNull();
            }else {
                RoomType roomType = roomTypeService.selectSimplePicById(projectId,id);
                return ResultUtil.success(roomType.getSimplePicUrl());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}
