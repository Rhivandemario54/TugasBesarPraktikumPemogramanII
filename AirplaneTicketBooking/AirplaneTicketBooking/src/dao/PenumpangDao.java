package src.dao;

import src.db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import src.model.Penumpang;
import src.model.AsalTerbang;
import src.model.TujuanTerbang;

public class PenumpangDao {

    // Insert
    public int insert(Penumpang penumpang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection(); ) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO penumpang (id, nama, umur, no_telpon, asal_terbang_id, tujuan_terbang_id) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, penumpang.getId());
            statement.setString(2, penumpang.getNama());
            statement.setString(3, penumpang.getUmur());
            statement.setString(4, penumpang.getNoTelpon());
            statement.setString(5, penumpang.getAsalTerbang().getId());
            statement.setString(6, penumpang.getTujuanTerbang().getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Update
    public int update(Penumpang penumpang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE penumpang SET nama = ?, umur = ?, no_telpon = ?, asal_terbang_id = ?, tujuan_terbang_id = ? WHERE id = ?");
            statement.setString(1, penumpang.getNama());
            statement.setString(2, penumpang.getUmur());
            statement.setString(3, penumpang.getNoTelpon());
            statement.setString(4, penumpang.getAsalTerbang().getId());
            statement.setString(5, penumpang.getTujuanTerbang().getId());
            statement.setString(6, penumpang.getId());
        }   catch (SQLException e) {
            e.printStackTrace();
        }   
        return result;
    }

    // Delete
    public int delete(Penumpang penumpang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection(); ){
            PreparedStatement statement =connection.prepareStatement("DELETE FROM penumpang WHERE id = ?");

            result = statement.executeUpdate();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Penumpang> findAll() {
        List<Penumpang> list = new ArrayList<>();
         try(Connection connection = MySqlConnection.getInstance().getConnection();
              Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery( "SELECT penumpang.*, asal_terbang.*, tujuan_terbang.* FROM penumpang INNER JOIN asal_terbang ON penumpang.asal_terbang_id = asal_terbang.id INNER JOIN tujuan_terbang ON penumpang.tujuan_terbang_id = tujuan_terbang.id");
            
            while(resultSet.next()) {
                Penumpang penumpang = new Penumpang();
                penumpang.setId(resultSet.getString("id"));
                penumpang.setNama(resultSet.getString("nama"));
                penumpang.setUmur(resultSet.getString("umur"));
                penumpang.setNoTelpon(resultSet.getString("no_telpon"));

                AsalTerbang asalTerbang = new AsalTerbang();
                asalTerbang.setId(resultSet.getString("asal_terbang_id"));  
                asalTerbang.setAsal(resultSet.getString("asal"));

                TujuanTerbang tujuanTerbang = new TujuanTerbang();
                tujuanTerbang.setId(resultSet.getString("tujuan_terbang_id"));
                tujuanTerbang.setTujuan(resultSet.getString("tujuan"));

                penumpang.setAsalTerbang(asalTerbang);
                penumpang.setTujuanTerbang(tujuanTerbang);

                list.add(penumpang);
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}