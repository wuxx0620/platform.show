package com.sureal.session;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>类名称: SessionFactory </p>
 * <p>描述: TODO  </p>
 * <p>创建时间 : 2019年2月23日 下午4:02:28 </p>
 *
 * @author lijunliang
 * @version 1.0
 */
public class ShiroSessionFactory implements SessionFactory {
    /**
     * (non-Javadoc)
     *
     * @see SessionFactory#createSession(SessionContext)
     */
    @Override
    public Session createSession(SessionContext initData) {
        SimpleSession session = new SimpleSession();
        if (initData != null && initData instanceof WebSessionContext) {
            WebSessionContext sessionContext = (WebSessionContext) initData;
            HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
        }
        return session;
    }
}
