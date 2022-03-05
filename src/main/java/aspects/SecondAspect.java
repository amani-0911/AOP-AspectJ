package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(public static void ma(String[]))")
    public void pc1(){
    }

    /*
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("Before main from @AspectJ Annotation.....");
    }
    @After("pc1()")
    public void aftereMain(){
        System.out.println("After main from @AspectJ Annotation.....");
    }

     */
    @Around("pc1()")
    public void arroindMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before main from around code advice.....");
       //execute la methode
    Object o=proceedingJoinPoint.proceed();
        System.out.println("After main from around code advice.....");

    }
}
