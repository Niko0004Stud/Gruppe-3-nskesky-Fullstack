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
    public ArrayList<WishList> getAllWLs(){
        ArrayList<WishList> wishlists = new ArrayList<>();
        String sql = "SELECT * FROM WishList";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                WishList wishList = new WishList();
                wishList.setId(resultSet.getInt("ID"));
                wishList.setUserid(resultSet.getInt("user_ID"));
                wishList.setName(resultSet.getString("name"));
                wishlists.add(wishList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return wishlists;
    }

    public void saveWL(WishList wishList){
        String sql = "INSERT INTO wishList (ID, user_ID, name) VALUES (?, ?, ?)";
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
        String sql = "SELECT * FROM wishlist WHERE id=?";

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
        String sql = "SELECT * FROM wishlist WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    wishList = new WishList();
                    wishList.setId(resultSet.getInt("ID"));
                    wishList.setUserid(resultSet.getInt("user_ID"));
                    wishList.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return wishList;
    }

    public void updateWL(WishList wishList){
        String sql = "UPDATE wishList SET id = ?, user_id = ?, name = ?";
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
