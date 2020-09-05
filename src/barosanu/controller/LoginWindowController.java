package barosanu.controller;

import barosanu.EmailMenager;
import barosanu.controller.services.LoginService;
import barosanu.model.EmailAccount;
import barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseCotroller {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailMenager);
            EmailLoginResult emailLoginResult = loginService.login();

            switch (emailLoginResult){
                case SUCCESS:
                    System.out.println("login succesfull!" + emailAccount);
                    return;
            }
        }
        System.out.println("login Button cliK!!");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);


    }

    private boolean fieldsAreValid() {
        if (emailAddressField.getText().isEmpty()) {

            errorLabel.setText("Please fill email");
            return false;
        }
        return true;
    }
}