package my.project.osgi.emergancymonitor;

import my.project.osgi.airbag.IAirbag;
import my.project.osgi.gps.IGps;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private IGps gps;

	private IAirbag airbag;

	private EmergancyMonitor monitor;

	private ServiceReference gpsServiceRef;

	private ServiceReference airbagServiceRef;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Launching");
		monitor = new EmergancyMonitor();
		gpsServiceRef = bundleContext.getServiceReference(IGps.class.getName());
		airbagServiceRef = bundleContext.getServiceReference(IAirbag.class
				.getName());
		if (gpsServiceRef == null || airbagServiceRef == null) {
			System.out.println("Unable to acuire GPS or airbag");
			return;
		}

		gps = (IGps)bundleContext.getService(gpsServiceRef);
		airbag = (IAirbag)bundleContext.getService(airbagServiceRef);
		if(gps == null || airbagServiceRef == null){
			System.out.println("Unable to acuire GPS or airbag");
			return;
		}
		monitor.setAirBag(airbag);
		monitor.setGps(gps);
		monitor.startup();
		monitor.startup();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		monitor.shutdown();
		if(gpsServiceRef!=null){
			bundleContext.ungetService(airbagServiceRef);
		}
		if(gpsServiceRef!=null)
		bundleContext.ungetService(gpsServiceRef);
		System.out.println("Shutting down");
	}

}
