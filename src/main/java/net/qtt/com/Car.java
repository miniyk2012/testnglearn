package net.qtt.com;

import org.testng.annotations.*;

@Test(groups = "Tomandy")
public class Car {
    @BeforeClass
    public void beforeClass() {
        System.out.println("car beforeClass");
    }

    @Test
    public void carTest() {
        System.out.println("net.qtt.com.Car Test");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("net.qtt.com.Car afterClass");
    }
}
