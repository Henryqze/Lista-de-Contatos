package br.com.listatelefonica;

public class Pessoa extends Contatos {
    private String email;

    public Pessoa(String nome, String numeroCelular, String email){
        super(nome, numeroCelular);
        this.email = email;

    }
    public String getEmail(){

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        String mensagem = String.format("Nome: %s | Celular: %s | Email: %s ",getNome(), getNumeroCelular(), email);
        return mensagem;
    }
}
