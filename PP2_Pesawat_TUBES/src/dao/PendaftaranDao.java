package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Jumlah;
import model.Tujuan;
import model.Pendaftaran;

public class PendaftaranDao {

    // Insert Sorum Dao In Database
    public int insert(Pendaftaran pendaftaran) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(
                            "insert into pendaftaran (id, namauser, tgl_penerbangan, kelaspen, jumlahpen_id, tujuanpen_id) value (?, ?, ?, ?, ?, ?)");
            statement.setString(1, pendaftaran.getId());
            statement.setString(2, pendaftaran.getNamauser());
            statement.setString(3, pendaftaran.getTgl_penerbangan());
            statement.setString(4, pendaftaran.getKelaspen());
            statement.setString(5, pendaftaran.getJumlah().getId());
            statement.setString(6, pendaftaran.getTujuan().getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Update Sorum Dao in Database
    public int update(Pendaftaran pendaftaran) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(
                            "update pendaftaran set namauser = ?, tgl_penerbangan = ?, kelaspen = ?, jumlahpen_id = ?, tujuanpen_id = ? where id = ?");
            statement.setString(1, pendaftaran.getNamauser());
            statement.setString(1, pendaftaran.getTgl_penerbangan());
            statement.setString(1, pendaftaran.getKelaspen());
            statement.setString(2, pendaftaran.getJumlah().getId());
            statement.setString(2, pendaftaran.getTujuan().getId());
            statement.setString(3, pendaftaran.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete in sorum Dao Database
    public int delete(Pendaftaran pendaftaran) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("delete from pendaftaran where id = ?");
            statement.setString(1, pendaftaran.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Pendaftaran> findAll() {
        List<Pendaftaran> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement
                    .executeQuery(
                            "select pendaftaran.*, jumlah.*, tujuan.* "
                                    + "from pendaftaran "
                                    + "LEFT OUTER JOIN jumlah on jumlah.id = pendaftaran.jumlahpen_id "
                                    + "LEFT OUTER JOIN tujuan on tujuan.id = pendaftaran.tujuanpen_id");) {
                // Retrieving the data
                while (resultSet.next()) {
                    Pendaftaran pendaftaran = new Pendaftaran();
                    pendaftaran.setId(resultSet.getString("id"));
                    pendaftaran.setNamauser(resultSet.getString("namauser"));
                    pendaftaran.setTgl_penerbangan(resultSet.getString("tgl_penerbangan"));
                    pendaftaran.setKelaspen(resultSet.getString("kelaspen"));

                    Jumlah jumlah = new Jumlah();
                    jumlah.setId(resultSet.getString("pendaftaran.jumlahpen_id"));
                    jumlah.setJumlahpen(resultSet.getString("jumlah.jumlahpen"));

                    Tujuan tujuan = new Tujuan();
                    tujuan.setId(resultSet.getString("pendaftaran.tujuanpen_id"));
                    tujuan.setTujuanpen(resultSet.getString("tujuan.tujuanpen"));

                    pendaftaran.setTujuan(tujuan);
                    pendaftaran.setJumlah(jumlah);

                    list.add(pendaftaran);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
