package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.Handle;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Label userName = new Label("_UserName");
        userName.setLabelFor(userTextField);
        userName.setMnemonicParsing(true);
        grid.add(userName, 0, 1);
        
        PasswordField pwBox = new PasswordField();
        
        Label pw = new Label("_Password");
        pw.setMnemonicParsing(true);
        pw.setLabelFor(pwBox);
        
        grid.addRow(2, pw, pwBox);
        
        Hyperlink hyperlink = new Hyperlink("F_rgot your password");
        hyperlink.setMnemonicParsing(true);
        GridPane.setHalignment(hyperlink, HPos.RIGHT);
        grid.add(hyperlink, 1, 3);
        hyperlink.setId("hyperlink");
        
        Button signInButton = new Button("_Sign in");
        signInButton.setDefaultButton(true);
        signInButton.setMnemonicParsing(true);
        signInButton.setId("sign_in");
        
        Button cancelButton = new Button("_Cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setMnemonicParsing(true);
        cancelButton.setId("cancel");
        
        HBox hBox = new HBox(5, signInButton, cancelButton);
        hBox.setAlignment(Pos.TOP_RIGHT);
        grid.add(hBox, 1, 4);
        
        Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);
        
        
        EventHandler<ActionEvent> btnPressed = new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Labeled target = (Labeled)event.getTarget();
                
                switch(target.getId()){
                    case "sign_in":
                        actionTarget.setFill(Color.FIREBRICK);
                        actionTarget.setText("Sign in button pressed");
                        break;
                    case "cancel":
                        actionTarget.setFill(Color.FIREBRICK);
                        actionTarget.setText("Cancel Button pressed");
                        break;
                    case "hyperling":
                        actionTarget.setFill(Color.FIREBRICK);
                        actionTarget.setText("Hyperlink button pressed");
                        break;
                }
            }
            
        };
        hyperlink.setOnAction(btnPressed);
        signInButton.setOnAction(btnPressed);
        cancelButton.setOnAction(btnPressed);
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
