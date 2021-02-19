package net.qtt.com.parallel;

import org.testng.annotations.*;


public class parallel1 {
    @BeforeClass
    public void bfClass() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel1 BeforeClass threadId: " + id);
    }

    @Test
    public void test() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel1 Test threadId: " + id);
    }

    @Test
    public void test1(){
        long id = Thread.currentThread().getId();
        System.out.println("parallel1 Test1 threadId: "+id);
    }

    @AfterClass
    public void afClass() {
        long id = Thread.currentThread().getId();
        System.out.println("parallel1 AfterClass threadId: " + id);
    }
}
