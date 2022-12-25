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

public class JumlahDao {
    public int insert(Jumlah jumlahpen) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("insert into jumlah (id, jumlahpen) value (?, ?)");
            statement.setString(1, jumlahpen.getId());
            statement.setString(2, jumlahpen.getJumlahpen());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Jumlah jumlahpen) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("update jumlah set jumlahpen = ? where id = ?");
            statement.setString(1, jumlahpen.getJumlahpen());
            statement.setString(2, jumlahpen.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Jumlah jumlahpen) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("delete from jumlah where id = ?");
            statement.setString(1, jumlahpen.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Jumlah> findAll() {
        List<Jumlah> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from jumlah");) {
                // Retrieving the data
                while (resultSet.next()) {
                    Jumlah jumlahpen = new Jumlah();
                    jumlahpen.setId(resultSet.getString("id"));
                    jumlahpen.setJumlahpen(resultSet.getString("jumlahpen"));
                    list.add(jumlahpen);
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