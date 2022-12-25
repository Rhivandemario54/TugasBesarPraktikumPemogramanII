package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Tujuan;

public class TujuanDao {
    public int insert(Tujuan tujuanpen) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("insert into tujuan (id, tujuanpen) value (?, ?)");
            statement.setString(1, tujuanpen.getId());
            statement.setString(2, tujuanpen.getTujuanpen());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Tujuan tujuanpen) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("update tujuan set tujuanpen = ? where id = ?");
            statement.setString(1, tujuanpen.getTujuanpen());
            statement.setString(2, tujuanpen.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Tujuan tujuanpen) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("delete from tujuan where id = ?");
            statement.setString(1, tujuanpen.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Tujuan> findAll() {
        List<Tujuan> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from tujuan");) {
                // Retrieving the data
                while (resultSet.next()) {
                    Tujuan tujuanpen = new Tujuan();
                    tujuanpen.setId(resultSet.getString("id"));
                    tujuanpen.setTujuanpen(resultSet.getString("tujuanpen"));
                    list.add(tujuanpen);
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
