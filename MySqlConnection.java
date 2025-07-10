package week3.day2;

public abstract class MySqlConnection implements DatabaseConnection {
	
	@Override
	public void connect() {
		
		System.out.println("Click connect button to connect to a Database ---- Database Connection Interface");
		
	}

	@Override
	public void disconnect() {
		
		System.out.println("Click disconnect button to disconnect from a Database ------Database Connection Interface");
		
	}

	@Override
	public void executeUpdate() {
		
		System.out.println("This method is to execute the update process ------ Database Connection Interface");
		
	}
	
	public void executeQuery() {
		
		System.out.println("This method is to execute a query ------ MySqlConnection Subclass");
	}

	public static void main(String[] args) {
		
		

	}

	

}
