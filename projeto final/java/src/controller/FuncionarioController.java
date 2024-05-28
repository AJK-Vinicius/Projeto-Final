package src.controller;

import src.database.Database;
import src.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    public static void adicionarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionarios (IDFuncionario, Nome, CPF, Email, DataNascimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, funcionario.getIdFuncionario());
            pstmt.setString(2, funcionario.getNome());
            pstmt.setString(3, funcionario.getCpf());
            pstmt.setString(4, funcionario.getEmail());
            pstmt.setString(5, funcionario.getDataNascimento());

            pstmt.executeUpdate();
            System.out.println("Funcionario adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarFuncionario(int id, Funcionario funcionario) {
        String sql = "UPDATE Funcionarios SET Nome = ?, CPF = ?, Email = ?, DataNascimento = ? WHERE IDFuncionario = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getEmail());
            pstmt.setString(4, funcionario.getDataNascimento());
            pstmt.setInt(5, id);

            pstmt.executeUpdate();
            System.out.println("Funcionario atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirFuncionario(int id) {
        String sql = "DELETE FROM Funcionarios WHERE IDFuncionario = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Funcionario excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionarios";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("IDFuncionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setDataNascimento(rs.getString("DataNascimento"));

                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return funcionarios;
    }
}
