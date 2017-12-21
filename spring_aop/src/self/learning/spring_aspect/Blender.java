package self.learning.spring_aspect;

import org.springframework.stereotype.Component;

@Component("blender")
public class Blender implements IBlender {

	/* (non-Javadoc)
	 * @see self.learning.spring_aspect.IBlend#blend()
	 */
	@Override
	public void blend() {
		System.out.println("Inside Blender.blend()");
	}
}
