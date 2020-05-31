import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		//Output statement
		System.out.println("Enter your name");
		
		//Scanner
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		//If Statement
		if(s.contentEquals("Benjamin")) {
			System.out.println("Hello Benjamin");
		}
		else if(s.contentEquals("Bob")) {
			System.out.println("Hello Bob");
		}
		else {
			System.out.println("You are not welcome.");
		}
		
		//While Loop
		int i = 0;
		while(i < 10) {
			System.out.println("i is: " + i);
			i++;
		}
		
		//For Loop
		for(int x = 0; x <10; x++) {
			System.out.println(x);
		}
		
		//Do While Loop
		int y = 0;
		do {
			System.out.println("y is: " + y);
			y++;
		}while(false);
		
		in.close();
		
		//Variable Declaration + Output
		int a = 5;
		int z;
		z = 5;
		double d = 5.5;
		char t = 't';
		System.out.println(d);
		System.out.println(a);
		System.out.println(z);
		System.out.println(d);
		System.out.println(t);

	}

}
