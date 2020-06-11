import java.util.LinkedList;

public class MazeSolver {
	
	//Creation of maze as static collection
	static int[][] maze = {
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
	
	//Static Stack created to store the path the solver has taken
	static LinkedList<Position> path = new LinkedList<Position>();
	
	//Main Class
	public static void main(String[] args) {
		
		//SolveMaze method called with starting coordinates
		if(solveMaze(new Position(4, 8))) {
			System.out.println("You won");
		}else {
			System.out.println("No path.");
		}
	}
	
	//Method to solve maze with given position
	private static boolean solveMaze(Position p) {
		path.push(p);
		
		//While loop to search the maze
		while(true) {
			
			//Assigning stack values to variables
			int y = path.peek().y;
			int x = path.peek().x;

			//Marking visited positions with a 0
			maze[y][x] = 0;
			
			//If statement to check whether a move down is possible
			if(isValid(y+1, x)) {
				
				//Checking value below position
				if(maze[y+1][x] == 2) {
					System.out.println("Moved down");
					System.out.println("You won");
					return true;
				} else if(maze[y+1][x] == 1) {
					System.out.println("Moved down");
					path.push(new Position(y+1, x));
					continue;
				}
			}

			//If statement to check whether a move left is possible
			if(isValid(y, x-1)) {
				
				//Checking value left of position
				if(maze[y][x-1] == 2) {
					System.out.println("Moved left");
					return true;
				} else if(maze[y][x-1] == 1) {
					System.out.println("Moved left");
					path.push(new Position(y, x-1));
					continue;
				}
			}
			
			//If statement to check whether a move right is possible
			if(isValid(y-1, x)) {
				
				//Checking value above position
				if(maze[y-1][x] == 2) {
					System.out.println("Moved up");
					return true;
				} else if(maze[y-1][x] == 1) {
					System.out.println("Moved up");
					path.push(new Position(y-1, x));
					continue;
				}
			}
			
			//If statement to check whether a move down is possible
			if(isValid(y, x+1)) {
				
				//Checking value right of position
				if(maze[y][x+1] == 2) {
					System.out.println("Moved left");
					return true;
				} else if(maze[y][x+1] == 1) {
					System.out.println("Moved left");
					path.push(new Position(y, x+1));
					continue;
				}
			}
			
			//Popping latest coordinates from stack
			path.pop();
			System.out.println("Backtracking...");
			
			//Message output if stack is empty
			if(path.size() <= 0) {
				return false;
			}
		}
	}

	//Method to check whether the current coordinate is out bounds
	public static boolean isValid(int y, int x) {
		if(y < 0 ||
				y >= maze.length ||
				x < 0 ||
				x >= maze[y].length
				) {
			return false;
		}
		return true;
	}
}
