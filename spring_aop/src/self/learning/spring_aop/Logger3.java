package self.learning.spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger3 {

	@After("execution(void self.learning.spring_aop.Camera.snapWithException())")
	public void snapAfter() {
		System.out.println("After snapWithException method call");
	}

	@AfterThrowing("execution(void self.learning.spring_aop.Camera.snapWithException())")
	public void snapAfterThrowing() {
		System.out.println("AfterThrowing snapWithException method call");
	}

	@AfterReturning("execution(void self.learning.spring_aop.Camera.snapWithException())")
	public void snapAfterReturning() {
		System.out.println("AfterReturning snapWithException method call");
	}

	@AfterReturning("execution(void self.learning.spring_aop.Camera.snapWithoutException())")
	public void snapAfterReturningNoException() {
		System.out.println("AfterReturning snapWithoutException method call");
	}
	
	@Around("execution(void self.learning.spring_aop.Camera.snapWithAround())")
	public void snapAround(ProceedingJoinPoint p) {
		System.out.println("Around advice (before)");
		try {
			p.proceed();
		} catch (Throwable e) {
		}
		System.out.println("Around advice (after)");
	}
}
