import java.util.ArrayList;


public class driver {

	public static void main(String[] args) {
		Graph maze = new Graph();
		Vertex one = new Vertex("Start", 1, 1);
		Vertex two = new Vertex("Two", 1, 5);
		Vertex three = new Vertex("Three", 8, 5);
		Vertex a = new Vertex("A", 1, 4);
		Vertex b = new Vertex("Exit", 2, 4);
		Vertex c = new Vertex("C", 5, 5);
		maze.Add(one);
		maze.Add(two);
		maze.Add(three);
		maze.Add(a, one);
		maze.Add(b, a);
		maze.Add(c, three);
		
		//drawGraph(maze);
		solve(maze);
	}
	public void drawGraph(Graph g){
		int maxX = g.getMaxX();
		int maxY = g.getMaxY();
		
		Vertex current = g.getStart();
		ArrayList<Vertex> neighbors = current.getNeighbors();
		for(Vertex next : neighbors){
			if(next.visited){
				continue;
			}else{
				
			}
		}
	}
	public static void solve(Graph g){
		Vertex start = g.getStart();
		start.visited = true;
		ArrayList<Vertex> neighbors = start.getNeighbors();
		Vertex endpoint = explore(neighbors);
		Vertex current = endpoint;
		System.out.println("End: " + endpoint);
//		ArrayList<Vertex> path = new ArrayList<Vertex>();
//		while(current != g.getStart()){
//			System.out.println(current);
//			path.add(current);
//			current = current.getLast();
//		}
//		System.out.println(" Correct Path: ");
//		for(int i = path.size(); i > 0; i++){
//			System.out.println(path.get(i));
//		}
	}
	public static Vertex explore(ArrayList<Vertex> list){
		System.out.println(list.size() + " neighbors of: " + list.get(0).getLast());
		for(Vertex next : list){
			System.out.println(next);
			if(next.getLabel().equalsIgnoreCase("Exit")){
				System.out.println("Found!");
				return next;
			}
		}
		for(Vertex next : list){
			if(next.hasNeighbors()){
				next = explore(next.getNeighbors());
			}else{
				continue;
			}
			if(next == null){
				continue;
			}else{
				return next;
			}
		}
		return null;
	}

}
