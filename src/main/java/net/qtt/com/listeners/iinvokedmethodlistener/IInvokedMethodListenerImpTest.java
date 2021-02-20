package net.qtt.com.listeners.iinvokedmethodlistener;
import net.qtt.com.listeners.DisableListener;
import org.testng.annotations.*;

@DisableListener
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
