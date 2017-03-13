package calculator;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IncomeController extends MainClass
{
	private double sumRev = 0;
	private double sumExp = 0;
    private double totalIncome;
    
	private ArrayList<Double> revenue = new ArrayList<Double>();
	private ArrayList<Double> expense = new ArrayList<Double>();
    
	//scene fields need to be declared so scenebuilder has access to them
	@FXML
	private TextField incomes;
	@FXML 
	private TextField expenses;
	@FXML
	private Button incomeSubmit;
	@FXML
	private Button incomeDone;
	@FXML
	private Button expSubmit;
	@FXML
	private Button expDone;
	@FXML
	private Button reset;
	@FXML 
	private Button mainMenu;
	@FXML
	private Label revPrint;
	@FXML
	private Label expPrint;
	@FXML
	private Label incomePrint;
	@FXML
	private Button calculate;
	@FXML
	private Label enterExpenses;
    
	//return to main menu
	public void showCalcOverview() 
    {
		super.showCalcOverview();
    }
	
	//Prints all calculated values to screen
	public void calculate()
	{
		revPrint.setText("$" + Double.toString(sumRev));
		expPrint.setText("$" + Double.toString(sumExp));
		totalIncome = sumRev - sumExp;
		incomePrint.setText("$" + Double.toString(totalIncome));
	}
	
	//Ensures all fields are not empty, have non-negative values, and don't have non-numerical values
	//Adds incomes to income array
	public void addRev()
	{
		if(incomes.getText().isEmpty() == false)
		{
			try {
				if(checkPos(incomes) == true)
					{
			       revenue.add(Double.parseDouble(incomes.getText()));
			       incomes.setText("");
					}
			    } catch(NumberFormatException e) {
			    	incomes.setText("");
			    	throwAlert();
			    }
		}	   
			else
		{
				throwAlert();
		}
	}

	//Ensures all fields are not empty, have non-negative values, and don't have non-numerical values
	//Adds expenses to expenses array
	public void addExp()
	{
		if(expenses.getText().isEmpty() == false)
		{
			try {
				if(checkPos(expenses) == true)
					{
			       expense.add(Double.parseDouble(expenses.getText()));
			       expenses.setText("");
					}
			    } catch(NumberFormatException e) {
			    	expenses.setText("");
			    	throwAlert();
			    }
		}	   
			else
		{
				throwAlert();
		}
	}

	//Calculates sum of incomes
    public void setSumRev()
    {
    	if(incomes.getText().isEmpty() == false)
    		{
    			try {
    				if(checkPos(incomes) == true)
    					{
    			       revenue.add(Double.parseDouble(incomes.getText()));
    			       incomes.setText("");
    			       
    			       for(double x : revenue)
    	    		    {
    	    		    	sumRev += x;
    	    		    }
    	    		    
    	    		    expenses.setVisible(true);
    	    		    expSubmit.setVisible(true);
    	    		    expDone.setVisible(true);
    	    		    enterExpenses.setVisible(true);	
    					}
    			    } catch(NumberFormatException e) {
    			    	incomes.setText("");
    			    	throwAlert();
    			    }   
    		}
    		else
    		{
    		    for(double x : revenue)
    		    {
    		    	sumRev += x;
    		    }
    		    
    		    expenses.setVisible(true);
    		    expSubmit.setVisible(true);
    		    expDone.setVisible(true);
    		    enterExpenses.setVisible(true);	
    		}
    }
    
    //Calculates some of expenses
    public void setSumExp()
    {
    	if(expenses.getText().isEmpty() == false)
		{
			try {
				if(checkPos(expenses) == true)
					{
			       expense.add(Double.parseDouble(expenses.getText()));
			       expenses.setText("");
			       
				    for(double x : expense)
				    {
				    	sumExp += x;
				    }
				    calculate();
			
			    } } catch(NumberFormatException e) {
			    	incomes.setText("");
			    	throwAlert();
			    }   
		}
    	else{
	    for(double x : expense)
	    {
	    	sumExp += x;
	    }
	    calculate();
    	}
    }
    
    public void reset()
    {
    	revPrint.setText("");
    	expPrint.setText("");
    	incomePrint.setText("");
    	totalIncome = 0;
    	sumRev = 0;
    	sumExp = 0;
    	revenue.clear();
    	expense.clear();
	    expenses.setVisible(false);
	    expSubmit.setVisible(false);
	    expDone.setVisible(false);
	    enterExpenses.setVisible(false);
    }
}
