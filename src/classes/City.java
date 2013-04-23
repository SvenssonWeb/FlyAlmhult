package classes;

public class City {
	private int id;
	private String name;
	private String country;
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	public void setValues(String name, int id) {
		// TODO Auto-generated method stub
		this.name = name;
		this.id = id;
	}
	public void setValues(String name, int id, String country) {
		// TODO Auto-generated method stub
		this.name = name;
		this.id = id;
		this.country = country;
	}
	
}
