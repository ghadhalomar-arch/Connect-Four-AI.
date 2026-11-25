public class Alpha_Beta {

	// # of board rows & columns
	private static final int rows = 6;
	private static final int cols = 7;
	
	private static final int empty = 0; //Empty state
	private static final int max = 1; //Yellow player, maximizing the score.
	private static final int min = 2; //Red player, minimizing the score.
	private int depth; //Maximum search depth
	
	//constructor
	public Alpha_Beta(int depth) { 
        this.depth = depth;
    }
	
	
	//Score a group of four cells.
	public int evaluateFourCells(int[] fourCells){
		
		int maxCount = 0;
	    int minCount = 0;
	    int emptyCount = 0;
	    
	    //Count how many max & min tokens & empty cells exist in a group of four cells window.
	    for(int i=0; i < fourCells.length; i++) {
	    	if(fourCells[i] == max) {
	    		maxCount ++;}
	    	if(fourCells[i] == min) {
	    		minCount ++;}
	    	if(fourCells[i] == empty) {
	    		emptyCount ++;}
	    }
	    
	 // Max evaluation
	    if (maxCount == 4) {
	        return 10000;}
	     else if (maxCount == 3 && emptyCount == 1) {
	        return 100;} 
	    else if (maxCount == 2 && emptyCount == 2) {
	        return 10;}
	    
	    // Min evaluation
	    if (minCount == 4) { 
	        return -10000;}
	     else if (minCount == 3 && emptyCount == 1) {
	        return -100;}
	     else if (minCount == 2 && emptyCount == 2) {
	        return -10;}
	   
		return 0; // Returns a neutral score when none of the previous conditions were satisfied.
		}
	
	//Calculate the heuristic score of the entire board.
	public int evaluateBoard(int[][] board){
			
		int score = 0;

		// Horizontal evaluation
		for (int row = 0; row < rows; row++) {
			/* "-3" because each window contains four cells if we reach.
			 * if we start at col 4 we would go out of bound of the array/board
			 */
		    for (int col = 0; col < cols - 3; col++) { // Stop at column = 3

		        int[] window = 
		           {board[row][col],
		            board[row][col + 1],
		            board[row][col + 2],
		            board[row][col + 3]};
		        	
		        score += evaluateFourCells(window);
		    }
		}
		
		// Vertical evaluation
		for (int row = 0; row < rows - 3; row++) {
			for (int col = 0; col < cols; col++) { // Stop at column = 3

		        int[] window = 
		           {board[row][col],
		            board[row + 1][col],
		            board[row + 2][col],
		            board[row + 3][col]};
		        	
		        score += evaluateFourCells(window);
		    }
		}
		
		// Diagonal down-right evaluation
		for (int row = 0; row < rows - 3; row++) { // Stop at row = 2
		    for (int col = 0; col < cols - 3; col++) { // Stop at column = 3

		        int[] window = 
		           {board[row][col],
		            board[row + 1][col + 1],
		            board[row + 2][col + 2],
		            board[row + 3][col + 3]};
		        	
		        score += evaluateFourCells(window);
		    }
		}
		
		// Diagonal down-left evaluation
		for (int row = 0; row < rows - 3; row++) { // Stop at row = 2
			for (int col = 3; col < cols; col++) { // Start at column = 3, any lower is out of bound

				int[] window = 
			       {board[row][col],
			        board[row + 1][col - 1],
			        board[row + 2][col - 2],
			        board[row + 3][col - 3]};

				score += evaluateFourCells(window);
			}
		}
		return score;
	}
	
	//Perform depth-limited Minimax with Alpha–Beta pruning.
	public int minMax(ConnectFourGame game, int depth, int alpha, int beta, boolean maximizing){
		
		if(game.checkWinner(max)) { //Max wins
			return 10000;
		}
		if(game.checkWinner(min)) { //Min wins
			return -10000;
		}
		if(game.isDraw()) { //Draw
			return 0;
		}
		if (depth == 0) { //Reached the depth limit
		    return evaluateBoard(game.board);
		}
		if (maximizing) { //max search

			int bestScore = Integer.MIN_VALUE; //Negative infinity

			for (int col = 0; col < cols; col++) {
				if (game.isValidMove(col)) {
					game.makeMove(col, max); //Simulate the move

					int score = minMax(game, depth - 1, alpha, beta, false); //Recursively evaluate the resulting

					undoMove(game, col); //Restore the original board.

					if (score > bestScore) { //Select the highest score
						bestScore = score;
					}
					if (bestScore > alpha) { //Update alpha
					    alpha = bestScore;
					}
					if (alpha >= beta) { //Alpha-Beta pruning
					    break;
					}
				}
			}
			
			return bestScore;
		}
		else { //Min search

			int bestScore = Integer.MAX_VALUE; //Positive infinity

			for (int col = 0; col < cols; col++) {
				if (game.isValidMove(col)) {
					game.makeMove(col, min); //Simulate the move

					int score = minMax(game, depth - 1, alpha, beta, true); //Recursively evaluate the resulting

					undoMove(game, col); //Restore the original board.

					if (score < bestScore) { //Select the lowest score
						bestScore = score;
					}
					if (bestScore < beta) { //Update beta
					    beta = bestScore;
					}
					if (alpha >= beta) { //Alpha-Beta pruning
					    break;
					}
				}
			}
			
			return bestScore;
		}
	}
	
	//Remove the last simulated token from a column.
	private void undoMove(ConnectFourGame game, int col) {

	    for (int row = 0; row < rows; row++) {

	        if (game.board[row][col] != empty) {
	            game.board[row][col] = empty;
	            break;}
	   }
	 }   
	
	
	//Return the best column for the AI to play.
	public int chooseMove(ConnectFourGame game, int player){
		
		if (game.checkWinner(max) || game.checkWinner(min)|| game.isDraw()) {
		    return -1;
		}
		
		int bestColumn = -1; //Stores column with best score
	    int bestScore; //Stores best score found

	    if (player == max) {
	        bestScore = Integer.MIN_VALUE;
	    } else {
	        bestScore = Integer.MAX_VALUE;
	    }
	    
	    for (int col = 0; col < cols; col++) {

	        if (game.isValidMove(col)) {
	        	game.makeMove(col, player);

	        	int score = minMax(game, depth - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, player == min);

	        	undoMove(game, col);
	        	
	        	if (player == max) {

	        	    if (score > bestScore) {
	        	        bestScore = score;
	        	        bestColumn = col;
	        	    }

	        	} else {

	        	    if (score < bestScore) {
	        	        bestScore = score;
	        	        bestColumn = col;
	        	    }
	        	}
	        }
	    }
	    return bestColumn;
	}
}
