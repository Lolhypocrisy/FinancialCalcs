/****************************************************************************************************************
Financial Calculators 
Aaron Thibodeau and Clint Rettler
CS 316 Second semester project
****************************************************************************************************************/

package calculator;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class MainClass extends Application
{

    private Stage primaryStage;
    protected static BorderPane rootLayout;

    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CalcApp");

        initRootLayout();

        showCalcOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() 
    {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showCalcOverview() 
    {
        try {
            // Load main menu overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("CalcOverview.fxml"));
            AnchorPane calcOverview = (AnchorPane) loader.load();

            // Set main menu into the center of root layout.
            rootLayout.setCenter(calcOverview);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() 
    {
        return primaryStage;
    }


    
    //If value is negative, show error message
    public boolean checkPos(TextField expenses)
    {
    	if(Double.parseDouble(expenses.getText()) < 0)
		{
			expenses.setText("");
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please enter a positive number");
	
			alert.showAndWait();
			return false;
		}
    	else {return true;}
    }
    
    //If value of text field is blank or non-numerical, show error message
    public void throwAlert()
    {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Please enter a number");

		alert.showAndWait();
    }
    
    //Gets real-time interest rate from internet
	public void getInterestRate(TextField text)
	{
		String value;
		try{
			String url = "http://www.bankrate.com";
			Document doc = Jsoup.connect(url).get();
			Element element = doc.select("td.rate > a").first();
			   
			value = element.text().substring(0, 4);
			   
			text.setText(value);
			
		}catch (Exception e){
				
				value = "3.92";
				text.setText(value);
		}
		
		
	}
}
