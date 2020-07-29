package com.j2core.sts.leetcode.com.tetris;

import java.awt.event.*;

class Tetris {

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}

class Game implements KeyListener {

    Board board = new Board();
    private int[][] currentObject;

    public void run() {

        // This example code draws a T-shaped piece.
        currentObject = new int[][]{{3,0,1},{4,0,1},{5,0,1},{4,1,1}};
        for (int[] array : currentObject){
            board.set(array[0], array[1], array[2]);
        }
//
//        board.set(3, 8, 1);
//        board.set(4, 8, 1);
//        board.set(5, 8, 1);
//        board.set(4, 9, 1);

        board.refresh();

        board.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        board.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        board.refresh();

        if (keyCode == KeyEvent.VK_DOWN) {
            stepDown();
            board.append("Down");
        }
        else if (keyCode == KeyEvent.VK_UP) {
            rotate();
            board.append("UP");
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
           stepLeft();
           board.append("Left");
        }
        else {
            stepRight();
            board.append(KeyEvent.getKeyText(keyCode));
        }
    }

    private void cleanLine(){

        int[][] currentBoard = board.getBoard();
        for (int i = 9; i > -1; i--){

            int counter = 0;
            for (int j = 0; j < 10; j++){
               if (currentBoard[i][j] == 1) {
                   counter++;
               }
            }
            if (counter == 10){
                System.arraycopy(currentBoard, 0, currentBoard, 1, i - 1 + 1);
                currentBoard[0] = new int[currentBoard[0].length];
            }
        }
    }

    private void rotate(){

        //todo

    }

    private void stepRight(){

        boolean flag = true;
        for (int[] array : currentObject){
            if (array[0]+1 == 10){
                flag = false;
                break;
            }
        }
        if (flag){
            setValueToBoard(currentObject, 0);
            int[][] tmpObject = new int[currentObject.length][currentObject[0].length];
            for (int i = 0; i < currentObject.length; i++){
                tmpObject[i][0] = currentObject[i][0]+1;
                tmpObject[i][1] = currentObject[i][1];
            }
            int[][] currentBoard = board.getBoard();
            for (int[] array : tmpObject){
                if (currentBoard[array[1]][array[0]] == 1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                currentObject = tmpObject;
                setValueToBoard(currentObject, 1);
            }else {
                setValueToBoard(currentObject, 1);
            }
        }
    }

    private void stepLeft(){

        boolean flag = true;
        for (int[] array : currentObject){
            if (array[0]-1 == -1){
                flag = false;
                break;
            }
        }
        if (flag){
            setValueToBoard(currentObject, 0);
            int[][] tmpObject = new int[currentObject.length][currentObject[0].length];
            for (int i = 0; i < currentObject.length; i++){
                tmpObject[i][0] = currentObject[i][0]-1;
                tmpObject[i][1] = currentObject[i][1];
            }
            int[][] currentBoard = board.getBoard();
            for (int[] array : tmpObject){
                if (currentBoard[array[1]][array[0]] == 1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                currentObject = tmpObject;
                setValueToBoard(currentObject, 1);
            }else {
                setValueToBoard(currentObject, 1);
            }
        }
    }

    private void stepDown(){

        boolean flag = true;
        for (int[] array : currentObject){
            if (array[1]+1 == 10){
                flag = false;
                break;
            }
        }
        if (flag){
            setValueToBoard(currentObject, 0);
            int[][] tmpObject = new int[currentObject.length][currentObject[0].length];
            for (int i = 0; i < currentObject.length; i++){
                tmpObject[i][0] = currentObject[i][0];
                tmpObject[i][1] = currentObject[i][1] + 1;
            }
            int[][] currentBoard = board.getBoard();
            for (int[] array : tmpObject){
                if (currentBoard[array[1]][array[0]] == 1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                setValueToBoard(tmpObject, 1);
                currentObject = tmpObject;
            }else {
                setValueToBoard(currentObject, 1);
                cleanLine();
                currentBoard = board.getBoard();
                if (currentBoard[1][4] == 1)  System.exit(0);
                currentObject = new int[][]{{3,0,1},{4,0,1},{5,0,1},{4,1,1}};
                setValueToBoard(currentObject, 1);
            }
        }else {
            cleanLine();
            int[][] currentBoard = board.getBoard();
            if (currentBoard[2][4] == 1)  System.exit(0);
            currentObject = new int[][]{{3,0,1},{4,0,1},{5,0,1},{4,1,1}};
            setValueToBoard(currentObject, 1);
        }
    }

    private void setValueToBoard(int[][] object, int value){

        for (int[] array : object){
            board.set(array[0], array[1], value);
        }
        board.refresh();
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
}
