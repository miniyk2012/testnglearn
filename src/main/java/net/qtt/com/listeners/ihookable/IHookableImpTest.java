package net.qtt.com.listeners.ihookable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({IHookableImp.class})
public class IHookableImpTest {
    @Test
    public void test() {
        System.out.println("test");
    }
}
