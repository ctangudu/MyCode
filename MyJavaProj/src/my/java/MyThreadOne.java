package my.java;

public class MyThreadOne implements Runnable {

	public static void main(String[] args) {
		Thread thread = new Thread(new MyThreadOne());
		thread.start();
		

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reminder is "+i%10);
		}
	}

}
