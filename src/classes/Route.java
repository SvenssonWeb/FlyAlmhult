package classes;

public class Route {
	private int id;
	private int departCityId;
	private int arriveCityId;
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
	public int getDepartCityId() {
		return departCityId;
	}
	/**
	 * @param departCityId the departCityId to set
	 */
	public void setDepartCityId(int departCityId) {
		this.departCityId = departCityId;
	}
	/**
	 * @return the arriveCityId
	 */
	public int getArriveCityId() {
		return arriveCityId;
	}
	/**
	 * @param arriveCityId the arriveCityId to set
	 */
	public void setArriveCityId(int arriveCityId) {
		this.arriveCityId = arriveCityId;
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
