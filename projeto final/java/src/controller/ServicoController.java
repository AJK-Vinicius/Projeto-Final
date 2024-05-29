package src.controller;

import src.database.Database;
import src.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoController {

    public static void adicionarServico(Servico servico) {
        String sql = "INSERT INTO Servicos (IDServico, NomeServico, Descricao, Preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, servico.getIdServico());
            pstmt.setString(2, servico.getNomeServico());
            pstmt.setString(3, servico.getDescricao());
            pstmt.setDouble(4, servico.getPreco());

            pstmt.executeUpdate();
            System.out.println("Servico adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarServico(int id, Servico servico) {
        String sql = "UPDATE Servicos SET NomeServico = ?, Descricao = ?, Preco = ? WHERE IDServico = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, servico.getNomeServico());
            pstmt.setString(2, servico.getDescricao());
            pstmt.setDouble(3, servico.getPreco());
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
            System.out.println("Servico atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirServico(int id) {
        String sql = "DELETE FROM Servicos WHERE IDServico = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Servico excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Servico> listarServicos() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM Servicos";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setIdServico(rs.getInt("IDServico"));
                servico.setNomeServico(rs.getString("NomeServico"));
                servico.setDescricao(rs.getString("Descricao"));
                servico.setPreco(rs.getDouble("Preco"));

                servicos.add(servico);
            }
            System.out.println("Servicos encontrados: " + servicos.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return servicos;
    }

    public static void removerServico(int id) {
        excluirServico(id);
    }
}
