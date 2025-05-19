
package sistemadeautenticacao;

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
    
    static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
