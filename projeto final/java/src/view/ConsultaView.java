package src.view;

import src.controller.ConsultaController;
import src.model.Consulta;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class ConsultaView {
    public static void menuConsulta() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Consultas ===");
            System.out.println("1. Adicionar Consulta");
            System.out.println("2. Atualizar Consulta");
            System.out.println("3. Remover Consulta");
            System.out.println("4. Listar Consultas");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarConsulta(scanner);
                    break;
                case 2:
                    atualizarConsulta(scanner);
                    break;
                case 3:
                    removerConsulta(scanner);
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

    private static void adicionarConsulta(Scanner scanner) {
        Consulta consulta = new Consulta();

        System.out.print("ID da Consulta: ");
        consulta.setIdConsulta(scanner.nextInt());
        scanner.nextLine();
        System.out.print("ID do Animal: ");
        consulta.setIdAnimal(scanner.nextInt());
        scanner.nextLine();
        System.out.print("ID do Serviço: ");
        consulta.setIdServico(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Data da Consulta (yyyy-MM-dd): ");
        consulta.setDataConsulta(scanner.nextLine());
        System.out.print("Hora da Consulta (HH:mm:ss): ");
        consulta.setHoraConsulta(scanner.nextLine());
        System.out.print("Motivo da Consulta: ");
        consulta.setMotivoConsulta(scanner.nextLine());
        System.out.print("Diagnóstico: ");
        consulta.setDiagnostico(scanner.nextLine());
        System.out.print("Tratamento: ");
        consulta.setTratamento(scanner.nextLine());

        if (isValidDate(consulta.getDataConsulta()) && isValidTime(consulta.getHoraConsulta())) {
            ConsultaController.adicionarConsulta(consulta);
        } else {
            System.out.println("Erro: Formato de data ou hora inválido.");
        }
    }

    private static void atualizarConsulta(Scanner scanner) {
        System.out.print("ID da Consulta a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = new Consulta();
        System.out.print("Novo ID do Animal: ");
        consulta.setIdAnimal(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Novo ID do Serviço: ");
        consulta.setIdServico(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nova Data da Consulta (yyyy-MM-dd): ");
        consulta.setDataConsulta(scanner.nextLine());
        System.out.print("Nova Hora da Consulta (HH:mm:ss): ");
        consulta.setHoraConsulta(scanner.nextLine());
        System.out.print("Novo Motivo da Consulta: ");
        consulta.setMotivoConsulta(scanner.nextLine());
        System.out.print("Novo Diagnóstico: ");
        consulta.setDiagnostico(scanner.nextLine());
        System.out.print("Novo Tratamento: ");
        consulta.setTratamento(scanner.nextLine());

        if (isValidDate(consulta.getDataConsulta()) && isValidTime(consulta.getHoraConsulta())) {
            ConsultaController.atualizarConsulta(id, consulta);
        } else {
            System.out.println("Erro: Formato de data ou hora inválido.");
        }
    }

    private static void removerConsulta(Scanner scanner) {
        System.out.print("ID da Consulta a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ConsultaController.excluirConsulta(id);
    }

    private static void listarConsultas() {
        List<Consulta> consultas = ConsultaController.listarConsultas();

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            System.out.println("\n=== Lista de Consultas ===");
            for (Consulta consulta : consultas) {
                System.out.println("ID: " + consulta.getIdConsulta());
                System.out.println("ID Animal: " + consulta.getIdAnimal());
                System.out.println("ID Serviço: " + consulta.getIdServico());
                System.out.println("Data: " + consulta.getDataConsulta());
                System.out.println("Hora: " + consulta.getHoraConsulta());
                System.out.println("Motivo: " + consulta.getMotivoConsulta());
                System.out.println("Diagnóstico: " + consulta.getDiagnostico());
                System.out.println("Tratamento: " + consulta.getTratamento());
                System.out.println();
            }
        }
    }

    private static boolean isValidDate(String date) {
        try {
            Date.valueOf(date);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean isValidTime(String time) {
        try {
            Time.valueOf(time);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
