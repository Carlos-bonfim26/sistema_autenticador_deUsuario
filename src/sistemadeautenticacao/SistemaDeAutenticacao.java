/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadeautenticacao;

/**
 *
 * @author carlo
 */
public class SistemaDeAutenticacao {

 
    public static void main(String[] args) {
        // criação do autenticador
      AuthFacade auth = new AuthFacade();
      // exemplo de usuário que já está criado
      //auth.cadastrar("João Pedro", "Joaopedro@email.com", "joao123");

      // painel do usuário
      Painel painel = new PainelProxy("Carlosbonfim772@gmail.com", "cb722", auth);
      Painel painel2 = new PainelProxy("Joaopedro@email.com", "joao123", auth);
      
      // tentativa de acesso
      painel.acessar();
      painel2.acessar();
    }
    
}
