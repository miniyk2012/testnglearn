package net.qtt.com.listeners.interceptor;

import net.qtt.com.listeners.DisableListener;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.internal.ConstructorOrMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyInterceptor implements IMethodInterceptor {

    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> rtMethods = new ArrayList<IMethodInstance>();
        for (Iterator<IMethodInstance> it = methods.iterator(); it.hasNext(); ) {
            IMethodInstance iMethodInstance = it.next();
            ITestNGMethod m = iMethodInstance.getMethod();
            ConstructorOrMethod consOrMethod  = m.getConstructorOrMethod();
            DisableListener disable = consOrMethod.getMethod().getDeclaringClass().getAnnotation(DisableListener.class);
            if (disable != null) {
                continue;
            }
            rtMethods.add(iMethodInstance);
        }
        return rtMethods;
    }
}
