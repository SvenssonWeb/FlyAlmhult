package classes;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String adress;
	private String telephone;
	private int clearenceLevel;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public int getClearenceLevel() {
		return clearenceLevel;
	}
	public void setClearenceLevel(int clearenceLevel) {
		this.clearenceLevel = clearenceLevel;
	}
	public User(int id, String firstName, String lastName, int clearenceLevel)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clearenceLevel = clearenceLevel;
	}
	public User(int id, String firstName, String lastName, String adress, String telephone, int clearenceLevel)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.telephone = telephone;
		this.clearenceLevel = clearenceLevel;
	}
}
