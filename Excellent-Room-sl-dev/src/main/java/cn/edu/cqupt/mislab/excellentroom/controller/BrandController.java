package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.service.impl.BrandService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: Excellent-Room-sl-dev
 * @description: 品牌概况
 * @author: 宋丽
 * @create: 2019-08-16 06:59
 **/
@Api("品牌概况")
@RestController
@RequestMapping("/brandSummarizationDisplay")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 企业简介
     * @param projectId
     * @return
     */
    @ApiOperation(value = "企业简介",notes = "查询对应项目的企业相关信息的接口")
    @RequestMapping(value = "/companyProfiles",method = RequestMethod.POST)
    public Result searchCompanyProfiles(@RequestBody ProjectId projectId){
        Result result = null;
        result = ResultUtil.success(brandService.searchCompanyInformation(projectId));
        return result;
    }


}
