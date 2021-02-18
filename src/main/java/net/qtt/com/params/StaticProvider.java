package net.qtt.com.params;

import org.testng.annotations.*;

public class StaticProvider {
    @DataProvider(name="create")
    public static Object[][] createData() {
        return new Object[][] {
                new Object[] {new Integer(42)}
        };
    }
}
