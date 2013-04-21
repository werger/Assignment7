
public class Graph {
	public int numVerticies;
	private Vertex start;
	private Vertex end;
	private int maxX;
	private int maxY;
	
	public Graph(){
		numVerticies = 0;
	}
	public void Add(Vertex newVertex){
		if(this.getMaxX() < newVertex.getxCoord()){
			this.setMaxX(newVertex.getxCoord());
		}else if(this.getMaxY() < newVertex.getyCoord()){
			this.setMaxY(newVertex.getyCoord());
		}
		if(start == null){
			start = newVertex;
		}else if(end == null){
			end = newVertex;
			end.setLast(start);
			start.AddNeighbor(end);
			//end.AddNeighbor(start);
		}else{
			Vertex temp = end;
			end = newVertex;
			end.setLast(temp);
			temp.AddNeighbor(end);
			//end.AddNeighbor(temp);
		}
	}
	public void Add(Vertex newVertex, Vertex last){
		if(this.getMaxX() < newVertex.getxCoord()){
			this.setMaxX(newVertex.getxCoord());
		}else if(this.getMaxY() < newVertex.getyCoord()){
			this.setMaxY(newVertex.getyCoord());
		}
		last.AddNeighbor(newVertex);
		//System.out.println(last);
		newVertex.setLast(last);
	}
	public Vertex getStart() {
		return start;
	}
	public void setStart(Vertex start) {
		this.start = start;
	}
	public Vertex getEnd() {
		return end;
	}
	public void setEnd(Vertex end) {
		this.end = end;
	}
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
}
