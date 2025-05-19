
package sistemadeautenticacao;

import java.sql.*;

/**
 *
 * @author carlo
 */
public class AuthFacade {

 public boolean cadastrar(String nome, String email, String senha) {
    String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, senha);
        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Erro no cadastro: " + e.getMessage());
        return false;
    }
}


    public Usuario login( String email, String senha) throws SQLException {
       String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
       
       try( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setString(1, email);
           stmt.setString(2, senha);
           
           ResultSet rs = stmt.executeQuery();
           
           if(rs.next()){
               String nome = rs.getString("nome");
               return new Usuario(nome, email);
           }
       }catch(SQLException e){
           System.out.println("Erro no login: "+ e.getMessage());
           
       }
       return null;
    }
}
