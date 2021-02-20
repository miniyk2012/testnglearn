package net.qtt.com.listeners.iinvokedmethodlistener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * TestNG在调用方法前、后启用该监听器. 常用于日志的采集
 */
public class IInvokedMethodListenerImp implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("beforeInvocation:" + testResult.getName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation:"+testResult.getName());
    }
}
