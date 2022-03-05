package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Long t1,t2;

    Logger logger=Logger.getLogger(this.getClass().getName());

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
       logger.setUseParentHandlers(false);

      }

    @Pointcut("execution(* *.*.*(..)) || initialization(metier.IMetierImpl.new(..))")
    public void pc1(){}

    @Before("pc1()")
    public void before(JoinPoint joinPoint){
     logger.info("********************");
     logger.info("Before l'execution de l'mèthode"+joinPoint.getSignature());
        t1=System.currentTimeMillis();

    }
    @After("pc1()")
    public void after(JoinPoint joinPoint){
     logger.info("After l'execution de l'mèthode"+joinPoint.getSignature());
        t2=System.currentTimeMillis();
     logger.info("La duree d'execution "+(t2-t1));
     logger.info("********************");
    }
}
