package com.j2core.sts.leetcode.com.tetris;
import java.awt.*;

/*
 * Board extends an AWT window object that displays the tetris game board.
 */
class Board extends Frame {
    static int WIDTH = 10;
    static int HEIGHT = 10;
    static int WINDOW_WIDTH = 200;
    static int WINDOW_HEIGHT = 500;
    static int TOP_BORDER = 30;
    static int BORDER = 10;

    TextArea area = null;

    // The board is represented as an array of arrays, with 10 rows and 10 columns.
    int[][] board = new int[HEIGHT][WIDTH];

    Board() {
        super("Demo");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setLayout(null);
        setVisible(true);
        requestFocus();

        area = new TextArea("", WIDTH, HEIGHT, TextArea.SCROLLBARS_NONE);
        area.setBounds(
                BORDER,
                TOP_BORDER,
                WINDOW_WIDTH - 2 * BORDER,
                WINDOW_HEIGHT - BORDER - TOP_BORDER);
        area.setFont(new Font("Monospaced", Font.PLAIN, 22));
        area.setEditable(false);
        area.setFocusable(false);

        add(area);
    }

    public int[][] getBoard() { return board; }

    public void set(int x, int y, int value) {
        board[y][x] = value;
    }

    /*
     * Append text to the demo text area.
     */
    public void append(String text) {
        area.append(text);
    }

    /*
     * Updates the demo text area with the contents of the board.
     */
    public void refresh() {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < WIDTH + 2; col++)
            sb.append("*");
        sb.append("\n");

        for (int row = 0; row < HEIGHT; row++) {
            sb.append("|");
            for (int col = 0; col < WIDTH; col++) {
                int value = board[row][col];
                sb.append(value == 0 ? " " : "#");
            }
            sb.append("|\n");
        }

        for (int col = 0; col < WIDTH + 2; col++)
            sb.append("*");
        sb.append("\n");


        area.setText(sb.toString());
    }
}
