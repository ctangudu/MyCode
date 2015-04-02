package my.java;

public class AccountMgmt implements Runnable {

	private Account account = new Account();

	public static void main(String[] args) {
		AccountMgmt accMgmt = new AccountMgmt();
		Thread one = new Thread(accMgmt);
		Thread two = new Thread(accMgmt);
		one.setName("One");
		two.setName("Two");
		one.start();
		two.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			managewithdrawl(10);
			if (account.getBalance() < 0) {
				System.out.println("Account is overdrawn");
			}
		}

	}

	private synchronized void managewithdrawl(int amount) {
		if (account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdraw, current balance is "+account.getBalance());
		} else {
			System.out.println(Thread.currentThread().getName() + " couldn't withdraw, as current blanace is "
					+ account.getBalance());
		}
	}

}

class Account {
	private int balance = 50;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
