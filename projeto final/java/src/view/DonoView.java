package src.view;

import src.controller.DonoController;
import src.model.Dono;

import java.util.List;
import java.util.Scanner;

public class DonoView {
    public static void menuDono() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Donos ===");
            System.out.println("1. Adicionar Dono");
            System.out.println("2. Atualizar Dono");
            System.out.println("3. Excluir Dono");
            System.out.println("4. Listar Donos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarDono(scanner);
                    break;
                case 2:
                    atualizarDono(scanner);
                    break;
                case 3:
                    excluirDono(scanner);
                    break;
                case 4:
                    listarDonos();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarDono(Scanner scanner) {
        Dono dono = new Dono();

        System.out.print("ID do Dono: ");
        dono.setIdDono(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Tipo (F/J): ");
        dono.setTipo(scanner.nextLine());
        System.out.print("Nome: ");
        dono.setNome(scanner.nextLine());
        System.out.print("Razão Social: ");
        dono.setRazaoSocial(scanner.nextLine());
        System.out.print("CPF: ");
        dono.setCpf(scanner.nextLine());
        System.out.print("CNPJ: ");
        dono.setCnpj(scanner.nextLine());
        System.out.print("Email: ");
        dono.setEmail(scanner.nextLine());
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        dono.setDataNascimento(scanner.nextLine());

        DonoController.adicionarDono(dono);
    }

    private static void atualizarDono(Scanner scanner) {
        System.out.print("ID do Dono a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Dono dono = new Dono();
        System.out.print("Novo Tipo (F/J): ");
        dono.setTipo(scanner.nextLine());
        System.out.print("Novo Nome: ");
        dono.setNome(scanner.nextLine());
        System.out.print("Nova Razão Social: ");
        dono.setRazaoSocial(scanner.nextLine());
        System.out.print("Novo CPF: ");
        dono.setCpf(scanner.nextLine());
        System.out.print("Novo CNPJ: ");
        dono.setCnpj(scanner.nextLine());
        System.out.print("Novo Email: ");
        dono.setEmail(scanner.nextLine());
        System.out.print("Nova Data de Nascimento (AAAA-MM-DD): ");
        dono.setDataNascimento(scanner.nextLine());

        DonoController.atualizarDono(id, dono);
    }

    private static void excluirDono(Scanner scanner) {
        System.out.print("ID do Dono a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DonoController.excluirDono(id);
    }

    private static void listarDonos() {
        List<Dono> donos = DonoController.listarDonos();

        System.out.println("\n=== Lista de Donos ===");
        for (Dono dono : donos) {
            System.out.println(dono);
        }
    }
}
