Instructions:

-click on any square in a column to drop a chip in that column

-the game starts once the player makes their first move
	+The player is always red and the cpu is always yellow
	
	+The opponent can be set to random or thoughtful using the buttons at the bottom
	
	+random: the opponent will randomly place chips on the boards

	+thoughtful: the opponent will make more calculated moves and try to prevent the player from winning
	
	+Once the first move is made, the difficulty setting of the AI is locked in
	 and cannot be changed without pressing the reset button

-save: creates a save state of the board that does not change unless the save or 
	   reset button is pressed
	   
-load: reverts the board to how it was when the save button was pressed

-log: opens the log.txt file in user's default text editor
	+format of the log goes as follows:
					
						2 <- turn number
						- - - - - - -  <- the state of the
						- - - - - - -     grid at that turn
						- - - - - - -  
						- - - - - - -  
						- - - - - - -  
						- x - - o - -  
					
		"x" is red chips, "o" is yellow chips, "-" is unoccupied spaces
		
-reset: clears the board and resets everything to its initial state

Video Demo: https://youtu.be/uQ-QPlKIU5U
