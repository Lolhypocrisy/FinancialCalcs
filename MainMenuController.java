package calculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import calculator.MainClass;

public class MainMenuController extends MainClass
{
//scene fields need to be declared so scenebuilder has access to them
@FXML
private Button FPV;
@FXML
private Button Mortgage;
@FXML
private Button ROI;
@FXML
private Button IncomeStatement;

	public void showROI() 
	{
   	    {
   	        try {
   	            // Load return on investment overview.
   	            FXMLLoader loader = new FXMLLoader();
   	            loader.setLocation(MainClass.class.getResource("ROI.fxml"));
   	            AnchorPane ROI = (AnchorPane) loader.load();

   	            // Set ROI overview into the center of root layout.
   	            MainClass.rootLayout.setCenter(ROI);
   	        } catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	    }
   	}
	public void showMortgage() 
	{
   	    {
   	        try {
   	            // Load mortgage calculator overview.
   	            FXMLLoader loader = new FXMLLoader();
   	            loader.setLocation(MainClass.class.getResource("Mortgage.fxml"));
   	            AnchorPane Mortgage = (AnchorPane) loader.load();

   	            // Set mortgage overview into the center of root layout.
   	            MainClass.rootLayout.setCenter(Mortgage);
   	        } catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	    }
   	}
	public void showFPV() 
	{
   	    {
   	        try {
   	            // Load future present value overview.
   	            FXMLLoader loader = new FXMLLoader();
   	            loader.setLocation(MainClass.class.getResource("FPV.fxml"));
   	            AnchorPane FPV = (AnchorPane) loader.load();

   	            // Set FPV overview into the center of root layout.
   	            MainClass.rootLayout.setCenter(FPV);
   	        } catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	    }
   	}
	public void showIncome() 
	{
   	    {
   	        try {
   	            // Load Income statement overview.
   	            FXMLLoader loader = new FXMLLoader();
   	            loader.setLocation(MainClass.class.getResource("Income.fxml"));
   	            AnchorPane Income = (AnchorPane) loader.load();

   	            // Set income overview into the center of root layout.
   	            MainClass.rootLayout.setCenter(Income);
   	        } catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	    }
   	}
}
