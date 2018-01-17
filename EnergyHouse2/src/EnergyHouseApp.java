import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EnergyHouseApp extends Application {
	View view;
	Model model;
	Controller controller;
    static Stage primaryStage;
    static Scene primaryScene;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		EnergyHouseApp.primaryStage = primaryStage;
		EnergyHouseApp.primaryStage.setTitle("Energy House Data Analysis Portal");
		Pane root = new Pane();
		
		primaryScene = new Scene(root,1024,768);
		EnergyHouseApp.primaryStage.setScene(primaryScene);
		EnergyHouseApp.primaryStage.show();
		
		view = new View(root);
		model  = new Model();
		controller = new Controller(model,view);	
	}

}