package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class StatistiqueTests {

    public static void main(Strings[] args){
    
        List<Voiture> voitures = new ArrayList<Voiture>();
        Voiture voiture1= new Voiture("Ferrarri", 2);
        Voiture voiture2= new Voiture("Lambo", 2);
        Voiture voiture3= new Voiture("Rolls Royce", 2);

        @Test
        voitures.ajouter(voiture1);
        voitures.ajouter(voiture2);
        voitures.ajouter(voiture3);
        Assertions.assertEquals(voitures.prixMoyen(),2);
    }
}

