package src.controller;

import src.database.Database;
import src.model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {

    public static void adicionarAnimal(Animal animal) {
        String sql = "INSERT INTO Animais (IDAnimal, IDDono, Nome, Especie, Raca, Idade, Sexo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animal.getIdAnimal());
            pstmt.setInt(2, animal.getIdDono());
            pstmt.setString(3, animal.getNome());
            pstmt.setString(4, animal.getEspecie());
            pstmt.setString(5, animal.getRaca());
            pstmt.setString(6, animal.getIdade());
            pstmt.setString(7, String.valueOf(animal.getSexo()));

            pstmt.executeUpdate();
            System.out.println("Animal adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarAnimal(int id, Animal animal) {
        String sql = "UPDATE Animais SET Nome = ?, Especie = ?, Raca = ?, Idade = ?, Sexo = ? WHERE IDAnimal = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animal.getNome());
            pstmt.setString(2, animal.getEspecie());
            pstmt.setString(3, animal.getRaca());
            pstmt.setString(4, animal.getIdade());
            pstmt.setString(5, String.valueOf(animal.getSexo()));
            pstmt.setInt(6, id);

            pstmt.executeUpdate();
            System.out.println("Animal atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirAnimal(int id) {
        String sql = "DELETE FROM Animais WHERE IDAnimal = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Animal excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Animal> listarAnimais() {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT * FROM Animais";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(rs.getInt("IDAnimal"));
                animal.setIdDono(rs.getInt("IDDono"));
                animal.setNome(rs.getString("Nome"));
                animal.setEspecie(rs.getString("Especie"));
                animal.setRaca(rs.getString("Raca"));
                animal.setIdade(rs.getString("Idade"));
                animal.setSexo(rs.getString("Sexo").charAt(0));

                animais.add(animal);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return animais;
    }
}
