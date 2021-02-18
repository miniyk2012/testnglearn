package net.qtt.com.parallel;

import org.testng.annotations.*;


public class parallel2 {
    @BeforeClass
    public void bfClass() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel2 BeforeClass threadId: " + id);
    }

    @Test
    public void test() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel2 Test threadId: " + id);
    }

    @AfterClass
    public void afClass() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel2 AfterClass threadId: " + id);
    }
}
