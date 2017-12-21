package self.learning.spring_aop_proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	@After("execution(void self.learning.spring_aop_proxy.Camera.snap())")
	public void afterSnap() {
		System.out.println("After snap");
	}
	// even in within point-cut definition, you can use * for package or class
	@After("within(self.learning.spring_aop_proxy.Camera)")
	public void afterWithinCamera() {
		System.out.println("after within camera");
	}
	
	@After("target(self.learning.spring_aop_proxy.SnapTaker)")
	public void afterTargetCamera() {
		System.out.println("after target SnapTaker");
	}

	// target all class (in beans container) methods where the class use annotation Component
	@After("@target(org.springframework.stereotype.Component)")
	public void afterTargetCompAnnotation() {
		System.out.println("after target Component Annotation");
	}

	// target all class (in beans container) methods that use annotation Component
	// you can also use @args to pick a class method where param object class is tagged with the specified annotation class
	// e.g., @args(java.lang.Deprecated) - flag a method which uses Deprecated class object as param..
	// @Deprecated class Car {...} ..  void myMethod(Car car) gets flagged
	@After("@annotation(java.lang.Deprecated)")
	public void afterAnnotationMethod() {
		System.out.println("after Annotation method");
	}
	
	// any method for bean camera
	// can also use pattern matching - e.g., *camera (any bean id ending with camera)
	@After("bean(camera)")
	public void afterBeanMethod() {
		System.out.println("after bean method");
	}

	// target any methods with params int, double
	// can also use pattern matching - e.g., (int, *) any method with first param int and second param any other type
	// e.g., args(.., double) - any method with one more params with last param type being double
	@After("args(int, double)")
	public void afterArgsMethod() {
		System.out.println("after args method");
	}
	
	@After("args(int, double)")	
	public void afterJoinPointMethod(JoinPoint jp) {
		System.out.println("after JoinPoint method - param values");
		for (Object obj : jp.getArgs()) {
			System.out.println("Arg - " + obj);
		}
	}
	@After("args(intVal, doubleVal)")	
	public void afterArgsValues(int intVal, double doubleVal) {
		System.out.println("after Args Values method - param values : " + intVal + ", " + doubleVal);
	}
	
	// target camera bean and method with params (int, double)
	// can also use || and ! in logic expressions when combining two or more pointcuts
	@After("bean(camera) && args(intVal, doubleVal)")
	public void afterTwoPointcuts(int intVal, double doubleVal) {
		System.out.println("afterTwoPonintcuts - param values : " + intVal + ", " + doubleVal);
	}
}
