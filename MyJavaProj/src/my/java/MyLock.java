package my.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyLock {

	public static void main(String[] args) {
		ExecutorService exService = Executors.newCachedThreadPool();
		Future<Integer> submit = exService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return 2+3;
			}
		});
		try {
			System.out.println("After thread execution");
			Integer integer = submit.get();
			System.out.println("Value of addition "+integer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exService.shutdown();
		}
	}

}
