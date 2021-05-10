package com.jx.Sudoku;

import java.util.stream.IntStream;

public class Board {
    private int[][] board;

    public Board(int[][] values) {
        this.board = values;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

    public void set(int x, int y, int value) {
        board[x][y]=value;
    }

    public int[] getRow(int row) {
        return board[row];
    }

    public int[] getColumn(int column)  {
            return IntStream.range(0, board.length)
                    .map(i -> board[i][column]).toArray();
    }

    /*
    The ennead is the nine cell square block numbered 0-8 starting in the upper left
    ennead 0 ==     [0][0], [1][0], [2][0]
                    [0][1], [1][1], [2][1]
                    [0][2], [1][2], [2][2]
                    or
                    [e*3+0][e*3+0], [e*3+1][e*3+0], [e*3+2][e*3+0]
                    [e*3+0][e*3+1], [e*3+1][e*3+1], [e*3+2][e*3+1]
                    [e*3+0][e*3+2], [e*3+1][e*3+2], [e*3+2][e*3+2]
     */
    public int[][] getEnnead(int enneadNumber) {
        int[][] ennead = new int[3][3];
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++) {
                ennead[i][j]=board[enneadNumber*3 + j][enneadNumber*3+i];
        }

        return ennead;
    }
}
