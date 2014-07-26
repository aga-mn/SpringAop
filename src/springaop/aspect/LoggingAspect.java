package springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import springaop.model.Circle;

@Aspect
public class LoggingAspect {

	//@Before("execution(public String get*())") for all public getters returning a string
	//@Before("execution(public * get*())") for all public getters
	//@Before("execution(public * get*(..))") for all public getters, any return type, any number of arguments 
	//@Before("execution(public * springaop.model.*.get*())") all public getters from classes in package
	//combining pointcuts && ||
	
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint){
		//System.out.println("Advice run. "+ joinPoint.toString()+ "Method called");
		//System.out.println(joinPoint.getTarget());
		//Circle circle= (Circle) joinPoint.getTarget();
	}
	
	/*@Before("stringArguments()")
	public void stringMethod(){
		System.out.println("A String-argument method has been called");
	}*/
	
	//after scuccessfully returning (w/o exceptions)
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumetnsMethods(String name, String returnString){
		System.out.println("A String-argument method has been called. The value is " +name+". Output: "+returnString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, Exception ex){
		System.out.println("An exception has been thrown "+ex);
	}
	
	@Around("allSetters()")
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
	
	@Pointcut("execution(* set*(..))")
	public void allSetters(){}
	
	//@Pointcut("within(springaop.model.*)") all methods within package
	//@Pointcut("within(springaop.model..*)") all methods within package with subpackages
	
	@Pointcut("within(springaop.model.Circle)")
	public void allCircleMethods(){}
	
	//@Pointcut(args(springasop.model.Circle)) arguments that methods have (here: Circle)
	
	@Pointcut("args(String)")
	public void stringArguments(){}
}
