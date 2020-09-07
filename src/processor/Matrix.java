package processor;

import java.util.Scanner;

public class Matrix {

    Scanner reader = new Scanner(System.in);
    public int row;
    public int column;
    private double[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new double[row][column];
    }

    public void generateMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = reader.nextDouble();
            }
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }
}
