package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FPVController extends MainClass 
{
	//scene fields need to be declared so scenebuilder has access to them
	@FXML
	private TextField interestRate;
	@FXML
	private TextField numPayments;
	@FXML
	private TextField paymentAmount;
	@FXML
	private Label answer;
	@FXML
	private Button mainMenu;
	@FXML
	private Button reset;
	@FXML
	private Button calculate;
	@FXML
	private Button getInterestRate;

	private double cashFlow;
	private double intRate;
	private int numberOfPayments;
	private double futureValue;
	
	//return to main menu
	public void showCalcOverview() 
    {
		super.showCalcOverview();
    }
	
	//Ensures all fields are not empty, have non-negative values, and don't have non-numerical values
	//If all fields are valid, prints results to screen
	public void calculate()
	{
		boolean rateOkay = false;
		boolean numOkay = false;
		boolean paymentOkay = false;
		
		if(interestRate.getText().isEmpty() == false)
		{
			try {
				if(checkPos(interestRate) == true)
					{
					intRate = Double.parseDouble(interestRate.getText());
					intRate /= 100;
					rateOkay = true;
					}
			    } catch(NumberFormatException e) {
			    	interestRate.setText("");
			    	throwAlert();
			    }
		}	   
			else
		{
				throwAlert();
		}
		
		if(numPayments.getText().isEmpty() == false)
		{
			try{
				if(checkPos(numPayments) == true)
				{
					numberOfPayments = Integer.parseInt(numPayments.getText());
					numOkay = true;
				}
			} catch(NumberFormatException e) {
				numPayments.setText("");
				throwAlert();
			}
		}
			else
			{
				throwAlert();
			}
		
		if(paymentAmount.getText().isEmpty() == false)
		{
			try{
				if(checkPos(paymentAmount) == true)
				{
					cashFlow = Double.parseDouble(paymentAmount.getText());
					paymentOkay = true;
				}
			} catch(NumberFormatException e) {
				paymentAmount.setText("");
				throwAlert();
			}
		}
			else
			{
				throwAlert();
			}
	
		if(paymentOkay && numOkay && rateOkay)
		{
		setFutureValue();		
		answer.setText("$" + Double.toString(futureValue));
		}
	}
	
	public void getInterestRate()
	{
		getInterestRate(interestRate);
	}
	
	public void setFutureValue()
	{
		futureValue = (cashFlow * Math.pow(1 + intRate, numberOfPayments));
		futureValue = (double)Math.round(futureValue * 100d) / 100d;
	}

	public void reset()
	{
		intRate = 0;
		numberOfPayments = 0;
		cashFlow = 0;
		answer.setText("");
		interestRate.setText("");
		numPayments.setText("");
		paymentAmount.setText("");
	}
}
