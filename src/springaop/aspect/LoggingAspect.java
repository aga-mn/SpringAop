package springaop.aspect;

import org.aspectj.lang.JoinPoint;
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
	
	@Before("stringArguments()")
	public void stringMethod(){
		System.out.println("A String-argument method has been called");
	}
	
	@Before("args(name)")
	public void stringArgumetnsMethods(String name){
		System.out.println(name);
	}
	
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	//@Pointcut("within(springaop.model.*)") all methods within package
	//@Pointcut("within(springaop.model..*)") all methods within package with subpackages
	
	@Pointcut("within(springaop.model.Circle)")
	public void allCircleMethods(){}
	
	//@Pointcut(args(springasop.model.Circle)) arguments that methods have (here: Circle)
	
	@Pointcut("args(String)")
	public void stringArguments(){}
}
