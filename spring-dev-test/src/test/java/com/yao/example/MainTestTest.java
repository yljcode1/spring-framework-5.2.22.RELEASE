package com.yao.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * @author xiaoK
 * @date 2023/2/21
 */
class MainTestTest {

	@Test
	void testBeanGet() {
		// Spring Bean 加载流程
		Resource resource = new ClassPathResource("beans.xml");
		// 获取一个 BeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 定义 Bean 定义读取器
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		// 从资源文件中读取 bean
		beanDefinitionReader.loadBeanDefinitions(resource);
		// 从工厂中获取 bean
		Person user = (Person) defaultListableBeanFactory.getBean("person");

		System.out.println(user.getName());

	}
}