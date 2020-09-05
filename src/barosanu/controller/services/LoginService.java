package barosanu.controller.services;

import barosanu.EmailMenager;
import barosanu.controller.EmailLoginResult;
import barosanu.model.EmailAccount;

import javax.mail.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class LoginService {

    EmailAccount emailAccount;
    EmailMenager emailMenager;

    public LoginService(EmailAccount emailAccount, EmailMenager emailMenager) {
        this.emailAccount = emailAccount;
        this.emailMenager = emailMenager;
    }

    public EmailLoginResult login(){

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(emailAccount.getAddress(), emailAccount.getPassword());
            }
        };

        try{
            Session session = Session.getInstance(emailAccount.getProperties(), authenticator);
            Store store = session.getStore("imaps");
            store.connect(emailAccount.getProperties().getProperty("incomingHost"),
                    emailAccount.getAddress(),
                    emailAccount.getPassword());
            emailAccount.setStore(store);

        }catch (NoSuchProviderException e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_NETWORK;
        }catch (MessagingException e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPECTED_ERROR;
        }catch (AuthenticationFailedException e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_CREDENTIALS;
        }catch (Exception e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPECTED_ERROR;
        }
        return EmailLoginResult.SUCCESS;
    }
}
