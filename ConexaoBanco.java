import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	// Nome do usuário do MySQL:
	private static final String USERNAME = "Whinters";
	
	// Senha do usuário do MySQL
	private static final String PASSWORD = "senha";
	
	// Conexão com o banco de dados através da url:
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/produto";
	
	// Método responsável pela conexão com o banco:
	public static Connection conexaoBanco() throws ClassNotFoundException, SQLException {
		
		// Carrega o driver de conexão na JVM através do seu nome (String):
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Estabelece a conexão através da url, nome de usuário e senha:
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		// Retorna a conexão estabelecida:
		return connection;
	}
}
