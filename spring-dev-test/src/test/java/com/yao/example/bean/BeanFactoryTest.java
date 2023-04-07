package com.yao.example.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings("deprecation")
public class BeanFactoryTest {
	@Test
	public void testSimpleBean() {

		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		MyTestBean myTestBean = xmlBeanFactory.getBean("myTestBean", MyTestBean.class);
		assertEquals("zhangSan", myTestBean.getName());
	}
}
