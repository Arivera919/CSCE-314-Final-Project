package application;

import java.util.ArrayList;
import java.util.Random;

public class Opponent {

	private String type;
	
	public Opponent(String choice) {
		this.type = choice;
	}
	
	public Opponent(Opponent o) {
		this.type = o.type;
	}
	
	public void setType(String choice) {
		this.type = choice;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getRandom() {
		Random num = new Random();
		
		return (num.nextInt(7));
	}
	
	public int backupPlan(ArrayList<Column> grid) {
		for(int row = 0; row < grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < grid.size(); col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#fffd01") {
					if((col - 1) < 0) {
						if(row == 5) {
							if(grid.get(col + 1).getChips().get(row).getOccupation() == false) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row).getOccupation() == true)) {
								return (col + 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						} else if(row == 0) {
							if((grid.get(col + 1).getChips().get(row).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col + 1);
							}
						} else if(row == 4) {
							if(grid.get(col + 1).getChips().get(row + 1).getOccupation() == false) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row).getOccupation() == true)) {
								return (col + 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						} else {
							if((grid.get(col + 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row).getOccupation() == true)) {
								return (col + 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						}
					} else if((row - 1) < 0) {
						if(col == 0) {
							if((grid.get(col + 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 1);
							}
						} else if (col == 6) {
							if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							}
						} else {
							if((grid.get(col + 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 1);
							} else if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else if((row + 1) > 5) {
						if(col == 0) {
							if(grid.get(col + 1).getChips().get(row).getOccupation() == false) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row).getOccupation() == true)) {
								return (col + 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						} else if(col == 6) {
							if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						} else {
							if(grid.get(col + 1).getChips().get(row).getOccupation() == false) {
								return (col + 1);
							} else if((grid.get(col + 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row).getOccupation() == true)) {
								return (col + 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}else if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else if((col + 1) > 6) {
						if(row == 5) {
							if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						} else if(row == 0) {
							if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							}
						} else if(row == 4) {
							if(grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						} else {
							if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
								return col;
							}
						}
					} else {
						if((grid.get(col + 1).getChips().get(row).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 1).getOccupation() == true)) {
							return (col + 1);
						} else if((grid.get(col + 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row).getOccupation() == true)) {
							return (col + 1);
						} else if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
							return col;
						}else if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col + 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col + 1).getChips().get(row + 2).getOccupation() == true)) {
							return (col + 1);
						}
					}
				}
			}
		}
		return -1;
	}
	
	public int playerWinningMoves(ArrayList<Column> grid){
		//checks for horizontal lines
		for(int row = 0; row < grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < grid.size() - 2; col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						grid.get(col + 1).getChips().get(row).getColor() == "#ff0000" &&
						grid.get(col + 2).getChips().get(row).getColor() == "#ff0000"
						) {
					if((col - 1) < 0) {
						if((row + 1) > 5) {
							if(grid.get(col + 3).getChips().get(row).getOccupation() == false) {
								return (col + 3);
							}
						} else {
							if((grid.get(col + 3).getChips().get(row).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 3);
							}
						} 
					} else if((col + 3) > 6){
						if((row + 1) > 5) {
							if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							}
						} else {
							if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							}
						}
						 
					} else {
						if((row + 1) > 5) {
							if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							} else if(grid.get(col + 3).getChips().get(row).getOccupation() == false) {
								return (col + 3);
							}
						} else {
							if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col + 3).getChips().get(row).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 3);
							} 
						}
						
					}
				}
			}
		}
		
		//checks for vertical lines
		for(int row = 0; row < grid.get(0).getChips().size() - 2; row++) {
			for(int col = 0; col < grid.size(); col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						grid.get(col).getChips().get(row + 1).getColor() == "#ff0000" &&
						grid.get(col).getChips().get(row + 2).getColor() == "#ff0000"
						) {
					if((row - 1) >= 0) {
						if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
							return col;
						}
					} 
				}
			}
		}
		
		//checks for forward slash (/)
		for(int row = 2; row < grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < grid.size() - 2; col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						grid.get(col + 1).getChips().get(row - 1).getColor() == "#ff0000" &&
						grid.get(col + 2).getChips().get(row - 2).getColor() == "#ff0000"
						) {
					if((row - 3) < 0) {
						if((col - 1) >= 0) {
							if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else if((row + 1) > 5) {
						if((col + 3) <= 6) {
							if((grid.get(col + 3).getChips().get(row - 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row - 2).getOccupation() == true)) {
								return (col + 3);
							}
							
						}
					} else if((col - 1) < 0) {
						if((row - 3) >= 0) {
							if((grid.get(col + 3).getChips().get(row - 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row - 2).getOccupation() == true)) {
								return (col + 3);
							}
						}
					} else if((col + 3) > 6) {
						if(row == 3) {
							if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							}
						} else if(row == 4) {
							if(grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) {
								return (col - 1);
							}
						}
					} else {
						if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col + 3).getChips().get(row - 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row - 2).getOccupation() == true)) {
							return (col + 3);
						}
					}
				}
			}
		}
		
		//checks for back slash (\)
		for(int row = 0; row < grid.get(0).getChips().size() - 2; row++) {
			for(int col = 0; col < grid.size() - 2; col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#ff0000" &&
						grid.get(col + 1).getChips().get(row + 1).getColor() == "#ff0000" &&
						grid.get(col + 2).getChips().get(row + 2).getColor() == "#ff0000"
						) {
					if((row - 1) < 0) {
						if((col + 3) <= 6) {
							if((grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 4).getOccupation() == true)) {
								return (col + 3);
							}
						}
					} else if((col - 1) < 0) {
						if(row <= 1) {
							if((grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 4).getOccupation() == true)) {
								return (col + 3);
							}
						} else if (row == 2) {
							if(grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) {
								return (col + 3);
							}
						}
					} else if((col + 3) > 6) {
						if((row - 1) >= 0) {
							if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else if((row + 3) > 5) {
						if((col - 1) >= 0) {
							if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else {
						if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 4).getOccupation() == true)) {
							return (col + 3);
						}
					}
				}
			}
		}
		
		//if no winning moves found
		return -1;
	}
	
	public int opponentWinningMoves(ArrayList<Column> grid){
		//checks for horizontal lines
		for(int row = 0; row < grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < grid.size() - 2; col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						grid.get(col + 1).getChips().get(row).getColor() == "#fffd01" &&
						grid.get(col + 2).getChips().get(row).getColor() == "#fffd01"
						) {
					if((col - 1) < 0) {
						if((row + 1) > 5) {
							if(grid.get(col + 3).getChips().get(row).getOccupation() == false) {
								return (col + 3);
							}
						} else {
							if((grid.get(col + 3).getChips().get(row).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 3);
							}
						} 
					} else if((col + 3) > 6){
						if((row + 1) > 5) {
							if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							}
						} else {
							if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							}
						}
						 
					} else {
						if((row + 1) > 5) {
							if(grid.get(col - 1).getChips().get(row).getOccupation() == false) {
								return (col - 1);
							} else if(grid.get(col + 3).getChips().get(row).getOccupation() == false) {
								return (col + 3);
							}
						} else {
							if((grid.get(col - 1).getChips().get(row).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 1).getOccupation() == true)) {
								return (col - 1);
							} else if((grid.get(col + 3).getChips().get(row).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 1).getOccupation() == true)) {
								return (col + 3);
							} 
						}
						
					}
				}
			}
		}
		
		//checks for vertical lines
		for(int row = 0; row < grid.get(0).getChips().size() - 2; row++) {
			for(int col = 0; col < grid.size(); col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						grid.get(col).getChips().get(row + 1).getColor() == "#fffd01" &&
						grid.get(col).getChips().get(row + 2).getColor() == "#fffd01"
						) {
					if((row - 1) >= 0) {
						if(grid.get(col).getChips().get(row - 1).getOccupation() == false) {
							return col;
						}
					} 
				}
			}
		}
		
		//checks for forward slash (/)
		for(int row = 2; row < grid.get(0).getChips().size(); row++) {
			for(int col = 0; col < grid.size() - 2; col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						grid.get(col + 1).getChips().get(row - 1).getColor() == "#fffd01" &&
						grid.get(col + 2).getChips().get(row - 2).getColor() == "#fffd01"
						) {
					if((row - 3) < 0) {
						if((col - 1) >= 0) {
							if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else if((row + 1) > 5) {
						if((col + 3) <= 6) {
							if((grid.get(col + 3).getChips().get(row - 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row - 2).getOccupation() == true)) {
								return (col + 3);
							}
							
						}
					} else if((col - 1) < 0) {
						if((row - 3) >= 0) {
							if((grid.get(col + 3).getChips().get(row - 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row - 2).getOccupation() == true)) {
								return (col + 3);
							}
						}
					} else if((col + 3) > 6) {
						if(row == 3) {
							if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
								return (col - 1);
							}
						} else if(row == 4) {
							if(grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) {
								return (col - 1);
							}
						}
					} else {
						if((grid.get(col - 1).getChips().get(row + 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row + 2).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col + 3).getChips().get(row - 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row - 2).getOccupation() == true)) {
							return (col + 3);
						}
					}
				}
			}
		}
		
		//checks for back slash (\)
		for(int row = 0; row < grid.get(0).getChips().size() - 2; row++) {
			for(int col = 0; col < grid.size() - 2; col++) {
				if(grid.get(col).getChips().get(row).getColor() == "#fffd01" &&
						grid.get(col + 1).getChips().get(row + 1).getColor() == "#fffd01" &&
						grid.get(col + 2).getChips().get(row + 2).getColor() == "#fffd01"
						) {
					if((row - 1) < 0) {
						if((col + 3) <= 6) {
							if((grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 4).getOccupation() == true)) {
								return (col + 3);
							}
						}
					} else if((col - 1) < 0) {
						if(row <= 1) {
							if((grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 4).getOccupation() == true)) {
								return (col + 3);
							}
						} else if (row == 2) {
							if(grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) {
								return (col + 3);
							}
						}
					} else if((col + 3) > 6) {
						if((row - 1) >= 0) {
							if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else if((row + 3) > 5) {
						if((col - 1) >= 0) {
							if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
								return (col - 1);
							}
						}
					} else {
						if((grid.get(col - 1).getChips().get(row - 1).getOccupation() == false) && (grid.get(col - 1).getChips().get(row).getOccupation() == true)) {
							return (col - 1);
						} else if((grid.get(col + 3).getChips().get(row + 3).getOccupation() == false) && (grid.get(col + 3).getChips().get(row + 4).getOccupation() == true)) {
							return (col + 3);
						}
					}
				}
			}
		}
		
		//if no winning moves found
		return -1;
	}
}


