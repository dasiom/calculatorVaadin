package com.example.calculatorgrel;

import com.vaadin.Application;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * Calculator for Gravity Electric.
 */
public class CalculatorUI extends Application implements ClickListener {

	private static final long serialVersionUID = 1L;
	
	private double newValue;

	private final Label display = new Label("Test it!");
	
	private Logic logic = new Logic();

	@Override
	public void init() {
		
		final GridLayout layout = new GridLayout(5, 6);
		layout.setWidth(400, Sizeable.UNITS_PIXELS);
		layout.setHeight(200, Sizeable.UNITS_PIXELS);
		
		Window mainWindow = new Window("Calculator for Gravity Electric",
				layout);
		setMainWindow(mainWindow);

		layout.addComponent(display, 0, 0, 4, 0);

		String[] operations = new String[] { "7", "8", "9", "/", "sin", 
				"4", "5", "6", "*", "cos", "1", "2", "3", "-", "^x",
				"0", "=", "C", "+", "log" };

		for (String caption : operations) {

			Button button = new Button(caption);
			button.setSizeFull();
			button.addListener(this);

			layout.addComponent(button);
		}
	}

	public void buttonClick(ClickEvent event) {

		Button button = event.getButton();

		char requestedOperation = button.getCaption().charAt(0);

		newValue = logic.calculate(requestedOperation);

		display.setValue(newValue);

	}



}
