package self.learning.spring_aspect;

import org.springframework.stereotype.Component;

@Component("fan")
public class Fan implements IFan {

	/* (non-Javadoc)
	 * @see self.learning.spring_aspect.IFan#activate()
	 */
	@Override
	public void activate() {
		System.out.println("Inside Fan.activate()");
	}
}
