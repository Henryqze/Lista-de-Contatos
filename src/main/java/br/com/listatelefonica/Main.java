package br.com.listatelefonica;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        ArrayList<Pessoa> contatos = new ArrayList<>();

        ArrayList<Emergencia> contatosEmergencia = new ArrayList<>();


        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        boolean valida = false;

        while (opcao != 7 && !valida) {
            Menu mostrarMenu = new Menu();
            mostrarMenu.Menu();
            if (entrada.hasNextInt()) {
                try {
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("As opções existentes são apenas as listadas acima.");
                    entrada.nextLine();
                }
                switch (opcao) {
                    case 1:
                        adicionarContato(contatos, entrada);
                        break;
                    case 2:
                        listarContatos(contatos);
                        break;
                    case 3:
                        buscarNome(contatos, entrada);
                        break;
                    case 4:
                        excluirContatos(contatos, entrada);
                        break;
                    case 5:
                        emergencia(contatosEmergencia, entrada);
                        break;
                    case 6:
                        mostrarEmergencia(contatosEmergencia, entrada);
                        break;
                    case 7:
                        sair();
                        System.out.println("-----------");
                        break;
                    default:
                        System.out.println("Somente as opções já passadas.");
                        break;
                }
            }else{
                System.out.println("Não é permitido letras, apenas números.");
                entrada.nextLine();
            }
        }

    }

     public static void adicionarContato(ArrayList<Pessoa> contatos, Scanner entrada){
            String nome, numeroCelular, email;

            do {
                System.out.println("Digite o nome da pessoa: ");
                nome = entrada.nextLine();
                if (nome.isBlank()){
                    System.out.println("Nome necessário.");
                }
            }while (nome.isBlank());

            do {
                System.out.println("Digite o número: ");
                numeroCelular = entrada.nextLine();
                if (numeroCelular.isBlank()){
                    System.out.println("Número necessário.");
                }
            }while(numeroCelular.isBlank());

            do {
                System.out.println("Digite o email: ");
                email = entrada.nextLine();
                if (email.isBlank()){
                    System.out.println("Email necessário.");
                }
            }while (email.isBlank());



            System.out.println("Adicionando...");
            Pessoa contato = new Pessoa(nome, numeroCelular, email);
            contatos.add(contato);

    }

    public static void listarContatos(ArrayList<Pessoa> contatos){
        if(contatos.isEmpty()) {
            System.out.println("Lista de contatos vazia.");
        }else {
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println((i + 1) + " - " + contatos.get(i));
            }
        }

    }

    public static void excluirContatos(ArrayList<Pessoa> contatos, Scanner entrada){
        if (contatos.isEmpty()){
            System.out.println("Nenhum contato para excluir");
            return;
        }

        for (int i = 0; i < contatos.size(); i++) {
            System.out.println((i + 1) + " - " + contatos.get(i));
        }

        System.out.print("Deseja remover qual contato: ");
        int remover = entrada.nextInt();
        entrada.nextLine();

        if(remover >= 1 && remover <= contatos.size()) {
            contatos.remove(remover - 1);
            System.out.println("Excluindo contato da listagem.");
        }else{
            System.out.println("Não encontrado.");
        }


    }


    public static void buscarNome(ArrayList<Pessoa> contatos, Scanner entrada) {
        if (contatos.isEmpty()){
            System.out.println("Nenhum contato na lista.");
            return;
        }

        System.out.print("Qual o nome do contato que deseja procurar: ");
        String procurar = entrada.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().toLowerCase().contains(procurar.toLowerCase())){
                System.out.println((i + 1) + " - " + contatos.get(i));
                encontrado = true;
            }
        }

        if (!encontrado){
            System.out.println("Nenhum contato encontrado.");

        }

    }

    public static void emergencia(ArrayList<Emergencia> contatosEmergencia, Scanner entrada){
        String nome, numeroCelular, relacao;

        do {
            System.out.println("Digite o nome da pessoa: ");
            nome = entrada.nextLine();
            if (nome.isBlank()){
                System.out.println("Nome necessário.");
            }
        }while (nome.isBlank());

        do {
            System.out.println("Digite o número: ");
            numeroCelular = entrada.nextLine();
            if (numeroCelular.isBlank()){
                System.out.println("Número necessário.");
            }
        }while(numeroCelular.isBlank());

        do {
            System.out.println("Digite o Parentesco: ");
            relacao = entrada.nextLine();
            if (relacao.isBlank()){
                System.out.println("Parentesco necessário.");
            }
        }while(relacao.isBlank());

        System.out.println("Adicionando contato de Emergência...");
        Emergencia somenteEmergencia = new Emergencia(nome, numeroCelular, relacao);
        contatosEmergencia.add(somenteEmergencia);
    }


    public static void mostrarEmergencia(ArrayList<Emergencia> contatosEmergencia, Scanner entrada){
        if (contatosEmergencia.isEmpty()){
            System.out.println("Contato de Emergência vazio.");
            return;
        }
        System.out.print("Qual o nome do contato que deseja procurar: ");
        String procurar = entrada.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contatosEmergencia.size(); i++) {
            if (contatosEmergencia.get(i).getNome().toLowerCase().contains(procurar.toLowerCase())) {
                System.out.println((i + 1) + " - " + contatosEmergencia.get(i));
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Não existe esse contato de emergência.");
        }

    }


    public static void sair(){
        System.out.println("Saindo do aplicativo, volte sempre!");

    }

}

