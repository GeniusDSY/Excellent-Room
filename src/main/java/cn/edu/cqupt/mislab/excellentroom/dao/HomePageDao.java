package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.HomePage;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.io.File;

@Repository
public interface HomePageDao {
    HomePage updateHomePageBkgound(@Param("homePageBkgound")String homePageBkgoundUrl);
    HomePage updateHomePageLogo(@Param("homePageLogo")String homePageLogoUrl);
    HomePage updateHomePageIcon(@Param("homePageIcon")String homePageIconUrl);
}
