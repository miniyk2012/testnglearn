package net.qtt.com.failure;

import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test(retryAnalyzer = MyRetry.class)  //失败重跑
    @Parameters(value = "para")
    public void helloWorldTest2(@Optional("Tom")String str) {
        System.out.println("TestNGHelloWorld1 Test2 entry!");
        Assert.assertEquals("1", "2");
        System.out.println("TestNGHelloWorld1 Test2! "+ str);
    }

    @Test(groups = {"test1"})
    public void helloWorldTest3() {
        System.out.println("TestNGHelloWorld2 Test3!");
        Assert.assertEquals("1", "3");
    }

    //test3依赖于test1组，如果test1组执行失败，则test3跳过测试
    @Test(groups = {"test3"}, dependsOnGroups = "test1")
    public void helloWorldTest4() {
        System.out.println("TestNGHelloWorld2 Test4!");
    }

    @AfterTest
    public void AfTest() {
        System.out.println("TestNGHelloWorld1 AfterTest!");
    }
}
