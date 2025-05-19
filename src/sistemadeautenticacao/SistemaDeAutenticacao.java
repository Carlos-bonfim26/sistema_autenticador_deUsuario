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
        
      AuthFacade auth = new AuthFacade();
      
      // auth.cadastrar("Carlos", "Carlosbonfim772@gmail.com", "cb722");
      
      //auth.cadastrar("João Pedro", "Joaopedro@email.com", "joao123");
      Painel painel = new PainelProxy("Carlosbonfim772@gmail.com", "cb722", auth);
      Painel painel2 = new PainelProxy("Joaopedro@email.com", "joao123", auth);
      
      painel.acessar();
      painel2.acessar();
    }
    
}
