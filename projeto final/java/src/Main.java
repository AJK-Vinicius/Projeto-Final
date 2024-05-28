package src;

import src.view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Gerenciamento Veterinário ===");
            System.out.println("1. Gerenciar Animais");
            System.out.println("2. Gerenciar Donos");
            System.out.println("3. Gerenciar Funcionários");
            System.out.println("4. Gerenciar Consultas");
            System.out.println("5. Gerenciar Serviços");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    AnimalView.menuAnimal();
                    break;
                case 2:
                    DonoView.menuDono();
                    break;
                case 3:
                    FuncionarioView.menuFuncionario();
                    break;
                case 4:
                    ConsultaView.menuConsulta();
                    break;
                case 5:
                    ServicoView.menuServico();
                    break;
                case 0:
                    System.out.println("Encerrando o Sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
