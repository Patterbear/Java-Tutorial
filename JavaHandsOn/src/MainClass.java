import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MainClass {
	
	Collection<String> stuff;

	public static void main(String[] args) throws FileNotFoundException {
		
		//Creation of Scanner to scan text files
		Scanner in  = new Scanner(new File("students.txt"));
		
		//Creation of empty ArrayList
		ArrayList<String> students = new ArrayList<String>();

		//While loop to add names from file to ArrayList
		while(in.hasNextLine()) {
			students.add(in.nextLine());
		}
		
		//For loop to output each of the elements added to ArrayList
		for(int i = 0; i < students.size(); i++) {
			System.out.println("name: " + students.get(i));
		}
		
		//Scanner closure
		in.close();
		
		//Instantiation of MainClass into object 'm'
		MainClass m = new MainClass();
		m.stuff = new ArrayList<String>();
		
	}

}
