package springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
		
	
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		
		Object returnValue=null;
		
		try {
			System.out.println("Before advice");
			returnValue=proceedingJoinPoint.proceed();
			System.out.println("After returning");
			
		} catch (Throwable e) {
			System.out.println("After throwing");
		}
		
		System.out.println("After finally");
		return returnValue;
	}
	
	

	
	
}
