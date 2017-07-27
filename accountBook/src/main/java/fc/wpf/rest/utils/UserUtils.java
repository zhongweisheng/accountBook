package fc.wpf.rest.utils;

import java.util.List;

import lombok.Data;

/**
 * @author RYO
 * @since 2015-05-20
 * @version 1.0
 * 
 * 2015-05-22 线程无法获取同一组, 此程式暂不使用
 */

public class UserUtils {
    
//    /** user资讯 */
//    //private static FCSysUser user;
//    private static final ThreadLocal<UserInfo> userThreadLocal = new ThreadLocal<UserInfo>();
//    
//    public static void init(FCSysUser user, List<FCSysBusiness> businessInfo) {
//        if (userThreadLocal != null) {
//            UserInfo userInfo = new UserInfo();
//            userInfo.setUser(user);
//            userInfo.setBusinessInfo(businessInfo);
//            userThreadLocal.set(userInfo);
//        }
//
//    }
//
//    public static FCSysUser getUser() {
//        return  userThreadLocal.get().getUser();
//    }
//
//    public static List<FCSysBusiness> getBusinessInfo() {
//        return userThreadLocal.get().getBusinessInfo();
//    }
//
//    public static void unset() {
//        userThreadLocal.remove();
//
//    }
}

//@Data
//class UserInfo{
//    private FCSysUser user;
//    private List<FCSysBusiness> businessInfo;
//
//}
