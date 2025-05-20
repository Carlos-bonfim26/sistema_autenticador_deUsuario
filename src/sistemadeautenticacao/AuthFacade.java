
package sistemadeautenticacao;
// import dos comandos sql
import java.sql.*;

/**
 *
 * @author carlo
 */
public class AuthFacade {

 public boolean cadastrar(String nome, String email, String senha) {
    // comandos sql para inserção na tabela usuários
    String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

    // tentando a conexão para ver se ela tem sucesso e 
    try (Connection conn = Conexao.conectar(); 
    // o PreparedStatement é um método da connection que está recebendo os comandos e sql e que por meio do setString depois aplicará o valor dos parámetros na iserção 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        // colocando o valor dos parâmetros na iserção para cadastrar o usuário
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
           // o executeQuery executa o sql do tipo select, o ResulSet trás um conjunto de resultados
           ResultSet rs = stmt.executeQuery();
           //o metodo next faz ele avançar o cursor para proxima linha do resultado
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
