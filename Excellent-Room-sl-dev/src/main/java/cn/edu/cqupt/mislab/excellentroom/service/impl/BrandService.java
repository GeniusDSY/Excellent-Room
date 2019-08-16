package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.po.CompanyProfiles;
/**
 * @author: 宋丽
 * @create: 2019-08-16 09:59
 **/
public interface BrandService {
    /**
     * 利用项目代号查找项目对应的企业的相关信息
     * @param projectId
     * @return
     */
    CompanyProfiles searchCompanyInformation(ProjectId projectId);
}
