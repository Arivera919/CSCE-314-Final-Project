package application;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class Column {

	private ArrayList<Chip> col;
	private Chip chip1;
	private Chip chip2;
	private Chip chip3;
	private Chip chip4;
	private Chip chip5;
	private Chip chip6;
	
	public Column(Button b1, Button b2, Button b3, Button b4, Button b5, Button b6) {
		this.col = new ArrayList<Chip>();
		this.chip1 = new Chip(b1);
		this.col.add(chip1);
		this.chip2 = new Chip(b2);
		this.col.add(chip2);
		this.chip3 = new Chip(b3);
		this.col.add(chip3);
		this.chip4 = new Chip(b4);
		this.col.add(chip4);
		this.chip5 = new Chip(b5);
		this.col.add(chip5);
		this.chip6 = new Chip(b6);
		this.col.add(chip6);
		
	}
	
	public Column(ArrayList<Chip> chips) {
		this.col = new ArrayList<Chip>();
		this.chip1 = new Chip(chips.get(0).getButton());
		this.col.add(chip1);
		this.chip2 = new Chip(chips.get(1).getButton());
		this.col.add(chip2);
		this.chip3 = new Chip(chips.get(2).getButton());
		this.col.add(chip3);
		this.chip4 = new Chip(chips.get(3).getButton());
		this.col.add(chip4);
		this.chip5 = new Chip(chips.get(4).getButton());
		this.col.add(chip5);
		this.chip6 = new Chip(chips.get(5).getButton());
		this.col.add(chip6);
	}
	
	public Column(Column clm) {
		this.col = new ArrayList<Chip>();
		this.chip1 = new Chip(clm.chip1);
		this.col.add(chip1);
		this.chip2 = new Chip(clm.chip2);
		this.col.add(chip2);
		this.chip3 = new Chip(clm.chip3);
		this.col.add(chip3);
		this.chip4 = new Chip(clm.chip4);
		this.col.add(chip4);
		this.chip5 = new Chip(clm.chip5);
		this.col.add(chip5);
		this.chip6 = new Chip(clm.chip6);
		this.col.add(chip6);
		
	}
	
	public ArrayList<Chip> getChips() {
		return this.col;
	}
	
	public void pressed(String color) {
		for(int i = (this.col.size() - 1); i >= 0; i--) {
			if(this.col.get(i).getOccupation() == false) {
				this.col.get(i).pressed(color);
				break;
			}
		}
	}
	
	public boolean isFull() {
		if(this.col.get(0).getOccupation() == false) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
