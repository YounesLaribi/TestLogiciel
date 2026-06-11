package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatistiqueTests {

    private StatistiqueImpl statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void testPrixMoyenNormal() throws ArithmeticException {
        statistique.ajouter(new Voiture("Ferrari", 100));
        statistique.ajouter(new Voiture("Renault", 200));

        Echantillon resultat = statistique.prixMoyen();

        assertEquals(2, resultat.getNombreDeVoitures());
        assertEquals(150, resultat.getPrixMoyen());
    }

    @Test
    void testPrixMoyenSansVoiture() {
        assertThrows(ArithmeticException.class, () -> {
            statistique.prixMoyen();
        });
    }
}

