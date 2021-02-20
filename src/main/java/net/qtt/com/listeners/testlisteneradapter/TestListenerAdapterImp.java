package net.qtt.com.listeners.testlisteneradapter;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListenerAdapterImp extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println("xxFailure");
    }
    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        System.out.println("xxSkip");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        System.out.println("xxSuccess");
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println(this);
    }
}
