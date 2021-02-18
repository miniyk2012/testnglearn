package net.qtt.com.factory;

import org.testng.annotations.*;

public class TestFactory {

    @DataProvider(name = "n")
    public Object[][] num() {
        return new Object[][]{{3}};
    }

    @Factory(dataProvider="n")
    public Object[] test(Integer n) {
        Object[] objects = new Object[n];
        for (int i = 0; i < n; i++) {
            TomandyFactory tomandyFactory = new TomandyFactory(i + "");
            objects[i] = tomandyFactory;
        }
        return objects;
    }
}
