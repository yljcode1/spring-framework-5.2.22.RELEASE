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

	@Override
	protected void initPropertySources() {
		logger.info("---在refresh方法里面尝试重写initPropertySources()方法");
		ConfigurableEnvironment environment = getEnvironment();
		// 在加载的时候将name属性设置进去
		environment.getSystemProperties().put("name", "yaolijun");

	}
}
