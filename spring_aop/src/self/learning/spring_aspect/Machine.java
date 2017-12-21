package self.learning.spring_aspect;

public class Machine implements IMachine {

	/* (non-Javadoc)
	 * @see self.learning.spring_aspect.IMachine#start()
	 */
	@Override
	public void start() {
		System.out.println("Inside Machine.start()");
	}
}
