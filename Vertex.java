import java.util.ArrayList;


public class Vertex {
	
	private int weight;
	private String label;
	private Vertex last;
	private ArrayList<Vertex> neighbors;
	public boolean visited;
	private int xCoord;
	private int yCoord;
	
	
	public Vertex(String label, int x, int y){
		this.setLabel(label);
		this.setxCoord(x);
		this.setyCoord(y);
		neighbors = new ArrayList<Vertex>();
		visited = false;
	}
	public void AddNeighbor(Vertex newVertex){
		neighbors.add(newVertex);
	}
	public boolean hasNeighbors(){
		if(this.getNumNeighbors() > 0){
			return true;
		}else{
			return false;
		}
	}
	public int getNumNeighbors(){
		return this.getNeighbors().size();
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(ArrayList<Vertex> neighbors) {
		this.neighbors = neighbors;
	}
	public Vertex getLast() {
		return last;
	}
	public void setLast(Vertex last) {
		int lastX = last.getxCoord();
		int lastY = last.getyCoord();
		int thisX = this.getxCoord();
		int thisY = this.getyCoord();
		
		if(thisX == lastX){
			weight = Math.abs(thisY - lastY);
		}else{
			weight = Math.abs(thisX - lastX);
		}
		
		last.setWeight(weight);
		this.last = last;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public String toString(){
		return this.getLabel() + ", (" + this.getxCoord() + ", " + this.getyCoord() + ")";
	}
}
