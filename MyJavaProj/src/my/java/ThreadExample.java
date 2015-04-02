package my.java;

public class ThreadExample implements Runnable {

	public static void main(String[] args) {
		ThreadExample thrd = new ThreadExample();
		new Thread(thrd).start();
		new Thread(new ThreadExample()).start();
	}

	@Override
	public void run() {
		move(Thread.currentThread().getId());
	}

	synchronized void move(long id) {
		System.out.println(id);
		System.out.println(id);
	}

}
