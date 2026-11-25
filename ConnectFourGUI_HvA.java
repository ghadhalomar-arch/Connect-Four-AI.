
import javax.swing.*;
import java.awt.*;

public class ConnectFourGUI_HvA extends JFrame {

    private ConnectFourGame game = new ConnectFourGame();
    private Alpha_Beta ai = new Alpha_Beta(6);

    private JPanel[][] cells = new JPanel[6][7];
    private int currentPlayer = 1;
    private JLabel title;

    // Colors
    private final Color backgroundColor = new Color(16, 27, 48);
    private final Color boardColor = new Color(36, 83, 164);
    private final Color maxColor = new Color(243, 206, 64);
    private final Color minColor = new Color(230, 80, 80);

    public ConnectFourGUI_HvA() {

        game.initiallizeBoard();

        // Window settings
        setTitle("Connect Four AI");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(backgroundColor);

        // Game title
        title = new JLabel("CONNECT FOUR", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(title, BorderLayout.NORTH);

        // Create the board
        JPanel boardPanel = new JPanel(new GridLayout(6, 7, 8, 8));
        boardPanel.setBackground(boardColor);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {

                cells[row][col] = new JPanel();
                cells[row][col].setBackground(backgroundColor);
                boardPanel.add(cells[row][col]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // Create the column buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 7, 8, 8));
        buttonsPanel.setBackground(backgroundColor);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        for (int col = 0; col < 7; col++) {

            JButton button = new JButton("Column " + (col + 1));

            button.setBackground(boardColor);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setPreferredSize(new Dimension(100, 40));

            final int column = col;

            button.addActionListener(e -> playMove(column));
            buttonsPanel.add(button);
        }

        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Update the board colors
    private void updateBoard() {

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {

                if (game.board[row][col] == 1) {
                    cells[row][col].setBackground(maxColor);
                } else if (game.board[row][col] == 2) {
                    cells[row][col].setBackground(minColor);
                } else {
                    cells[row][col].setBackground(backgroundColor);
                }
            }
        }
    }

    // Check if the game has ended
    private boolean checkGameOver() {

        if (game.checkWinner(1)) {
            title.setText("MAX WINS!");
            title.setForeground(maxColor);
            return true;

        } else if (game.checkWinner(2)) {
            title.setText("MIN WINS!");
            title.setForeground(minColor);
            return true;

        } else if (game.isDraw()) {
            title.setText("DRAW!");
            return true;
        }

        return false;
    }

    // Play the human player's move
    private void playMove(int col) {

        if (checkGameOver() || currentPlayer != 1) {
            return;
        }

        if (!game.isValidMove(col)) {
            title.setText("COLUMN IS FULL");
            return;
        }

        game.makeMove(col, 1);
        updateBoard();

        if (checkGameOver()) {
            return;
        }

     // Switch to the AI
        currentPlayer = 2;
        aiMove();
    }

    // Play the AI's move
    private void aiMove() {

        int bestColumn = ai.chooseMove(game, 2);

        if (!game.isValidMove(bestColumn)) {
            title.setText("INVALID AI MOVE");
            return;
        }

        game.makeMove(bestColumn, 2);
        updateBoard();

        if (checkGameOver()) {
            return;
        }

        // Switch back to the human
        currentPlayer = 1;
        title.setText("YOUR TURN");
    }
}
