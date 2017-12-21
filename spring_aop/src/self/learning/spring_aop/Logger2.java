package self.learning.spring_aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger2 {

	@Before("execution(void self.learning.spring_aop.Camera.sayCheese())")
	public void aboutToSayCheese() {
		System.out.println("About to say cheese...");
	}

	@Pointcut("execution(void self.learning.spring_aop.Camera.sayCheese(..))")
	public void callSayCheeseAnyParam() {
	}
	@After("callSayCheeseAnyParam()")
	public void justSaidCheese() {
		System.out.println("Just said cheese...");
	}

	// * is the wildcard to apply to any type of return
	@Pointcut("execution(* self.learning.spring_aop.Camera.sayCheese(String))")
	public void callSayCheeseStringParam() {
	}
	@Before("callSayCheeseStringParam()")
	public void aboutToSayCheeseStringParam() {
		System.out.println("About to say cheese with string param...");
	}
	
	@Before("execution(* self.learning.spring_aop.Camera.*(..))")
	public void allInCamera() {
		System.out.println("This applies before all camera methods regardless of return type and params");
	}
	
	@Before("execution(* self.learning.spring_aop.*.*(..))")
	public void allInPackage() {
		System.out.println("This applies before all class methods in package regardless of return type and params");
	}
}
