package model;

public class Medicamento {
    // atributos da classe (caracteristica do medicamento)
    public int id;
    public String nome;
    public String horario;
    public int quantidadeComprimidos;
    public int dias;
    
    // construtor da classe: inicia os atributos ao cria um objeto
    public Medicamento(int id, String nome, String horario, int quantidadeComprimidos, int dias){
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.quantidadeComprimidos = quantidadeComprimidos;
        this.dias = dias;
    }
    
    // metodo que retorna uma string com os detalhes
    public String detalhes(){
        return "ID: " + id +
                "\nNome: " + nome +
                "\nHorario: " + horario +
                "\nComprimidos: " + quantidadeComprimidos +
                "\nDias: " + dias;
                
    }
    
}
