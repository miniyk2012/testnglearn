package net.qtt.com.virtual;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class VirtualTestNGXml {
    public static void main(String[] args) {
        // 构造虚拟xml文件
        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("net.qtt.com.virtual.Run2"));
        test.setXmlClasses(classes) ;

        // 执行虚拟xml文件用例
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}
