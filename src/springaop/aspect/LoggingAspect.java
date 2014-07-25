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
	//combining pointcuts && ||
	
	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice(){
		System.out.println("Advice run. Get Method called");
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("A Get method called");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	//@Pointcut("within(springaop.model.*)") all methods within package
	//@Pointcut("within(springaop.model..*)") all methods within package with subpackages
	
	@Pointcut("within(springaop.model.Circle)")
	public void allCircleMethods(){}
	
	//@Pointcut(args(springasop.model.Circle)) arguments that methods have (here: Circle)
	// 
	
}
