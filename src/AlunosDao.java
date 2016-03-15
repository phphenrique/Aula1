import java.sql.*;

public class AlunosDAO extends DatabaseConnect {

	protected String nome, rg, end, email, dados;
	protected int cpf, tel;

	public void cadastrar() {

		Connection conn = getConnection();

		String sql = "Insert into alunos"
				+ "(nome, rg, cpf, logradouro, email, telefone)" + "values (?,?,?,?,?,?)";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, rg);
			pst.setInt(3, cpf);
			pst.setString(4, end);
			pst.setString(5, email);
			pst.setInt(6, tel);
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
	
	public void consultar (){
	
		
		  Connection conn=getConnection();
		     
	      String sql = "select nome,rg,cpf,logradouro,email,telefone from alunos where cpf=?";
	   
	      try{
	      
	         PreparedStatement pst=conn.prepareStatement(sql);
	         
	         pst.setInt(1,cpf);
	         
	         ResultSet rs = pst.executeQuery();
	      
	              
	         if(rs.next())
	         {
	            
	            nome=rs.getString("nome");
	            rg=rs.getString("rg");
	            cpf=rs.getInt("cpf");
	            end=rs.getString("logradouro");
	            email=rs.getString("email");
	            tel=rs.getInt("telefone");
	            
	         }
	      
	         pst.close();
	      
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   	
	      try {
	         
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
		
	      dados=    "########## Dados Do Aluno ##########"+
	                "\n\nNome: "+nome+
					"\nRg: "+rg+
					"\nCpf: "+cpf+
					"\nEndereço: "+end+
					"\nEmail: "+email+
					"\nTelefone: "+tel;	                
	
	}
	
	public void alterar (){
		
		Connection conn = getConnection();

		 String sql = "update alunos set nome=?,rg=?, logradouro=? , email=?, telefone=? where cpf=?";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, rg);
			pst.setString(3, end);
			pst.setString(4, email);
			pst.setInt(5, tel);
			pst.setInt(6, cpf);
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
	
	public void deletar(){
		
		
		Connection conn=getConnection();
		   
	      String sql = "delete from alunos where cpf=?";
	   				 
	      try{
	      
	         PreparedStatement pst=conn.prepareStatement(sql);
	         
	         pst.setInt(1,cpf);
	         pst.executeUpdate();
	         pst.close();
	        
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   	
	      try {
	      
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      } 

	}

}
