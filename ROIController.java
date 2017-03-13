package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ROIController extends MainClass
{
	//scene fields need to be declared so scenebuilder has access to them
	@FXML
	private TextField investment;
	@FXML 
	private TextField costs;
	@FXML
	private Button reset;
	@FXML 
	private Button mainMenu;
	@FXML
	private Label roiDollarPrint;
	@FXML
	private Label roiPercentPrint;
	@FXML
	private Button calculate;
	
	private double cost;
	private double initInvestment;
	private double roiDollars;
	private double roiPercent;
	
	//return to main menu
	public void showCalcOverview() 
    {		
		super.showCalcOverview();
    }
	
	//Ensures all fields are not empty, have non-negative values, and don't have non-numerical values
	//If all fields are valid, prints calculated values to screen
	public void onSubmit()
	{
		boolean costsOkay = false;
		boolean investmentOkay = false; 
		
		if(costs.getText().isEmpty() == false)
		{
			try{
				if(checkPos(costs) == true)
				{
					cost = Double.parseDouble(costs.getText());
					costsOkay = true;
				}
			} catch(NumberFormatException e) {
				costs.setText("");
				throwAlert();
			}
		}
			else
			{
				throwAlert();
			}
		
		if(investment.getText().isEmpty() == false)
		{
			try{
				if(checkPos(investment) == true)
				{
					initInvestment = Double.parseDouble(investment.getText());
					investmentOkay = true;
				}
			} catch(NumberFormatException e) {
				investment.setText("");
				throwAlert();
			}
		}
			else
			{
				throwAlert();
			}
		
		if(investmentOkay && costsOkay)
		{
			dollars();
			percent();
			roiDollarPrint.setText("$" + Double.toString(roiDollars));
			roiPercentPrint.setText(Double.toString(roiPercent) + "%");
		}
	}
	
	public void dollars()
	{
		double roiPrecent = (initInvestment - cost)/cost;
		this.roiDollars = roiPrecent*initInvestment;
		roiDollars = (double)Math.round(roiDollars * 100d) / 100d;
	}
	public void percent()
	{
		this.roiPercent = (initInvestment - cost)/cost;
		roiPercent = (double)Math.round(roiPercent * 100d) / 100d;
		roiPercent *= 100;
	}
	
	public void reset()
	{
		investment.setText("");
		costs.setText("");
		roiDollarPrint.setText("");
		roiPercentPrint.setText("");
		roiDollars = 0;
		roiPercent = 0;
		cost = 0;
		initInvestment = 0;		
	}
}
