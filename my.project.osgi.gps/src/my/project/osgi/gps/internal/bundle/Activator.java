package my.project.osgi.gps.internal.bundle;

import my.project.osgi.gps.IGps;
import my.project.osgi.gps.internal.MockGps;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		MockGps mockGps = new MockGps();
		serviceRegistration = context.registerService(IGps.class.getName(),
				mockGps, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}

}
