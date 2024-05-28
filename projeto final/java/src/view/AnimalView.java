package src.view;

import src.controller.AnimalController;
import src.model.Animal;

import java.util.List;
import java.util.Scanner;

public class AnimalView {
    public static void menuAnimal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Animais ===");
            System.out.println("1. Adicionar Animal");
            System.out.println("2. Atualizar Animal");
            System.out.println("3. Excluir Animal");
            System.out.println("4. Listar Animais");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAnimal(scanner);
                    break;
                case 2:
                    atualizarAnimal(scanner);
                    break;
                case 3:
                    excluirAnimal(scanner);
                    break;
                case 4:
                    listarAnimais();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarAnimal(Scanner scanner) {
        Animal animal = new Animal();

        System.out.print("ID do Animal: ");
        animal.setIdAnimal(scanner.nextInt());
        scanner.nextLine();
        System.out.print("ID do Dono: ");
        animal.setIdDono(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nome: ");
        animal.setNome(scanner.nextLine());
        System.out.print("Espécie: ");
        animal.setEspecie(scanner.nextLine());
        System.out.print("Raça: ");
        animal.setRaca(scanner.nextLine());
        System.out.print("Idade: ");
        animal.setIdade(scanner.nextLine());
        System.out.print("Sexo (M/F): ");
        animal.setSexo(scanner.nextLine().charAt(0));

        AnimalController.adicionarAnimal(animal);
    }

    private static void atualizarAnimal(Scanner scanner) {
        System.out.print("ID do Animal a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = new Animal();
        System.out.print("Novo Nome: ");
        animal.setNome(scanner.nextLine());
        System.out.print("Nova Espécie: ");
        animal.setEspecie(scanner.nextLine());
        System.out.print("Nova Raça: ");
        animal.setRaca(scanner.nextLine());
        System.out.print("Nova Idade: ");
        animal.setIdade(scanner.nextLine());
        System.out.print("Novo Sexo (M/F): ");
        animal.setSexo(scanner.nextLine().charAt(0));

        AnimalController.atualizarAnimal(id, animal);
    }

    private static void excluirAnimal(Scanner scanner) {
        System.out.print("ID do Animal a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AnimalController.excluirAnimal(id);
    }

    private static void listarAnimais() {
        List<Animal> animais = AnimalController.listarAnimais();

        System.out.println("\n=== Lista de Animais ===");
        for (Animal animal : animais) {
            System.out.println(animal);
        }
    }
}
