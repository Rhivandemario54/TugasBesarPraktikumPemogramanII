package src.dao;

import src.db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import java.util.ArrayList;

import src.model.AsalTerbang;

public class AsalTerbangDao {
    // Insert Database Asal Terbang
    public int insert(AsalTerbang asalTerbang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO asal_terbang (id, asal_terbang) VALUES (?, ?)");
            statement.setString(1, asalTerbang.getId());
            statement.setString(2, asalTerbang.getAsal());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Update Datababase Asal Terbang
    public int update(AsalTerbang asalTerbang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE asal_terbang SET asal_terbang = ? WHERE id = ?");
            statement.setString(1, asalTerbang.getAsal());
            statement.setString(2, asalTerbang.getId());

            result = statement.executeUpdate();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete Database Asal Terbang
    public int delete(AsalTerbang asalTerbang) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM asal_terbang WHERE id = ?");
            statement.setString(1, asalTerbang.getId());

            result = statement.executeUpdate();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<AsalTerbang> findAll() {
        List<AsalTerbang> list = new ArrayList<>();
         try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement(); ) {
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM asal_terbang");) {
                while(resultSet.next()) {
                    AsalTerbang asalTerbang = new AsalTerbang();
                    asalTerbang.setId(resultSet.getString("id"));
                    asalTerbang.setAsal(resultSet.getString("asal_terbang"));
                    list.add(asalTerbang);
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
