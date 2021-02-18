package net.qtt.com.params;

import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestNGHelloWorld1 {
    @BeforeTest
    public void bfTest() {
        System.out.println("TestNGHelloWorld1 beforTest!");
    }

    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = ".*zero")
    public void helloWorldTest1() {
        System.out.println("TestNGHelloWorld1 Test1!");
        int c = 1 / 0;
        Assert.assertEquals("1", "1");
    }

    // testng.xml配置parameter的value为传入给变量的值，name与@Parameters的value一致。
    @Test()
    @Parameters(value = "para")
    public void helloWorldTest2(String str) {
        Assert.assertEquals("1", "1");
        System.out.println("TestNGHelloWorld1 Test2! " + str);
    }

    @Test()
    @Parameters(value = "other_para")
    public void helloWorldTest3(@Optional("Tom") String str) {
        Assert.assertEquals("1", "1");
        System.out.println("TestNGHelloWorld1 Test3! " + str);
    }

    //This method will provide data to any test method that declares that its Data Provider is named "test1"
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", new Integer(36)},
                {"Anne", new Integer(37)},
        };
    }

    // This test method declares that its data should be supplied by the Data Provider named "test1"
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

    @Test(dataProviderClass = StaticProvider.class, dataProvider = "create")
    public void testData2(Integer n) {
        System.out.println("TestNGBHelloWorld1" + " " + n);
    }

    @DataProvider(name = "test3")
    public Iterator<Object[]> createData3() {
        List<Object> items = new ArrayList<Object>();
        items.add(1);
        items.add(2);
        items.add(3);
        List<Object[]> users = new ArrayList<Object[]>();
        for (Object u : items) {
            users.add(new Object[]{u, "haha"});
        }
        return users.iterator();
    }

    @Test(dataProvider = "test3")
    public void testData3(Integer n, String str) {
        System.out.println(n + " " + str);
    }

    @DataProvider(name = "dp", parallel = true)
    public Object[][] createData(Method m) {
        System.out.println(m.getName());  // print test method name
        return new Object[][] {
                new Object[] { "Cedric1" },
                new Object[] { "Cedric2" },
                new Object[] { "Cedric3" },
                new Object[] { "Cedric4" },
        };
    }

    @Test(dataProvider = "dp")
    public void test1_1(String s) throws InterruptedException {
        System.out.println("test1_1 " + s);
        Thread.sleep(1000);
    }

    @Test(dataProvider = "dp")
    public void test1_2(String s) throws InterruptedException {
        System.out.println("test1_2 " + s);
        Thread.sleep(1000);
    }

    @AfterTest
    public void AfTest() {
        System.out.println("TestNGHelloWorld1 AfterTest!");
    }
}
