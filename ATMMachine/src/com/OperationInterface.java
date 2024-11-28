package com;

public  interface OperationInterface { // interface function as abstract, use to group related method
	//define behaviors that a class should implement.
	void viewBalance(); 
	void withdrawAmount(int withdraw); 
	void depositAmount(int deposit); 
	void ViewMiniStatement(); 
}
