import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

abstract class MysqlConnect implements Connect {

	// atributo
	public Connection conn;

	// construtor
	public MysqlConnect() {
		conn = null;// verdadeira conex„o com o banco.
		String url = "jdbc:mysql://localhost/"; // localizacao do servidor
		String dbName = "sistemas_cursos"; // nome do banco de dados
		String driver = "com.mysql.jdbc.Driver"; // nome do driver de conexao
		String userName = "root"; // nome do usuario do banco
		// String password = ""; // respectiva senha
		String password = "root"; // respectiva senha

		try {
			Class.forName(driver);
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
							"Erro...", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();// Oque È isso?
		}
	}

	// fornece a conex√£o com o banco de dados Mysql
	public Connection getConnection() {
		return conn;
	}

	// Fecha a conec√ß√£o com bco de dados
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}