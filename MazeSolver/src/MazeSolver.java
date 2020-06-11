import java.util.ArrayList;
import java.util.LinkedList;

public class MazeSolver {
	
	//Main Class
	public static void main(String[] args) {
		
		//ArrayList created to store all of the mazes to be solved
		ArrayList<Maze> mazes = new ArrayList<Maze>();
		
		//Instantiation of class 'Maze' as objects 'm' and 'n'
		Maze m = new Maze();
		Maze n = new Maze();
		
		//Mazes created as 2D arrays
		int[][] maze = {
			{1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1}
		};
		
		int[][] n_maze = {
				{1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
				{0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
				{0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
				{1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
				{0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1}
			};
		
		
		
		//Key
		//0 = wall
		//1 = path
		//2 = destination
		
		//Maze objects assigned to 'maze' and 'n_maze'
		m.maze = maze;
		n.maze = n_maze;
		
		//Starting position set
		m.start = new Position(4, 8);
		n.start = new Position(4, 8);
		
		//Linked list created to store path taken
		m.path = new LinkedList<Position>();
		n.path = new LinkedList<Position>();
		
		//Maze objects added to mazes ArrayList
		mazes.add(m);
		mazes.add(n);
		
		//While loop used with index variable 'i' to iterate through ArrayList 'mazes'
		int i = 0;
		while(i < mazes.size()) {
			
			//SolveMaze method called with starting coordinates
			if(solveMaze(mazes.get(i))) {
				System.out.println("You won");
			}else {
				System.out.println("No path.");
			}
			i++;
		}
	
	}
	
	//Method to solve maze with given position
	private static boolean solveMaze(Maze m) {
		Position p = m.start;
		m.path.push(p);
		
		//While loop to search the maze
		while(true) {
			
			//Assigning stack values to variables
			int y = m.path.peek().y;
			int x = m.path.peek().x;

			//Marking visited positions with a 0
			m.maze[y][x] = 0;
			
			//If statement to check whether a move down is possible
			if(isValid(y+1, x, m)) {
				
				//Checking value below position
				if(m.maze[y+1][x] == 2) {
					System.out.println("Moved down");
					System.out.println("You won");
					return true;
				} else if(m.maze[y+1][x] == 1) {
					System.out.println("Moved down");
					m.path.push(new Position(y+1, x));
					continue;
				}
			}

			//If statement to check whether a move left is possible
			if(isValid(y, x-1, m)) {
				
				//Checking value left of position
				if(m.maze[y][x-1] == 2) {
					System.out.println("Moved left");
					return true;
				} else if(m.maze[y][x-1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x-1));
					continue;
				}
			}
			
			//If statement to check whether a move right is possible
			if(isValid(y-1, x, m)) {
				
				//Checking value above position
				if(m.maze[y-1][x] == 2) {
					System.out.println("Moved up");
					return true;
				} else if(m.maze[y-1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y-1, x));
					continue;
				}
			}
			
			//If statement to check whether a move down is possible
			if(isValid(y, x+1, m)) {
				
				//Checking value right of position
				if(m.maze[y][x+1] == 2) {
					System.out.println("Moved left");
					return true;
				} else if(m.maze[y][x+1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x+1));
					continue;
				}
			}
			
			//Popping latest coordinates from stack
			m.path.pop();
			System.out.println("Backtracking...");
			
			//Message output if stack is empty
			if(m.path.size() <= 0) {
				return false;
			}
		}
	}

	//Method to check whether the current coordinate is out bounds
	public static boolean isValid(int y, int x, Maze m) {
		if(y < 0 ||
				y >= m.maze.length ||
				x < 0 ||
				x >= m.maze[y].length
				) {
			return false;
		}
		return true;
	}
}
