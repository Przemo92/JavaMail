package barosanu.view;

import barosanu.EmailMenager;

public class ViewFactory {

    private EmailMenager emailMenager;

    public ViewFactory(EmailMenager emailMenager) {
        this.emailMenager = emailMenager;
    }

    public void showLoginWIndow(){
        System.out.println("show login window called");
    }
}
