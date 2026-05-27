package model;

public class Usuario {
    // atributos da classe usuario
    public String nome;
    public String senha;
    public String telefone;
    public String endereco;
    public String email;
    public String sexo;
    public int idade;
    
    // construtor da classe: inicia os atributos ao cria um objeto
    public Usuario(String nome, String senha, String telefone, String endereco, String email, String sexo, int idade){
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.sexo = sexo;
        this.idade= idade;
    }
}
