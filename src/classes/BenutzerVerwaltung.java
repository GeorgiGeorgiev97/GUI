package classes;

import java.io.Serializable;
/**
 * Interface fuer Benutzerverwaltung
 */
public interface BenutzerVerwaltung extends Serializable {
    /**
     * @param benutzer Fuege company.Benutzer hinzu
     * @throws UserAlreadyExistsException throws wenn User schon hinzugefuegt wurde
     */
    void benutzerEintragen(Benutzer benutzer) throws UserAlreadyExistsException, EmptyUser;

    /**
     * @param benutzer company.Benutzer
     * @return wenn der company.Benutzer schon hinzugefuegt wurde
     */
    boolean benutzerVorhanden(Benutzer benutzer);
}
