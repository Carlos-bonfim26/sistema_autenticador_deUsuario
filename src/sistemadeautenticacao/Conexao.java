
package sistemadeautenticacao;

// importes necessários para conexão 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_usuarios";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    // o Connection é uma interface que fará que o método retorne uma conexão
    // throws SQLException indica que o método pode lançar uma exceção sql caso tenha algum erro
    static Connection conectar() throws SQLException{
        //Essa linha realmente cria a conexão com o banco usando os três parâmetros, ele localiza o driver JDBC e estabelce a conexão
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
