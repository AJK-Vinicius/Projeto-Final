package src.view;

import src.controller.ConsultaController;
import src.model.Consulta;

import java.util.List;
import java.util.Scanner;

public class ConsultaView {
    public static void menuConsulta() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Consultas ===");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Atualizar Status da Consulta");
            System.out.println("3. Cancelar Consulta");
            System.out.println("4. Listar Consultas");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    agendarConsulta(scanner);
                    break;
                case 2:
                    atualizarStatusConsulta(scanner);
                    break;
                case 3:
                    cancelarConsulta(scanner);
                    break;
                case 4:
                    listarConsultas();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void agendarConsulta(Scanner scanner) {
        Consulta consulta = new Consulta();

        System.out.print("ID do Animal: ");
        consulta.setIdAnimal(scanner.nextInt());
        scanner.nextLine();
        System.out.print("ID do Serviço: ");
        consulta.setIdServico(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Data da Consulta (AAAA-MM-DD): ");
        consulta.setDataConsulta(scanner.nextLine());
        System.out.print("Hora da Consulta (HH:MM): ");
        consulta.setHoraConsulta(scanner.nextLine());
        System.out.print("Motivo da Consulta: ");
        consulta.setMotivoConsulta(scanner.nextLine());

        ConsultaController.agendarConsulta(consulta);
    }

    private static void atualizarStatusConsulta(Scanner scanner) {
        System.out.print("ID da Consulta a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo Status (Confirmada/Cancelada): ");
        String novoStatus = scanner.nextLine();

        ConsultaController.atualizarStatusConsulta(id, novoStatus);
    }

    private static void cancelarConsulta(Scanner scanner) {
        System.out.print("ID da Consulta a ser cancelada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ConsultaController.cancelarConsulta(id);
    }

    private static void listarConsultas() {
        List<Consulta> consultas = ConsultaController.listarConsultas();

        System.out.println("\n=== Lista de Consultas ===");
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }
}
