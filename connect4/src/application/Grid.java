package application;

import java.util.ArrayList;

public class Grid {

	private ArrayList<Column> grid;
	private Column col1;
	private Column col2;
	private Column col3;
	private Column col4;
	private Column col5;
	private Column col6;
	private Column col7;
	private Opponent cpu;
	
	public Grid(Column c1, Column c2, Column c3, Column c4, Column c5, Column c6, Column c7, String cpu) {
		this.grid = new ArrayList<Column>();
		this.col1 = new Column(c1.getChips());
		this.grid.add(c1);
		this.col2 = new Column(c2.getChips());
		this.grid.add(c2);
		this.col3 = new Column(c3.getChips());
		this.grid.add(c3);
		this.col4 = new Column(c4.getChips());
		this.grid.add(c4);
		this.col5 = new Column(c5.getChips());
		this.grid.add(c5);
		this.col6 = new Column(c6.getChips());
		this.grid.add(c6);
		this.col7 = new Column(c7.getChips());
		this.grid.add(c7);
		this.cpu = new Opponent(cpu);
	}
	
	public Grid(Grid grd) {
		this.grid = new ArrayList<Column>();
		this.col1 = new Column(grd.col1);
		this.grid.add(col1);
		this.col2 = new Column(grd.col2);
		this.grid.add(col2);
		this.col3 = new Column(grd.col3);
		this.grid.add(col3);
		this.col4 = new Column(grd.col4);
		this.grid.add(col4);
		this.col5 = new Column(grd.col5);
		this.grid.add(col5);
		this.col6 = new Column(grd.col6);
		this.grid.add(col6);
		this.col7 = new Column(grd.col7);
		this.grid.add(col7);
		this.cpu = new Opponent(grd.cpu);
	}
	
	public ArrayList<Column> getCols() {
		return this.grid;
	}
	
	public Opponent getCPU() {
		return this.cpu;
	}
	
	public boolean isFull() {
		for(int i = 0; i < this.grid.size(); i++) {
			if(this.grid.get(i).isFull() == false) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean playerWins() {
		//checks for horizontal lines
		for(int row = 0; row < this.grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < this.grid.size() - 3; col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						this.grid.get(col + 1).getChips().get(row).getColor() == "#ff0000" &&
						this.grid.get(col + 2).getChips().get(row).getColor() == "#ff0000" &&
						this.grid.get(col + 3).getChips().get(row).getColor() == "#ff0000"
						) {
					return true;
				}
			}
		}
		
		//checks for vertical lines
		for(int row = 0; row < this.grid.get(0).getChips().size() - 3; row++) {
			for(int col = 0; col < this.grid.size(); col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						this.grid.get(col).getChips().get(row + 1).getColor() == "#ff0000" &&
						this.grid.get(col).getChips().get(row + 2).getColor() == "#ff0000" &&
						this.grid.get(col).getChips().get(row + 3).getColor() == "#ff0000"
						) {
					return true;
				}
			}
		}
		
		//checks for forward slash (/)
		for(int row = 3; row < this.grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < this.grid.size() - 3; col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						this.grid.get(col + 1).getChips().get(row - 1).getColor() == "#ff0000" &&
						this.grid.get(col + 2).getChips().get(row - 2).getColor() == "#ff0000" &&
						this.grid.get(col + 3).getChips().get(row - 3).getColor() == "#ff0000"
						) {
					return true;
				}
			}
		}
		
		//checks for back slash (\)
		for(int row = 0; row < this.grid.get(0).getChips().size() - 3; row++) {
			for(int col = 0; col < this.grid.size() - 3; col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						this.grid.get(col + 1).getChips().get(row + 1).getColor() == "#ff0000" &&
						this.grid.get(col + 2).getChips().get(row + 2).getColor() == "#ff0000" &&
						this.grid.get(col + 3).getChips().get(row + 3).getColor() == "#ff0000"
						) {
					return true;
				}
			}
		}
		
		//no winning moves
		return false;
	}
	
	public boolean opponentWins() {
		for(int row = 0; row < this.grid.get(0).getChips().size() - 3; row++) {
			for(int col = 0; col < this.grid.size(); col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						this.grid.get(col + 1).getChips().get(row).getColor() == "#fffd01" &&
						this.grid.get(col + 2).getChips().get(row).getColor() == "#fffd01" &&
						this.grid.get(col + 3).getChips().get(row).getColor() == "#fffd01"
						) {
					return true;
				}
			}
		}
		
		for(int row = 0; row < this.grid.get(0).getChips().size() - 3; row++) {
			for(int col = 0; col < this.grid.size(); col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						this.grid.get(col).getChips().get(row + 1).getColor() == "#fffd01" &&
						this.grid.get(col).getChips().get(row + 2).getColor() == "#fffd01" &&
						this.grid.get(col).getChips().get(row + 3).getColor() == "#fffd01"
						) {
					return true;
				}
			}
		}
		
		for(int row = 3; row < this.grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < this.grid.size() - 3; col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						this.grid.get(col + 1).getChips().get(row - 1).getColor() == "#fffd01" &&
						this.grid.get(col + 2).getChips().get(row - 2).getColor() == "#fffd01" &&
						this.grid.get(col + 3).getChips().get(row - 3).getColor() == "#fffd01"
						) {
					return true;
				}
			}
		}
		
		for(int row = 0; row < this.grid.get(0).getChips().size() - 3; row++) {
			for(int col = 0; col < this.grid.size() - 3; col++) {
				if(this.grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						this.grid.get(col + 1).getChips().get(row + 1).getColor() == "#fffd01" &&
						this.grid.get(col + 2).getChips().get(row + 2).getColor() == "#fffd01" &&
						this.grid.get(col + 3).getChips().get(row + 3).getColor() == "#fffd01"
						) {
					return true;
				}
			}
		}
		return false;
	}
}
