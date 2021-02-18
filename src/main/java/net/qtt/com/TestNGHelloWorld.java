import org.testng.annotations.*;

@Test(groups = "Tomandy")
public class TestNGHelloWorld {
    @BeforeSuite(groups = "bfSuite")
    public void bfSuite() {
        System.out.println("TestNGHelloWorld BeforeSuite!");
    }

    @BeforeClass(enabled = false)  //不可执行
    public void bfClass() {
        System.out.println("TestNGHelloWorld BeforeClass!");
    }

    @BeforeTest(dependsOnGroups = "bfSuite")  //依赖bfSuite组
    public void bfTest() {
        System.out.println("TestNGHelloWorld BeforeTest!");
    }


    @BeforeClass(inheritGroups = false) //如果xml文件配置按Tomandy组执行的话，@BeforeClass注解的方法不会被执行
    public void setUp() {
        System.out.println("setUp!");
    }

    @Test(groups = "Tomandy")
    public void helloWorld() {
        System.out.println("My first TestNG testCase!");
    }

    public void helloWorld2() {
        System.out.println("My second TestNG testCase!");
    }

    @BeforeMethod(alwaysRun = true, dependsOnGroups = "bfSuite") //依赖bfSuite组,alwaysRun
    public void bfMethod() {
        System.out.println("TestNGHelloWorld BeforeMethod!");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("tearDown!");
    }

    @AfterSuite
    public void afSuite() {
        System.out.println("TestNGHelloWorld AfterSuite!");
    }

    @AfterMethod
    public void afMethod(){
        System.out.println("TestNGHelloWorld AfterMethod!");
    }

}
