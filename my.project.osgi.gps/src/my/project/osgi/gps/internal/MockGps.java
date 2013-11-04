/**
 * 
 */
package my.project.osgi.gps.internal;

import my.project.osgi.gps.IGps;

/**
 * @author Chaitanya
 *
 */
public class MockGps implements IGps {

	@Override
	public int getHeadings(){
		return 90;
	}
	
	@Override
	public int getLattitude(){
		return 370882; 
	}
	
	@Override
	public int getLongitude(){
		return -1244544;
	}
	
	@Override
	public int getSpeed(){
		return 50;
	}

}
