package net.qtt.com;

import org.testng.annotations.*;

@Test(groups = "test")
public class TestNGHelloWorld1 {
    @BeforeTest
    public void bfTest(){
        System.out.println("TestNGHelloWorld1 beforTest!");
    }

    @Test(groups = {"test1","test2"}, description = "test description")
    public void helloWorldTest1(){
        System.out.println("TestNGHelloWorld1 Test1!");
    }

    @Test(groups = {"test3"})
    public void helloWorldTest2() {
        System.out.println("TestNGHelloWorld1 Test2!");
    }

    @AfterTest
    public void AfTest(){
        System.out.println("TestNGHelloWorld1 AfterTest!");
    }
}
