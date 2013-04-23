package classes;

public class Route {
	private int id;
	private Airport departAirport;
	private Airport arriveAirport;
	private int distance;
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
	 * @return the departCityId
	 */
	public Airport getDepartAirport() {
		return departAirport;
	}
	/**
	 * @param departCityId the departCityId to set
	 */
	public void setDepartAirport(Airport departAirport) {
		this.departAirport = departAirport;
	}
	/**
	 * @return the arriveCityId
	 */
	public Airport getArriveAirport() {
		return arriveAirport;
	}
	/**
	 * @param arriveCityId the arriveCityId to set
	 */
	public void setArriveAirport(Airport arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
