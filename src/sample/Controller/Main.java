package sample.Controller;


/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 15/4/18
 *
 *****************************/

//-----------------//
//    Imports      //
//-----------------//
import javafx.application.Application;
import javafx.stage.Stage;
import sample.View.HomePage.Display_Options;

import java.util.Random;

import static sample.Controller.Controller.numberProducts;

//-----------------//
//    Class        //
//-----------------//
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Random rand = new Random();
        numberProducts = rand.nextInt(99999) + 1;

        Display_Options.load_Display_Options(primaryStage);  // starts with loading the main Display Options Scene

        primaryStage.show();                                 // show the primary stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}
