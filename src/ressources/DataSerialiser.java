package ressources;
import Auteur.Auteur;
import Membres.*;
import Pret.*;
import Livres.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*public class DataSerialiser {
    public void saveAuteur(ArrayList<Auteur> auteurs, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(auteurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Auteur> loadAuteur(String filePath) {
        ArrayList<Auteur> auteurs = new ArrayList<>();

        File file = new File(filePath);
        if(file.exists())
        {
            System.out.println("Le fichier existe");
        } else{
            System.out.println("Le fichier n'existe pas, création en cours...");
            try {
                if(file.createNewFile()) {
                    System.out.println("Fichier créé avec succès");
                } else {
                    System.out.println("Erreur lors de la création du fichier");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                System.out.println("Le fichier existe2");
                // Vérifiez que chaque ligne a assez de données pour créer un Auteur
                if (data.length == 4) {
                    String nom = data[0];
                    String prenom = data[1];
                    String dateNaissanceStr = data[2];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr,formatter);
                    String nationalite = data[3];
                    System.out.println("Le fichier existe3");
                    auteurs.add(new Auteur(nom, prenom, dateNaissance, nationalite));
                    System.out.println("Le fichier existe4");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return auteurs;
    }
}*/

public class DataSerialiser {
    public void saveAuteur(ArrayList<Auteur> auteurs, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(auteurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Auteur> loadAuteur(String filePath) {
        ArrayList<Auteur> auteurs = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            auteurs = (ArrayList<Auteur>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return auteurs;
    }
}
