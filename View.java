import javax.swing.JLabel;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	Pane root;
	GraphicsContext gc;
	Canvas canvas;
	Stage primaryStage;
	Image logo;
	Image energyHouse;
	Image energyHouse2;
	Image background;
	Image background1;
	Button startButton;
	Button quitButton;
	StackPane titleSP;
	Text titleText;
	Text subTitleText;
	Text titleLogin;
	Rectangle titleRectangle;


	Pane root2;
	Scene scene2;
	Canvas canvas2;
	TextField usernameField;
	PasswordField passwordField;
	Button createAccountButton;
	Button loginButton;
	Button guestContinue;
	Button prevScreen;
	Button quitButton2;
	Text titleText2;
	Label usernameLabel;
	Label passwordLabel;
	Label createAccountLabel;

	Pane root3;
	Scene scene3;
	Canvas canvas3;
	Button importDataButton;
	Button calculateButton;
	ComboBox<String> comboBox;
	Text calculatorTitle;
	Label dropmenuLabel;

	Pane root4;
	Scene scene4;
	Canvas canvas4;

	Stage window;

	public View(Pane root) {

		super();
		this.root = root;
		this.primaryStage = EnergyHouseApp.primaryStage;
		canvas = new Canvas(1024,768);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.ORANGE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		root.getChildren().add(canvas);

		background = new Image(this.getClass().getResource("res/bg.png").toExternalForm());
		gc.drawImage(background, 0, 0);
		logo = new Image(this.getClass().getResource("res/logo.png").toExternalForm());
		gc.drawImage(logo, 25, 30, 190, 100);
		energyHouse = new Image(this.getClass().getResource("res/energyHouseSign.png").toExternalForm());
		gc.drawImage(energyHouse, 700, 20, 300, 150);

		startButton = new Button("Start");
		startButton.setLayoutX(325);
		startButton.setLayoutY(550);
		startButton.setPrefSize(150, 100);
		startButton.setFont(Font.font("Calibri",FontPosture.REGULAR, 32));
		root.getChildren().add(startButton);

		quitButton = new Button("Quit");
		quitButton.setLayoutX(525);
		quitButton.setLayoutY(550);
		quitButton.setPrefSize(150, 100);
		quitButton.setFont(Font.font("Calibri",FontPosture.REGULAR, 32));
		root.getChildren().add(quitButton);


		titleText= new Text();
		titleText.setText("UoS Energy House");
		titleText.setLayoutX(250);
		titleText.setLayoutY(300);
		titleText.setFont(Font.font("Calibri",FontWeight.BOLD,FontPosture.REGULAR,70));
		titleText.setFill(Color.CRIMSON);
		root.getChildren().add(titleText);

		subTitleText= new Text();
		subTitleText.setText("Material Resistance Calculator");
		subTitleText.setLayoutX(90);
		subTitleText.setLayoutY(375);
		subTitleText.setFont(Font.font("Calibri",FontWeight.BOLD,FontPosture.REGULAR,70));
		subTitleText.setFill(Color.GREY);
		root.getChildren().add(subTitleText);

		//SCENE2-------------------------------------------------------------------------
		root2 = new Pane();
		canvas2 = new Canvas(1024,768);
		scene2 = new Scene(root2,1024,768);
		gc = canvas2.getGraphicsContext2D();
		root2.getChildren().add(canvas2);
		background = new Image(this.getClass().getResource("res/bg.png").toExternalForm());
		gc.drawImage(background, 0, 0);
		logo = new Image(this.getClass().getResource("res/logo.png").toExternalForm());
		gc.drawImage(logo, 25, 30, 190, 100);
		energyHouse = new Image(this.getClass().getResource("res/energyHouseSign.png").toExternalForm());
		gc.drawImage(energyHouse, 700, 20, 300, 150);

		titleText2= new Text();
		titleText2.setText("Please log in.");
		titleText2.setLayoutX(25);
		titleText2.setLayoutY(200);
		titleText2.setFont(Font.font("Calibri",FontWeight.BOLD,FontPosture.REGULAR,30));
		titleText2.setFill(Color.CRIMSON);
		root2.getChildren().add(titleText2);

		usernameLabel = new Label();
		usernameLabel.setText("Username:");
		usernameLabel.setLayoutX(25);
		usernameLabel.setLayoutY(250);
		root2.getChildren().add(usernameLabel);

		usernameField = new TextField();
		usernameField.setLayoutX(25);
		usernameField.setLayoutY(275);
		root2.getChildren().add(usernameField);

		passwordLabel = new Label();
		passwordLabel.setText("Password:");
		passwordLabel.setLayoutX(25);
		passwordLabel.setLayoutY(325);
		root2.getChildren().add(passwordLabel);

		passwordField = new PasswordField();
		passwordField.setLayoutX(25);
		passwordField.setLayoutY(350);
		root2.getChildren().add(passwordField);

		createAccountLabel = new Label();
		createAccountLabel.setText("Don't have an account? Click below to create one.");
		createAccountLabel.setLayoutX(25);
		createAccountLabel.setLayoutY(650);
		root2.getChildren().add(createAccountLabel);

		createAccountButton = new Button("Create Account");
		createAccountButton.setLayoutX(25);
		createAccountButton.setLayoutY(675);
		createAccountButton.setPrefSize(185, 50);
		root2.getChildren().add(createAccountButton);

		loginButton = new Button("Log in");
		loginButton.setLayoutX(25);
		loginButton.setLayoutY(400);
		loginButton.setPrefSize(185,50);
		root2.getChildren().add(loginButton);

		guestContinue = new Button("Continue as Guest");
		guestContinue.setLayoutX(225);
		guestContinue.setLayoutY(400);
		guestContinue.setPrefSize(185,50);
		root2.getChildren().add(guestContinue);

		quitButton2 = new Button("Quit");
		quitButton2.setLayoutX(800);
		quitButton2.setLayoutY(675);
		quitButton2.setPrefSize(185, 50);
		root2.getChildren().add(quitButton2);

		prevScreen = new Button("Back to previous screen");
		prevScreen.setLayoutX(600);
		prevScreen.setLayoutY(675);
		prevScreen.setPrefSize(185, 50);
		root2.getChildren().add(prevScreen);


		//SCENE3 ---------------------
		root3 = new Pane();
		canvas3 = new Canvas(1024,768);
		scene3= new Scene(root3,1024,768);
		gc = canvas3.getGraphicsContext2D();
		root3.getChildren().add(canvas3);
		background = new Image(this.getClass().getResource("res/bg.png").toExternalForm());
		gc.drawImage(background, 0, 0);

		calculatorTitle = new Text("Calculator");
		calculatorTitle.setLayoutX(25);
		calculatorTitle.setLayoutY(200);
		calculatorTitle.setFont(Font.font("Calibri",FontWeight.BOLD,FontPosture.REGULAR,30));
		calculatorTitle.setFill(Color.CRIMSON);
		root3.getChildren().add(calculatorTitle);
		
		logo = new Image(this.getClass().getResource("res/logo.png").toExternalForm());
		gc.drawImage(logo, 25, 30, 190, 100);
		energyHouse = new Image(this.getClass().getResource("res/energyHouseSign.png").toExternalForm());
		gc.drawImage(energyHouse, 700, 20, 300, 150);

		importDataButton= new Button("Import File");
		importDataButton.setLayoutX(25);
		importDataButton.setLayoutY(225);
		importDataButton.setPrefSize(185,50);
		root3.getChildren().add(importDataButton);

		dropmenuLabel = new Label("Select Required Formula:");
		dropmenuLabel.setLayoutX(25);
		dropmenuLabel.setLayoutY(325);
		root3.getChildren().add(dropmenuLabel);

		comboBox= new ComboBox<>();
		comboBox.getItems().addAll(
				"Air to Air",
				"Surface to Air",
				"Surface to Surface"
				);
		comboBox.setPromptText("Select required formula:");
		comboBox.setLayoutX(25);
		comboBox.setLayoutY(350);
		root3.getChildren().add(comboBox);

		calculateButton= new Button("Calculate");
		calculateButton.setLayoutX(750);
		calculateButton.setLayoutY(600);
		calculateButton.setPrefSize(185,50);
		root3.getChildren().add(calculateButton);

		//////SCENE4--------------------------------------

		root4 = new Pane();
		canvas4 = new Canvas(1024,768);
		scene4= new Scene(root4,1024,768);
		gc = canvas4.getGraphicsContext2D();
		root4.getChildren().add(canvas4);

	}
	public class Login extends Application {

		String user = "JavaFX2";
		String pw = "password";
		String checkUser, checkPw;



		@Override
		public void start(Stage primaryStage) {

		}
	}
}
