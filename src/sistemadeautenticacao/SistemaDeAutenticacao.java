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

      //cadastro do usuário
      auth.cadastrar("Carlos Bonfim", "Carlosbonfim@email.com", "pfvrProfessorMeDe40pontos");

      //criação do painel para o usuário
      Painel painel = new PainelProxy("Carlosbonfim@email.com", "pfvrProfessorMeDe40pontos", auth);

      //acesso ao usuário
      painel.acessar();
    }
    
}
