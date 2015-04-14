package my.java;

/**
 * 
 * @author 929284
 *
 */
public class MyThreadClass {

	public static void main(String[] args) {
		BankAccount acount = new BankAccount();
		Thread t1 = new BankAccountWidhdraw(acount);
		t1.setName("t1");
		Thread t2 = new BankAccountWidhdraw(acount);
		t2.setName("t2");
		t1.start();
		t2.start();
	}

}

class BankAccountWidhdraw extends Thread{

	private BankAccount acount;
	
	BankAccountWidhdraw(BankAccount acount){
		this.acount = acount;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			acount.withdrawMoney(10);
		}
		
	}
	
}

class BankAccount {
	int amount = 50;

	int getAmount() {
		return amount;
	}

	synchronized void withdrawMoney(int money) {
		if (this.amount >= money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is going to withdraw money.");
			amount = amount - money;
			System.out.println(Thread.currentThread().getName() + " has withdrawn money, balance is " + amount);
		} else {
			System.out.println("Enough money is not available to withdraw " + Thread.currentThread().getName()
					+ ", current balance is " + amount);
		}
	}
}
