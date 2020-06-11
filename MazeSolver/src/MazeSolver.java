import java.util.LinkedList;

public class MazeSolver {
	
	//Instantiation of class 'Maze' as object 'm'
	static Maze m = new Maze();
	
	//Main Class
	public static void main(String[] args) {
		
		//Maze created as 2D array
		int[][] maze = {
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
		
		//Maze object assigned to 'maze'
		m.maze = maze;
		
		//Starting position set
		m.start = new Position(4, 8);
		
		//Linked list created to store path taken
		m.path = new LinkedList<Position>();
		
		//SolveMaze method called with starting coordinates
		if(solveMaze(m.start)) {
			System.out.println("You won");
		}else {
			System.out.println("No path.");
		}
	}
	
	//Method to solve maze with given position
	private static boolean solveMaze(Position p) {
		m.path.push(p);
		
		//While loop to search the maze
		while(true) {
			
			//Assigning stack values to variables
			int y = m.path.peek().y;
			int x = m.path.peek().x;

			//Marking visited positions with a 0
			m.maze[y][x] = 0;
			
			//If statement to check whether a move down is possible
			if(isValid(y+1, x)) {
				
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
			if(isValid(y, x-1)) {
				
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
			if(isValid(y-1, x)) {
				
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
			if(isValid(y, x+1)) {
				
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
	public static boolean isValid(int y, int x) {
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
