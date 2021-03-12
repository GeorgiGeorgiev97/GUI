package classes;



import java.io.Serializable;

public class Benutzer implements Serializable {
    public String userID;
    public char[] passWort;


    /**
     * Default-Konstruktor setzt userID "" und passWort ""
     */
    public Benutzer() {
        this.userID = "";
        this.passWort = null;
    }

    /**
     * Konstruktor, der beide Attribute initialisiert
     *
     * @param userid   userid
     * @param password passwort
     */
    public Benutzer(String userid, char[] password) {
        this.userID = userid;
        this.passWort = password;
    }

    /**
     * @return userId
     */
    public String getUserID(){
        return this.userID;
    }

    /**
     * @return password
     */
    public char[] getPassword(){
        return this.passWort;
    }

    /**
     * @param obj Objekt
     * @return true wenn das Objekt das Selbe ist
     */
    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof Benutzer)
                && ( String.copyValueOf(this.passWort).equals (String.copyValueOf(((Benutzer) obj).passWort)))
                && (this.userID.equals(((Benutzer) obj).userID)));
    }

    /**
     * @return String Darstellung vom User
     */
    @Override
    public String toString() {
        return ("UserID: " + this.userID
                + ", Passwort: " + String.copyValueOf(this.passWort));
    }

}
