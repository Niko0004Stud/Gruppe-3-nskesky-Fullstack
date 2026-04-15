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
public class WishlistRepo {

    @Autowired
    private DataSource dataSource;
    public ArrayList<WishList> getAllWishLists(){
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

    public void save(WishList wishList){
        String sql = "INSERT INTO wishLists (ID, user_ID, name) VALUES (?, ?, ?)";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1);

        }
    }

    public WishlistRepo(DataSource datasource){
        this.datasource=datasource;
    }

}
