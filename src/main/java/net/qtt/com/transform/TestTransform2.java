package net.qtt.com.transform;

import org.testng.annotations.Test;

public class TestTransform2 {
    private String str;

    public TestTransform2(String str) {
        this.str = str;
    }

    @Test()
    public void test() {
        System.out.println("Test annotationTransformer2!");
        System.out.println("DataProviderName:" + str);
    }
}