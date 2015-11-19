package com.example.calculatorgrel;


public class Logic {

	private double current = 0.0;
	private double stored = 0.0;
	private char lastOperationRequested = 'C';


	// Calculator "business logic" implemented here 
	double calculate(char requestedOperation) {
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
