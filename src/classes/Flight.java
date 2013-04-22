package classes;

import java.sql.Timestamp;

public class Flight {
	private int id;
	private int routeId;
	private int planeId;
	private Timestamp departure;
	private Timestamp arrival;
	private String test;
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
	public int getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the planeId
	 */
	public int getPlaneId() {
		return planeId;
	}
	/**
	 * @param planeId the planeId to set
	 */
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
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
