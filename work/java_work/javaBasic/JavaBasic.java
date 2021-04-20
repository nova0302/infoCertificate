//import java.util.*;
public class JavaBasic{
    static Scanner sc = new Scanner(System.in);

    public static int getSum(int x, int y){
	return x+y;
    }
    public static void changeMe(int cNum){
	cNum = 10;
    }
    public static int getSum2(int ... nums){
	int sum=0;
	for(int x: nums)
	    sum += x;
	return sum;
    }
    static int[] getNext2(int x){
	int[] vals = new int[2];
	vals[0] = x+1;
	vals[1] = x+2;
	return vals;
    }
    public static void main(String[] args) {
	System.out.println("5+4" + getSum(5,4));
	int cNum = 0;
	changeMe(cNum);
	System.out.println("cNum = " + cNum);

	System.out.println("Sum: " + getSum2(1,2,3,4)); 

	int[] multVA = getNext2(5);
	for(int x: multVA)
	    System.out.println(x);
    }
}
