package sample;


//-----------------//
//    Imports      //
//-----------------//
import javafx.application.Application;
import javafx.stage.Stage;

//-----------------//
//    Class        //
//-----------------//
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{


        OPT0_Display_Options.load_Display_Options(primaryStage);  // starts with loading the main Display Options Scene

        primaryStage.show();                                 // show the primary stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}
