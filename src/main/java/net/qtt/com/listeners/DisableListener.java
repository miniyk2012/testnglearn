package net.qtt.com.listeners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在MyInterceptor中, 对@DisableListener装饰的类做了过滤, 直接不运行test case
 * 在IInvokedMethodListenerImp中, 则对@DisableListener装饰的类跳过这个打印动作"beforeInvocation:"
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DisableListener {}

