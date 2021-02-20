package net.qtt.com.listeners.ireporter;


import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "test1")
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

    @Test()
    @Parameters(value = "tom")
    public void helloWorldTest2(@Optional("Tom")String str) {
        Assert.assertEquals("1", "2");
        System.out.println("TestNGHelloWorld1 Test2! "+ str);
    }

    @Test(invocationCount = 3)
    public void test3() {
        System.out.println("wang");
    }

    @AfterTest
    public void AfTest() {
        System.out.println("TestNGHelloWorld1 AfterTest!");
    }
}
