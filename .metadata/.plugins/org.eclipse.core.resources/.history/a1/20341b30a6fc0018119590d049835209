package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class RMIClass {
	
	private DatabaseService ch;

	public RMIClass() throws Exception {
		ch = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");

	}

	// ============== READ ====================
	public List<Order> readData() throws Exception {
		return ch.read();
	}

}
