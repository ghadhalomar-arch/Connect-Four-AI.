
public class Experiments {

    public static void alphaBetaVsAlphaBeta(int maxDepth, int minDepth) {

        // Initialize the game
        ConnectFourGame game = new ConnectFourGame();
        game.initiallizeBoard();

        // Create two AI agents
        Alpha_Beta maxAI = new Alpha_Beta(maxDepth);
        Alpha_Beta minAI = new Alpha_Beta(minDepth);

        int currentPlayer = 1;

        // Total decision time for each agent
        long maxTotalTime = 0;
        long minTotalTime = 0;

        // Number of moves for each agent
        int maxMoves = 0;
        int minMoves = 0;

        long startTime = System.nanoTime();

        // Game loop
        while (!game.checkWinner(1) && !game.checkWinner(2) && !game.isDraw()) {

            int bestColumn;
            long moveStartTime = System.nanoTime();

            // Select a column
            if (currentPlayer == 1) {
                bestColumn = maxAI.chooseMove(game, 1);
            } else {
                bestColumn = minAI.chooseMove(game, 2);
            }

            // Calculate decision time
            long moveEndTime = System.nanoTime();
            long decisionTime = moveEndTime - moveStartTime;

            // Check if the column is valid
            if (!game.isValidMove(bestColumn)) {
                System.out.println("Error: Invalid move");
                return;
            }

            game.makeMove(bestColumn, currentPlayer);

            // Update the time and move count for each player
            if (currentPlayer == 1) {
                maxTotalTime += decisionTime;
                maxMoves++;
            } else {
                minTotalTime += decisionTime;
                minMoves++;
            }

            // Display the move and board
            System.out.println("Move " + (maxMoves + minMoves)
                    + ": Player " + currentPlayer
                    + " selected column " + bestColumn);

            game.displayBoard();

            // Switch players
            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
        }

        // Calculate total game time in seconds
        long endTime = System.nanoTime();
        double totalGameTime = (endTime - startTime) / 1000000000.0;

        // Determine the winner
        String result;

        if (game.checkWinner(1)) {
            result = "MAX wins (Depth " + maxDepth + ")";
        } else if (game.checkWinner(2)) {
            result = "MIN wins (Depth " + minDepth + ")";
        } else {
            result = "Draw";
        }

        // Calculate average decision time in milliseconds
        double maxAverageTime = 0;
        double minAverageTime = 0;

        if (maxMoves > 0) {
            maxAverageTime = (maxTotalTime / 1000000.0) / maxMoves;
        }

        if (minMoves > 0) {
            minAverageTime = (minTotalTime / 1000000.0) / minMoves;
        }

        // Print results
        System.out.println("\n===== EXPERIMENT RESULTS =====");
        System.out.println("MAX depth: " + maxDepth);
        System.out.println("MIN depth: " + minDepth);
        System.out.println("Result: " + result);
        System.out.println("Total moves: " + (maxMoves + minMoves));
        System.out.println("MAX moves: " + maxMoves);
        System.out.println("MIN moves: " + minMoves);
        System.out.println("Total game time: " + totalGameTime + " seconds");
        System.out.println("MAX average decision time: " + maxAverageTime + " ms");
        System.out.println("MIN average decision time: " + minAverageTime + " ms");
        System.out.println("==============================");
    }
}
