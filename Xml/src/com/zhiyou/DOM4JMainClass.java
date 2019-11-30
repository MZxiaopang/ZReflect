package com.zhiyou;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JMainClass {

	public static void main(String[] args) throws DocumentException {
		// 1：创建SAXreader对象
		SAXReader reader = new SAXReader();
		// 2：通过SAXreader对象 来加载xml文件
		Document document = reader.read(new File("F:\\eclipse-workspace\\Xml\\src\\A.XML"));
		// 3：获得文件中的根节点
		Element element = document.getRootElement();
		// 4：通过根元素获得一个迭代器
		Iterator iterator = element.elementIterator();
		while (iterator.hasNext()) {
			// 5：获得根节点中的第一个子节点
			Element book = (Element) iterator.next();
			// 6：获得子节点中的所有塑型特征
			List<Attribute> list = book.attributes();
			// 7：循环输出所有的属性
			for (Attribute att : list) {
				System.out.println("属性名：" + att.getName() + "  属性值：" + att.getValue());
			}
			// 8：获取子节点中的节点
			Iterator iterator2 = book.elementIterator();
			// 9：从子节点中获得其下面所有 的节点
			while (iterator2.hasNext()) {
				Element bookChild = (Element) iterator2.next();
				System.out.println("节点名称：" + bookChild.getName() + "  节点内容：" + bookChild.getStringValue());
			}
		}
	}

}
