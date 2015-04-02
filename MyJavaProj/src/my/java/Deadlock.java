package my.java;

public class Deadlock {

	private Resource resourceA = new Resource();

	private Resource resourceB = new Resource();

	public static void main(String[] args) {
		final Deadlock deadlock = new Deadlock();
		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				deadlock.read();
			}
		});
		threadA.start();
		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				deadlock.write(5, 5);
			}
		});
		threadB.start();

	}

	public int read() {
		synchronized (resourceA) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resourceB) {
				System.out.println("Succesfully read");
				return resourceA.value + resourceB.value;
			}
		}
	}

	public void write(int valA, int valB) {
		synchronized (resourceB) {
			synchronized (resourceA) {
				System.out.println("Succesfully wrote");
				resourceB.value = valB;
				resourceA.value = valA;
			}
		}
	}

}

class ThreadA implements Runnable {

	@Override
	public void run() {

	}

}

class Resource {
	public int value;
}
