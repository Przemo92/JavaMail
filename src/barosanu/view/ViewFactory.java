package barosanu.view;

import barosanu.EmailMenager;
import barosanu.controller.BaseCotroller;
import barosanu.controller.LoginWindowController;
import barosanu.controller.MainWindowController;
import barosanu.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailMenager emailMenager;
    private ArrayList<Stage> activeStages;

    public ViewFactory(EmailMenager emailMenager) {
        this.emailMenager = emailMenager;
        activeStages = new ArrayList<Stage>();
    }

    //View options handling:

    private ColorTheme colorTheme = ColorTheme.DARK;
    private FontSize fontSize = FontSize.MEDIUM;

    public void showLoginWindow(){
        System.out.println("show login window called");

        BaseCotroller controller = new LoginWindowController(emailMenager, this, "LoginWindow.fxml");
        initializeStage(controller);
    }
    public void showMainWindow(){
        System.out.println("main window called");

        BaseCotroller controller = new MainWindowController(emailMenager, this, "MainWindow.fxml");
        initializeStage(controller);
    }
    public void showOptionsWindow(){
        System.out.println("options window called");

        BaseCotroller controller = new OptionsWindowController(emailMenager, this, "OptionsWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseCotroller baseCotroller){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseCotroller.getFxmlName()));
        fxmlLoader.setController(baseCotroller);
        Parent parent;
        try{
            parent = fxmlLoader.load();
        }catch(IOException e){
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }
    public void closeStage(Stage stageToClose){

        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void updateStyles() {
        for(Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }

    }
}
