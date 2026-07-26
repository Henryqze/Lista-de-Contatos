package org.example;

public class Pessoa {
    private  String nome;
    private String numeroCelular;
    private String email;

    public Pessoa(String nome, String numeroCelular, String email){
        this.nome = nome;
        this.numeroCelular = numeroCelular;
        this.email = email;

    }

    public String getNumeroCelular(){

        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNome(){

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        String mensagem = String.format("Nome: %s | Celular: %s | Email: %s ", nome, numeroCelular, email);
        return mensagem;
    }
}
