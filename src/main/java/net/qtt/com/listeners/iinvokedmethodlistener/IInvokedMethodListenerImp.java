package net.qtt.com.listeners.iinvokedmethodlistener;

import net.qtt.com.listeners.DisableListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

/**
 * TestNG在调用方法前、后启用该监听器. 常用于日志的采集
 */
public class IInvokedMethodListenerImp implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        ConstructorOrMethod consOrMethod =method.getTestMethod().getConstructorOrMethod();
        DisableListener disable = consOrMethod.getMethod().getDeclaringClass().getAnnotation(DisableListener.class);
        if (disable != null) {
            return;
        }
        System.out.println("beforeInvocation:" + testResult.getName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation:"+testResult.getName());
    }
}
