package src.controller;

import src.database.Database;
import src.model.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaController {

    public static void adicionarConsulta(Consulta consulta) {
        String sql = "INSERT INTO Consultas (IDConsulta, IDAnimal, IDServico, DataConsulta, HoraConsulta, MotivoConsulta, Diagnostico, Tratamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, consulta.getIdConsulta());
            pstmt.setInt(2, consulta.getIdAnimal());
            pstmt.setInt(3, consulta.getIdServico());
            pstmt.setString(4, consulta.getDataConsulta());
            pstmt.setString(5, consulta.getHoraConsulta());
            pstmt.setString(6, consulta.getMotivoConsulta());
            pstmt.setString(7, consulta.getDiagnostico());
            pstmt.setString(8, consulta.getTratamento());

            pstmt.executeUpdate();
            System.out.println("Consulta adicionada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarConsulta(int id, Consulta consulta) {
        String sql = "UPDATE Consultas SET IDAnimal = ?, IDServico = ?, DataConsulta = ?, HoraConsulta = ?, MotivoConsulta = ?, Diagnostico = ?, Tratamento = ? WHERE IDConsulta = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, consulta.getIdAnimal());
            pstmt.setInt(2, consulta.getIdServico());
            pstmt.setString(3, consulta.getDataConsulta());
            pstmt.setString(4, consulta.getHoraConsulta());
            pstmt.setString(5, consulta.getMotivoConsulta());
            pstmt.setString(6, consulta.getDiagnostico());
            pstmt.setString(7, consulta.getTratamento());
            pstmt.setInt(8, id);

            pstmt.executeUpdate();
            System.out.println("Consulta atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirConsulta(int id) {
        String sql = "DELETE FROM Consultas WHERE IDConsulta = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Consulta excluída com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Consulta> listarConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consultas";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("IDConsulta"));
                consulta.setIdAnimal(rs.getInt("IDAnimal"));
                consulta.setIdServico(rs.getInt("IDServico"));
                consulta.setDataConsulta(rs.getString("DataConsulta"));
                consulta.setHoraConsulta(rs.getString("HoraConsulta"));
                consulta.setMotivoConsulta(rs.getString("MotivoConsulta"));
                consulta.setDiagnostico(rs.getString("Diagnostico"));
                consulta.setTratamento(rs.getString("Tratamento"));

                consultas.add(consulta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return consultas;
    }

    public static void agendarConsulta(Consulta consulta) {
    }

    public static void atualizarStatusConsulta(int id, String novoStatus) {
    }

    public static void cancelarConsulta(int id) {
    }
}
