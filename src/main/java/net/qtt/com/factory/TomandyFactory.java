package net.qtt.com.factory;

import org.testng.annotations.Test;

public class TomandyFactory {
    private  String str;
    public TomandyFactory(String str){
        this.str = str;
    }

    @Test
    public void test(){
        System.out.println("TomandyFactory: " +str);
    }

    @Test(dependsOnMethods = "test")
    public void test1(){
        System.out.println("TomandyFactory1: " +str);
    }
}
