import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller implements EventHandler {
	Model model;
	View view;
	File dataFile = null;
	File dataFileSave = null; // NIU
	static ArrayList<Double> valuesAr = new ArrayList<Double>();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");
	Date date = new Date();
	String date2 = dateFormat.format(date).toString() + " hr";
	FileInputStream fis;
	FileOutputStream fis1;
	double valueToAdd = 0;
	String directoryPath = null;
	boolean threeDaysPassed = false;
	int num = 1;
	int count = 1;
	Login login;
	String userLoggedIn = "Unknown";

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		this.view.startButton.setOnAction(this);
		this.view.quitButton.setOnAction(this);
		this.view.guestContinue.setOnAction(this);
		this.view.createAccountButton.setOnAction(this);
		this.view.prevScreen.setOnAction(this);
		this.view.quitButton2.setOnAction(this);
		this.view.importDataButton.setOnAction(this);
		this.view.deleteDataButton.setOnAction(this);
		this.view.calculateButton.setOnAction(this);
		this.view.quitButton3.setOnAction(this);
		this.view.submitData.setOnAction(this);
		this.view.back.setOnAction(this);
		this.view.back1.setOnAction(this);
		this.view.loginButton.setOnAction(this);
	}

	@Override
	public void handle(Event event) {
		if (event.getSource() == this.view.startButton) 
		{
			this.view.primaryStage.setScene(this.view.scene2);
		}
		else if (event.getSource() == this.view.quitButton) 
		{
			System.exit(0);
		} 
		else if (event.getSource() == this.view.guestContinue) 
		{
			this.view.primaryStage.setScene(this.view.scene3);
		} 
		else if (event.getSource() == this.view.createAccountButton) 
		{
			this.view.primaryStage.setScene(this.view.scene4);
		}
		else if (event.getSource() == this.view.prevScreen) 
		{
			this.view.primaryStage.setScene(EnergyHouseApp.primaryScene);
		}
		else if (event.getSource() == this.view.quitButton2) 
		{
			System.exit(0);
		}
		else if (event.getSource() == this.view.importDataButton) 
		{
			String fileName = null;
			JFrame mainWindow = new JFrame();
			// use a Filedialog to select a file to read from
			FileDialog fileDialogBox = new FileDialog(mainWindow, "Open", FileDialog.LOAD);

			fileDialogBox.setDirectory("."); // set project folder as current
												// folder
			fileDialogBox.setVisible(true);

			fileName = fileDialogBox.getFile();
			directoryPath = fileDialogBox.getDirectory();
			

			dataFile = new File(directoryPath+fileName);
			System.out.println(directoryPath + fileName);
			

		
		//	FileOutputStream oFile = new FileOutputStream(yourFile, false); 
			
			try {

				fis = new FileInputStream(new File(directoryPath + fileName));
				File sourceFile = new File (directoryPath +"/EnergyHouse/"+userLoggedIn+"/TestData/"+fileName);
				if (!sourceFile.exists()) {
					sourceFile.getParentFile().mkdirs();
					try {
						sourceFile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				try{
					if(!sourceFile.exists())
					{
						Files.copy(dataFile.toPath(), sourceFile.toPath(),StandardCopyOption.COPY_ATTRIBUTES);
					}
					else
					{
						Files.copy(dataFile.toPath(), sourceFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
					}

				}
				catch(NoSuchFileException e)
				{
					e.printStackTrace();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		else if (event.getSource() == this.view.deleteDataButton) 
		{
			String fileName = null;
			JFrame mainWindow = new JFrame();
			// use a Filedialog to select a file to read from
			FileDialog fileDialogBox = new FileDialog(mainWindow, "Select data to delete", FileDialog.LOAD);
			fileDialogBox.setVisible(true);

			fileName = fileDialogBox.getFile();
			directoryPath = fileDialogBox.getDirectory();
			
		
			dataFile = new File(directoryPath+fileName);
			System.out.println(directoryPath + fileName);				
					if(dataFile.exists())
					{
						if(dataFile.getAbsolutePath().contains(userLoggedIn))
						{
						  dataFile.delete();
						  view.infoMessage("Delete successful.");
						}
						else
						{
							view.errorMessage("Sorry you cannot delete a file that is not yours.");
						}
					}
		}

		else if (event.getSource() == this.view.calculateButton) // CALCULATE
																	// BUTTON															// =------------------=-=-=-=-=-=-=-=-=0=-0-=-0
		{

			String formulaChosen = this.view.comboBox.getValue();
			if (formulaChosen == null) {
				System.out.println("You have to chose one formula");
			} 
			else if (formulaChosen.equals("Air to Air")) 
			{
				valueToAdd = 0;
				date2 = date2 + "AA";
			} 
			else if (formulaChosen.equals("Surface to Air")) 
			{
				valueToAdd = 0.13;
				date2 = date2 + "SA";
			} 
			else if (formulaChosen.equals("Surface to Surface")) 
			{
				valueToAdd = 0.17;
				date2 = date2 + "SS";
			}
			String fileName1 = "newfile" + date2;
			String extension = ".txt";

			System.out.println(fileName1 + extension);
			// String directoryPath1 = fileDialogBoxSave.getDirectory();

			// dataFileSave = new File(directoryPath, fileName1+extension); NIU

			if (dataFile == null) {
				System.out.println("You have to import file first");

			}

			else {

				HSSFWorkbook wb = null;
				try {
					wb = new HSSFWorkbook(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
				HSSFSheet sheet = wb.getSheetAt(0);
				String cellStringValue = null;
				int lastRow = sheet.getLastRowNum() + 1;
				int colNum = sheet.getRow(0).getLastCellNum();
				String[][] data = new String[lastRow][colNum];

				////
				for (int i = 1; i < (lastRow); i++) {
					HSSFRow row = sheet.getRow(i);
					for (int j = 0; j < colNum; j++) {
						if (row.getCell(j).toString().contains("-")) {
							HSSFRow veryFirstRow = sheet.getRow(1);
							String veryFirstCell = veryFirstRow.getCell(0).toString().substring(0, 1);
							int veryFirstCellInt = Integer.parseInt(veryFirstCell);

							String dateString = row.getCell(j).toString().substring(0, 2); // Gets
																							// Date
							int dateInt = Integer.parseInt(dateString);

							// String timeString = row.getCell(j).toString(); //
							// Gets Time
							// String timeString =
							// row.getCell(j).toString().substring(4,9); // Gets
							// Time
							// int timeInt = Integer.parseInt(timeString);
							// System.out.println(timeString);

							System.out.println();
							if (dateInt >= veryFirstCellInt + 3) {
								threeDaysPassed = true;

								System.out.println("<<" + dateInt + ">>");
							}
						}
					}
				}
				if (threeDaysPassed) {
					File file = new File(directoryPath +"/EnergyHouse/"+userLoggedIn+"/Results/"+ fileName1 + extension);
					
					if (!file.exists()) {
						file.getParentFile().mkdirs();
						try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					String value = null;
					Double results = null;
					FileWriter saveFiles = null;
					try {
						saveFiles = new FileWriter(file.getAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
					BufferedWriter bw = new BufferedWriter(saveFiles);

					for (int i = 1; i < (lastRow); i++) {
						HSSFRow row = sheet.getRow(i);

						// System.out.println(" new row " + valuesAr);
						if (!valuesAr.isEmpty()) {

							results = formOne(valuesAr) + valueToAdd;

							try {

								bw.write(results.toString()); /// Point 1

							} catch (IOException e1) {
								e1.printStackTrace();
							}

							System.out.println(results + " RESULTS " + formulaChosen);
							try {
								bw.newLine();
							} catch (IOException e) {
								e.printStackTrace();
							}

						} else {
							System.out.println("Array list is empty!");
						}

						valuesAr.clear();
						int j =0;
						for (; j < colNum; j++) {
						
							if (row.getCell(j).equals(null)) {
								System.out.println("empty cells");
							} else {
								HSSFCell cell = row.getCell(j);
								if (!row.getCell(0).equals(null)) {
									// System.out.print(row.getCell(0) + " FIRST
									// PRINT ");
									// System.out.print( " SECOND PRINT " +
									// row.getCell(0).getDateCellValue());
									DataFormatter dataFormatter = new DataFormatter();
									cellStringValue = dataFormatter.formatCellValue(row.getCell(0));
									// Date date =
									// row.getCell(0).getDateCellValue();

									// row.getCell(0).toString();
									row.getCell(0).setCellValue(cellStringValue);
								}
								value = cellToString(row, cell, valuesAr);
								data[i][j] = value;
								System.out.print(value + " ");
								System.out.print(" " + valuesAr + " Array list ");
							}
						}
					
						try {
							bw.write(cellStringValue);

							/// Point 1
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {

							bw.write("\n , \n");

						} catch (IOException e) {
							e.printStackTrace();
						}
						for (Double obj : valuesAr) {

							try {
								bw.write(obj.toString()); /// Point 1
							} catch (IOException e) {
								e.printStackTrace();
							}

							try {
								bw.write("\n , \n");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					} // End of outer for.

					System.out.println(directoryPath + fileName1 + extension);
					try {

						fis = new FileInputStream(new File(directoryPath +"/EnergyHouse/"+userLoggedIn+"/Results/"+ fileName1 + extension));

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					try {
						bw.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						saveFiles.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			threeDaysPassed = false;// Needed otherwise file will be created even if too small.
				} // End of the enclosing if.
				else {
					view.errorMessage("Not enough data you need at least 72 hours.");
				}
	
			}

		}
		else if (event.getSource() == this.view.quitButton3) 
		{
			System.exit(0);
		}
		else if (event.getSource() == this.view.submitData) {
			count = 0;
			boolean isFirstNameCorrect = isFieldCorrect(this.view.firstNameTextFieldSignup);
			boolean isSurnameCorrect = isFieldCorrect(this.view.surnameTextFieldSignup);
			boolean isPasswordsEqual = this.view.passwordFieldSignup.getText().equals(this.view.passwordFieldConfirmSignup.getText());
			boolean arePasswordsPresent = isFieldCorrect(this.view.passwordFieldSignup) && isFieldCorrect(this.view.passwordFieldConfirmSignup);
			int nextNumberInt = Integer.parseInt(Model.userNo) + 1;
			System.out.println("int"+nextNumberInt);
			String nextNumberString = Integer.toString(nextNumberInt);
			System.out.println("string"+nextNumberString);
			if (!isPasswordsEqual) 
			{
				view.errorMessage("Passwords do not match. Try again.");
			}
			if(isFirstNameCorrect && isSurnameCorrect)
			{
			this.view.usernameLabelSignup.setText(this.view.firstNameTextFieldSignup.getText().toLowerCase()+"_"+this.view.surnameTextFieldSignup.getText().toLowerCase()+nextNumberString);
			}
			if(isFirstNameCorrect && isSurnameCorrect && isPasswordsEqual && arePasswordsPresent)
			{
				login = new Login();
			    login.addToUserTable(this.view.usernameLabelSignup.getText()+(nextNumberString),this.view.passwordFieldConfirmSignup.getText());
				view.clearEntries();
			}
		} 
		else if (event.getSource() == this.view.back) 
		{
			this.view.primaryStage.setScene(this.view.scene2);
		} 
		else if (event.getSource() == this.view.back1) 
		{
			this.view.primaryStage.setScene(this.view.scene2);
		} 
		else if (event.getSource() == this.view.loginButton) 
		{
			String username = this.view.usernameFieldLogin.getText();
			login = new Login(username, this.view.passwordFieldLogin.getText());
			if (Model.successfulLogin) {
				view.infoMessage("Successfully logged in "+username+".");
				userLoggedIn = username;
				view.deleteDataButton.setVisible(true);
				this.view.primaryStage.setScene(this.view.scene3);
				Model.successfulLogin = false;
				view.clearEntries();
			} else {
				view.errorMessage("Incorrect Username and Password Combination.");
				view.clearEntries();
			}
		}
	}

	public boolean isFieldCorrect(TextField nameFieldText) {
		boolean digits = false;
		boolean empty = false;
		boolean symbols = false;
		for (int i = 0; i < nameFieldText.getText().length(); i++) {
			if (Character.isDigit(nameFieldText.getText().charAt(i))) {
				digits = true;
			}
		}
		for (int i = 0; i < nameFieldText.getText().length(); i++) {
			if (!Character.isLetterOrDigit(nameFieldText.getText().charAt(i))) {
				symbols = true;
			}
		}
		if (nameFieldText.getText().isEmpty()) {
			empty = true;
		}
		if (digits) {
			if (count == 0) {
				view.errorMessage("Must be letters.");
				count++;
			}
		}
		if (empty) {
			if (count == 0) {
				view.errorMessage("Empty field(s) exist.");
				count++;
			}
		}
		if (symbols) {
			if (count == 0) {
				view.errorMessage("Refrain from using sysmbols.");
				count++;
			}
		}
		if(empty || digits|| symbols)
		{
			return false;
		}
		return true;	
	}

	private static Double formOne(ArrayList<Double> valuesAr) {
		double value;
		double avgTemp = valuesAr.get(0);
		double avgExTemp = valuesAr.get(1);
		double avgHeat = valuesAr.get(2);
		value = 1 / (((avgTemp - avgExTemp) / avgHeat));

		return value;
	}

	public static String cellToString(HSSFRow row, HSSFCell cell, ArrayList<Double> valuesAr) {

		CellType type;
		Object result;
		type = cell.getCellTypeEnum();

		switch (type) {
		case STRING:
			result = cell.getStringCellValue();
			break;
		case NUMERIC:
			cell.getCellTypeEnum().toString();
			result = cell.getNumericCellValue();
			valuesAr.add((Double) result);

			break;
		default:
			throw new RuntimeException("There are no support for this type of data");

		}

		return result.toString();
	}

}
