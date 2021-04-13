import java.util.*;
public class ExceptionHandling{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
	try{
	    int badInt = 10/2;
	}
	catch(ArithmeticException ex){
	    System.out.println("Can't divide by Zero");
	    System.out.println(ex.getMessage());
	    System.out.println(ex.toString());
	}
	catch(Exception ex){
	    System.out.println(ex.getMessage());
	}
	finally{
	    System.out.println("Clean up");
	}
    }
}
