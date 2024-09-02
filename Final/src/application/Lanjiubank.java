package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Lanjiubank extends Application{
	static ArrayList<Consumer> accounts = new ArrayList<Consumer>();
	static GridPane main;
	static int type = 0;
	static int acontrol = 0;
	static int atype = 0;
	static String actions = "";
	static Text qes = new Text("");
	static Text statment = new Text("");
	static Text response = new Text("");
	static TextArea info = new TextArea("");
	static boolean hasc = false;
	static boolean hass = false;

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setResizable(false);
		///// Title on top of page
		pane.setStyle("-fx-background-color: gainsboro;");
		HBox titlebar = new HBox();
		Text title = new Text("Lanjiu Bank");
		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		titlebar.getChildren().add(title);
		titlebar.setStyle("-fx_border-width: 6px; -fx-border-color: cadetblue");
		titlebar.setAlignment(Pos.TOP_CENTER);
		Button back = new Button("Back");
		/////Login panes
		VBox loginpg = new VBox();
		Text enterun = new Text("Please enter your ID #");
		TextField id = new TextField();
		Text enterpw = new Text("Please enter your Password");
		TextField password = new TextField();
		Button enter = new Button("Enter");
		Button ca = new Button("Create an Account");
		Button logout = new Button("Logout");
		Text warning = new Text("If you exist program with out logining out actions are not saved to data base");
		enter.setAlignment(Pos.BOTTOM_RIGHT);
		loginpg.setStyle("-fx_border-width: 50px; -fx-border-color: gainsboro");
		loginpg.getChildren().addAll(enterun, id, enterpw , password, enter, ca);
		loginpg.setAlignment(Pos.CENTER);
		
		/////Adding to pane
		pane.setAlignment(Pos.TOP_CENTER);
		pane.add(titlebar, 2, 0);
		pane.add(loginpg, 2, 1);
		pane.setVgap(15);
		
	////Enter button both checks id and password that takes you to the main menu
		enter.setOnAction(e -> {
			System.out.println(id.getText());
			int userid = Integer.parseInt(id.getText());
			System.out.println(password.getText());
			if(Integer.parseInt(id.getText()) < accounts.size()) {
				if(accounts.get(Integer.parseInt(id.getText())).getpassword().equals(password.getText()) == true){
					pane.getChildren().remove(loginpg);
					main = Mainmenu(userid);
					pane.add(main, 2, 1);
					
					pane.add(logout, 2, 2);
					warning.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
					warning.setFill(Color.CADETBLUE);
					pane.add(warning, 2, 3);
				}else {
					System.out.println("Passwords do not match.");
					Text wpass = new Text("Incorrect password please try again");
					loginpg.getChildren().add(wpass);
				}
			}else {
				System.out.println("Not a valid id number.");
				Text wid = new Text("Not a valid ID # please try again");
				loginpg.getChildren().add(wid);
			}
			
			
		});
		/////Log out button takes you back to login.
		logout.setOnAction(e->{
			try {
				saveData();
				System.out.println("Data saved");
			} catch (FileNotFoundException | ClassNotFoundException | EOFException | ParseException e1) {
				System.out.println("Data not saved");
				e1.printStackTrace();
			}
			pane.getChildren().remove(logout);
			pane.getChildren().remove(warning);
			pane.getChildren().remove(main);
			pane.add(loginpg, 2, 1);
			id.setText("");
			password.setText("");
			
			
		});
		/// Button that takes you to the create new account page.
		ca.setOnAction(e->{
			main = createa();
			pane.getChildren().remove(loginpg);
			pane.add(main, 2, 1);
			pane.add(back, 2, 2);
				
			});
		
		back.setOnAction(e->{
			pane.getChildren().remove(main);
			pane.getChildren().remove(back);
			pane.add(loginpg, 2, 1);
			id.setText("");
			password.setText("");
			
			
		});
		/////Adding cool image to pop more color
		Image sideing = new Image("Bluesiding.png");
		ImageView side = new ImageView(sideing);
		side.setFitWidth(100);
	    side.setPreserveRatio(true);
		ImageView side2 = new ImageView(sideing);
		side2.setFitWidth(100);
	    side2.setPreserveRatio(true);
	    pane.add(side, 0, 0);
	    pane.add(side2, 3, 0);
		
		Image icon = new Image("icon.png"); // add image for icon
		primaryStage.getIcons().add(icon); // change icon
		primaryStage.setTitle("LanjiuBank"); // Title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	public static void main(String[] args)  throws FileNotFoundException, ClassNotFoundException, ParseException, EOFException{
		/////Reading files from the account
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("Userdata.dat"))) {
			try{
				while(true) {
			
					int id = input.readInt();
					String password = input.readUTF();
					boolean hc = input.readBoolean();
					int haccnumber = input.readInt();
					double hbalance = input.readDouble();
					boolean hs = input.readBoolean();
					int saccnumber = input.readInt();
					double sbalance = input.readDouble();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
					///////sdf.format(date); for the other way.
					Date hcreated =  sdf.parse(input.readUTF());
					Date screated =  sdf.parse(input.readUTF());
					double hinterestrate = input.readDouble();
					double sinterestrate = input.readDouble();
					String chistory = input.readUTF();
					String shistory = input.readUTF();
					
			
					accounts.add(new Consumer(id,password, hc,haccnumber,hbalance,hs,saccnumber,sbalance, hcreated, screated, hinterestrate, sinterestrate, chistory, shistory));
				}
			}catch(EOFException ex){
				 System.out.println("End of File");
				 input.close();
			}
		}catch(IOException ex){
			System.out.println("File not accessible");
			
		}
		/////basic test account
		System.out.println(accounts.get(0).getpassword());
		accounts.get(1).setId(1);
		
		/////Writing accounts to the file
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Userdata.dat"));){
			int i = 0;
			int k = accounts.size();
			do {
				System.out.println(accounts.get(i).getId());
				output.writeInt(accounts.get(i).getId());
				output.writeUTF(accounts.get(i).getpassword());
				output.writeBoolean(accounts.get(i).hasChecking());
				output.writeInt(accounts.get(i).getAccountnumber(1));
				output.writeDouble(accounts.get(i).getBalance(1));
				output.writeBoolean(accounts.get(i).hasSavings());
				output.writeInt(accounts.get(i).getAccountnumber(2));
				output.writeDouble(accounts.get(i).getBalance(2));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
				output.writeUTF(sdf.format(accounts.get(i).getDateCreated(1)));
				output.writeUTF(sdf.format(accounts.get(i).getDateCreated(2)));
				output.writeDouble(accounts.get(i).getAnnualInterestRate(1));
				output.writeDouble(accounts.get(i).getAnnualInterestRate(2));
				output.writeUTF(accounts.get(i).getHistory(1));
				output.writeUTF(accounts.get(i).getHistory(2));
						
				i++;
			} while(i != k);
				
				System.out.println(k);
	
			
				System.out.println("Accounts saved to file");
			
		}catch(IOException ex){
			System.out.println("File not accessible");
		}
		
		/// launching the GUI
		launch(args);
	}
	/////main menu of the account screen.
	public static GridPane Mainmenu(int id) {
		GridPane pane = new GridPane();
		////Creating all the necessary buttons for the page and nodes.
		Button sav = new Button("Savings account");
		Button che = new Button("Checking account");
		Button yes = new Button("Yes");
		Button no = new Button("No");
		HBox yngro = new HBox();
		Button cb = new Button("Check Balance");
		Button wth = new Button("WithDrawl");
		Button de = new Button("Deposit");
		Button ainfo = new Button("Account Info");
		HBox controls = new HBox();
		Button back = new Button("Back");
		TextField answer = new TextField();
		Button enter = new Button("Enter");
		controls.getChildren().addAll(cb, wth, de, ainfo);
		yngro.getChildren().addAll(yes,no);
		pane.add(sav, 0, 0);
		pane.add(che, 0, 1);
		pane.setVgap(5);
		pane.setHgap(5);
	
		//// Savings button response
		sav.setOnAction(e-> {
			type = 2;
			if(accounts.get(id).hasSavings()==false) {
				pane.getChildren().removeAll(sav,che);
				qes = new Text("You do not have a Saving acount would you like to open one?");
				pane.add(qes, 0, 0);
				pane.add(yngro, 0, 1);
			}else {
				pane.getChildren().remove(sav);
				pane.getChildren().remove(che);
				qes = new Text("Saving Acount");
				acontrol = 0;
				pane.add(qes, 0, 0);
				pane.add(controls, 0, 1);
				pane.add(back, 0, 3);
			}
		});
		///// checking button response
		che.setOnAction(e-> {
			type = 1;
			if(accounts.get(id).hasChecking()==false) {
				pane.getChildren().removeAll(sav,che);
				qes = new Text("You do not have a Checking acount would you like to open one?");
				pane.add(qes, 0, 0);
				pane.add(yngro, 0, 1);
				acontrol = 0;
			}else {
				pane.getChildren().remove(sav);
				pane.getChildren().remove(che);
				qes = new Text("Checking Acount");
				acontrol = 0;
				pane.add(qes, 0, 0);
				pane.add(controls, 0, 1);
				pane.add(back, 0, 3);
				
			}
		});
		/////yes button response different response depending on the account type. 
		yes.setOnAction(e->{
			pane.getChildren().remove(qes);
			pane.getChildren().remove(yngro);
			if(type == 1) {
				qes = new Text("Checking Acount");
				accounts.get(id).openchecking(id, 0);
				
			}else {
				qes = new Text("Saving Acount");
				accounts.get(id).opensavings(id, 0);
			}
			acontrol = 0;
			pane.add(qes, 0, 0);
			pane.add(controls, 0, 1);
			pane.add(back, 0, 3);
			
		});
		/////no button response
		no.setOnAction(e->{
			pane.getChildren().remove(qes);
			pane.getChildren().remove(yngro);
			pane.add(sav, 0, 0);
			pane.add(che, 0, 1);
		});
		////back button controls
		back.setOnAction(e-> {
			////Changes what it does depending on the past page so the number shows the page difference.
			//// basic main menu
			if(acontrol == 0) {
				pane.getChildren().removeAll(qes, controls, back);
				pane.add(sav, 0, 0);
				pane.add(che, 0, 1);
				////Deposit and withdraw back
			}else if (acontrol == 1) {
				pane.getChildren().removeAll(qes, statment, answer, back, enter);
				pane.add(sav, 0, 0);
				pane.add(che, 0, 1);
			}
			////Balance back
			else if(acontrol == 2) {
				pane.getChildren().removeAll(qes, statment, back);
				pane.add(sav, 0, 0);
				pane.add(che, 0, 1);
			}
			////account info back
			else if (acontrol == 3) {
				pane.getChildren().removeAll(qes, info, back);
				pane.add(sav, 0, 0);
				pane.add(che, 0, 1);
			}
			////after deposit/withdraw
			else if (acontrol == 4) {
				pane.getChildren().removeAll(qes, statment, answer, back, enter, response);
				pane.add(sav, 0, 0);
				pane.add(che, 0, 1);
			}
			
			
		});
		
		/// Checking Balance page
		cb.setOnAction(e->{
			pane.getChildren().removeAll(controls, back);
			double an = accounts.get(id).getBalance(type);
			statment = new Text("Balance: " + an);
			pane.add(statment, 0, 1);
			pane.add(back, 0, 2);
			acontrol = 2;
			
		
		});
		////Withdraw money
		wth.setOnAction(e-> {
			pane.getChildren().removeAll(controls,back);
			statment = new Text("How much would you like to withdrawl?");
			pane.add(statment, 0, 1);
			pane.add(answer, 0, 2);
			pane.add(enter, 0, 3);
			pane.add(back, 0, 4);
			acontrol = 1;
			atype = 1;
		});
		/////Deposit money
		de.setOnAction(e-> {
			pane.getChildren().removeAll(controls, back);
			statment = new Text("How much would you like to Deposit?");
			pane.add(statment, 0, 1);
			pane.add(answer, 0, 2);
			pane.add(enter, 0, 3);
			pane.add(back, 0, 4);
			acontrol = 1;
			atype = 2;
			
		});
		/// account info
		ainfo.setOnAction(e-> {
			pane.getChildren().removeAll(controls, back);
			info = new TextArea(accounts.get(id).accountinfo(type) + " \n" + accounts.get(id).getHistory(type));
			info.setWrapText(true);
			pane.add(info, 0, 1);
			pane.add(back, 0, 2);
			acontrol = 3;
			
		});
		
		enter.setOnAction(e -> {
			acontrol = 4;
			if(atype == 1) {
				System.out.println(answer.getText());
				accounts.get(id).withdraw(Double.parseDouble(answer.getText()), type);
				if(type == 1 ) {
					if((accounts.get(id).getBalance(type) - Double.parseDouble(answer.getText())) > accounts.get(id).getOverDraftLimit(type)) {
						actions = " Withdrawl: " + answer.getText();
						response = new Text("Withdrawl made");
					}else {
						actions = " Withdrawl: " + answer.getText() + "- Not enough funds";
						response = new Text("Not enough funds");
					}
				}else {
					if(Double.parseDouble(answer.getText()) > accounts.get(id).getBalance(type)) {
						actions = " Withdrawl: " + answer.getText() + "- Not enough funds";
						response = new Text("Not enough funds");
					}else {
						actions = " Withdrawl: " + answer.getText();
						response = new Text("Withdrawl made");
					}
				}
				accounts.get(id).addHistory(actions, type);
				pane.add(response, 0, 5);
			}else {
				System.out.println(answer.getText());
				accounts.get(id).deposit(Double.parseDouble(answer.getText()), type);
				actions = " Deposit: " + answer.getText();
				response = new Text("Amount Deposit");
				accounts.get(id).addHistory(actions, type);
				pane.add(response, 0, 5);
				answer.setText("");
				
				
			}
		});

		return pane;
	}
	
	/////Creating and Account pane to put into the scene
	public static GridPane createa(){
		GridPane createa = new GridPane();
		Text st = new Text("Had back to login");
		Text userpa = new Text("Please enter a Password");
		TextField userpassword = new TextField();
		Button enter = new Button("Enter");
		CheckBox ch = new CheckBox("Checkings");
		CheckBox sav = new CheckBox("Savings");
		createa.add(userpa, 0, 0);
		createa.add(userpassword, 0, 1);
		createa.add(enter, 0, 2);
		createa.setVgap(5);
		createa.setHgap(5);
		//// Event handler for the check boxes.
		EventHandler<ActionEvent> handler = e -> {
			if(ch.isSelected()) {
				hasc = true;
			}else {
				hasc = false;
			}
			if(sav.isSelected()) {
				hass = true;
			}else {
				hass = false;
			}
			
		};
		ch.setOnAction(handler);
		sav.setOnAction(handler);
		
		////Enter box response
		enter.setOnAction(e->{
			System.out.print(accounts.size());
			int as = accounts.size();
			accounts.add(new Consumer(as, userpassword.getText(), hasc, hass));
			createa.getChildren().removeAll(userpa, userpassword, enter);
			Text usersinfo = new Text("You id # is " + as + " and your password is " + userpassword.getText());
			createa.add(usersinfo, 0, 0);
			createa.add(st, 0, 1);
			
			try {
				saveData();
				System.out.println("Data saved");
			} catch (FileNotFoundException | ClassNotFoundException | EOFException | ParseException e1) {
				System.out.println("Data not saved");
				e1.printStackTrace();
			}
			
		});
		
		return createa;
	}
	//// to write all the info to the file after each logout.
	public static void saveData() throws FileNotFoundException, ClassNotFoundException, ParseException, EOFException{
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Userdata.dat"));){
			int i = 0;
			int k = accounts.size();
			do {
				System.out.println(accounts.get(i).getId());
				output.writeInt(accounts.get(i).getId());
				output.writeUTF(accounts.get(i).getpassword());
				output.writeBoolean(accounts.get(i).hasChecking());
				output.writeInt(accounts.get(i).getAccountnumber(1));
				output.writeDouble(accounts.get(i).getBalance(1));
				output.writeBoolean(accounts.get(i).hasSavings());
				output.writeInt(accounts.get(i).getAccountnumber(2));
				output.writeDouble(accounts.get(i).getBalance(2));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
				output.writeUTF(sdf.format(accounts.get(i).getDateCreated(1)));
				output.writeUTF(sdf.format(accounts.get(i).getDateCreated(2)));
				output.writeDouble(accounts.get(i).getAnnualInterestRate(1));
				output.writeDouble(accounts.get(i).getAnnualInterestRate(2));
				output.writeUTF(accounts.get(i).getHistory(1));
				output.writeUTF(accounts.get(i).getHistory(2));
						
				i++;
			} while(i != k);
				
				System.out.println(k);
	
			
				System.out.println("Accounts saved to file");
			
		}catch(IOException ex){
			System.out.println("File not accessible");
		}
	}
}
