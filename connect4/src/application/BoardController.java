package application;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BoardController {
	
	//TODO:
	//make the README file
	//record demo
	
	
	@FXML
	private RadioButton randomButton;
	@FXML
	private RadioButton thoughtfulButton;
	
	private ToggleGroup challengers = new ToggleGroup();
	
	@FXML
	private Button saveButton;
	
	@FXML
	private Button loadButton;
	
	@FXML
	private Button resetButton;
	
	@FXML
	private Button logButton;
	
	@FXML
	private Button r1c1;
	@FXML
	private Button r2c1;
	@FXML
	private Button r3c1;
	@FXML
	private Button r4c1;
	@FXML
	private Button r5c1;
	@FXML
	private Button r6c1;
	
	private Column c1;
	
	@FXML
	private Button r1c2;
	@FXML
	private Button r2c2;
	@FXML
	private Button r3c2;
	@FXML
	private Button r4c2;
	@FXML
	private Button r5c2;
	@FXML
	private Button r6c2;
	
	private Column c2;
	
	@FXML
	private Button r1c3;
	@FXML
	private Button r2c3;
	@FXML
	private Button r3c3;
	@FXML
	private Button r4c3;
	@FXML
	private Button r5c3;
	@FXML
	private Button r6c3;
	
	private Column c3;
	
	@FXML
	private Button r1c4;
	@FXML
	private Button r2c4;
	@FXML
	private Button r3c4;
	@FXML
	private Button r4c4;
	@FXML
	private Button r5c4;
	@FXML
	private Button r6c4;
	
	private Column c4;
	
	@FXML
	private Button r1c5;
	@FXML
	private Button r2c5;
	@FXML
	private Button r3c5;
	@FXML
	private Button r4c5;
	@FXML
	private Button r5c5;
	@FXML
	private Button r6c5;
	
	private Column c5;
	
	@FXML
	private Button r1c6;
	@FXML
	private Button r2c6;
	@FXML
	private Button r3c6;
	@FXML
	private Button r4c6;
	@FXML
	private Button r5c6;
	@FXML
	private Button r6c6;
	
	private Column c6;
	
	@FXML
	private Button r1c7;
	@FXML
	private Button r2c7;
	@FXML
	private Button r3c7;
	@FXML
	private Button r4c7;
	@FXML
	private Button r5c7;
	@FXML
	private Button r6c7;
	
	private Column c7;
	
	private Grid board;
	
	private boolean playerturn;
	
	int turnCounter;
	
	int savedTurn;
	
	
	
	@FXML
	private Text announcement;
	
	@FXML
	private BorderPane background;
	
	private String[][] savedColors;
	
	
	@FXML
	public void log(ActionEvent e) {
		File file = new File("./src/log.txt");
		
		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().open(file);
			}
			catch (IOException ioe) {
				System.out.println("Cannot perform the given operation to the " + file + " file");
			}
		} else {
			announcement.setText("Can't open log");
		}
		
		
	}
	
	private void logOut(int turn, boolean append) {	
		FileWriter out = null;
		int turnNum = turn;
		String[] line = new String[7];
		
		
		try {
			
			out = new FileWriter("./src/log.txt", append);
			BufferedWriter bw = new BufferedWriter(out);
			PrintWriter outfile = new PrintWriter(bw);
			
			outfile.println(turnNum);
			
			for(int row = 0; row < board.getCols().get(0).getChips().size(); row++) {
				for(int col = 0; col < board.getCols().size(); col++) {
					if(board.getCols().get(col).getChips().get(row).getColor() == "#ffffff") {
						line[col] = "-";
					} else if(board.getCols().get(col).getChips().get(row).getColor() == "#ff0000") {
						line[col] = "x";
					} else if(board.getCols().get(col).getChips().get(row).getColor() == "#fffd01") {
						line[col] = "o";
					}
				}
				outfile.println(line[0] + " " + line[1] + " " + line[2] + " " + line[3] + " " + line[4] + " " + line[5] + " " + line[6]);
			}
			
			outfile.close();
			
		} catch(IOException e) {
			System.out.println("Was not able to write to file");
		}
		
	}
	
	private void logIn(int turn) {
		String fileName = "./src/log.txt";
		Scanner infile = null;
		
				
		try {
			infile = new Scanner(new FileReader(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		
		while(infile.hasNextLine()) {
			int turnNum = Integer.parseInt(infile.nextLine());
			if(turnNum == turn) {
				for(int row = 0; row < board.getCols().get(0).getChips().size(); row++) {
					String line = infile.nextLine();
					StringTokenizer tokenizer = new StringTokenizer(line);
					for(int col = 0; col < board.getCols().size(); col++) {
						String chip = tokenizer.nextToken();
						if(chip.equals("-")) {
							savedColors[row][col] = "#ffffff";
						} else if(chip.equals("x")) {
							savedColors[row][col] = "#ff0000";
						} else if(chip.equals("o")) {
							savedColors[row][col] = "#fffd01";
						}
					}
				}
			}else {
				for(int i = 0; i < 6; i++) {
					System.out.println(infile.nextLine());
				}
			}
		}
		infile.close();
	}
	
	@FXML
	private void initialize() {
		background.setStyle("-fx-background-color: #cdcdcd");
		randomButton.setToggleGroup(challengers);
		randomButton.setSelected(true);
		thoughtfulButton.setToggleGroup(challengers);
		c1 = new Column(r1c1, r2c1, r3c1, r4c1, r5c1, r6c1);
		c2 = new Column(r1c2, r2c2, r3c2, r4c2, r5c2, r6c2);
		c3 = new Column(r1c3, r2c3, r3c3, r4c3, r5c3, r6c3);
		c4 = new Column(r1c4, r2c4, r3c4, r4c4, r5c4, r6c4);
		c5 = new Column(r1c5, r2c5, r3c5, r4c5, r5c5, r6c5);
		c6 = new Column(r1c6, r2c6, r3c6, r4c6, r5c6, r6c6);
		c7 = new Column(r1c7, r2c7, r3c7, r4c7, r5c7, r6c7);
		board = new Grid(c1, c2, c3, c4, c5, c6, c7, "random");
		playerturn = true;
		turnCounter = 0;
		randomButton.setStyle("-fx-text-fill: #000000");
		randomButton.setOpacity(1);
		thoughtfulButton.setStyle("-fx-text-fill: #000000");
		thoughtfulButton.setOpacity(1);
		announcement.setText("");
		savedColors = new String[6][7];
		logOut(turnCounter, false);
	}
	
	@FXML
	public void reset(ActionEvent e) {
		initialize();
	}
	
	@FXML
	public void save(ActionEvent e) {
		logIn(turnCounter);
		savedTurn = turnCounter;
	}
	
	@FXML
	public void load(ActionEvent e) {
		turnCounter = savedTurn;
		for(int row = 0; row < board.getCols().get(0).getChips().size(); row++) {
			for(int col = 0; col < board.getCols().size(); col++) {
				board.getCols().get(col).getChips().get(row).setColor(savedColors[row][col]);
				if((savedColors[row][col] == "#fffd01") || (savedColors[row][col] == "#ff0000")) {
					board.getCols().get(col).getChips().get(row).setOccupation(true);
				} else {
					board.getCols().get(col).getChips().get(row).setOccupation(false);
				}
			}
		}
		logOut(turnCounter, false);
	}
	
	public void opponentPress() {
		if(board.getCPU().getType() == "thoughtful") {
			if(board.getCPU().playerWinningMoves(board.getCols()) == -1) {
				if(board.getCPU().opponentWinningMoves(board.getCols()) == -1) {
					if(board.getCPU().backupPlan(board.getCols()) == -1) {
						int num1 = board.getCPU().getRandom();
						if(board.getCols().get(num1).isFull() == true) {
							opponentPress();
						} else {
							board.getCols().get(num1).pressed("#fffd01");
						}
					} else {
						board.getCols().get(board.getCPU().backupPlan(board.getCols())).pressed("#fffd01");
					}
				} else {
					board.getCols().get(board.getCPU().opponentWinningMoves(board.getCols())).pressed("#fffd01");
				}
			} else {
				board.getCols().get(board.getCPU().playerWinningMoves(board.getCols())).pressed("#fffd01");
			}
		} else {
			int num2 = board.getCPU().getRandom();
			if(board.getCols().get(num2).isFull() == true) {
				opponentPress();
			} else {
				board.getCols().get(num2).pressed("#fffd01");
			}
		}
		
	}
	
	@FXML
	public void pressed1(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		
		if(board.getCols().get(0).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false) && (board.isFull() == false))) {
				announcement.setText("");
				board.getCols().get(0).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
		
	}
	
	@FXML
	public void pressed2(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		if(board.getCols().get(1).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false))) {
				announcement.setText("");
				board.getCols().get(1).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
		
	}
	
	@FXML
	public void pressed3(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		
		if(board.getCols().get(2).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false))) {
				announcement.setText("");
				board.getCols().get(2).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
	}
	
	@FXML
	public void pressed4(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		
		if(board.getCols().get(3).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false))) {
				announcement.setText("");
				board.getCols().get(3).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
	}
	
	@FXML
	public void pressed5(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		
		if(board.getCols().get(4).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false))) {
				announcement.setText("");
				board.getCols().get(4).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
	}
	
	@FXML
	public void pressed6(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		
		if(board.getCols().get(5).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false))) {
				announcement.setText("");
				board.getCols().get(5).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
	}
	
	@FXML
	public void pressed7(ActionEvent e) {
		if(turnCounter == 0) {
			board.getCPU().setType(initializeChallenger());
		}
		
		
		
		if(board.getCols().get(6).isFull()) {
			announcement.setText("That one's full, try again");
		} else {
			if((playerturn == true) && ((board.playerWins() == false) && (board.opponentWins() == false))) {
				announcement.setText("");
				board.getCols().get(6).pressed("#ff0000");
				playerturn = false;
				turnCounter++;
				logOut(turnCounter, true);
				if(board.playerWins()) {
					announcement.setText("Player Wins!");
					announcement.setStyle("-fx-fill: #ff0000");
				} else if(board.isFull() == true) {
					announcement.setText("It's a Draw!");
					announcement.setStyle("-fx-fill: #000000");
				} else {
					opponentPress();
					playerturn = true;
					turnCounter++;
					logOut(turnCounter, true);
					if(board.opponentWins()) {
						announcement.setText("Opponent Wins!");
						announcement.setStyle("-fx-fill: #fffd01");
					} else if(board.isFull() == true) {
						announcement.setText("It's a Draw!");
						announcement.setStyle("-fx-fill: #000000");
					}
				}
			}
		}
	}
	
	public String initializeChallenger() {
		if(randomButton.isSelected()) {
			thoughtfulButton.setStyle("-fx-text-fill: #ffffff");
			thoughtfulButton.setOpacity(0);
			return "random";
		} else {
			randomButton.setStyle("-fx-text-fill: #ffffff");
			randomButton.setOpacity(0);
			return "thoughtful";
		}
	}
	
	

	
}
