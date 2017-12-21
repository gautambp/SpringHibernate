package self.learning.spring_aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MachineAspect {

	@DeclareParents(value="self.learning.spring_aspect.*", defaultImpl=self.learning.spring_aspect.Machine.class)
	private IMachine machine;
	
	@Around("within(self.learning.spring_aspect.*)")
	public void runMachine(ProceedingJoinPoint jp) {
		System.out.println("Before running...");
		try {
			jp.proceed();
		} catch (Throwable e) {
		}
		System.out.println("After running...");
	}
}
