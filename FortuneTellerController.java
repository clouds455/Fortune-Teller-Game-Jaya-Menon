
/**
 * Description of the Program: This program allows the user to input fortunes, remove them, display them, and receive fortunes
 * @author Jaya Menon
 * @since 5/14/25
 */


package com.example.fortuneteller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class sets up the variables and creates a list view, an observable list, and an array list
 */
public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    ArrayList<String> fortunes = new ArrayList<String>();
    @FXML
    private TextField fortuneBox;
    @FXML
    private Label fortuneLabel;
    @FXML
    private TextField fortuneTextBox;
    @FXML
    private Label allFortunes;
    @FXML
    int display = 1;
    @FXML
    ListView<String> fortuneList = new ListView<String>();
    ObservableList<String> items = FXCollections.observableArrayList(fortunes);
    @FXML
    int number_of_fortunes = 10;



    /**
     * This protected void generates each fortune, randomizing them, and displays them into a label.
     */
    @FXML
    protected void onGenerateFortuneClick() {
        String fortune = fortuneBox.getText();
        Collections.shuffle(fortunes);
        fortuneLabel.setText("Your Fortune is: " + fortunes.get(0));

    }

    /**
     * This protected void displays the fortunes onto a list view
     */
    @FXML
    protected void onDisplayFortunesClick() {
        if (display == 1) {
            display = 0;
            String clicked = fortuneList.getSelectionModel().getSelectedItem();
            String fortune = fortuneBox.getText();
            if (fortune.trim().isEmpty()) {
                fortunes.add("Your Destiny is On the Right Track");
                fortunes.add("You will become successful");
                fortunes.add("You will get a good grade on something");
                fortunes.add("There is a obstacle in your Future");
                fortunes.add("There is good in your future");
                fortunes.add("Stay True to Yourself");
                fortunes.add("Don't Give Up");
                fortunes.add("You are going to get straight As");
                fortunes.add("You will have a great year");
                fortunes.add("Have a good day");
                Collections.shuffle(fortunes);
                fortunes.remove(clicked);
                fortuneList.refresh();
                fortunes.add(fortune);
            }
            items.setAll(fortunes);
            fortuneList.setItems(items);
        }

    }
    /**
    *This method allows only the inputted fortune into the array list
    */
  
  
    protected void onAddFortuneToList() {
        String fortune = fortuneBox.getText();
        if (fortunes.isEmpty()) {
            fortunes.add(fortune);
        }
        fortuneBox.clear();
        items.setAll(fortunes);
        fortuneList.setItems(items);
    }

    /**
     * This protected void allows the user to add a fortune, as long as they type in something to the fortune box.
     */
    @FXML
    protected void onAddFortuneButtonClick() {
        String fortune = fortuneBox.getText();
        if(fortune == null || fortune.trim().isEmpty()) {
            generateInfoAlert("Enter a fortune to continue");
        }
        else {
            generateInfoAlert("Fortune added!");
            fortunes.add(fortune);
            onAddFortuneToList();
            fortuneList.setItems(items);
            number_of_fortunes += 1;
        }
    }



    /**
     * This protected void allows the user to remove a fortune from the list.
     */
    @FXML
    protected void onRemoveFortuneClick(){
        try {
            String clicked = fortuneList.getSelectionModel().getSelectedItem();
            if(clicked == null) {
                generateInfoAlert("Select a fortune to remove");
            }
            else {
                generateInfoAlert("Fortune Removed!");

            }
            fortunes.remove(fortuneList.getSelectionModel().getSelectedItem());
            items.setAll(fortunes);
            fortuneList.setItems(items);
            number_of_fortunes -= 1;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * This protected void generates an error message or message on the screen
     * @param errorMag this is the type of message that is displayed on the screen, for example it is a string.
     */

    private void generateInfoAlert(String errorMag) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText(errorMag);
        alert.showAndWait();
    }

}
