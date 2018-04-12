package sample;



/**
 * Created by Steve on 11/04/2018.
 */
//-----------------//
//    Imports      //
//-----------------//
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




//-----------------//
//    Class        //
//-----------------//
public class OPT1_Add_Product {





    public static void load_Add_Options(Stage primaryStage){


        // Title
        HBox chooseProductType_Title         = new HBox();                                                       // store title

        Label label_chooseProductType_Title  = new Label("Please select which product to add:");            // create label for title

        chooseProductType_Title.getChildren().add(label_chooseProductType_Title);                                // add label to title HBox

        chooseProductType_Title.setAlignment(Pos.CENTER);                                                        // center main structure

        // Options
        HBox chooseProductType_Options       = new HBox();                                                       // store options

        Button AddPhone = new Button("Add Phone");                                                          // create button to add phone

        Button AddTV    = new Button("Add TV");                                                             // create button to add tv

        chooseProductType_Options.getChildren().addAll(AddPhone, AddTV );                                        // add buttons to hbox

        chooseProductType_Options.setSpacing(30);                                                                // adds spacing between elements

        chooseProductType_Options.setAlignment(Pos.CENTER);                                                      // center main structure


        // main structure
        VBox chooseProductType_MainStructure = new VBox();                                                       // store HBoxes

        chooseProductType_MainStructure.getChildren().addAll(chooseProductType_Title,chooseProductType_Options); // add HBox's to vBox

        chooseProductType_MainStructure.setSpacing(50);                                                          // set spacing between children

        chooseProductType_MainStructure.setAlignment(Pos.CENTER);                                                // center main structure

        Scene chooseProductType = new Scene(chooseProductType_MainStructure, 500, 500);            // Create the Scene // create new scene, add VBOX


        primaryStage.setScene(chooseProductType);                                                                // set scene




        /* ----------------------------------------------------
                  Buttons
           ---------------------------------------------------- */

        AddPhone.setOnAction((ActionEvent e) -> {

               OPT1_Add_Phone.load_Add_Phone(primaryStage);                             // switch to create Phone screen

        });



        AddTV.setOnAction(e-> {

            OPT1_Add_TV.load_Add_TV(primaryStage);                                     // switch to create TV screen

        });





    }


}
