package application.gui.elements;

import application.controllers.SkewbScreenController;
import cubes.skewb.data.L2LCase;
import cubes.skewb.data.L2LSet;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Settings.Settings.AUTO_REMOVE_FOCUS;

public class AlgSetElement extends TitledPane implements Initializable {
    @FXML
    private VBox caseContainer;

    L2LSet algSet;

    public AlgSetElement(L2LSet algSet, SkewbScreenController co) {
        this.algSet = algSet;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/elements/algSetElement.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (AUTO_REMOVE_FOCUS) {
            caseContainer.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    co.getScreen().requestFocus();
                }
            });
        }

        this.setText(this.algSet.getId() + ": " + this.algSet.getName());
        for (L2LCase c : this.algSet.getCases()) {
            this.caseContainer.getChildren().add(new AlgCaseElement(c, co));
        }
    }

    public VBox getCaseContainer() {
        return caseContainer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setExpanded(false);
    }


}
