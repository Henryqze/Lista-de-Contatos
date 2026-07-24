package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        ArrayList<Pessoa> contatos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            menu();
            try{
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

        if(remover >= 1 && remover <= contatos.size()) {
            contatos.remove(remover - 1);
        }else{
            System.out.println("Não encontrado.");
        }


        System.out.println("Excluindo contato da listagem.");
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

    public static void sair(){
        System.out.println("Saindo do aplicativo, volte sempre!");
    }

}

