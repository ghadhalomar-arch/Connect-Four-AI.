
public class Experiments {

	public static void alphaBetaVsAlphaBeta(int maxDepth, int minDepth) {

		// Create and initialize an empty Connect Four board
		ConnectFourGame game = new ConnectFourGame();
		game.initiallizeBoard();

		// Create two AI agents with different search depth
		Alpha_Beta maxAI = new Alpha_Beta(maxDepth);
		Alpha_Beta minAI = new Alpha_Beta(minDepth);

		int currentPlayer = 1; // Max --> player 1 starts the game
		int moveCount = 0; // total of moves played in the game

		// Total decision time for each agent
		long maxTotalTime = 0;
		long minTotalTime = 0;

		// # of moves played by each agent
		int maxMoves = 0;
		int minMoves = 0;

		long startTime = System.nanoTime(); // Start time of the experiments

		while (!game.checkWinner(1) && !game.checkWinner(2) && !game.isDraw()) { // game loop

			int bestColumn; // Stores the column selected by the agent

			long moveStartTime = System.nanoTime(); // Calculates how long an agent takes to make a decision- Start

			// Who's turn to play
			if (currentPlayer == 1) { // Max turn

				bestColumn = maxAI.chooseMove(game, 1);

			} else { // Min turn

				bestColumn = minAI.chooseMove(game, 2);
			}

			long moveEndTime = System.nanoTime(); // Calculates how long an agent takes to make a decision- End

			long decisionTime = moveEndTime - moveStartTime; // Calculates the decision time

			// Calculate decision time for each agent
			if (currentPlayer == 1) {

				maxTotalTime += decisionTime;

			} else {

				minTotalTime += decisionTime;
			}

			// is the column valid?
			if (!game.isValidMove(bestColumn)) {
				System.out.println("Error: AI selected an invalid move.");
				return;
			}

			// Place the current's player decision in the board
			game.makeMove(bestColumn, currentPlayer);

			moveCount++;

			if (currentPlayer == 1) {
				maxMoves++;
			} else {
				minMoves++;
			}

			System.out.println("Move " + moveCount + ": Player " + currentPlayer + " selected column " + bestColumn);

			game.displayBoard();

			// Switch players
			if (currentPlayer == 1) {
				currentPlayer = 2;
			} else {
				currentPlayer = 1;
			}
		}

		long endTime = System.nanoTime(); // End time of the experiment

		double totalGameTime = (endTime - startTime) / 1000000000.0; // Calculating the total time of the game

		String result;

		if (game.checkWinner(1)) {
			result = "MAX wins (Depth " + maxDepth + ")";
		} else if (game.checkWinner(2)) {
			result = "MIN wins (Depth " + minDepth + ")";
		} else {
			result = "Draw";
		}

		double maxAverageTime = 0;
		double minAverageTime = 0;

		if (maxMoves > 0) {
			maxAverageTime = (maxTotalTime / 1000000.0) / maxMoves;
		}

		if (minMoves > 0) {
			minAverageTime = (minTotalTime / 1000000.0) / minMoves;
		}

		// Printing
		System.out.println("\n===== EXPERIMENT RESULTS =====");

		System.out.println("MAX depth: " + maxDepth);
		System.out.println("MIN depth: " + minDepth);

		System.out.println("Result: " + result);

		System.out.println("Total moves: " + moveCount);
		System.out.println("MAX moves: " + maxMoves);
		System.out.println("MIN moves: " + minMoves);

		System.out.println("Total game time: " + totalGameTime + " seconds");

		System.out.println("MAX average decision time: " + maxAverageTime + " ms");
		System.out.println("MIN average decision time: " + minAverageTime + " ms");

		System.out.println("==============================");
	}
}
