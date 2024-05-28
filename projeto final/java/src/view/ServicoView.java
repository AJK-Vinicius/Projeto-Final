package src.view;

import src.controller.ServicoController;
import src.model.Servico;

import java.util.List;
import java.util.Scanner;

public class ServicoView {
    public static void menuServico() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Serviços ===");
            System.out.println("1. Adicionar Serviço");
            System.out.println("2. Atualizar Serviço");
            System.out.println("3. Remover Serviço");
            System.out.println("4. Listar Serviços");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarServico(scanner);
                    break;
                case 2:
                    atualizarServico(scanner);
                    break;
                case 3:
                    removerServico(scanner);
                    break;
                case 4:
                    listarServicos();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void listarServicos() {
    }

    private static void adicionarServico(Scanner scanner) {
        Servico servico = new Servico();

        System.out.print("ID do Serviço: ");
        servico.setIdServico(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nome do Serviço: ");
        servico.setNomeServico(scanner.nextLine());
        System.out.print("Descrição: ");
        servico.setDescricao(scanner.nextLine());
        System.out.print("Preço: ");
        servico.setPreco(scanner.nextDouble());
        scanner.nextLine();

        ServicoController.adicionarServico(servico);
    }

    private static void atualizarServico(Scanner scanner) {
        System.out.print("ID do Serviço a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Servico servico = new Servico();
        System.out.print("Novo Nome do Serviço: ");
        servico.setNomeServico(scanner.nextLine());
        System.out.print("Nova Descrição: ");
        servico.setDescricao(scanner.nextLine());
        System.out.print("Novo Preço: ");
        servico.setPreco(scanner.nextDouble());
        scanner.nextLine();

        ServicoController.atualizarServico(id, servico);
    }

    private static void removerServico(Scanner scanner) {
        System.out.print("ID do Serviço a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ServicoController.removerServico(id);
    }
}