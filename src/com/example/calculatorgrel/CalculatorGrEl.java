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
public class CalculatorGrEl extends Application implements ClickListener {

	private static final long serialVersionUID = 1L;

	private double current = 0.0;
	private double stored = 0.0;
	private char lastOperationRequested = 'C';
	private double newValue;

	private final Label display = new Label("Test it!");

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

		newValue = calculate(requestedOperation);

		display.setValue(newValue);

	}

	// Calculator "business logic" implemented here 
	private double calculate(char requestedOperation) {
		if ('0' <= requestedOperation && requestedOperation <= '9') {
			current = current * 10
					+ Double.parseDouble("" + requestedOperation);
			return current;
		}
		switch (lastOperationRequested) {
		case '+':
			stored += current;
			break;
		case '-':
			stored -= current;
			break;
		case '/':
			stored /= current;
			break;
		case '*':
			stored *= current;
			break;
		case 'l':
			stored = Math.log(current);
			break;
		case 's':
			stored = Math.sin(current);
			break;
		case 'c':
			stored = Math.cos(current);
			break;
		case '^':
			stored = Math.pow(stored,current);
			break;
		case 'C':
			stored = current;
			break;
		}
		lastOperationRequested = requestedOperation;
		current = 0.0;
		if (requestedOperation == 'C') {
			stored = 0.0;
		}
		return stored;

	}


}
