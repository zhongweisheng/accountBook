package fc.wpf.rest.web.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.mlb.util.SessionConfig;
import com.mlb.util.SessionUtils;

/** 
 *  
 * @ClassName: LoginListenner 
 * @Description: 登录监听类-处理同一时间只允许账号，单地点登录 
 */  
public class LoginListener implements HttpSessionAttributeListener {  
    /** 
     * 用于存放账号和session对应关系的map 
     */  
    private Map<String, HttpSession> map = new HashMap<String, HttpSession>();  
  
    /** 
     * 当向session中放入数据触发 
     */  
    public void attributeAdded(HttpSessionBindingEvent event) {  
        String name = event.getName();  
  
        if (name.equals(SessionUtils.AB_SESSION_CONFIG)) {  
        	SessionConfig sessionConfig =  (SessionConfig) event.getValue();  
        	String userId = String.valueOf(sessionConfig.getUserId());
            if (map.get(userId) != null) {  
                HttpSession session = map.get(userId);  
                session.removeAttribute(userId);  
                session.invalidate();  
            }  
            map.put(userId, event.getSession());  
        }  
  
    }  
    /** 
     * 当向session中移除数据触发 
     */  
    public void attributeRemoved(HttpSessionBindingEvent event) {  
        String name = event.getName();  
        if (name.equals(SessionUtils.AB_SESSION_CONFIG)) {  
        	SessionConfig sessionConfig =  (SessionConfig) event.getValue();  
        	String userId = String.valueOf(sessionConfig.getUserId());
            map.remove(userId);  
        }  
    }  
  
    public void attributeReplaced(HttpSessionBindingEvent event) {  
  
    }  
  
    public Map<String, HttpSession> getMap() {  
        return map;  
    }  
  
    public void setMap(Map<String, HttpSession> map) {  
        this.map = map;  
    }  
  
}