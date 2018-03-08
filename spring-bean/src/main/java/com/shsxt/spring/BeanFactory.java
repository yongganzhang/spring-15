package com.shsxt.spring;

/**
 * bean工厂
 * 
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
public interface BeanFactory {
	
	/**
	 * 获取bean
	 * @param name
	 * @return
	 */
	public Object getBean(String name);

}
