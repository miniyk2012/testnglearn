package net.qtt.com.listeners.isuitelistener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MyISuiteListenerImp implements ISuiteListener {
    public void onStart(ISuite suite) {
        System.out.println("**suite " + suite.getName() + " start.");
    }

    public void onFinish(ISuite suite) {
        System.out.println("**suite " + suite.getName() + " end.");
    }
}
