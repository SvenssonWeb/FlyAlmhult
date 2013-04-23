package classes;

import java.sql.Timestamp;

public class Flight {
	private int id;
	private Route route;
	private Plane plane;
	private Timestamp departure;
	private Timestamp arrival;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the routeId
	 */
	public Route getRoute() {
		return route;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}
	/**
	 * @return the planeId
	 */
	public Plane getPlane() {
		return plane;
	}
	/**
	 * @param planeId the planeId to set
	 */
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	/**
	 * @return the departure
	 */
	public Timestamp getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}
	/**
	 * @return the arrival
	 */
	public Timestamp getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(Timestamp arrival) {
		this.arrival = arrival;
	}
	
}
