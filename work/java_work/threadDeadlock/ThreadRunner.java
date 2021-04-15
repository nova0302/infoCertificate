//https://www.youtube.com/watch?v=wcMfu5Voxos
//https://github.com/discospiff/ThreadExamples

public class ThreadRunner {

    Object lock1 = new Object();
    Object lock2 = new Object();
	
    public static void main(String[] args) {
	ThreadRunner tr = new ThreadRunner();
	tr.runThreads();
		
    }
    public void runThreads() {
	Concurrent1 c1 = new Concurrent1();
	Concurrent2 c2 = new Concurrent2();
	Thread tc1 = new Thread(c1);
	Thread tc2 = new Thread(c2);
	tc1.start();
	tc2.start();
    }
    public void forceDeadlock() {
	synchronized (lock2) {
	    synchronized(lock1) {
		System.out.println("Do work");
	    }
	}
    }
    class Concurrent1 implements Runnable {
	@Override
	public void run() {
	    /*
	      for (int i = 0; i<8; i++) {
	      try {
	      Thread.sleep(1000);
	      }
	      catch (Throwable e) {
	      System.out.println("Error " + e.getMessage());
	      e.printStackTrace();
	      }
	      System.out.printf("Thread ID: %d, i: %d\n", Thread.currentThread().getId(), i);
	      }
	    */
	    synchronized(lock1) {
		System.out.printf("id: %d get lock1!!\n", Thread.currentThread().getId());
		try {
		    Thread.sleep(1000);
		    System.out.printf("id: %d get woke up and trying to get lock2\n", Thread.currentThread().getId());
		    forceDeadlock();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
    class Concurrent2 implements Runnable {
	@Override
	public void run() {
	    /*
	      for (int i = 0; i<8; i++) {
	      try {
	      Thread.sleep(3000);
	      }
	      catch (Throwable e) {
	      System.out.println("Error " + e.getMessage());
	      e.printStackTrace();
	      }
	      System.out.printf("Thread ID: %d, i: %d\n", Thread.currentThread().getId(), i);
	      }
	    */
	    synchronized(lock2) {
		System.out.printf("id: %d get lock2!!\n", Thread.currentThread().getId());
		try {
		    Thread.sleep(1000);
		    System.out.printf("id: %d get woke up and trying to get lock1\n", Thread.currentThread().getId());
		    forceDeadlock();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}
