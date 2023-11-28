import controller.SimpleController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.SimpleModel;
import view.SampleView;


public class Launcher extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new SimpleController(new SampleView(primaryStage), new SimpleModel());
    }
}
