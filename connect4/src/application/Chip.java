package application;

import javafx.scene.control.Button;

public class Chip extends Button {
	
	private Button button;
	private boolean isOccupied;
	private String buttonColor;
	
	public Chip(Button b) {
		this.button = b;
		this.button.setStyle("-fx-background-color: #ffffff");
		this.isOccupied = false;
		this.buttonColor = "#ffffff";
	}
	
	
	public Chip(Chip c) {
		this.button = c.button;
		this.buttonColor = c.buttonColor;
		//button.setStyle("-fx-background-color: " + this.buttonColor);
		this.isOccupied = c.isOccupied;
	}
	public void copyChip(Chip c) {
		this.button = c.button;
		this.isOccupied = c.isOccupied;
		this.buttonColor = c.buttonColor;
		this.button.setStyle(c.buttonColor);
	}
	
	public boolean getOccupation() {
		return this.isOccupied;
	}
	
	public void setOccupation(boolean b) {
		this.isOccupied = b;
	}
	
	public Button getButton() {
		return this.button;
	}
	
	public String getColor() {
		return this.buttonColor;
	}
	
	public void setColor(String color) {
		this.buttonColor = color;
		this.button.setStyle("-fx-background-color: " + color);
	}
	
	public void pressed(String color) {
		if(this.isOccupied == false) {
			this.button.setStyle("-fx-background-color: " + color);
			this.buttonColor = color;
			this.isOccupied = true;
		} else {
			System.out.println("this space is already occupied");
		}
	}
}
