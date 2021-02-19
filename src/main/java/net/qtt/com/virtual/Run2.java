package net.qtt.com.virtual;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Run2 {
    @Test
    public void test1() {
        System.out.println("Run2 test1");
    }

    @Test
    public void test2() {
        System.out.println("Run2 test2");
        Assert.assertEquals(1, 2);
    }
}
