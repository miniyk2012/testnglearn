package net.qtt.com.transform;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// 用于修改Factory的dataProvider为data
public class Transform2 implements IAnnotationTransformer2 {
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    }

    public void transform(IDataProviderAnnotation annotation, Method method) {
//        if (annotation.getName().equals("tom"))  //匹配名为data的DataProvider
//        {
//            annotation.setParallel(true); //设置并行
//            annotation.setName("aaa");
//        }

    }

    public void transform(IFactoryAnnotation annotation, Method method) {
//        annotation.setDataProvider("aaa");
        annotation.setDataProvider("data");
    }

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    }
}
