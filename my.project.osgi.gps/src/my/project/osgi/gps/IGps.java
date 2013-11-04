package my.project.osgi.gps;

public interface IGps {

	public abstract int getHeadings();

	public abstract int getLattitude();

	public abstract int getLongitude();

	public abstract int getSpeed();

}