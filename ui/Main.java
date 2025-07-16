package org.manipal.oops.proj.trade.ui;

import org.manipal.oops.proj.trade.loader.LoadManager;
import org.manipal.oops.proj.trade.model.DataSource;
import org.manipal.oops.proj.trade.model.User;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene scene1,scene2;
   
   public static void main(String[] args) {
       launch(args);
   }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setOnCloseRequest(e -> System.out.println("Window closed"));
        primaryStage.setTitle("Pragya's Project");
        
        Label label1 = new Label("Welcome to Pragya's project");
        Label label2 = new Label("Upload Successful");
        
        ChoiceBox<User> usersList = new ChoiceBox<User>();
        usersList.setItems(getUsersMasterList());
        //TODO: set default user
       
        
        /*ChoiceBox<String> dataSourceList = new ChoiceBox<String>();
        dataSourceList.getItems().add("ICICI");
        dataSourceList.getItems().add("Axis");*/
        
        ChoiceBox<DataSource> dataSourceList = new ChoiceBox<DataSource>();
        dataSourceList.setItems(getDataSourceMasterList());
        //TODO: set default ds       
        
        Button button = new Button("Upload");
     
        button.setOnAction(e -> {
            getSelectedUser(usersList);
            getSelectedDataSource(dataSourceList);
            //window.setScene(scene2);
            } );
        
        /*button.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("HIT from anonymous inner class");
            }
            
        });*/
        
        //children laid out in vertical column spaced out 20 pixels away
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button);
        scene1 = new Scene(layout1,200,200);
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(label2);
        
        scene2 = new Scene(layout2,300,250);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public ObservableList<User> getUsersMasterList(){
        ObservableList<User> users = FXCollections.observableArrayList(LoadManager.getUserList());
        return users;
    }
    
    public ObservableList<DataSource> getDataSourceMasterList(){
        ObservableList<DataSource> dsMasterList = FXCollections.observableArrayList(LoadManager.getDatasourselist());
        return dsMasterList;
    }
    
    private static DataSource getSelectedDataSource(ChoiceBox<DataSource> dataSourceList) {
        DataSource selectedDataSource = dataSourceList.getValue();
        System.out.println("Selected datasource is: " + selectedDataSource);
        return selectedDataSource;
        
    }

    private static User getSelectedUser(ChoiceBox<User> usersList) {
        User selectedUser = usersList.getValue();
        System.out.println("Selected User is: " + selectedUser);
        
        return selectedUser;
    }

    
}
