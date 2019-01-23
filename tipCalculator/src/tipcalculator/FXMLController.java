/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Grzegorz
 */
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<Person> tableView;

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.isControlDown()) {
            if (event.getCode() == KeyCode.X) {

            }
        }
    }

    @FXML
    private void refresh(ActionEvent event) {
        Set<Person> output = new HashSet(tableView.getItems());
        Scene scene = tableView.getScene();
        TableView<Person> tableInFocus = null;
        sqlStatements statement = new sqlStatements();

        if (scene.focusOwnerProperty().get() instanceof TableView) {
            tableInFocus = (TableView) scene.focusOwnerProperty().get();
            ObservableList<Person> itemsSelected = tableInFocus.getSelectionModel().getSelectedItems();
            Set<Person> toTable = new HashSet(itemsSelected);
            toTable = statement.getPerson();

            //here i should fetch people from database
            ObservableList<Person> dataForTableViewAndModel = FXCollections.observableArrayList(toTable);
            tableView.setItems(dataForTableViewAndModel);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<PersonColumnInfo> columns = PersonTableViewFactory.makeColumnInfoList();
        PersonTableViewFactory.makeTable(tableView, columns);
    }

}
