package my.java;

public class ThreadNotification {

	public static void main(String[] args) {
		ThreadB threadB = new ThreadB();
		threadB.start();
		System.out.println("ThreadB started.");
		synchronized (threadB) {
			System.out.println("Entered ThreadB synchronized block.");
			try {
				System.out.println("Waiting to be completed");
				threadB.wait();
				System.out.println("total is " + threadB.total);
			} catch (InterruptedException e) {
			}
		}
//		ThreadD threadD = new ThreadD(threadB);
//		threadD.start();
		
		System.out.println("Exiting main block.");
	}

}


class ThreadB extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("In ThreadB run.sync block.");
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				total += i;
			}
			notify();
			System.out.println("Operation in ThreadB ");
		}
	}
}

class ThreadD extends Thread{
	ThreadB threadB;
	ThreadD(ThreadB threadB){
		this.threadB = threadB;
	}
	@Override
	public void run() {
		System.out.println("In threadD, waiting to go into sync block");
		synchronized (threadB) {
			try {
				System.out.println("Waiting to be completed");
				threadB.wait();
				System.out.println("total is " + threadB.total);
			} catch (InterruptedException e) {
				System.out.println("total is 99999" + threadB.total);
			}
		}
	}
}
