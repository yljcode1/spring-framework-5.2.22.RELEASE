package com.yao.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AbstractApplicationContextImpl extends ClassPathXmlApplicationContext {

	public AbstractApplicationContextImpl(String parent) {
		super(parent);
	}

	// 继承AbstractXmlApplicationContext实现的子类可以重写initPropertySources方法，可以在启动时候设置一些属性
	@Override
	protected void initPropertySources() {
		logger.info("---在refresh方法里面尝试重写initPropertySources()方法");
		ConfigurableEnvironment environment = getEnvironment();
		// 在加载的时候将name属性设置进去
		environment.getSystemProperties().put("name", "yaolijun");

	}
}
