import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import classes.*;

public class DbFactory {

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	private static String url = "jdbc:mysql://db4free.net:3306/flyalmhult";
	private static String user = "flyalmhult";
	private static String password = "hejsanalla";
	//private static String url = "jdbc:mysql://localhost:3306/162050-flyalmhult";
	//private static String user = "root";
	//private static String password = "";
	
	public static List<City> cities = new ArrayList<City>();
	public static List<Airport> airports = new ArrayList<Airport>();
	public static List<Route> routes = new ArrayList<Route>();
	public static List<Plane> planes = new ArrayList<Plane>();
	public static List<Flight> flights = new ArrayList<Flight>();
	
	//Fill the system (lists with data from the database)
	public static void initiateSystem(){
	    cities = getAllCities();
		airports = getAllAirports();
		routes = getAllRoutes();
		planes = getAllPlanes();
		flights = getAllFlights();
		
	}
	
	
	//Function to check if password matches
	public static boolean checkPassword(String userIn, String passIn){
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE username =" + userIn);

			if (rs.next()) {
				passIn = rs.getString("password");

				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	
	/* --------- GET WITH ID ------------ */

	// returns the city with that id
	public static City getCity(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM city WHERE iID=" + id);

			if (rs.next()) {
				City city = new City();
				city.setId(rs.getInt("iID"));
				city.setName(rs.getString("sName"));
				city.setCountry(rs.getString("sCountry"));

				return city;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// returns the airport with that id
	public static Airport getAirport(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM airport WHERE iID=" + id);

			if (rs.next()) {
				Airport airport = new Airport();
				airport.setId(rs.getInt("iID"));
				airport.setName(rs.getString("sName"));
				
				//Cities
				if ( cities.size() == 0 ) {
					cities = getAllCities();
				}
				

				for (City city : cities) {
					if (city.getId() == rs.getInt("iCityID")) {
						airport.setCity(city);
					}
				}

				return airport;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// returns the route with that id
	public static Route getRoute(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM route WHERE iID=" + id);

			if (rs.next()) {
				Route route = new Route();

				route.setId(rs.getInt("iID"));
				route.setId(rs.getInt("iDistance"));
				
				//Airports
				if ( airports.size() == 0 ) {
					airports = getAllAirports();
				}

				// departAirport
				for (Airport airport : airports) {
					if (airport.getId() == rs.getInt("iDepartAirportId")) {
						route.setDepartAirport(airport);
					}
				}

				// arriveAirport
				for (Airport airport : airports) {
					if (airport.getId() == rs.getInt("iArriveAirportId")) {
						route.setArriveAirport(airport);
					}
				}

				return route;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// returns the flight with that id
	public static Flight getFlight(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM flight WHERE iID=" + id);

			if (rs.next()) {
				Flight flight = new Flight();

				flight.setId(rs.getInt("iID"));
				flight.setDeparture(rs.getTimestamp("tsDeparture"));
				flight.setArrival(rs.getTimestamp("tsArrival"));
				
				//Routes
				if ( routes.size() == 0 ) {
					routes = getAllRoutes();
				}

				// Route
				for (Route route : routes) {
					if (route.getId() == rs.getInt("iRouteID")) {
						flight.setRoute(route);
					}
				}
				
				//Planes
				if ( planes.size() == 0 ) {
					planes = getAllPlanes();
				}

				// Plane
				for (Plane plane : planes) {
					if (plane.getId() == rs.getInt("iPlaneID")) {
						flight.setPlane(plane);
					}
				}

				return flight;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// returns the plane with that id
	public static Plane getPlane(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM plane WHERE iID=" + id);

			if (rs.next()) {
				Plane plane = new Plane(rs.getInt("iID"),
						rs.getString("sName"), rs.getInt("iPassengers"));
				plane.setCost(rs.getInt("iCost"));
				plane.setSpeed(rs.getString("sSpeed"));

				return plane;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// returns the user with that id
	public static User getUser(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE iID=" + id);

			if (rs.next()) {
				User newUser = new User(rs.getInt("iID"),
						rs.getString("sFirstName"), rs.getString("sLastName"),
						rs.getString("sAdress"), rs.getString("sTelephone"),
						rs.getInt("iClearenceLevel"));

				return newUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/* --------- END GET WITH ID ------------ */

	/* --------- GET LIST ------------ */

	// returns a list with all airports
	public static List<Airport> getAllAirports() {
		List<Airport> returnList = new ArrayList<Airport>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM airport");

			while (rs.next()) {
				Airport airport = new Airport();
				airport.setId(rs.getInt("iID"));
				airport.setName(rs.getString("sName"));
				
				//Cities
				if ( cities.size() == 0 ) {
					cities = getAllCities();
				}

				// City
				for (City city : cities) {
					if (city.getId() == rs.getInt("iCityID")) {
						airport.setCity(city);
					}
				}

				returnList.add(airport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	// returns a list with all cities
	public static List<City> getAllCities() {
		List<City> returnList = new ArrayList<City>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM city");

			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt("iID"));
				city.setName(rs.getString("sName"));
				city.setCountry(rs.getString("sCountry"));
				returnList.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	// returns a list with all flights
	public static List<Flight> getAllFlights() {
		List<Flight> returnList = new ArrayList<Flight>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM flight");

			while (rs.next()) {
				Flight flight = new Flight();
				flight.setId(rs.getInt("iID"));
				flight.setDeparture(rs.getTimestamp("tsDeparture"));
				flight.setArrival(rs.getTimestamp("tsArrival"));
				
				//Routes
				if ( routes.size() == 0 ) {
					routes = getAllRoutes();
				}

				// Route
				for (Route route : routes) {
					if (route.getId() == rs.getInt("iRouteID")) {
						flight.setRoute(route);
					}
				}
				
				//Planes
				if ( planes.size() == 0 ) {
					planes = getAllPlanes();
				}

				// Plane
				for (Plane plane : planes) {
					if (plane.getId() == rs.getInt("iPlaneID")) {
						flight.setPlane(plane);
					}
				}

				returnList.add(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	// returns a list with all planes
	public static List<Plane> getAllPlanes() {
		List<Plane> returnList = new ArrayList<Plane>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM plane");

			while (rs.next()) {
				Plane plane = new Plane(rs.getInt("iID"),
						rs.getString("sName"), rs.getInt("iPassengers"));

				plane.setCost(rs.getInt("iCost"));
				plane.setSpeed(rs.getString("sSpeed"));

				returnList.add(plane);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	// returns a list with all routes
	public static List<Route> getAllRoutes() {
		List<Route> returnList = new ArrayList<Route>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM route");

			while (rs.next()) {
				Route route = new Route();

				route.setId(rs.getInt("iID"));
				route.setId(rs.getInt("iDistance"));
				
				//Airports
				if ( airports.size() == 0 ) {
					airports = getAllAirports();
				}

				// departAirport
				for (Airport airport : airports) {
					if (airport.getId() == rs.getInt("iDepartAirportID")) {
						route.setDepartAirport(airport);
					}
				}

				// arriveAirport
				for (Airport airport : airports) {
					if (airport.getId() == rs.getInt("iArriveAirportID")) {
						route.setArriveAirport(airport);
					}
				}

				returnList.add(route);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	// returns a list with all users
	public static List<User> getAllUsers() {
		List<User> returnList = new ArrayList<User>();

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user");

			while (rs.next()) {
				User newUser = new User(rs.getInt("iID"),
						rs.getString("sFirstName"), rs.getString("sLastName"),
						rs.getString("sAdress"), rs.getString("sTelephone"),
						rs.getInt("iClearenceLevel"));

				returnList.add(newUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	/* --------- END GET LIST ------------ */

	/* --------- INSERT ------------ */

	// add new airport to database
	public static void insertAirport(Airport airport) {

		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = con
					.prepareStatement("INSERT INTO airport (sName, iCityID) VALUES (?, ?)");
			prepStmt.setString(1, airport.getName());
			prepStmt.setInt(2, airport.getCity().getId());

			// System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// add new route to database
	public static void insertRoute(Route route) {

		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = con
					.prepareStatement("INSERT INTO route (iDepartAirportID, iArriveAirportID, iDistance) VALUES (?, ?, ?)");
			prepStmt.setInt(1, route.getDepartAirport().getId());
			prepStmt.setInt(2, route.getArriveAirport().getId());
			prepStmt.setInt(3, route.getDistance());

			// System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// add new flight to database
	public static void insertFlight(Flight flight) {

		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = con
					.prepareStatement("INSERT INTO flight (iRouteID, iPlaneID, tsDeparture, tsArrival) VALUES (?, ?, ?, ?)");
			prepStmt.setInt(1, flight.getRoute().getId());
			prepStmt.setInt(2, flight.getPlane().getId());
			prepStmt.setTimestamp(3, flight.getDeparture());
			prepStmt.setTimestamp(4, flight.getArrival());

			// System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// add new city to database
	public static void insertCity(City city) {

		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = con
					.prepareStatement("INSERT INTO city (sName, sCountry) VALUES (?, ?)");
			prepStmt.setString(1, city.getName());
			prepStmt.setString(2, city.getCountry());

			// System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// add new user to database
	public static void insertUser(User newUser) {

		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = con
					.prepareStatement("INSERT INTO user (sfirstName, slastName, sAdress, sTelephone, iClearenceLevel) VALUES (?, ?, ?, ?, ?)");
			prepStmt.setString(1, newUser.getFirstName());
			prepStmt.setString(2, newUser.getLastName());
			prepStmt.setString(3, newUser.getAdress());
			prepStmt.setString(4, newUser.getTelephone());
			prepStmt.setInt(5, newUser.getClearenceLevel());

			// System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// add new plane to the database
	public static void insertPlane(Plane plane) {

		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = con
					.prepareStatement("INSERT INTO plane (sName, sSpeed, iPassengers, iCost) VALUES (?, ?, ?, ?)");
			prepStmt.setString(1, plane.getName());
			prepStmt.setString(2, plane.getSpeed());
			prepStmt.setInt(3, plane.getPassengers());
			prepStmt.setInt(4, plane.getCost());

			// System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* --------- END INSERT ------------ */

	/* ------------ REMOVE ------------ */

	// function to remove city
	public static void removeCity(int id) {

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

	// function to remove airport
	public static void removeAirport(int id) {

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

	// function to remove flight in database
	public static void removeFlight(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);

			String tempSQLString = "DELETE FROM flight WHERE id =?";

			PreparedStatement prepStmt = con.prepareStatement(tempSQLString);
			prepStmt.setInt(1, id);

			prepStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// function to remove plane from database
	public static void removePlane(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);

			String tempSQLString = "DELETE FROM plane WHERE id =?";

			PreparedStatement prepStmt = con.prepareStatement(tempSQLString);
			prepStmt.setInt(1, id);

			prepStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// function to remove route
	public static void removeRoute(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);

			String tempSQLString = "DELETE FROM route WHERE id =?";

			PreparedStatement prepStmt = con.prepareStatement(tempSQLString);
			prepStmt.setInt(1, id);

			prepStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// function to remove user
	public static void removeUser(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);

			String tempSQLString = "DELETE FROM user WHERE id =?";

			PreparedStatement prepStmt = con.prepareStatement(tempSQLString);
			prepStmt.setInt(1, id);

			prepStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* --------- END REMOVE ------------ */

}
