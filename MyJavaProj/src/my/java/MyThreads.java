package my.java;

public class MyThreads {

	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		thread.setName("Thread 1");
//		thread.start();
		// thread = new Thread(new MyRunnable());
		// thread.setName("Thread 2");
		// thread.start();
		// thread = new Thread(new MyRunnable());
		Thread t1 = new TThread();
		t1.start();
		System.out.println("Main thread");
	}

}

class TThread extends Thread{
	@Override
	public void run() {
		System.out.println("Running the thread");
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				System.out.println("Modulus is " + 0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// System.out.println("Run by "+Thread.currentThread().getName()+" Printing "+i);
		}

	}

}
