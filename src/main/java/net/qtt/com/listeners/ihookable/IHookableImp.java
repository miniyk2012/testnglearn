package net.qtt.com.listeners.ihookable;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class IHookableImp implements IHookable {
    /*
    它在测试方法执行前提供了切入点，根据当前执行的情况决定是否执行某个测试方法
     */
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println("tom");
        callBack.runTestMethod(testResult);
    }
}
