/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Grzegorz
 */
@SuppressWarnings("restriction")
public class PersonTableViewFactory {

    static public void processInput(Person editPerson, String newValue, String editProperty) {
        if (editProperty.equals("Name")) {
            editPerson.setName(newValue);
        }
        System.out.println("New value is " + newValue + " for property " + editProperty);
    }

    public static List<PersonColumnInfo> makeColumnInfoList() {
        List<PersonColumnInfo> myColumnInfoList = new ArrayList<>();
        myColumnInfoList.add(new PersonColumnInfo().setHeading("Name").setMinWidth(200).setProperty("name"));

        myColumnInfoList.add(new PersonColumnInfo().setHeading("Hours").setMinWidth(200).setProperty("hours"));

        myColumnInfoList.add(new PersonColumnInfo().setHeading("Money").setMinWidth(200).setProperty("money"));

        return myColumnInfoList;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static public void makeTable(TableView<Person> tableView, List<PersonColumnInfo> myColumnInfoList) {

        for (final PersonColumnInfo myColumnInfo : myColumnInfoList) {
            @SuppressWarnings("rawtypes")
            TableColumn thisColumn = new TableColumn(myColumnInfo.getHeading());
            thisColumn.setMinWidth(myColumnInfo.getMinWidth());
            
            thisColumn.setCellValueFactory(new PropertyValueFactory<Person, String>(myColumnInfo.getProperty()));
            thisColumn.setCellFactory(TextFieldTableCell.forTableColumn());

            thisColumn.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Person, String> editEvent) {
                    int editRow = editEvent.getTablePosition().getRow();
                    Person editPerson = editEvent.getTableView().getItems().get(editRow);
                    processInput(editPerson, editEvent.getNewValue(), myColumnInfo.getProperty());
                }
            });
            tableView.getColumns().add(thisColumn);
        }
    }
}
