package processor;

import java.util.Scanner;

class Matrix {

    Scanner reader = new Scanner(System.in);
    public static int row;
    public static int column;
    private int[][] matrix;

    public Matrix() {
        row = reader.nextInt();
        column = reader.nextInt();
        matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
