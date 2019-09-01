package cn.edu.cqupt.mislab.excellentroom.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 获取数据
 * @author: 宋丽
 * @create: 2019-08-25 14:55
 **/
public class GetUtil {
    /**
     * 从session里获取projectId
     * @return
     */
    public static String getProjectId(HttpServletRequest request){
        HttpSession httpSession =  request.getSession();
        String projectId = (String)httpSession.getAttribute("projectId");
        return projectId;
    }

}
