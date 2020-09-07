package processor;

import java.util.Scanner;

public class MatrixProcessor {

    private Matrix A;
    private Matrix B;

    public MatrixProcessor(Matrix A, Matrix B) {
        this.A = A;
        this.B = B;
    }

    public MatrixProcessor(Matrix A) {
        this.A = A;
    }

    public Scanner newScanner() {
        return new Scanner(System.in);
    }

    public void printMatrix(double[][] matrix) {
        for (double[] array : matrix) {
            for (double element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public void addMatrix() {
        double[][] matrixSum = new double[A.row][A.column];

        if (B == null) {
            return;
        }

        if (A.getMatrix().length != B.getMatrix().length) {
            System.out.println("ERROR");
            return;
        }

        for (int i = 0; i < A.getMatrix().length; i++) {
            for (int j = 0; j < A.getMatrix()[A.row-1].length; j++) {
                matrixSum[i][j] = A.getMatrix()[i][j] + B.getMatrix()[i][j];
            }
        }

        printMatrix(matrixSum);
    }

    public void multiplyBy(int constant) {
        double[][] matrixProduct = new double[A.row][A.column];

        for (int i = 0; i < A.getMatrix().length; i++) {
            for (int j = 0; j < A.getMatrix()[A.row-1].length; j++) {
                matrixProduct[i][j] = A.getMatrix()[i][j] * constant;
            }
        }

        printMatrix(matrixProduct);
    }

    public void multiplyMatrixes() {


        double product[][] = new double[A.row][B.column];

        for (int i = 0; i < A.row; i++) {
            for (int j = 0; j < B.column; j++) {
                for (int k = 0; k < A.column; k++) {
                    product[i][j] += A.getMatrix()[i][k] * B.getMatrix()[k][j];
                }
            }
        }

        printMatrix(product);

    }
}
