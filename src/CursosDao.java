import java.sql.*;

public class CursosDAO extends DatabaseConnect {

	protected String cod, nome, numLab, regSoft, material, livro, dataIni,
			dataTer, horario, dados;
	protected int vagas;
	protected double valor;

	public void cadastrar() {

		Connection conn = getConnection();

		String sql = "Insert into cursos"
				+ "(codigo, curso, data_inicio, data_termino, horario, vagas, valor, numero_laboratorio, registro_software, material, livros)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, cod);
			pst.setString(2, nome);
			pst.setString(3, dataIni);
			pst.setString(4, dataTer);
			pst.setString(5, horario);
			pst.setInt(6, vagas);
			pst.setDouble(7, valor);
			pst.setString(8, numLab);
			pst.setString(9, regSoft);
			pst.setString(10, material);
			pst.setString(11, livro);
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consultar() {

		Connection conn = getConnection();

		String sql = "select codigo, curso, data_inicio, data_termino, horario, vagas, valor, numero_laboratorio, registro_software, material, livros from cursos where codigo = ?";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, cod);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				cod = rs.getString("codigo");
				nome = rs.getString("curso");
				dataIni = rs.getString("data_inicio");
				dataTer = rs.getString("data_termino");
				horario = rs.getString("horario");
				vagas = rs.getInt("vagas");
				valor = rs.getDouble("valor");
				numLab = rs.getString("numero_laboratorio");
				regSoft = rs.getString("registro_software");
				material = rs.getString("material");
				livro = rs.getString("livros");

			}

			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		dados = "########## Dados Do Curso ##########" + "\n\nCodigo: " + cod
				+ "\nCurso: " + nome + "\nData Inicial: " + dataIni
				+ "\nData Termino: " + dataTer + "\nHorario: " + horario
				+ "\nVagas: " + vagas + "\nValor: " + valor
				+ "\nNumero de Laboratorio: " + numLab
				+ "\nRegistro de Software: " + regSoft + "\nMaterial: "
				+ material + "\nLivro: " + livro;

	}

	public void alterar() {

		Connection conn = getConnection();

		String sql = "update cursos set curso=?, data_inicio=?, data_termino=?, horario=?, vagas=?, valor=?, numero_laboratorio=?, registro_software=?, material=?, livros=? where codigo=?";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, dataIni);
			pst.setString(3, dataTer);
			pst.setString(4, horario);
			pst.setInt(5, vagas);
			pst.setDouble(6, valor);
			pst.setString(7, numLab);
			pst.setString(8, regSoft);
			pst.setString(9, material);
			pst.setString(10, livro);
			pst.setString(11, cod);
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletar() {

		Connection conn = getConnection();

		String sql = "delete from cursos where codigo=?";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, cod);
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
