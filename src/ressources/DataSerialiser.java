package ressources;
import Auteur.Auteur;
import Membres.*;
import Pret.*;
import Livres.*;

import java.io.*;
import java.util.ArrayList;

public class DataSerialiser {
    public void serializeData(ArrayList<Auteur> auteurs, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(auteurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Auteur> deserializeData(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (ArrayList<Auteur>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
