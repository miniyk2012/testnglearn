package net.qtt.com.interceptor;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

public class OSFilterInterceptor implements IMethodInterceptor {
    public static int totalIgnored = 0;
    public static int totalRun = 0;
    public static int totalConfigured = 0;

    private List<IMethodInstance> methodsToTest = null;

    public boolean isQualified(ITestNGMethod iTestNGMethod) {
        boolean isQualified = false;
        Method m = iTestNGMethod.getConstructorOrMethod().getMethod();
        Test testAnno = m.getAnnotation(Test.class);
        String[] groups = testAnno.groups();
        List<String> groupList = Arrays.asList(groups);
        String osName = getCurrentOS();
        if (groupList.contains(osName)) {
            isQualified = true;
        }
        return isQualified;
    }

    private String getCurrentOS() {
        String osname = System.getProperties().getProperty("os.name");
        if (osname.startsWith("Windows")) {
            return OSNames.OS_WINDOWS;
        } else if (osname.equalsIgnoreCase("Linux")) {
            return OSNames.OS_LINUX;
        } else if(osname.equals("Mac OS X")) {
            return OSNames.OS_MAC_X;
        } else {
            return OSNames.OS_UNKNOWN;
        }
    }


    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        if (methodsToTest == null) {
            SortedMap<String, IMethodInstance> sortedMap = new TreeMap<String, IMethodInstance>();
            List<String> ignoredMethods = new ArrayList<String>();
            for (Iterator<IMethodInstance> it = methods.iterator(); it
                    .hasNext();) {
                IMethodInstance iMethodInstance = it.next();
                ITestNGMethod m = iMethodInstance.getMethod();
                String methodName = m.getConstructorOrMethod().getName();
                String className = m.getTestClass().getRealClass().getName();
                totalConfigured += 1;
                if (isQualified(iMethodInstance.getMethod())) {
                    String sortKey = className + "_" + methodName;
                    sortedMap.put(sortKey, iMethodInstance);
                    totalRun += 1;
                } else {
                    ignoredMethods.add(methodName + "(" + className + ")");
                    totalIgnored += 1;
                }
            }
            List<IMethodInstance> rtMethods = new ArrayList<IMethodInstance>(
                    sortedMap.values());

            ProgressTracker.totalRun = totalRun;

            System.out.println("Ignored Test Methods: " + ignoredMethods);

            methodsToTest = rtMethods;
        }
        return methodsToTest;
    }
}
