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
            pstmt.setDate(4, Date.valueOf(consulta.getDataConsulta()));  // Converte para java.sql.Date
            pstmt.setTime(5, Time.valueOf(consulta.getHoraConsulta()));  // Converte para java.sql.Time
            pstmt.setString(6, consulta.getMotivoConsulta());
            pstmt.setString(7, consulta.getDiagnostico());
            pstmt.setString(8, consulta.getTratamento());

            pstmt.executeUpdate();
            System.out.println("Consulta adicionada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Formato de data ou hora inválido.");
        }
    }

    public static void atualizarConsulta(int id, Consulta consulta) {
        String sql = "UPDATE Consultas SET IDAnimal = ?, IDServico = ?, DataConsulta = ?, HoraConsulta = ?, MotivoConsulta = ?, Diagnostico = ?, Tratamento = ? WHERE IDConsulta = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, consulta.getIdAnimal());
            pstmt.setInt(2, consulta.getIdServico());
            pstmt.setDate(3, Date.valueOf(consulta.getDataConsulta()));  // Converte para java.sql.Date
            pstmt.setTime(4, Time.valueOf(consulta.getHoraConsulta()));  // Converte para java.sql.Time
            pstmt.setString(5, consulta.getMotivoConsulta());
            pstmt.setString(6, consulta.getDiagnostico());
            pstmt.setString(7, consulta.getTratamento());
            pstmt.setInt(8, id);

            pstmt.executeUpdate();
            System.out.println("Consulta atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Formato de data ou hora inválido.");
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
                consulta.setDataConsulta(rs.getDate("DataConsulta").toString());  // Converte para String
                consulta.setHoraConsulta(rs.getTime("HoraConsulta").toString());  // Converte para String
                consulta.setMotivoConsulta(rs.getString("MotivoConsulta"));
                consulta.setDiagnostico(rs.getString("Diagnostico"));
                consulta.setTratamento(rs.getString("Tratamento"));

                consultas.add(consulta);
            }
            System.out.println("Consultas encontradas: " + consultas.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return consultas;
    }
}
