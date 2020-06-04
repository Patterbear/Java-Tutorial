import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		//Creating exception for non-existent file which prints Stack trace
				try {
					Scanner in = new Scanner(new File("test"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
								
		//Creation of Linked Lists
				LinkedList<String> names = new LinkedList<String>();
				LinkedList<String> animals = new LinkedList<String>();
				
		//Using Linked List as a Queue
				
		//Elements added to queue
				names.add("Benjamin");
				names.add("Adam");
				names.add("Moss");
				
		//Elements 'dequeued' from queue and outputted
				System.out.println(names.remove());
				System.out.println(names.remove());
				System.out.println(names.remove());
				
		//Using LinkedList as a Stack
				
		//Elements 'pushed' onto stack
				animals.push("Coyote");
				animals.push("Buffalo");
				animals.push("Eagle");
				
		//Elements 'popped' from stack and outputted
				System.out.println(animals.pop());
				System.out.println(animals.pop());
				System.out.println(animals.pop());
		
	}

}
