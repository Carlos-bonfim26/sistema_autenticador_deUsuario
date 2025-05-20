[mysql]: https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
[netbeans]: https://img.shields.io/badge/apache%20netbeans-1B6AC6?style=for-the-badge&logo=apache%20netbeans%20IDE&logoColor=white
[java]: https://img.java.io/badge/Microsoft_Office-D83B01?style=for-the-badge&logo=microsoft-office&logoColor=white

# 📱Sistema de autenticação de usuário

![Java](https://img.shields.io/badge/Java-FF5349?style=for-the-badge&logo=**java**&logoColor=blac)
![MYSQL]
![NETBEANS]

## 🤔 O que faz?

O sistema de autenticação criado pode cadastrar usuários no banco de dados e poder dar acesso ou não a esses usuários quando tentarem acessar, dependendo se já está cadastrado e se usou de digitou sua senha de forma correta no momento do login.

## 🎯 Motivo por eu ter feito

O projeto faz parte da minha entrega de A3 de um projeto na faculdade, sou estudante do 3° semestre em ADS na anhembi morumbi, o desafio era criar alguma aplicação em java que utilize dois design patterns, caso queira saber mais um pouco pode visitar o meu outro repositório sobre [Design Patterns](https://github.com/Carlos-bonfim26/design-Patterns-3S-UAM), os design patterns escolhidos foram o proxy e o facade.

## 😎 Como você pode utilizar

clone o repositório digitando isso no terminal(recomendo estar dentro de alguma pasta):

```bash
git clone https://github.com/seu-usuario/sistema_autenticador_deUsuario.git
```

baixe o mysql, se não tiver e dentro do seu terminal mysql ou em algum ambiente de desenvolvimento como por exemplo o Workbench rode esses comandos:

```bash
create database sistema_usuarios;

use sistema_usuarios;

create table usuarios(
idUser int auto_increment primary key,
nome varchar(100),
email varchar(100) unique,
senha varchar(50)
);
```

esses comandos também estão na pasta sql.

se não tiver o driver JDBC do Mysql também necessita baixa-lo:
[link do driver](https://dev.mysql.com/downloads/connector/j/)

no projeto esse driver já foi aplicado e está na pasta lib, mas caso tenha complicações, no netbeans você ira seguir esses passos:

- No NetBeans, clique com o botão direito no seu projeto (SistemaDeAutenticacao).

- Vá em Propriedades.

- No menu da esquerda, clique em Bibliotecas.

- Vá até a aba Compile (ou Compilação).

- Clique em Adicionar JAR/Pasta (adicone uma classpath).

- Navegue até a pasta lib e selecione o arquivo .jar.

- Clique em OK para adicionar.

## 🏠 Facade (fachada)

O facade serve para que o usuário não tenha que interagir com todas as classes, escondendo funcionalidades e classes mais complexas por meio de uma "fachada" e deixando exposto apenas o que o usuário necessita usar e ver.

Fazendo uma analogia, o facade seria um controle remoto, o controle remoto tem várias várias funções e botões, mas que estão escondidas pela interface dele, você não interagi direto com a placa, e sim com o pedaço de plástico envolta, isso o facade faz, deixa o mais simples para o usuário ver exposto e esconde a complexidade atrás, assim também comprindo o conceito de encapsulamento.

### 💻exemplo no código

A classe AuthFacade faz isso, ela á principal classe, fazendo o cadastro e verificando o login do usuário, por trás de metódos simples que o usuário chama como o cadastrar( ), e o de login( ), o cliente não consegue ver o código por trás disso, apenas o que é importante para ele.

```bash

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
# resto do código...
}
```

## 💁‍♂️Proxy

O proxy funciona como um substituto ou intermédiario de um serviço entre o objeto final e o usuário, fazendo uma analogia, é que nem quando você vai no banco, você não vai no dinheiro do banco direto sacar, você vai passar por um intermediário antes, um atendente ou o caixa eletrônico, ele protege o objeto final e pode adicionar funcionalidades extras sem alterar a classe original.

### 💻exemplo no código

A classe PainelProxy é um ótimo exemplo, onde ela é o intermediário para o usuário fazer o Login, controlando o acesso por via de um método, onde ela não só protege o AuthFacade e o PainelReal também que é quem verdadeiramente disponibiliza o acesso ao usuário.

```bash
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
        try {
            Usuario usuario = auth.login(email, senha);
            if(usuario != null){
                painelReal = new PainelReal(usuario.getNome());
                painelReal.acessar();
            }else{
                System.out.println("Acesso negado, Usuário não autenticado");
            }
        } catch (SQLException e) {
            System.out.println("Erro na autenticação" + e.getMessage());
        }
    }
}
```

# 👨‍💻Desenvolvedor

 <div style="display:flex; flex-direction:column;">
 <img src="https://github.com/Carlos-bonfim26.png?size=200" width=200>
 <a href="https://www.linkedin.com/in/carlosbonfim26/" target="_blank" style="font-size: 1.8rem">Carlos Bonfim</a>
 </div>

## 🧑‍💼Colaboradores

  <div style= "display: flex; gap: 0.5rem;">
      <div style="display:flex; flex-direction:column;">
      <img src="https://github.com/leoduarte14.png?size=115" width=115>
       <a href="https://www.linkedin.com/in/leonardo-duarte-pereira-a4705b255/" target="_blank">Leonardo Duarte</a>
       </div>
       <div style="display:flex; flex-direction:column;">
      <img src="https://github.com/leoduarte14.png?size=115" width=115>
       <a href="https://www.linkedin.com/in/yanferrezin/" target="_blank">Yan Souza</a>
       </div>
       <div style="display:flex; flex-direction:column;">
      <img src="https://github.com/JoaquimGuilhermeNunesLeal.png?size=115" width=115>
       <a href="https://www.linkedin.com/in/guilherme-nunes-a7415b2ba/" target="_blank">Joaquim Guilherme</a>
       </div>
  </div>
