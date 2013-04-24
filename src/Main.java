
public class Main {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbFactory.initiateSystem();
		
		System.out.println(DbFactory.getCity(1).getName());
		System.out.println(DbFactory.getRoute(1).getId());
		System.out.println(DbFactory.getAirport(1).getName());
		System.out.println("got here");
	}

}
