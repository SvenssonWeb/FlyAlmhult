
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.sql.PreparedStatement;


public class DbFactory {
		
	    private static Connection con = null;
	    private static Statement st = null;
		private static ResultSet rs = null;  

		private static String url = "jdbc:mysql://flyalmhult-162050.mysql.binero.se:3306?useUnicode=true&characterEncoding=UTF-8";
		private static String user = "162050_gr60540";
		private static String password = "hejsanalla";
	
		
		//returns the city with that id
		public static City getCity(int id) {
			
			try {
				con = DriverManager.getConnection(url, user, password);
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM city WHERE id=" + id);

				if (rs.next()) {
					City city = new City();
					city.setId(rs.getInt("iID"));
					city.setValues(rs.getString("sName"), rs.getInt("iCityID"));
					
					return category;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}
		
		
		
		//returns the airport with that id
		public static Airport getAirport(int id) {
			
			try {
				con = DriverManager.getConnection(url, user, password);
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM airport WHERE id=" + id);

				if (rs.next()) {
					Airport airport = new Airport();
					airport.setId(rs.getInt("iID"));
					airport.setValues(rs.getString("sName"), rs.getInt("iCityID"));
					
					return airport;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}
		
	
		
		
		//returns a list with all airports
		public static List<Airport> getAllAirports() {
			List<Airport> returnList = new ArrayList<Airport>();

			try {
				con = DriverManager.getConnection(url, user, password);
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM airport");

				while (rs.next()) {
					Airport airport = new Airport();
					airport.setId(rs.getInt("iID"));
					airport.setValues(rs.getString("sName"), rs.getInt("iCityID"));
					returnList.add(airport);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return returnList;
		}
		
		
		
		//returns a list with all cities
		public static List<City> getAllCities() {
			List<City> returnList = new ArrayList<City>();

			try {
				con = DriverManager.getConnection(url, user, password);
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM city");

				while (rs.next()) {
					City city = new City();
					city.setId(rs.getInt("iID"));
					city.setValues(rs.getString("sName"), rs.getString("sCountry"));
					returnList.add(city);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return returnList;
		}
		
		

			
		// add new airport to database
		public static void insertAirport(Airport airport) {

			try {
				con = DriverManager.getConnection(url, user, password);

				PreparedStatement prepStmt = con.prepareStatement("INSERT INTO post (sName, -iCityID) VALUES (?, ?)");
				prepStmt.setString(1, airport.getName());
				prepStmt.setString(2, airport.getCityID());

				//System.out.println(prepStmt.toString());
				prepStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		//add new city to database
		public static void insertCity(City city)
		{

			try {
				con = DriverManager.getConnection(url, user, password);

				PreparedStatement prepStmt = con.prepareStatement("INSERT INTO city (sName, sCountry) VALUES (?, ?)");
				prepStmt.setString(1, city.getName());
				prepStmt.setString(2,  city.getCountry());

				//System.out.println(prepStmt.toString());
				prepStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//function to remove city
		public static void removeCity(int id){
			
			try {
				con = DriverManager.getConnection(url, user, password);

				String tempSQLString = "DELETE FROM city WHERE id =?";

				PreparedStatement prepStmt = con.prepareStatement(tempSQLString);
				prepStmt.setInt(1, id);

				prepStmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		

		//function to airport city
		public static void removeAirport(int id){
			
			try {
				con = DriverManager.getConnection(url, user, password);

				String tempSQLString = "DELETE FROM airport WHERE id =?";

				PreparedStatement prepStmt = con.prepareStatement(tempSQLString);
				prepStmt.setInt(1, id);

				prepStmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

	}



