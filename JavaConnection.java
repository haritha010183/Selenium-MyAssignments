package week3.day2;

public class JavaConnection extends MySqlConnection implements DatabaseConnection {
	
	@Override
	public void connect() {
		
		System.out.println("Connect to a database ----- Database Connection Interface");
		
	}

	@Override
	public void disconnect() {
		
		System.out.println("Disconnect the database connection ---- Database Connection Interface");
		
	}

	@Override
	public void executeUpdate() {
		
		System.out.println("This is an execute update method ---- Database Connection Interface");
		
	}

	public static void main(String[] args) {
		
		JavaConnection connection = new JavaConnection();
		connection.connect();
		connection.disconnect();
		connection.executeUpdate();
		connection.executeQuery();
	}

	

}
