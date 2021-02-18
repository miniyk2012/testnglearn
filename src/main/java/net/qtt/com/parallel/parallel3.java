package net.qtt.com.parallel;

import org.testng.annotations.*;

public class parallel3 {
    @BeforeClass
    public void bfClass() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel3 BeforeClass threadId: " + id);
    }

    @Test
    public void test() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel3 Test threadId: " + id);
    }

    @AfterClass
    public void afClass() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel3 AfterClass threadId: " + id);
    }
}
