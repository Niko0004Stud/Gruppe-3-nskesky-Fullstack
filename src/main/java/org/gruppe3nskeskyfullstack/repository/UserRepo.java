package org.gruppe3nskeskyfullstack.repository;

import org.gruppe3nskeskyfullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepo {

    @Autowired
    DataSource dataSource;
    public User verifyLogin(String email, String password){
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ?, password = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet != null ){
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setFirstName(resultSet.getString("firstName"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setEmail(resultSet.getString("email"));
                    user.setTlfNumber(resultSet.getString("tlfNumber"));
                    user.setGender(resultSet.getString("gender"));
                    user.setBirthDate(resultSet.getDate("birthDate").toLocalDate());
                    user.setPassword(resultSet.getString("password"));
                }
                else {
                    return null;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
}
