import org.testng.annotations.*;


public class BMW extends Car {

    @Test
    public void BMWTest() {
        System.out.println("BMW Test");
    }

    @AfterClass
    public void bmwAfterClass() {
        System.out.println("BMW AfterClass");
    }
}
