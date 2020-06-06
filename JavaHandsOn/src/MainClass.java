public class MainClass {

	public static void main(String[] args) {
		
		//Creation  of 2D array
		int[][] data = {
				{4, 6, 3, 10},
				{4, 2, 40, 1, 5, 3, 2, 30},
				{5, 34, 1, 43}
		};
		
		//Changing element of 2D array
		data[1][2] = 49;
		
		//Outputting specific element of 2D array
		System.out.println(data[1][2]);
	
		//Outputting every element of a 2D array using a nested For loop
		for(int i = 0; i < data.length; i++) {
			for(int j =0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	
	}

}
