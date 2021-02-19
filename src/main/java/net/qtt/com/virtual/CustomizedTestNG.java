package net.qtt.com.virtual;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class CustomizedTestNG {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{Run2.class});
        testng.addListener((ITestNGListener) tla);
        testng.run();
        System.out.println("test results:");
        for (ITestResult r : tla.getPassedTests()) {
            System.out.println(r.getName() + " is Passed.");
        }
        for (ITestResult r : tla.getFailedTests()) {
            System.out.println(r.getName() + " is Failed.");
        }
    }
}
