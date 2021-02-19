package net.qtt.com.parallel;
import org.testng.annotations.Factory;

public class TestParallel1Factory {
    @Factory
    public Object[] testParallel1(){
        Object[] objects = new Object[3];
        for(int i=0;i<3;i++){
            objects[i] = new parallel1();
        }
        return objects;
    }
}
