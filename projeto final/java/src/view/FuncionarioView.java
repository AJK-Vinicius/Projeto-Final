package src.view;

import src.controller.FuncionarioController;
import src.model.Funcionario;

import java.util.List;
import java.util.Scanner;

public class FuncionarioView {

    public static void menuFuncionario() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Funcionários ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Atualizar Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(scanner);
                    break;
                case 2:
                    atualizarFuncionario(scanner);
                    break;
                case 3:
                    removerFuncionario(scanner);
                    break;
                case 4:
                    listarFuncionarios();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarFuncionario(Scanner scanner) {
        Funcionario funcionario = new Funcionario();

        System.out.print("ID do Funcionário: ");
        funcionario.setIdFuncionario(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nome do Funcionário: ");
        funcionario.setNome(scanner.nextLine());
        System.out.print("CPF do Funcionário: ");
        funcionario.setCpf(scanner.nextLine());
        System.out.print("Email do Funcionário: ");
        funcionario.setEmail(scanner.nextLine());
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        funcionario.setDataNascimento(scanner.nextLine());

        FuncionarioController.adicionarFuncionario(funcionario);
    }

    private static void atualizarFuncionario(Scanner scanner) {
        System.out.print("ID do Funcionário a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = new Funcionario();
        System.out.print("Novo Nome do Funcionário: ");
        funcionario.setNome(scanner.nextLine());
        System.out.print("Novo CPF do Funcionário: ");
        funcionario.setCpf(scanner.nextLine());
        System.out.print("Novo Email do Funcionário: ");
        funcionario.setEmail(scanner.nextLine());
        System.out.print("Nova Data de Nascimento (AAAA-MM-DD): ");
        funcionario.setDataNascimento(scanner.nextLine());

        FuncionarioController.atualizarFuncionario(id, funcionario);
    }

    private static void removerFuncionario(Scanner scanner) {
        System.out.print("ID do Funcionário a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        FuncionarioController.excluirFuncionario(id);
    }

    private static void listarFuncionarios() {
        List<Funcionario> funcionarios = FuncionarioController.listarFuncionarios();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("\n=== Lista de Funcionários ===");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getIdFuncionario());
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
                System.out.println();
            }
        }
    }
}
