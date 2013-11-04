/**
 * 
 */
package my.project.osgi.airbag.internal.bundle;

import my.project.osgi.airbag.IAirbag;
import my.project.osgi.airbag.internal.MockAirbag;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author Chaitanya
 * 
 */
public class Activator implements BundleActivator {

	private MockAirbag airbag;

	private ServiceRegistration serviceRegistration;

	/*
	 * (non-Javadoc)
	 * 
	 * @see )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		airbag = new MockAirbag();
		airbag.startUp();
		serviceRegistration = context.registerService(IAirbag.class.getName(),
				airbag, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
		airbag.shutDown();
	}

}
