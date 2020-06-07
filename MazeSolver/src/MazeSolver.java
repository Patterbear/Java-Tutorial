import java.util.LinkedList;

public class MazeSolver {
	
	//Creation of maze as static collection
	static int[][] maze = {
			{2, 0, 1, 1},
			{1, 1, 0, 1},
			{0, 0, 1, 0}
	};
	
	//Key
	//0 = wall
	//1 = path
	//2 = destination
	
	//Static Stack created to store the path the solver has taken
	static LinkedList<Position> path = new LinkedList<Position>();
	
	public static void main(String[] args) {
		
		//Starting position created and added to stack
		Position p = new Position(3, 0);
		path.push(p);
		
		//Marking visited positions with a 0
		maze[path.peek().y][path.peek().x] = 0;
	}

}
