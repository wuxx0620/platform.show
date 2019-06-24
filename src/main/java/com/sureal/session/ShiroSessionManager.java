package com.sureal.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/5/27 18:34
 * @PackageName com.sureal.shiro
 * @ClassName ShiroSessionManager
 * @Description 重写retrieveSession方法，解决多次访问Redis问题
 */
public class ShiroSessionManager extends DefaultWebSessionManager {

    public ShiroSessionManager() {
        super();
    }

    @Override
    protected Session retrieveSession(SessionKey sessionKey) {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        if (sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }
        if (request != null && sessionId != null) {
            Session session = (Session) request.getAttribute(sessionId.toString());
            if (session != null) {
                return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        if (request != null && sessionId != null) {
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }
}
