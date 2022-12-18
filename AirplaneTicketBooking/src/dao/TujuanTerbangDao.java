package src.dao;

import src.db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;


import java.util.ArrayList;

import src.model.TujuanTerbang;

public class TujuanTerbangDao {
    // Insert Database Asal Terbang
    public int insert(TujuanTerbang tujuanTerbang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO asal_terbang (id, tujuan_terbang) VALUES (?, ?)");
            statement.setString(1, tujuanTerbang.getId());
            statement.setString(2, tujuanTerbang.getTujuan());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Update Datababase Asal Terbang
    public int update(TujuanTerbang tujuanTerbang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE tujuan_terbang SET tujuan_terbang = ? WHERE id = ?");
            statement.setString(1, tujuanTerbang.getTujuan());
            statement.setString(2, tujuanTerbang.getId());

            result = statement.executeUpdate();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete Database Asal Terbang
    public int delete(TujuanTerbang tujuanTerbang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tujuan_terbang WHERE id = ?");
            statement.setString(1, tujuanTerbang.getId());

            result = statement.executeUpdate();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<TujuanTerbang> findAll() {
        List<TujuanTerbang> list = new ArrayList<>();
         try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement(); ) {
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM tujuan_terbang");) {
                while(resultSet.next()) {
                    TujuanTerbang tujuanTerbang = new TujuanTerbang();
                    tujuanTerbang.setId(resultSet.getString("id"));
                    tujuanTerbang.setTujuan(resultSet.getString("tujuan_terbang"));
                    list.add(tujuanTerbang);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }   catch (SQLException e) {
            e.printStackTrace();
        }   
        return list;
    }

}
