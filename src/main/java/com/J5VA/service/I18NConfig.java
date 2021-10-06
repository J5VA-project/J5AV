<<<<<<< HEAD
//package com.J5VA.service;
//
//import java.util.Locale;
//
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//
//@Configuration
//public class I18NConfig implements WebMvcConfigurer {
//	@Bean("messageSource")
//	public MessageSource getMessageSource() {
//		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
//		ms.setBasenames("classpath:i18n/global", "classpath:i18n/global");
//		ms.setDefaultEncoding("utf-8");
//		return ms;
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//	LocaleChangeInterceptor locale = new LocaleChangeInterceptor();
//	locale.setParamName("lang");
//	registry.addInterceptor(locale).addPathPatterns("/**");
//	}
//	@Bean("localeResolver")
//	public LocaleResolver getLocaleResolver() {
//	CookieLocaleResolver resolver = new CookieLocaleResolver();
//	resolver.setDefaultLocale(new Locale("vi"));
//	resolver.setCookieMaxAge(10*24*60*60); // 10 ngày
//	resolver.setCookiePath("/");
//	return resolver; }
//	
//}
=======
package com.J5VA.service;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class I18NConfig implements WebMvcConfigurer{
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setDefaultEncoding("utf-8");
		ms.setBasenames("classpath:i18n/messages","classpath:i18n/global");
		return ms;
	}
	
	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver cookie = new CookieLocaleResolver();
		cookie.setDefaultLocale(new Locale("en"));
		cookie.setCookiePath("/");
		cookie.setCookieMaxAge(10*24*60*60);
		return cookie;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		registry.addInterceptor(lci).addPathPatterns("/**").excludePathPatterns("/images/**");
	}
}
>>>>>>> ea8cfbd0c18d8407eb701d3cc7b7c77a91147266
