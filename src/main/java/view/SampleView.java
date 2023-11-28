package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleView {

    private static final String TITLE = "Sample View";
    private static final String UPDATE_BUTTON_TEXT = "Update";
    private static final String UNDO_BUTTON_TEXT = "Undo";
    private static final String REDO_BUTTON_TEXT = "Redo";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private TextField firstField;
    private TextField secondField;
    private Button buttonUpdate;
    private Button buttonUndo;
    private Button buttonRedo;


    public SampleView(Stage primaryStage){
        primaryStage.setTitle(TITLE);

        GridPane gridPane = new GridPane();
        initializeGridPane(gridPane);

        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);

        initializeFields(gridPane);

        primaryStage.show();
    }

    private void initializeGridPane(GridPane gridPane){
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
    }

    private void initializeFields(GridPane gridPane){

        firstField = new TextField();
        gridPane.add(firstField, 0, 1);

        secondField = new TextField();
        gridPane.add(secondField, 0, 2);

        buttonUpdate = new Button(UPDATE_BUTTON_TEXT);
        HBox buttonUpdateHBox = new HBox(10);
        buttonUpdateHBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonUpdateHBox.getChildren().add(buttonUpdate);
        gridPane.add(buttonUpdateHBox, 0, 4);

        buttonUndo = new Button(UNDO_BUTTON_TEXT);
        HBox buttonUndoHBox = new HBox(10);
        buttonUndoHBox.setAlignment(Pos.BOTTOM_LEFT);
        buttonUndoHBox.getChildren().add(buttonUndo);
        gridPane.add(buttonUndoHBox, 1, 4);

        buttonRedo = new Button(REDO_BUTTON_TEXT);
        HBox buttonRedoHBox = new HBox(10);
        buttonRedoHBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonRedoHBox.getChildren().add(buttonRedo);
        gridPane.add(buttonRedoHBox, 2, 4);
    }

    public String getFirstFieldText(){
        return firstField.getText();
    }

    public String getSecondFieldText(){
        return secondField.getText();
    }

    public void updateFirstFieldText(String firstText){
        this.firstField.setText(firstText);
    }

    public void updateSecondFieldText(String secondText){
        this.secondField.setText(secondText);
    }

    public void addUpdateButtonListener(EventHandler<ActionEvent> eventListener){
        buttonUpdate.setOnAction(eventListener);
    }

    public void addUndoButtonListener(EventHandler<ActionEvent> eventListener){
        buttonUndo.setOnAction(eventListener);
    }

    public void addRedoButtonListener(EventHandler<ActionEvent> eventListener){
        buttonRedo.setOnAction(eventListener);
    }
}
