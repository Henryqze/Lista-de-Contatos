package org.example;

public class Pessoa {
    private String nome;
    private String numeroCelular;

    public Pessoa(String nome, String numeroCelular){
        this.nome = nome;
        this.numeroCelular = numeroCelular;

    }

    public String getNumeroCelular(){
        return numeroCelular;
    }

    public String getNome(){

        return nome;
    }
}
