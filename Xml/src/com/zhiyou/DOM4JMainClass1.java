package com.zhiyou;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JMainClass1 {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("F:\\eclipse-workspace\\Xml\\src\\A.xml");
		Element element = document.getRootElement();
		Iterator iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element book = (Element) iterator.next();
			List<Attribute> list = book.attributes();
			for (Attribute ele : list) {
				System.out.println("属性标签：" + ele.getName() + "\t属性名：" + ele.getValue());
			}
			Iterator iterator2 = book.elementIterator();
			while (iterator2.hasNext()) {
				Element bookChiled = (Element) iterator2.next();
				System.out.println("节点名字：" + bookChiled.getName() + "\t节点内容:" + bookChiled.getStringValue());
			}
		}
	}
}
