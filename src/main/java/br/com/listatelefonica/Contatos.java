package br.com.listatelefonica;

public class Contatos {
    private String nome;
    private String numeroCelular;

    public Contatos(String nome, String numeroCelular){
        this.nome = nome;
        this.numeroCelular = numeroCelular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
