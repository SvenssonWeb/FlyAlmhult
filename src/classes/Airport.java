package classes;

public class Airport {
	private int id;
	private String name;
	private City city;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cityId
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	public void setValues(String name, City city) {
		// TODO Auto-generated method stub
		this.name = name;
		this.city = city;
	}
	
	
}
