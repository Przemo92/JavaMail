package barosanu.controller;

import barosanu.EmailMenager;
import barosanu.view.ViewFactory;

public abstract class BaseCotroller {

    private EmailMenager emailMenager;
    private ViewFactory viewFactory;
    private String fxmlName;

    public BaseCotroller(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        this.emailMenager = emailMenager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
