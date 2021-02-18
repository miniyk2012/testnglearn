package net.qtt.com;

import org.testng.annotations.*;


public class BMW extends Car {

    @Test
    public void BMWTest() {
        System.out.println("net.qtt.com.BMW Test");
    }

    @AfterClass
    public void bmwAfterClass() {
        System.out.println("net.qtt.com.BMW AfterClass");
    }
}
