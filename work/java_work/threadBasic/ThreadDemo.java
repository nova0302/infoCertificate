
class MyClass extends Thread{
    public void run(){
	for(int i=0; i<10; i++){
	    System.out.println(Thread.currentThread().getId() + ", Value: " + i);
	    try {
		Thread.sleep(1000);
	    }
	    catch (Throwable e) {
		System.out.println("Error " + e.getMessage());
		e.printStackTrace();
	    }
	}
    }
}

public class ThreadDemo{
    public static void main(String[] args){
	MyClass myClass01 = new MyClass();
	myClass01.start();
	MyClass myClass02 = new MyClass();
	myClass02.start();
    }
}
