package com.chinasofti.GD;



import java.util.Properties;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.chinasofti.GD.realm.UserRealm;
import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MyConfiguration { 
	/*
	@Bean // 定义Bean
	@Primary // 主要的候选者
	@ConfigurationProperties(prefix="spring.datasource") // 配置属性
	public DataSource getDataSource(){
		return DataSourceBuilder.create() // 创建数据源构建对象
				.type(ComboPooledDataSource.class) // 设置数据源类型
				.build(); // 构建数据源对象
	}
	
	/** 定义创建Session工厂Bean的方法 */
	/*@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
		//定义MyBatis的Session工厂对象，用于产生MyBatis全局的会话工厂
	    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	    //设置数据源
	    sqlSessionFactoryBean.setDataSource(getDataSource());
	   // 分页拦截器的配置信息
	    Properties properties = new Properties();
	    properties.setProperty("reasonable", "true");
	    properties.setProperty("supportMethodsArguments", "true");
	    properties.setProperty("pageSizeZero", "true");
	    //创建分页拦截器
	    PageInterceptor interceptor = new PageInterceptor();
	    interceptor.setProperties(properties);
	    //添加分页拦截器
	    sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor});
	    return sqlSessionFactoryBean;
	
	}
	*/
	
	// 配置安全管理器
	@Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager(
    		@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
	
	// 配置Shiro过滤器工厂
	@Bean
    public ShiroFilterFactoryBean shiroFilter(
    		@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 注册安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        
     // 当用户访问认证资源的时候，如果用户没有登录，那么就会跳转到该属性指定的页面
      //  shiroFilterFactoryBean.setLoginUrl("/views/GD/login.html");
        // 当用户访问未授权资源的时候，那么就会跳转到该属性指定的页面
       // shiroFilterFactoryBean.setUnauthorizedUrl("/views/GD/login.html");
        // 定义资源访问规则
       // LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        
       // linkedHashMap.put("/*.html", "login");
        
        return shiroFilterFactoryBean;
	}
	@Bean
	public UserRealm userRealm(){
		return new UserRealm();
	}
	
	
	// 启用Shiro的注解功能
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	    DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
	    defaultAAP.setProxyTargetClass(true);
	    return defaultAAP;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
	    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor 
	    	= new AuthorizationAttributeSourceAdvisor();
	    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
	    return authorizationAttributeSourceAdvisor;
	}
	
	@Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        factory.setMaxFileSize("4096KB");
        factory.setMaxRequestSize("4096KB");
        return factory.createMultipartConfig();
    }
	
	
	
	//websocket即时会话
	    @Bean
	    public ServerEndpointExporter serverEndpointExporter() {
	        System.out.println(">>>>>>>>>>>>>>>>>启用 WebSocket");
	        return new ServerEndpointExporter();
	    }
}




