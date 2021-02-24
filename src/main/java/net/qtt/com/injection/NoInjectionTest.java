package net.qtt.com.injection;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class NoInjectionTest {
    @DataProvider(name = "provider")
    public Object[][] provide() throws Exception {
        return new Object[][]{{CC.class.getMethod("f")}};
    }

    @Test(dataProvider = "provider")
    public void withoutInjection(@NoInjection Method m) {
        System.out.println("withoutInjection");
        Assert.assertEquals(m.getName(), "f");
    }
    
    @Test(dataProvider = "provider")
    public void withInjection(Method m, Method m2) {
        System.out.println("withInjection");
        Assert.assertEquals(m.getName(), "withInjection");  // 这是被注入的
        Assert.assertEquals(m2.getName(), "f");  // 这是DataProvider的
    }

}
