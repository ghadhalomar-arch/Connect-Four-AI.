
public class Alpha_Beta {

    // Board dimensions
    private static final int rows = 6;
    private static final int cols = 7;

    // Board values
    private static final int empty = 0;
    private static final int max = 1;
    private static final int min = 2;

    private int depth;

    // Constructor
    public Alpha_Beta(int depth) {
        this.depth = depth;
    }

    // Evaluate a group of four cells
    public int evaluateFourCells(int[] fourCells) {

        int maxCount = 0;
        int minCount = 0;
        int emptyCount = 0;

        // Count MAX, MIN and empty cells
        for (int i = 0; i < fourCells.length; i++) {

            if (fourCells[i] == max) {
                maxCount++;
            } else if (fourCells[i] == min) {
                minCount++;
            } else if (fourCells[i] == empty) {
                emptyCount++;
            }
        }

        // MAX evaluation
        if (maxCount == 4) {
            return 10000;
        } else if (maxCount == 3 && emptyCount == 1) {
            return 100;
        } else if (maxCount == 2 && emptyCount == 2) {
            return 10;
        }

        // MIN evaluation
        if (minCount == 4) {
            return -10000;
        } else if (minCount == 3 && emptyCount == 1) {
            return -100;
        } else if (minCount == 2 && emptyCount == 2) {
            return -10;
        }

        return 0;
    }

    // Calculate the score of the entire board
    public int evaluateBoard(int[][] board) {

        int score = 0;

        // Horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) {

                int[] window = {board[row][col], board[row][col + 1],
                        board[row][col + 2], board[row][col + 3]};

                score += evaluateFourCells(window);
            }
        }

        // Vertical
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols; col++) {

                int[] window = {board[row][col], board[row + 1][col],
                        board[row + 2][col], board[row + 3][col]};

                score += evaluateFourCells(window);
            }
        }

        // Diagonal down-right
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols - 3; col++) {

                int[] window = {board[row][col], board[row + 1][col + 1],
                        board[row + 2][col + 2], board[row + 3][col + 3]};

                score += evaluateFourCells(window);
            }
        }

        // Diagonal down-left
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 3; col < cols; col++) {

                int[] window = {board[row][col], board[row + 1][col - 1],
                        board[row + 2][col - 2], board[row + 3][col - 3]};

                score += evaluateFourCells(window);
            }
        }

        return score;
    }

    // Minimax with Alpha-Beta pruning
    public int minMax(ConnectFourGame game, int depth, int alpha,
                      int beta, boolean maximizing) {

        // Terminal conditions and depth limit
        if (game.checkWinner(max)) {
            return 10000;
        } else if (game.checkWinner(min)) {
            return -10000;
        } else if (game.isDraw()) {
            return 0;
        } else if (depth == 0) {
            return evaluateBoard(game.board);
        }

        // MAX search
        if (maximizing) {

            int bestScore = Integer.MIN_VALUE;

            for (int col = 0; col < cols; col++) {

                if (game.isValidMove(col)) {

                    // Simulate and evaluate the move
                    game.makeMove(col, max);
                    int score = minMax(game, depth - 1, alpha, beta, false);
                    undoMove(game, col);

                    // Select the highest score
                    if (score > bestScore) {
                        bestScore = score;
                    }

                    // Update alpha
                    if (bestScore > alpha) {
                        alpha = bestScore;
                    }

                    // Pruning
                    if (alpha >= beta) {
                        break;
                    }
                }
            }

            return bestScore;

        } else {

            // MIN search
            int bestScore = Integer.MAX_VALUE;

            for (int col = 0; col < cols; col++) {

                if (game.isValidMove(col)) {

                    // Simulate and evaluate the move
                    game.makeMove(col, min);
                    int score = minMax(game, depth - 1, alpha, beta, true);
                    undoMove(game, col);

                    // Select the lowest score
                    if (score < bestScore) {
                        bestScore = score;
                    }

                    // Update beta
                    if (bestScore < beta) {
                        beta = bestScore;
                    }

                    // Pruning
                    if (alpha >= beta) {
                        break;
                    }
                }
            }

            return bestScore;
        }
    }

    // Remove the last simulated token
    private void undoMove(ConnectFourGame game, int col) {

        for (int row = 0; row < rows; row++) {

            if (game.board[row][col] != empty) {
                game.board[row][col] = empty;
                break;
            }
        }
    }

    // Find the best column to play
    public int chooseMove(ConnectFourGame game, int player) {

        if (game.checkWinner(max) || game.checkWinner(min) || game.isDraw()) {
            return -1;
        }

        int bestColumn = -1;
        int bestScore;

        if (player == max) {
            bestScore = Integer.MIN_VALUE;
        } else {
            bestScore = Integer.MAX_VALUE;
        }

        // Test each valid column
        for (int col = 0; col < cols; col++) {

            if (game.isValidMove(col)) {

                game.makeMove(col, player);

                int score = minMax(game, depth - 1,
                        Integer.MIN_VALUE, Integer.MAX_VALUE, player == min);

                undoMove(game, col);

                // Select the best move for MAX
                if (player == max) {

                    if (score > bestScore) {
                        bestScore = score;
                        bestColumn = col;
                    }

                } else {

                    // Select the best move for MIN
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
