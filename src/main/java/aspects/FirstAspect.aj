package aspects;

public aspect FirstAspect {
    pointcut pc1():execution(* test.Application.ma(..));

    before():pc1(){
        System.out.println("Before main AspectJ Syntax...");
    }
    after():pc1(){
        System.out.println("After  main AspectJ Syntax...");
    }
}
