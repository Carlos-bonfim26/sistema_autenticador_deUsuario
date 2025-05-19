/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadeautenticacao;

/**
 *
 * @author carlo
 */
public class PainelReal implements Painel{
    private String nomeUsuario;

    public PainelReal(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    @Override
    public void acessar(){
        System.out.println("Bem vindo ao painel, "+ nomeUsuario + "!");
    }
}
