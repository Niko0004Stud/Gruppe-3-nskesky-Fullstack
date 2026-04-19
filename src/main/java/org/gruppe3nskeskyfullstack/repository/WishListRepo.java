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

            while(resultSet.next()){
                WishList wishList = new WishList();
                wishList.setId(resultSet.getInt("ID"));
                wishList.setUserId(resultSet.getInt("userID"));
                wishList.setName(resultSet.getString("name"));
                wishLists.add(wishList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return wishLists;
    }

    public void saveWL(WishList wishList){
        String sql = "INSERT INTO wishlists (userID, name, shareToken) VALUES (?, ?, ?)";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, wishList.getUserId());
            statement.setString(2,wishList.getName());
            statement.setString(3,wishList.getShareToken());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteWL(int id) {
        String sql = "DELETE FROM wishlist WHERE id=?";

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
                    wishList.setUserId(resultSet.getInt("userID"));
                    wishList.setName(resultSet.getString("name"));
                    wishList.setShareToken(resultSet.getString("shareToken"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return wishList;
    }

    public void updateWL(WishList wishList){
        String sql = "UPDATE wishlists SET name = ? WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setString(1,wishList.getName());
            statement.setInt(2, wishList.getId());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public WishList findByToken(String token) {
        String sql = "SELECT * FROM wishlists WHERE shareToken = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, token);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                WishList wishList = new WishList();
                wishList.setId(resultSet.getInt("id"));
                wishList.setName(resultSet.getString("name"));
                wishList.setUserId(resultSet.getInt("userID"));
                wishList.setShareToken(resultSet.getString("shareToken"));
                return wishList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//    public WishListRepo(DataSource dataSource){
//        this.dataSource=dataSource;
//    }

}
