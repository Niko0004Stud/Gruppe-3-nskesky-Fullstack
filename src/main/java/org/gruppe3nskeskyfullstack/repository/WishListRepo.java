package org.gruppe3nskeskyfullstack.repository;

import org.gruppe3nskeskyfullstack.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WishListRepo {

    @Autowired
    private DataSource dataSource;
    public ArrayList<WishList> getAllWLsByUser(int userId){
        ArrayList<WishList> wishLists = new ArrayList<>();
        String sql = "SELECT * FROM wishlists WHERE userID = ?";
        System.out.println("userId: " + userId);

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,userId);

            ResultSet resultSet = statement.executeQuery();
            System.out.println("userId: " + userId);

            while(resultSet.next()){
                WishList wishList = new WishList();
                wishList.setId(resultSet.getInt("ID"));
                wishList.setUserid(resultSet.getInt("userID"));
                wishList.setName(resultSet.getString("name"));
                wishLists.add(wishList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return wishLists;
    }

    public void saveWL(WishList wishList){
        String sql = "INSERT INTO wishlists (ID, userID, name) VALUES (?, ?, ?)";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, wishList.getId());
            statement.setInt(2, wishList.getUserid());
            statement.setString(3,wishList.getName());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteWL(int id) {
        String sql = "DELETE FROM wishlists WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public WishList getWLById(int id){
        WishList wishList = null;
        String sql = "SELECT * FROM wishlists WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    wishList = new WishList();
                    wishList.setId(resultSet.getInt("ID"));
                    wishList.setUserid(resultSet.getInt("userID"));
                    wishList.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return wishList;
    }

    public void updateWL(WishList wishList){
        String sql = "UPDATE wishlists SET id = ?, userid = ?, name = ?";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, wishList.getId());
            statement.setInt(2,wishList.getUserid());
            statement.setString(3,wishList.getName());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    public WishListRepo(DataSource dataSource){
//        this.dataSource=dataSource;
//    }

}
