package calculator;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MortgageController extends MainClass
{
	//scene fields need to be declared so scenebuilder has access to them
	@FXML
	private TextField mortgageAmount;
	@FXML
	private TextField interestRate;
	@FXML
	private TextField numYears;
	@FXML
	private Button mainMenu;
	@FXML
	private Button reset;
	@FXML
	private Label monthlyPayment;
	@FXML
	private Label totalPaid;
	@FXML
	private Button calculate;
	
	private double intRate;
	private double mortAmount;
	private double monthPayment;
	private double loanTotal;
	private int numberYears;
	private int numPayments;
	
	//return to main menu
	public void showCalcOverview() 
    {
		super.showCalcOverview();
    }
	
	//Ensures all fields are not empty, have non-negative values, and don't have non-numerical values
	//Performs calculations and prints results to screen
	public void calculate()
	{
		boolean mortOkay = false;
		boolean interestOkay = false;
		boolean yearsOkay = false;
		
		if(mortgageAmount.getText().isEmpty() == false)
		{
			try{
				if(checkPos(mortgageAmount) == true)
				{
					mortAmount = Double.parseDouble(mortgageAmount.getText());
					mortOkay = true;
				}
			} catch(NumberFormatException e) {
				mortgageAmount.setText("");
				throwAlert();
			}
		}
			else
			{
				throwAlert();
			}
		
		if(interestRate.getText().isEmpty() == false)
		{
			try{
				if(checkPos(interestRate) == true)
				{
					intRate = Double.parseDouble(interestRate.getText());
					interestOkay = true;
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
		
		if(numYears.getText().isEmpty() == false)
		{
			try{
				if(checkPos(numYears) == true)
				{
					numberYears = Integer.parseInt(numYears.getText());
					yearsOkay = true;
				}
			} catch(NumberFormatException e) {
				numYears.setText("");
				throwAlert();
			}
		}
			else
			{
				throwAlert();
			}
		if(yearsOkay && interestOkay && mortOkay)
		{	
			intRate = (intRate/100)/12;
			numPayments = numberYears * 12;
			setMonthlyPayment();
			setLoanTotal();
			
			totalPaid.setText("$" + Double.toString(loanTotal));
			monthlyPayment.setText("$" + Double.toString(monthPayment));
		}
	}
	
	//Calculates monthly payments
	//amount of mortgage*(interest rate *(1 + interest rate)^number of payments)/(1 + interest rate)^number of payments)-1))
	public void setMonthlyPayment()
	{
		monthPayment = mortAmount * ((intRate * Math.pow(1 + intRate, numPayments))/(Math.pow(1+intRate, numPayments) - 1));
		monthPayment = (double)Math.round(monthPayment * 100d)/ 100d;
	}
	
	//Calculates total of entire mortgage
	//(interest rate * mortgage amount)/((1 + interest rate)^number of payments*-1) * number of payments))
	public void setLoanTotal()
	{
		loanTotal = ((intRate * mortAmount)/(1-Math.pow(1+intRate,numPayments*-1)) * numPayments);
		loanTotal = (double)Math.round(loanTotal * 100d) / 100d;
	}
	
	public void getInterestRate()
	{
		getInterestRate(interestRate);
	}

	public void reset()
	{
		mortAmount = 0;
		intRate = 0;
		numberYears = 0;
		monthPayment = 0;
		loanTotal = 0;
		totalPaid.setText("");
		monthlyPayment.setText("");
		mortgageAmount.setText("");
		interestRate.setText("");
		numYears.setText("");
	}
}
