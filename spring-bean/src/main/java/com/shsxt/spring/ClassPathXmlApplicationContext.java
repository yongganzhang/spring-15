package com.shsxt.spring;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 加载配置 并且提供bean
 * 
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

	// 配置文件的地址
	// private String filePath;

	private List<Node> list = new LinkedList<Node>();

	// bean缓存池
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 构造器
	 * 
	 * @param filePath
	 */
	public ClassPathXmlApplicationContext(String filePath) {

		// 解析xml
		xmlContextReader(filePath);
		// 初始化bean
		initBeanPool();

	}

	public Object getBean(String name) {
		return map.get(name);
	}

	/**
	 * 解析xml
	 * 
	 * @param path
	 */
	private void xmlContextReader(String path) {
		// 创建SaxReader
		SAXReader sax = new SAXReader();
		// 创建Docment
		try {
			Document doc = sax.read(new File(path));
			// 获取根元素
			Element rootElement = doc.getRootElement();
			Iterator<Element> itor = rootElement.elementIterator();

			while (itor.hasNext()) {
				Element ele = itor.next();
				String id = ele.attributeValue("id");
				String c = ele.attributeValue("class");
				//
				Node node = new Node(id, c);
				list.add(node);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化bean
	 */
	private void initBeanPool() {
		try {
			for (Node node : list) {
				String claz = node.claz;
				// 反射获取对象
				Class<?> clz = Class.forName(claz);
				// 对象
				Object obj = clz.newInstance();
				map.put(node.id, obj);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
