package org.gruppe3nskeskyfullstack.repository;

import org.gruppe3nskeskyfullstack.model.Wish;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository //fortæller Spring, at klassen er ansvarlig for databaselogik CRUD
public class WishRepo {

    @Autowired//bruges til at få Spring til automatisk at indsætte et objekt
    private DataSource dataSource;
    //get all wishes by user. all wishes
    public ArrayList<Wish> getAllWishesByWishlist(int wishlistID){
        ArrayList<Wish> wishes=new ArrayList<>();
        String sql = "SELECT * FROM wishes WHERE wishlistID = ?";
        //sql til db: find wishes og deres wishlist og kun hvis wishlisten tilhører den bruger vi søger efter

        /*try with resources
        connection åbner en forbindelse til databasen
        prepares statement forbereder sql query
        try with resources: connection og statement bliver automatisk lukket
         */
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,wishlistID);//indsæt første parameter i sql streng, useris=værdien der intastes
            ResultSet resultSet=statement.executeQuery();//sql kører i db. resultset er resultat

            while (resultSet.next())//gennemløb resultaterne, flyt cursoren til næste række
            {   Wish wish=new Wish();//tom java obj derfor tom konstruktor :)
                wish.setId(resultSet.getInt("Id"));//henter data fra db og detter på objekt
                wish.setWishlistID(resultSet.getInt("wishlistID"));
                wish.setName(resultSet.getString("name"));
                wish.setPrice(resultSet.getDouble("price"));
                wish.setUrl(resultSet.getString("url"));
                wishes.add(wish);// lægger obj i liste
            }
            } catch (SQLException e){
            e.printStackTrace();
        }
        return wishes;
    }

    public void saveWish(Wish wish){
        String sql="INSERT INTO wishes ( wishlistID, name, price, url) VALUES(?,?,?,?)";
        //sql komando. databasen siger opret en ny række i wishes.. fyld kolonnerne:wishlistID, name, price, url
        System.out.println("Du kom ind i saveWish()");
        try (Connection connection=dataSource.getConnection();
        PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1,wish.getWishlistID());//henter wishlistID fra wishobjekt og sætter værdien ind i sqlkomando
            statement.setString(2,wish.getName());
            statement.setDouble(3,wish.getPrice());
            statement.setString(4,wish.getUrl());
            statement.executeUpdate();//sqlkomand sendes til db.db opretter en ny wish.id-auto increment
        }catch (SQLException e){
            e.printStackTrace();//catch fejl og print
        }
    }


    public void deleteWish(int id){
        String sql="DELETE FROM wishes WHERE id=?";//sqlkomando gemmes i en variabel. slet fra tabel wishes. rækken hvor id matcher

        try(Connection connection= dataSource.getConnection();
        PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1,id);//sæt første værdi i sql query med matchede id
            statement.executeUpdate();//sqlkomando sendes til db. db sletter en række: wishen med det id
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Wish getWishByID(int id){
        Wish wish=null;
        String sql="SELECT * FROM wishes WHERE id= ?";//sql kommendo find rækker i tabellen wishes hvor id matcher

        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)){

            statement.setInt(1,id);//sæt første værdi i sql query med matchede id

            try (ResultSet resultSet= statement.executeQuery())//kør sql i db. resultat er resultset
            {
                if(resultSet.next())//next flytter cursoren til første række. returnerer true hvis der fande en wish med det id og false hvis det ikk e finder noget
                {   wish=new Wish();
                    wish.setId(resultSet.getInt("id"));//fylder obj med data fra db
                    wish.setWishlistID(resultSet.getInt("wishlistID"));
                    wish.setName(resultSet.getString("name"));
                    wish.setPrice(resultSet.getDouble("price"));
                    wish.setUrl(resultSet.getString("url"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return wish;
    }

    public void updateWish(Wish wish){
        String sql="UPDATE wishes SET wishlistID=?, name=?, price=?, url=? WHERE id=?";//update db

        try (Connection connection=dataSource.getConnection();
        PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1,wish.getWishlistID());
            statement.setString(2,wish.getName());
            statement.setDouble(3, wish.getPrice());
            statement.setString(4,wish.getUrl());
            statement.setInt(5,wish.getId());//update kun wish med en bestemt id
            statement.executeUpdate();//sql update kører i db
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}