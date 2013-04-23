package classes;

public class Route {
	private int id;
	private City departCity;
	private City arriveCity;
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
	public City getDepartCity() {
		return departCity;
	}
	/**
	 * @param departCityId the departCityId to set
	 */
	public void setDepartCity(City departCity) {
		this.departCity = departCity;
	}
	/**
	 * @return the arriveCityId
	 */
	public City getArriveCity() {
		return arriveCity;
	}
	/**
	 * @param arriveCityId the arriveCityId to set
	 */
	public void setArriveCity(City arriveCity) {
		this.arriveCity = arriveCity;
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
