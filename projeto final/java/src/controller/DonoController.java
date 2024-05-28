package src.controller;

import src.database.Database;
import src.model.Dono;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonoController {

    public static void adicionarDono(Dono dono) {
        String sql = "INSERT INTO Donos (IDDono, Tipo, Nome, RazaoSocial, CPF, CNPJ, Email, DataNascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, dono.getIdDono());
            pstmt.setString(2, dono.getTipo());
            pstmt.setString(3, dono.getNome());
            pstmt.setString(4, dono.getRazaoSocial());
            pstmt.setString(5, dono.getCpf());
            pstmt.setString(6, dono.getCnpj());
            pstmt.setString(7, dono.getEmail());
            pstmt.setDate(8, java.sql.Date.valueOf(dono.getDataNascimento()));

            pstmt.executeUpdate();
            System.out.println("Dono adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarDono(int id, Dono dono) {
        String sql = "UPDATE Donos SET Tipo = ?, Nome = ?, RazaoSocial = ?, CPF = ?, CNPJ = ?, Email = ?, DataNascimento = ? WHERE IDDono = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dono.getTipo());
            pstmt.setString(2, dono.getNome());
            pstmt.setString(3, dono.getRazaoSocial());
            pstmt.setString(4, dono.getCpf());
            pstmt.setString(5, dono.getCnpj());
            pstmt.setString(6, dono.getEmail());
            pstmt.setDate(8, java.sql.Date.valueOf(dono.getDataNascimento()));
            pstmt.setInt(8, id);

            pstmt.executeUpdate();
            System.out.println("Dono atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirDono(int id) {
        String sql = "DELETE FROM Donos WHERE IDDono = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Dono excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Dono> listarDonos() {
        List<Dono> donos = new ArrayList<>();
        String sql = "SELECT * FROM Donos";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dono dono = new Dono();
                dono.setIdDono(rs.getInt("IDDono"));
                dono.setTipo(rs.getString("Tipo"));
                dono.setNome(rs.getString("Nome"));
                dono.setRazaoSocial(rs.getString("RazaoSocial"));
                dono.setCpf(rs.getString("CPF"));
                dono.setCnpj(rs.getString("CNPJ"));
                dono.setEmail(rs.getString("Email"));
                dono.setDataNascimento(rs.getString("DataNascimento"));

                donos.add(dono);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return donos;
    }
}
