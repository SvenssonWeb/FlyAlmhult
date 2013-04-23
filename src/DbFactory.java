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

	private static String url = "jdbc:mysql://flyalmhult-162050.mysql.binero.se:3306?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "162050_gr60540";
	private static String password = "hejsanalla";

	/* --------- GET WITH ID ------------ */

	// returns the city with that id
	public static City getCity(int id) {

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM city WHERE id=" + id);

			if (rs.next()) {
				City city = new City();
				city.setId(rs.getInt("iID"));
				city.setName(rs.getString("sName"));
				city.setId(rs.getInt("iCityID"));

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
			rs = st.executeQuery("SELECT * FROM airport WHERE id=" + id);

			if (rs.next()) {
				Airport airport = new Airport();
				airport.setId(rs.getInt("iID"));
				airport.setName(rs.getString("sName"));

				for (City city : getAllCities()) {
					if (city.getId() == rs.getInt("iCityId")) {
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
			rs = st.executeQuery("SELECT * FROM route WHERE id=" + id);

			if (rs.next()) {
				Route route = new Route();

				route.setId(rs.getInt("iID"));
				route.setId(rs.getInt("sDistance"));

				// departAirport
				for (Airport airport : getAllAirports()) {
					if (airport.getId() == rs.getInt("iDepartID")) {
						route.setDepartAirport(airport);
					}
				}

				// arriveAirport
				for (Airport airport : getAllAirports()) {
					if (airport.getId() == rs.getInt("iArriveID")) {
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
			rs = st.executeQuery("SELECT * FROM flight WHERE id=" + id);

			if (rs.next()) {
				Flight flight = new Flight();

				flight.setId(rs.getInt("iID"));
				flight.setDeparture(rs.getTimestamp("tsDeparture"));
				flight.setArrival(rs.getTimestamp("tsArrival"));

				// Route
				for (Route route : getAllRoutes()) {
					if (route.getId() == rs.getInt("iRouteID")) {
						flight.setRoute(route);
					}
				}

				// Plane
				for (Plane plane : getAllPlanes()) {
					if (plane.getId() == rs.getInt("iplaneID")) {
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
			rs = st.executeQuery("SELECT * FROM plane WHERE id=" + id);

			if (rs.next()) {
				Plane plane = new Plane(rs.getInt("iID"),
						rs.getString("sName"), rs.getInt("sPassgengers"));
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
			rs = st.executeQuery("SELECT * FROM user WHERE id=" + id);

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

				// City
				for (City city : getAllCities()) {
					if (city.getId() == rs.getInt("iCityId")) {
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

				// Route
				for (Route route : getAllRoutes()) {
					if (route.getId() == rs.getInt("iRouteID")) {
						flight.setRoute(route);
					}
				}

				// Plane
				for (Plane plane : getAllPlanes()) {
					if (plane.getId() == rs.getInt("iplaneID")) {
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
				route.setId(rs.getInt("distance"));

				// departAirport
				for (Airport airport : getAllAirports()) {
					if (airport.getId() == rs.getInt("iDepartID")) {
						route.setDepartAirport(airport);
					}
				}

				// arriveAirport
				for (Airport airport : getAllAirports()) {
					if (airport.getId() == rs.getInt("iArriveID")) {
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
					.prepareStatement("INSERT INTO post (sName, iCityID) VALUES (?, ?)");
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
					.prepareStatement("INSERT INTO post (iDepartID, iArriveID, iDistance) VALUES (?, ?, ?)");
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
					.prepareStatement("INSERT INTO post (iRouteID, iPlaneID, tsDeparture, tsArrival) VALUES (?, ?, ?, ?)");
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
