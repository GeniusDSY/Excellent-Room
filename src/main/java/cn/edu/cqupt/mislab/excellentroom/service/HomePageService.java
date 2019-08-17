package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;

/**
 * @Author HanSiyue
 * @Date 2019/8/14 下午9:40
 */
public interface HomePageService {
    HomePagePo updateHomePageBkground(String homePageBkgroundUrl,String projectId);
    HomePagePo updateHomePageLogo(String homePageLogoUrl,String projectId);
    HomePagePo updateHomePageIcon(String homePageIconUrl,String projectId);
}
