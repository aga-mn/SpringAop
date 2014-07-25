package springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	//@Before("execution(public String get*())") for all public getters returning a string
	//@Before("execution(public * get*())") for all public getters
	//@Before("execution(public * get*(..))") for all public getters, any return type, any number of arguments 
	//@Before("execution(public * springaop.model.*.get*())") all public getters from classes in package
	
	@Before("allGetters()")
	public void LoggingAdvice(){
		System.out.println("Advice run. Get Method called");
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice executed");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){
		
	}
	
}
