package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement p;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HIRE?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		stmt = conn.createStatement();

		List<Order> List = new ArrayList<Order>();
		String strSelect = "select * from orders";

		ResultSet rset = stmt.executeQuery(strSelect);

		while (rset.next()) { 
			int id = rset.getInt("OrderID");
			Date d = rset.getDate("Date");
			int cust = rset.getInt("CustID");
			int car = rset.getInt("CarID");
			
			Order s = new Order(id, d, cust, car);
			List.add(s);
		}
		return List;
	}

	@Override
	public void delete(int id) throws RemoteException, SQLException {
		
		p = conn.prepareStatement("Delete from orders where ORDERID = ?");
		p.setInt(1, id);
		p.executeUpdate();
		p.close();	
	}

}
