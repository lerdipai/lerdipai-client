package com.lerdipai.client.util;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import com.icafebutler.framework.util.DateUtil;
import com.icafebutler.framework.util.StringUtil;

public class SpringBeanUtil implements ApplicationContextAware, ServletContextAware {
	private static ApplicationContext applicationContext;
	private String localPath;
	private String staticPath;

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静�?�变�?.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringBeanUtil.applicationContext = applicationContext; // NOSONAR
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋�?�对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋�?�对象的类型. 如果有多个Bean符合Class, 取出第一�?.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		checkApplicationContext();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 清除applicationContext静�?�变�?.
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicaitonContext未注�?,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

	@Override
	public void setServletContext(ServletContext context) {
		if(StringUtil.isNotBlank(localPath)){
			context.setAttribute("localPath", localPath);
		}
		if(StringUtil.isNotBlank(staticPath)){
			context.setAttribute("staticPath", staticPath);
		}
		context.setAttribute("version", DateUtil.format(new Date(), "yyyyMMddHHmm"));
	}

	public String getLocalPath() {
		return localPath;
	}
	public String getStaticPath() {
		return staticPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public void setStaticPath(String staticPath) {
		this.staticPath = staticPath;
	}
}