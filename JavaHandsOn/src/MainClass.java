import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		//Linked List Creation
		LinkedList<String> names = new LinkedList<String>();
		
		//Elements 'pushed' onto stack
		names.push("Benjamin");
		names.push("Adam");
		names.push("Richard");
		
		//ListIterator object instantiated
		ListIterator<String> it = names.listIterator();
		
		//Iterating through the list and adding an element
		it.next();
		it.next();
		it.add("Chris");
		
		//While loop to output stack contents
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//Element added to list at specified index
		names.add(2, "Harry");
		
		//For Each loop to output stack contents
		for(String s: names) {
			System.out.println(s);
		}
		
	}

}
