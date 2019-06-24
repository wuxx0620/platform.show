package com.sureal.shiro;

import com.sureal.session.RedisSessionDAO;
import com.sureal.session.ShiroSessionFactory;
import com.sureal.session.ShiroSessionManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Wuxx
 * @date 2019/4/17 10:04
 * @PackageName com.sureal.config
 * @ClassName ShiroConfig
 * @Description
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /*创建SecurityManager*/
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /*登录页面*/
        shiroFilterFactoryBean.setLoginUrl("/login");
        /*设置无权限时跳转的Url*/
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        /*设置拦截器*/
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        /*静态资源不拦截*/
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/imags/**", "anon");
        /*URL控制*/
        filterChainDefinitionMap.put("/login/**", "anon");
        filterChainDefinitionMap.put("/product", "anon");
        filterChainDefinitionMap.put("/about", "anon");
        filterChainDefinitionMap.put("/introduce1", "anon");
        filterChainDefinitionMap.put("/introduce2", "anon");
        filterChainDefinitionMap.put("/introduce3", "anon");
        filterChainDefinitionMap.put("/channel", "anon");
        filterChainDefinitionMap.put("/joinUs", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        /*除上以为所有Url都必须认证通过才可以访问*/
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截成功");
        return shiroFilterFactoryBean;
    }

    /**
     * SecurityManager 登录，登出，权限，Session的管理
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        /*设置Realm*/
        securityManager.setRealm(ShiroRealm());
//        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Autowired
    @Qualifier("shiro_redis")
    private RedisTemplate redisTemplate;

    /**
     * RedisSessionDAO
     *
     * @return
     */
    @Bean(name = "redisSessionDAO")
    public RedisSessionDAO SessionDAO() {
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setRedisManager(redisTemplate);
        return sessionDAO;
    }

    /**
     * 设置Cookie
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("ssid");
        simpleCookie.setHttpOnly(false);
        simpleCookie.setMaxAge(3600 * 24 * 7);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     *
     * @return
     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager() {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        return cookieRememberMeManager;
//    }

    @Bean
    public ShiroSessionFactory sessionFactory() {
        return new ShiroSessionFactory();
    }

    /**
     * SessionManager session管理
     *
     * @return
     */
    @Bean(name = "ShiroSessionManager")
    public SessionManager sessionManager() {
        ShiroSessionManager sessionManager = new ShiroSessionManager();
        sessionManager.setSessionDAO(SessionDAO());
        sessionManager.setGlobalSessionTimeout(3600 * 1000 * 24 * 7);
//        //取消URL后的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(rememberMeCookie());
        sessionManager.setSessionFactory(sessionFactory());
        return sessionManager;
    }

    /**
     * 注入自定义身份认证Realm
     *
     * @return
     */
    @Bean
    public Realm ShiroRealm() {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        System.out.println("MyRealm注入成功");
        return myRealm;
    }


    /**
     * 注入密码匹配器
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setHashSalted(true);
        return hashedCredentialsMatcher;
    }
}
