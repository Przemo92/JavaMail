package barosanu.controller;

import barosanu.EmailMenager;
import barosanu.controller.BaseCotroller;
import barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

public class OptionsWindowController extends BaseCotroller {

    public OptionsWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }
    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<?> themePicker;


    @FXML
    void applyButtonAction() {

    }

    @FXML
    void cancelButtonAction() {

    }

}