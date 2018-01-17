import javax.swing.JLabel;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	TextField usernameFieldLogin;
	PasswordField passwordFieldLogin;
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
	Text createAccount;
	Text fillout;

	Stage window;

	Button back;
	Button back1;
	Text name;
	Text surname;
	Text email;
	TextField firstNameTextFieldSignup;
	TextField surnameTextFieldSignup;
	Label usernameLabelSignup;
	PasswordField passwordFieldSignup;
	PasswordField passwordFieldConfirmSignup;
	Text password;
	Text passwordConfirm;
	ComboBox<String> comboBox1;
	Image background2;
	Button submitData;
	Alert alertConfirmation;

	public View(Pane root) {

		super();
		this.root = root;
		this.primaryStage = EnergyHouseApp.primaryStage;
		canvas = new Canvas(1024, 768);
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
		startButton.setFont(Font.font("Calibri", FontPosture.REGULAR, 32));
		root.getChildren().add(startButton);

		quitButton = new Button("Quit");
		quitButton.setLayoutX(525);
		quitButton.setLayoutY(550);
		quitButton.setPrefSize(150, 100);
		quitButton.setFont(Font.font("Calibri", FontPosture.REGULAR, 32));
		root.getChildren().add(quitButton);

		titleText = new Text();
		titleText.setText("UoS Energy House");
		titleText.setLayoutX(250);
		titleText.setLayoutY(300);
		titleText.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 70));
		titleText.setFill(Color.CRIMSON);
		root.getChildren().add(titleText);

		subTitleText = new Text();
		subTitleText.setText("Material Resistance Calculator");
		subTitleText.setLayoutX(90);
		subTitleText.setLayoutY(375);
		subTitleText.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 70));
		subTitleText.setFill(Color.GREY);
		root.getChildren().add(subTitleText);

		// SCENE2-------------------------------------------------------------------------
		root2 = new Pane();
		canvas2 = new Canvas(1024, 768);
		scene2 = new Scene(root2, 1024, 768);
		gc = canvas2.getGraphicsContext2D();
		root2.getChildren().add(canvas2);
		background = new Image(this.getClass().getResource("res/bg.png").toExternalForm());
		gc.drawImage(background, 0, 0);
		logo = new Image(this.getClass().getResource("res/logo.png").toExternalForm());
		gc.drawImage(logo, 25, 30, 190, 100);
		energyHouse = new Image(this.getClass().getResource("res/energyHouseSign.png").toExternalForm());
		gc.drawImage(energyHouse, 700, 20, 300, 150);

		titleText2 = new Text();
		titleText2.setText("Please log in.");
		titleText2.setLayoutX(25);
		titleText2.setLayoutY(200);
		titleText2.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
		titleText2.setFill(Color.CRIMSON);
		root2.getChildren().add(titleText2);

		usernameLabel = new Label();
		usernameLabel.setText("Username:");
		usernameLabel.setLayoutX(25);
		usernameLabel.setLayoutY(250);
		root2.getChildren().add(usernameLabel);

		usernameFieldLogin = new TextField();
		usernameFieldLogin.setLayoutX(25);
		usernameFieldLogin.setLayoutY(275);
		root2.getChildren().add(usernameFieldLogin);

		passwordLabel = new Label();
		passwordLabel.setText("Password:");
		passwordLabel.setLayoutX(25);
		passwordLabel.setLayoutY(325);
		root2.getChildren().add(passwordLabel);

		passwordFieldLogin = new PasswordField();
		passwordFieldLogin.setLayoutX(25);
		passwordFieldLogin.setLayoutY(350);
		root2.getChildren().add(passwordFieldLogin);

		createAccountLabel = new Label();
		createAccountLabel.setText("Don't have an account? Click below to create one.");
		createAccountLabel.setLayoutX(25);
		createAccountLabel.setLayoutY(650);
		root2.getChildren().add(createAccountLabel);

		createAccountButton = new Button("Create Account");
		createAccountButton.setLayoutX(25);
		createAccountButton.setLayoutY(695);
		createAccountButton.setPrefSize(185, 50);
		root2.getChildren().add(createAccountButton);

		loginButton = new Button("Log in");
		loginButton.setLayoutX(25);
		loginButton.setLayoutY(400);
		loginButton.setPrefSize(185, 50);
		root2.getChildren().add(loginButton);

		guestContinue = new Button("Continue as Guest");
		guestContinue.setLayoutX(225);
		guestContinue.setLayoutY(400);
		guestContinue.setPrefSize(185, 50);
		root2.getChildren().add(guestContinue);

		quitButton2 = new Button("Quit");
		quitButton2.setLayoutX(800);
		quitButton2.setLayoutY(695);
		quitButton2.setPrefSize(185, 50);
		root2.getChildren().add(quitButton2);

		prevScreen = new Button("Back to previous screen");
		prevScreen.setLayoutX(600);
		prevScreen.setLayoutY(695);
		prevScreen.setPrefSize(185, 50);
		root2.getChildren().add(prevScreen);

		// SCENE3 ---------------------
		root3 = new Pane();
		canvas3 = new Canvas(1024, 768);
		scene3 = new Scene(root3, 1024, 768);
		gc = canvas3.getGraphicsContext2D();
		root3.getChildren().add(canvas3);
		background = new Image(this.getClass().getResource("res/bg.png").toExternalForm());
		gc.drawImage(background, 0, 0);

		calculatorTitle = new Text("Calculator");
		calculatorTitle.setLayoutX(25);
		calculatorTitle.setLayoutY(220);
		calculatorTitle.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
		calculatorTitle.setFill(Color.CRIMSON);
		root3.getChildren().add(calculatorTitle);

		logo = new Image(this.getClass().getResource("res/logo.png").toExternalForm());
		gc.drawImage(logo, 25, 30, 190, 100);
		energyHouse = new Image(this.getClass().getResource("res/energyHouseSign.png").toExternalForm());
		gc.drawImage(energyHouse, 700, 20, 300, 150);

		importDataButton = new Button("Import File");
		importDataButton.setLayoutX(25);
		importDataButton.setLayoutY(245);
		importDataButton.setPrefSize(185, 50);
		root3.getChildren().add(importDataButton);

		dropmenuLabel = new Label("Select Required Formula:");
		dropmenuLabel.setLayoutX(25);
		dropmenuLabel.setLayoutY(345);
		root3.getChildren().add(dropmenuLabel);

		comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Air to Air", "Surface to Air", "Surface to Surface");
		comboBox.setPromptText("Select required formula:");
		comboBox.setLayoutX(25);
		comboBox.setLayoutY(350);
		root3.getChildren().add(comboBox);

		calculateButton = new Button("Calculate");
		calculateButton.setLayoutX(600);
		calculateButton.setLayoutY(580);
		calculateButton.setPrefSize(185, 100);
		root3.getChildren().add(calculateButton);
		
		quitButton = new Button("Quit");
		quitButton.setLayoutX(800);
		quitButton.setLayoutY(695);
		quitButton.setPrefSize(185, 50);
		root3.getChildren().add(quitButton);
		
		back = new Button("Back");
		back.setLayoutX(600);
		back.setLayoutY(695);
		back.setPrefSize(185, 50);
		root3.getChildren().add(back);

		////// SCENE4--------------------------------------

		root4 = new Pane();
		canvas4 = new Canvas(1024, 768);
		scene4 = new Scene(root4, 1024, 768);
		gc = canvas4.getGraphicsContext2D();
		root4.getChildren().add(canvas4);
		background = new Image(this.getClass().getResource("res/bg.png").toExternalForm());
		gc.drawImage(background, 0, 0);
		
		logo = new Image(this.getClass().getResource("res/logo.png").toExternalForm());
		gc.drawImage(logo, 25, 30, 190, 100);
		energyHouse = new Image(this.getClass().getResource("res/energyHouseSign.png").toExternalForm());
		gc.drawImage(energyHouse, 700, 20, 300, 150);

		createAccount = new Text("Create Account");
		createAccount.setLayoutX(25);
		createAccount.setLayoutY(220);
		createAccount.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 40));
		createAccount.setFill(Color.BLACK);
		root4.getChildren().add(createAccount);

		fillout = new Text("Fill in the information below correctly in order to create your account.");
		fillout.setLayoutX(25);
		fillout.setLayoutY(245);
		fillout.setFill(Color.CRIMSON);
		root4.getChildren().add(fillout);

		name = new Text("First Name");
		name.setLayoutX(25);
		name.setLayoutY(270);
		name.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18));
		name.setFill(Color.BLACK);
		root4.getChildren().add(name);

		firstNameTextFieldSignup = new TextField();
		firstNameTextFieldSignup.setLayoutX(25);
		firstNameTextFieldSignup.setLayoutY(280);
		root4.getChildren().add(firstNameTextFieldSignup);

		surname = new Text("Last Name");
		surname.setLayoutX(300);
		surname.setLayoutY(270);
		surname.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18));
		surname.setFill(Color.BLACK);
		root4.getChildren().add(surname);

		surnameTextFieldSignup = new TextField();
		surnameTextFieldSignup.setLayoutX(300);
		surnameTextFieldSignup.setLayoutY(280);
		root4.getChildren().add(surnameTextFieldSignup);

		email = new Text("Username");
		email.setLayoutX(25);
		email.setLayoutY(350);
		email.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18));
		email.setFill(Color.BLACK);
		root4.getChildren().add(email);

		usernameLabelSignup = new Label();
		usernameLabelSignup.setLayoutX(25);
		usernameLabelSignup.setLayoutY(360);
		usernameLabelSignup.setText("auto-generated");
		root4.getChildren().add(usernameLabelSignup);

		password = new Text("Password");
		password.setLayoutX(25);
		password.setLayoutY(420);
		password.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18));
		password.setFill(Color.BLACK);
		root4.getChildren().add(password);

		passwordFieldSignup = new PasswordField();
		passwordFieldSignup.setLayoutX(25);
		passwordFieldSignup.setLayoutY(430);
	    root4.getChildren().add(passwordFieldSignup);
		 
		passwordConfirm = new Text("Repeat Password");
		passwordConfirm.setLayoutX(300);
		passwordConfirm.setLayoutY(420);
		passwordConfirm.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18));
		passwordConfirm.setFill(Color.BLACK);
		root4.getChildren().add(passwordConfirm);

		passwordFieldConfirmSignup = new PasswordField();
		passwordFieldConfirmSignup.setLayoutX(300);
		passwordFieldConfirmSignup.setLayoutY(430);
		root4.getChildren().add(passwordFieldConfirmSignup);

		submitData = new Button("Create Account");
		submitData.setLayoutX(25);
		submitData.setLayoutY(500);
		submitData.setPrefSize(185, 50);
		root4.getChildren().add(submitData);
		
		quitButton = new Button("Quit");
		quitButton.setLayoutX(800);
		quitButton.setLayoutY(695);
		quitButton.setPrefSize(185, 50);
		root4.getChildren().add(quitButton);

		back1 = new Button("Back to previous screen");
		back1.setLayoutX(600);
		back1.setLayoutY(695);
		back1.setPrefSize(185, 50);
		root4.getChildren().add(back1);
		
		alertConfirmation = new Alert(AlertType.CONFIRMATION);
	}

	public void errorMessage(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public void infoMessage(String message) {
		alertConfirmation.getButtonTypes().clear();
		ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
		alertConfirmation.getButtonTypes().add(ok);
		alertConfirmation.setTitle("Confirmation");
		alertConfirmation.setHeaderText(null);
		alertConfirmation.setContentText(message);
		alertConfirmation.showAndWait();
	
	}
	public void clearEntries()
	{
		firstNameTextFieldSignup.clear();
		surnameTextFieldSignup.clear();
	   // usernameLabelSignup.setText("auto-generated");
	    passwordFieldSignup.clear();
		passwordFieldConfirmSignup.clear();
		usernameFieldLogin.clear();
		passwordFieldLogin.clear();
	}
}
