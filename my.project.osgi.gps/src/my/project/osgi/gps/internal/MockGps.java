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

	public int getHeadings(){
		return 90;
	}
	
	public int getLattitude(){
		return 370882; 
	}
	
	public int getLongitude(){
		return -1244544;
	}
	
	public int getSpeed(){
		return 50;
	}

}
