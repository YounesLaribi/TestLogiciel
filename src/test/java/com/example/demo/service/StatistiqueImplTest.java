package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatistiqueImplTest {

    private StatistiqueImpl statistiqueService;

    @BeforeEach
    void setUp() {
        // Initialisation d'une nouvelle instance avant chaque test
        statistiqueService = new StatistiqueImpl();
    }

    @Test
    void testPrixMoyenAvecVoitures() {
        // 1. Données de test (Ajout de 3 voitures)
        statistiqueService.ajouter(new Voiture("Peugeot", 20000));
        statistiqueService.ajouter(new Voiture("Renault", 30000));
        statistiqueService.ajouter(new Voiture("Tesla", 40000));

        // 2. Exécution de la méthode à tester
        Echantillon echantillon = statistiqueService.prixMoyen();

        // 3. Vérifications (Moyenne attendue : (20k + 30k + 40k) / 3 = 30000)
        assertNotNull(echantillon, "L'échantillon retourné ne doit pas être nul");
        assertEquals(3, echantillon.getNombreDeVoitures(), "Le nombre de voitures doit être de 3");
        assertEquals(30000, echantillon.getPrixMoyen(), "Le prix moyen calculé doit être de 30000");
    }

    @Test
    void testPrixMoyenSansVoitureLeveException() {
        // Si aucune voiture n'est ajoutée, la division par 0 doit lever une ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            statistiqueService.prixMoyen();
        }, "Une ArithmeticException devrait être levée en cas de liste vide (division par zéro)");
    }
}
