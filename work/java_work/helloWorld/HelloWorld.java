//package edu.smh.game;
import java.util.*;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

public class HelloWorld{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
	int theInt = 4;
	int a = 4;
	int b = 4;

	//System.out.printf("3+4 = %d", theInt.getSum());

	
	System.out.print("Enter name: ");
	if(sc.hasNextLine()){
	    String userName = sc.nextLine();
	    System.out.println("Hello " + userName);
	}

	System.out.printf("3+4 = %d\n", Add(3,4));

	String jopName = JOptionPane.showInputDialog("Enter name: ");
	System.out.println("Hello " + jopName + "\n");

	// Relational Operators : ==, !=, >, <, >=, <=
	// Logical operators : ! && || ^
	int age = 12;
	System.out.printf("Your are %d years old.\n", age);

	if((age >= 5) && (age <= 6)){
	    System.out.println("Go to Kindergarden");
	}else if((age >= 7) && (age <= 13)){
	    System.out.println("Go to Elementary School");
	}else if((age >= 14) && (age <= 18)){
	    System.out.println("Go to Middle School");
	}else{
	    System.out.println("Stay home!!");
	}

	int wL = 0;
	while(wL < 20){
	    if(wL % 2 == 0){
		System.out.println(wL);
		wL++;
		continue;
	    }
	    if(wL >= 10){
		break;
	    }
	    wL++;
	}

	String lang = "Korean";

	switch(lang){
	    case "Chile": case "Cuba" :
		System.out.println("Holar");
		break;
	    case "Korean":
		System.out.println("Hmm...!!");
		break;
	    default:
		System.out.println("Hello");
	}
	int secretNum = 7;
	int guess = 0;
	do{
	    System.out.print("Guess: ");
	    if(sc.hasNextInt()){
		guess = sc.nextInt();
	    }
	}while(secretNum != guess);
	System.out.println("Your guessed it!!");
	    
    }
    public static  int Add(int a, int b){
	return a+b;
    }
}
