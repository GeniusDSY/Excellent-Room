package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.dao.CompanyProfilesDao;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.po.CompanyProfiles;
import cn.edu.cqupt.mislab.excellentroom.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业简述相关服务的实现
 * @author: 宋丽
 * @create: 2019-08-16 07:04
 **/
@Service("Brand")
public class BrandImpl implements BrandService {
    @Autowired
    private CompanyProfilesDao companyProfilesDao;

    @Override
    public CompanyProfiles searchCompanyInformation(ProjectId projectId) {
        CompanyProfiles companyProfiles = null;
        companyProfiles.setTitle(companyProfilesDao.searchTitle(projectId));
        companyProfiles.setText(companyProfilesDao.searchText(projectId));
        companyProfiles.setViedio(companyProfilesDao.searchVideo(projectId));
        companyProfiles.setPic(companyProfilesDao.searchPic(projectId));
        return companyProfiles;
    }
}
