package aspects;

import metier.Compte;
import metier.IMetierImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PatchAspect {
   @Around("execution(* metier.IMetierImpl.retirer(..)) && args(code,mt)")
    public void patch(Long code, double mt, JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       IMetierImpl metier=(IMetierImpl) joinPoint.getTarget();
       Compte compte=metier.getCompte(code);
       if(compte.getSolde()>mt) proceedingJoinPoint.proceed();
       else throw new RuntimeException("Solde insuffsant");
   }



}
