/**
 * 
 */
package my.project.osgi.emergancymonitor;

import my.project.osgi.airbag.IAirbag;
import my.project.osgi.airbag.IAirbagListener;
import my.project.osgi.gps.IGps;

/**
 * @author Chaitanya
 * 
 */
public class EmergancyMonitor implements IAirbagListener {

	private IAirbag airbag;

	private IGps gps;

	@Override
	public void deployed() {
		System.out.println("Emeergancy occurred at lat =" + gps.getLattitude()
				+ " lon= " + gps.getLongitude() + " heading= "
				+ gps.getHeadings() + " speed= " + gps.getSpeed());
	}
	
	public void setAirBag(IAirbag airbag){
		this.airbag = airbag;
	}
	
	public void setGps(IGps gps){
		this.gps = gps;
	}
	
	public void startup(){
		airbag.addListener(this);
	}

	public void shutdown(){
		airbag.removeListener(this);
	}
}
