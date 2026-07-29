package br.com.listatelefonica;

public class Emergencia extends Contatos {
   private String relacao;

    public Emergencia(String nome, String numeroCelular, String relacao){
        super(nome, numeroCelular);
       this.relacao = relacao;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    @Override
    public String toString(){
        String mensagem = String.format("Emergência: %s | Número: %s | Relação %s", getNome(), getNumeroCelular(), relacao);
        return mensagem;
    }
}
