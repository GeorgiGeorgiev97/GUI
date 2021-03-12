package controllers;

import application.MainApplication;

public class ReferenceController {
    MainApplication mainApp = null;

    /**
     * controller with a reference to the MainApp instance
     * @param ref Reference to MainApplication
     */
    public void setReference(MainApplication ref) {
        this.mainApp = ref;
    }
}
