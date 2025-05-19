/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadeautenticacao;

/**
 *
 * @author carlo
 */
public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
       
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    
    
}
