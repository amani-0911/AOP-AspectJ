package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    private  String username="root";
    private String password="1234";

    @Around("execution(* test.Application.start(..))")
    public void auth(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("------------Authentication----------- ");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Username: "); username=scanner.next();
        System.out.print("Password: "); password=scanner.next();
if(username.equals("root") && password.equals("1234")){
    proceedingJoinPoint.proceed();
}else{
    throw new RuntimeException("Access Denied");
}
    }
}
