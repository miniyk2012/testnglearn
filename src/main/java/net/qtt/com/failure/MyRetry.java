package net.qtt.com.failure;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
