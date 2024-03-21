package org.example.lab01;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * version 1.1
 * creating an application
 */
public class HelloApplication extends Application {

    private TextArea textInput;
    private Label lineCountLabel;
    private Label wordCountLabel;
    private Label charCountLabel;
    private Label digitCountLabel;

    private Label createStatusBar;


    private HBox createStatusBar() {
        createStatusBar = new Label("Status bar content");
        HBox statusBar = new HBox(createStatusBar);
        statusBar.setStyle("-fx-background-color: lightgrey; -fx-padding: 5px;");
        return statusBar;
    }

    @Override
    public void start(Stage stage) {
        textInput = new TextArea();
        textInput.setPrefRowCount(20);
        textInput.setPrefColumnCount(50);

        BorderPane pane = new BorderPane();
        pane.setCenter(textInput);
        pane.setBottom(createStatusBar());


        /**
         * TODO call the method createStatusBar
         *		TODO Create a new button  "process the text" .
         *		TODO call setOnKeyPressed on this button and pass a lambda to it. In the lambda if the key pressed, invoke processInput method
         *		TODO set  button style   as "-fx-background-color: darkslateblue; -fx-text-fill: white;"
         */

        Button countButton = new Button("Process this text");
        countButton.setOnAction(event -> processInput());
        textInput.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                processInput();
            }
        });
        countButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white");

        stage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            if (!event.isConsumed() && KeyCode.ESCAPE == event.getCode()) {
                stage.hide();
            }
        });
        /* Create each of the labels, and set their properties. */


        /*
         * 	TODO Create wordCountLabel, and set their  properties.
         */

        lineCountLabel = new Label("  Number of lines:");
        lineCountLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        lineCountLabel.setMaxWidth(1000);


        /*
         * 	TODO Create wordCountLabel, and set their  properties.
         */

        wordCountLabel = new Label("  Number of wordcount:");
        wordCountLabel.setStyle("-fx-text-fill: red; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        wordCountLabel.setMaxWidth(1000);


        /*
         * 	TODO Create charCountLabel, and set their properties.
         */

        charCountLabel = new Label("  Number of Charcount:");
        charCountLabel.setStyle("-fx-text-fill: blue; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        charCountLabel.setMaxWidth(1000);

        digitCountLabel = new Label("  Number of digitcount:");
        digitCountLabel.setStyle("-fx-text-fill: black; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        digitCountLabel.setMaxWidth(1000);

        VBox countLabels = new VBox(5, lineCountLabel, wordCountLabel, charCountLabel, digitCountLabel);
        countLabels.setPadding(new Insets(10));

        HBox header = new HBox(new Label("Enter your text here"));
        header.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 20px; -fx-padding: 10px;");

        VBox root = new VBox(10, header, textInput, countButton, countLabels);
        root.setStyle("-fx-background-color: lightgrey; -fx-padding: 10px");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Text Analyzer");
        stage.setResizable(false);
        stage.show();
    }

    public void processInput() {
        String text = textInput.getText();

        int lineCt = text.split("\n").length;
        int wordCt = text.split("\\s+").length;
        int charCt = text.length();
        int digitCt = countDigits(text);

        lineCountLabel.setText("Number of lines: " + lineCt);
        wordCountLabel.setText("Number of words: " + wordCt);
        charCountLabel.setText("Number of characters: " + charCt);
        digitCountLabel.setText("Number of digits: " + digitCt);
    }

    private int countDigits(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        launch(args);
    }
}