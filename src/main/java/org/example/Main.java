package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main{
    static ArrayList<Pessoa> contatos = new ArrayList<>();
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            menu();
            try{
                opcao = entrada.nextInt();
                entrada.nextLine();
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("As opções existentes são apenas as listadas acima.");
                entrada.nextLine();
            }
            switch (opcao) {
                case 1:
                    System.out.println("Adicionando...");
                    adicionarContato(contatos, entrada);
                    break;
                case 2:
                    System.out.println("Listando...");
                    listarContatos(contatos);
                    break;
                case 3:
                    System.out.println("Buscando...");
                    buscarNome(contatos, entrada);
                    break;
                case 4:
                    System.out.println("Excluindo...");
                    excluirContatos(contatos, entrada);
                    break;
                case 5:
                    sair();
                    System.out.println("-----------");
                    break;
                default:
                    System.out.println("Somente as opções já passadas.");
                    break;
            }


        }
    }

    public static void menu(){
        String mensagem = "MENU \n" +
                "1 - Adicionar contato\n" +
                "2 - Listar contatos\n" +
                "3 - Encontrar por nome\n" +
                "4 - Excluir contatos\n" +
                "5 - Sair\n" +
                "Escolha sua opção: ";
        System.out.print(mensagem);
    }

     public static void adicionarContato(ArrayList<Pessoa> contatos, Scanner entrada){
         System.out.println("Digite o nome da pessoa: ");
         String nome = entrada.nextLine();

         System.out.println("Digite o número: ");
         String numeroCelular = entrada.nextLine();

         Pessoa contato = new Pessoa(nome, numeroCelular);

         contatos.add(contato);

    }

    public static void listarContatos(ArrayList<Pessoa> contatos){
        if(contatos.isEmpty()) {
            System.out.println("Lista de contatos vazia.");
        }else {
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println((i + 1) + " - " + contatos.get(i).getNome() + " | " + contatos.get(i).getNumeroCelular());
            }
        }

    }

    public static void excluirContatos(ArrayList<Pessoa> contatos, Scanner entrada){
        if (contatos.isEmpty()){
            System.out.println("Nenhum contato para excluir");
            return;
        }

        for (int i = 0; i < contatos.size(); i++) {
            System.out.println((i + 1) + " - " + contatos.get(i).getNome() + " | " + contatos.get(i).getNumeroCelular());
        }
        System.out.print("Deseja remover qual contato: ");
        int remover = entrada.nextInt();
        contatos.remove(remover - 1);
        System.out.println("Excluindo contato da listagem.");
    }


    public static void buscarNome(ArrayList<Pessoa> contatos, Scanner entrada) {
        if (contatos.isEmpty()){
            System.out.println("Nenhuma nome para procurar");
            return;
        }

        System.out.print("Qual o nome do contato que deseja procurar: ");
        String procurar = entrada.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().toLowerCase().contains(procurar.toLowerCase())){
                System.out.println((i + 1) + " - " + contatos.get(i).getNome() + " | " + contatos.get(i).getNumeroCelular());
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Nenhum contato encontrado.");

        }

    }

    public static void sair(){
        System.out.println("Saindo do aplicativo, volte sempre!");
    }

}

