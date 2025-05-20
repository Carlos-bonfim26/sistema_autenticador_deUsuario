/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadeautenticacao;

import java.sql.SQLException;


/**
 *
 * @author carlo
 */
public class PainelProxy implements Painel{
    private String email;
    private String senha;
    private AuthFacade auth;
    private PainelReal painelReal;

    public PainelProxy(String email, String senha, AuthFacade auth) {
        this.email = email;
        this.senha = senha;
        this.auth = auth;
    }
    
    @Override 
    public void acessar(){
        // tenta logar o usuário por via de seu usuário e senha
        try {
            Usuario usuario = auth.login(email, senha);
            if(usuario != null){
                painelReal = new PainelReal(usuario.getNome());
                painelReal.acessar();
            }else{
                System.out.println("Acesso negado, Usuário não autenticado");
            }
        } catch (SQLException e) {
            // exceção caso tenha erros
            System.out.println("Erro na autenticação" + e.getMessage());
        }
    }
}
