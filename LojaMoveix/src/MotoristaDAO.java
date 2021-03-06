import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAO {
        public void adicionarMotorista(Motorista m) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO Motorista(CodMot, CPF, CNH, Nome, endereco) VALUES(?,?,?,?,?)");
            stmt.setInt(1, m.getCodMot());
            stmt.setLong(2, m.getCPF());
            stmt.setLong(3, m.getCNH());
            stmt.setString(4, m.getNome());
            stmt.setString(5, m.getEndereco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    public void removerMotorista(int codMot) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM Motorista WHERE CodMot=?");
            stmt.setInt(1, codMot);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    public List<Motorista> listarMotorista() {
        List<Motorista> listaRetorno = new ArrayList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Motorista ORDER BY CodMot");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Motorista m = new Motorista(rs.getInt("CodMot"),rs.getLong("CPF"),rs.getLong("CNH"),rs.getString("Nome"),rs.getString("endereco"));
                listaRetorno.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }
    
    
    public Motorista getMotoristaPeloCodigo(int CodMot) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Motorista WHERE CODIGO=?");
            stmt.setInt(1, CodMot);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Motorista mot = new Motorista(rs.getInt("CodMot"), rs.getLong("CPF"), rs.getLong("CNH"), rs.getString("Nome"), rs.getString("Endereco"));
                return mot;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    
    public void updateMotorista(Motorista m) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Motorista SET CPF=?, CNH=?, Nome=?, Endereco=? WHERE CodMot=?");
            stmt.setInt(1, m.getCodMot());
            stmt.setLong(2, m.getCPF());
            stmt.setLong(3, m.getCNH());
            stmt.setString(4, m.getNome());
            stmt.setString(5, m.getEndereco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
}

