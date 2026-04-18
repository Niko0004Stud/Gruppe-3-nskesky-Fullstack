package org.gruppe3nskeskyfullstack.service;

import org.gruppe3nskeskyfullstack.model.Wish;
import org.gruppe3nskeskyfullstack.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service//opret et wishservice objekt
public class WishService {
    private final WishRepo wishRepo;

    @Autowired//spring satrter app og finder @service klassen
    //spring ser konstruktoren, finder en wishrepo bean og indsætter det i konstruktor
    public WishService(WishRepo wishRepo){
        this.wishRepo=wishRepo;
    }

    //metodesn sendes fra controller, userid videresendes. repo laver sqljoin. resultat fra db kommer i array. servise returnerer listen
    public ArrayList<Wish>getAllWishesByWishlist(int wishlistID){
        return wishRepo.getAllWishesByWishlist(wishlistID);
    }

    public void saveWish(Wish wish){
        wishRepo.saveWish(wish);
    }

    public void deleteWish(int id){
        wishRepo.deleteWish(id);
    }

    public Wish getWishByID(int id){
        return wishRepo.getWishByID(id);
    }

    public void updateWish(Wish wish){
        wishRepo.updateWish(wish);
    }

}
