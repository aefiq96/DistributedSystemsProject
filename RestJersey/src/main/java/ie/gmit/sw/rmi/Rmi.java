package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class Rmi {
	
	private DatabaseService ds;

	public Rmi() throws Exception {
		ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");

	}

	public List<Order> getData() throws Exception {
		return ds.read();
	}
	
	public void delete(int id) throws RemoteException, SQLException{
		ds.delete(id);
	}

}
