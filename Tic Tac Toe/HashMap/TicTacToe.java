package HashMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    private static String currentPlayer = "X";
    private static JButton[][] board = new JButton[3][3];
    private static JLabel textLabel = new JLabel("Tic-Tac-Toe");

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        JPanel textPanel = new JPanel();
        JPanel boardPanel = new JPanel();

        frame.setVisible(true);
        frame.setSize(650, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        frame.add(boardPanel);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().equals("")) {
                            tile.setText(currentPlayer);
                            if (checkWin()) {
                                textLabel.setText(currentPlayer + " wins!");
                                disableBoard();
                            } else if (isBoardFull()) {
                                textLabel.setText("It's a tie!");
                            } else {
                                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                                textLabel.setText(currentPlayer + "'s turn");
                            }
                        }
                    }
                });
            }
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals(currentPlayer) &&
                    board[i][1].getText().equals(currentPlayer) &&
                    board[i][2].getText().equals(currentPlayer)) {
                return true;
            }
            if (board[0][i].getText().equals(currentPlayer) &&
                    board[1][i].getText().equals(currentPlayer) &&
                    board[2][i].getText().equals(currentPlayer)) {
                return true;
            }
        }
        if (board[0][0].getText().equals(currentPlayer) &&
                board[1][1].getText().equals(currentPlayer) &&
                board[2][2].getText().equals(currentPlayer)) {
            return true;
        }
        if (board[0][2].getText().equals(currentPlayer) &&
                board[1][1].getText().equals(currentPlayer) &&
                board[2][0].getText().equals(currentPlayer)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void disableBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setEnabled(false);
            }
        }
    }
}