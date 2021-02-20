package net.qtt.com.listeners.iinvokedmethodlistener;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

@Listeners(IInvokedMethodListenerImp.class)
public class IInvokedMethodListenerImpTest {
    @BeforeClass
    public void bfClass(){
        System.out.println("bfClass123");
    }

    @Test
    public void test1(){
        System.out.println("test123");
    }

    @Test
    public void test2(){
        System.out.println("test321");
    }
}
