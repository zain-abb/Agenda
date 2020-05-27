package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.CalendarPaneModel;
import model.DateGet;

import java.io.*;
import java.util.HashMap;

public class CreateAgendaRecordController {

    @FXML
    private JFXTextField subjectTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private JFXButton submitButton;

    HashMap<String, String> data = new HashMap<>();
    AgendaController agendaController = new AgendaController();

    String subject = "No Subject";
    String description = "No Description";

    @FXML
    void initialize() {
        assert subjectTextField != null : "fx:id=\"subjectTextField\" was not injected: check your FXML file 'createAgendaRecord.fxml'.";
        assert descriptionTextArea != null : "fx:id=\"descriptionTextArea\" was not injected: check your FXML file 'createAgendaRecord.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'createAgendaRecord.fxml'.";
    }

    public void submitClick(ActionEvent actionEvent) {
        System.out.println(subjectTextField.getText());
        System.out.println(descriptionTextArea.getText());
        if(!subjectTextField.getText().equals("")) {
            subject = subjectTextField.getText();
        }
        if(!descriptionTextArea.getText().equals("")) {
            description = descriptionTextArea.getText();
        }
        String line = null;
        try(BufferedReader br = new BufferedReader(new FileReader("Date.txt"))) {
            StringBuilder sb = new StringBuilder();
            line = br.readLine();
            System.out.println(line);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Document.txt", true)))) {
            out.println("Dated: " + line);
            out.println("Subject: " + subject);
            out.println("Description:\n" + description + "\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
//        data.put(subjectTextField.getText(), descriptionTextArea.getText());
    }
}
