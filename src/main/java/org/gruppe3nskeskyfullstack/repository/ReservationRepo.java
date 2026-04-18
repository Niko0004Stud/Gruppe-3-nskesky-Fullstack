package org.gruppe3nskeskyfullstack.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Repository
public class ReservationRepo {



@Autowired
DataSource dataSource;


    public void reserveWish(int wishId, int userId) {
        String sql = "INSERT INTO reservation (wishId, userId) VALUES (?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, wishId);
            ps.setInt(2, userId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
