package net.qtt.com;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGHelloWorld2 {
    @BeforeTest
    public void bfTest() {
        System.out.println("TestNGHelloWorld2 beforTest!");
    }

    @Test(groups = {"test1"})
    public void helloWorldTest1() {
        System.out.println("TestNGHelloWorld2 Test1!");
        Assert.assertEquals("1", "2");
    }

    //test3依赖于test1组，如果test1组执行失败，则test3跳过测试
    @Test(groups = {"test3"}, dependsOnGroups = "test1")
    public void helloWorldTest2() {
        System.out.println("TestNGHelloWorld2 Test2!");
    }

    @Test(timeOut = 2000, enabled = false)
    public void helloWorldTest3() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("TestNGHelloWorld2 Test3!");
    }

    @Test(invocationCount = 5, invocationTimeOut = 4000, enabled = false)
    public void helloWorldTest4() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("TestNGHelloWorld2 Test4!");
    }

    @Test(threadPoolSize = 3, invocationCount = 3, timeOut = 2000)
    public void helloWorldTest5() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("TestNGHelloWorld2 Test5!");
    }

    @Test(threadPoolSize = 3, invocationCount = 10, successPercentage = 9, enabled=false)
    public void helloWorldTest6() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("TestNGHelloWorld2 Test!6");
        Assert.assertEquals("1", "1");
    }

    // 该测试方法依然会被运行即使其所依赖的方法执行失败
    @Test(dependsOnMethods = "helloWorldTest1", alwaysRun = true)
    public void helloWorldTest7() {
        System.out.println("TestNGHelloWorld2 Test7!");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void helloWorldTest8() {
        System.out.println("TestNGHelloWorld2 Test8!");
        int c = 1/0;
        Assert.assertEquals("1", "1");
    }

    @Test(expectedExceptions = ArithmeticException.class,expectedExceptionsMessageRegExp = ".*zero")
    public void helloWorldTest9() {
        System.out.println("TestNGHelloWorld2 Test9!");
        int c = 1/0;
        Assert.assertEquals("1", "1");
    }

    @AfterTest
    public void AfTest() {
        System.out.println("TestNGHelloWorld2 AfterTest!");
    }
}
