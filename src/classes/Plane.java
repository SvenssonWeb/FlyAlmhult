package classes;

public class Plane {
	private int id;
	private String name;
	private String speed;
	private int passengers;
	private int cost;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	
	public Plane(int id, String name, int passengers)
	{
		this.id = id;
		this.name = name;
		this.passengers = passengers;
	}
}
