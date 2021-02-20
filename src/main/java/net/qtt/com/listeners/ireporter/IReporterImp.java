package net.qtt.com.listeners.ireporter;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IReporterImp implements IReporter {
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> iSuites, String outputDirectory) {
        ArrayList<String> list = new ArrayList<String>();
        for (ISuite iSuite : iSuites) {
            // 分<suite>遍历
            Map<String, ISuiteResult> iSuiteResultMap = iSuite.getResults();
            System.out.println("所有执行的方法：" + iSuite.getAllInvokedMethods());
            System.out.println("获取所有@Test标注的方法：" + iSuite.getAllMethods());
            System.out.println("suiteName：" + iSuite.getName());
            System.out.println("输出路径：" + iSuite.getOutputDirectory());
            System.out.println("并发方式：" + iSuite.getParallel());
            System.out.println("参数tom的值：" + iSuite.getParameter("tom"));
            System.out.println("报告路径：" + outputDirectory);

            for (ISuiteResult iSuiteResult : iSuiteResultMap.values()) {
                // 分<test>遍历
                System.out.println("-----------");
                System.out.println(iSuiteResult);
                ITestContext iTestContext = iSuiteResult.getTestContext();
                IResultMap iResultMap = iTestContext.getPassedTests();
                IResultMap iResultMap1 = iTestContext.getFailedTests();

                Set<ITestResult> iTestResultset = iResultMap.getAllResults();
                for (ITestResult iTestResult : iTestResultset) {
                    // 每个Pass的test method结果遍历
                    System.out.println("测试方法：" + iTestResult.getTestClass().getName() + "." + iTestResult.getName());
                    System.out.println("执行结果（1-成功，2-失败，3-skip）：" + iTestResult.getStatus());
                    System.out.println("开始时间：" + iTestResult.getStartMillis());
                    System.out.println("结束时间：" + iTestResult.getEndMillis());
                }

                Set<ITestResult> iTestResultset1 = iResultMap1.getAllResults();
                for (ITestResult iTestResult1 : iTestResultset1) {
                    // 每个Failed test method结果遍历
                    System.out.println("测试方法：" + iTestResult1.getTestClass().getName() + "." + iTestResult1.getName());
                    System.out.println("执行结果（1-成功，2-失败，3-skip）：" + iTestResult1.getStatus());
                    System.out.println("开始时间：" + iTestResult1.getStartMillis());
                    System.out.println("结束时间：" + iTestResult1.getEndMillis());
                }
            }
        }
    }
}
