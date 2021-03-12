package classes;


import java.io.*;
import java.util.ArrayList;

/**
 * @author Georgi Geogiev
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {
    //Speichere User
    private ArrayList<Benutzer> users = new ArrayList<Benutzer>();

    /**
     * Liste von Benutzern wird initialisiert und in einer Datei "db" gespeichert
     */
    public void dbInit() {
        users = new ArrayList<Benutzer>();
        dbSchreiben();
    }

    /**
     * Lade database wenn sie existiert oder erstelle eine falls keine existiert
     */
    private void dbLesen() {
        if (new File("db").exists()) {
            try {
                // deserialisierung wird duch ObjectInput Stream durchgefüht
                // der Inhalt aus der db wird in users gelegt
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("db"));
                // Lese
                users = (ArrayList<Benutzer>)in.readObject();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                // Sollte eine klasse nicht vorhanden sein
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            dbInit();
        }
    }

    /**
     * Spiechere Änderungen zu database
     */
    private void dbSchreiben() {
        try {
            // Serialisierung
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("db"));
            // schreibe in die db den Inhalt von users
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     * @param benutzer company.Benutzer hinzufuegen
     * @throws UserAlreadyExistsException throws wenn benutzer schon hinzugefuegt wurde
     */
    public void benutzerEintragen(Benutzer benutzer) throws UserAlreadyExistsException, EmptyUser {
        dbLesen();
        if (!benutzer.userID.equals("") && benutzer.passWort != null && benutzer.passWort.length>1) {
            if (benutzerVorhanden(benutzer)) {
                throw new UserAlreadyExistsException("The user you are trying to add already exists.");
            } else {
                users.add(benutzer);
            }
        } else {
            throw new EmptyUser("company.EmptyUser!");
        }
        dbSchreiben();
    }

    /**
     * @param benutzer company.Benutzer
     * @return wenn USer schon hinzugefuegt wurde
     */
    public boolean benutzerVorhanden(Benutzer benutzer) {
        dbLesen();
        return users.contains(benutzer);
    }











    /**
     * @param benutzer company.Benutzer der geloescht werden soll
     * @throws UserNotFoundException throws wenn User bereits existiert
     */
    public void benutzerLoeschen(Benutzer benutzer) throws UserNotFoundException {
        dbLesen();
        if (!users.contains(benutzer)) {
            throw new UserNotFoundException("The user you are trying to remove does not exists.");
        } else {
            users.remove(benutzer);
        }
        dbSchreiben();
    }
    public void benutzerEntf() {
        users.clear();
    }
}
