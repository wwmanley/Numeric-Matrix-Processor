package processor;

import java.util.Arrays;
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
            for (int j = 0; j < A.getMatrix()[A.row - 1].length; j++) {
                matrixSum[i][j] = A.getMatrix()[i][j] + B.getMatrix()[i][j];
            }
        }

        printMatrix(matrixSum);
    }

    public void multiplyBy(int constant) {
        double[][] matrixProduct = new double[A.row][A.column];

        for (int i = 0; i < A.getMatrix().length; i++) {
            for (int j = 0; j < A.getMatrix()[A.row - 1].length; j++) {
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

    public void transpose(int menuOptions) {

        double transpose[][] = new double[A.row][A.column];
        double copyOfInitial[][] = A.getMatrix().clone();

        switch (menuOptions) {
            case 1: {
                for (int i = 0; i < transpose.length; i++) {
                    for (int j = 0; j < transpose[i].length; j++) {
                        if (i == j) {
                            transpose[i][j] = copyOfInitial[i][j];
                        } else {
                            transpose[i][j] = copyOfInitial[j][i];
                        }
                    }
                }
                printMatrix(transpose);
                break;
            }
            case 2: {
                int i = 0;
                int j = 0;
                for (int columns = transpose.length - 1; columns >= 0; columns--) {
                    for (int rows = transpose.length - 1; rows >= 0; rows--) {
                        transpose[i][j] = copyOfInitial[rows][columns];
                        if (j + 1 == transpose.length) {
                            j = 0;
                            i++;
                        } else {
                            j++;
                        }
                    }
                }
                printMatrix(transpose);
                break;
            }
            case 3: {
                int j = 0;
                for (int i = 0; i < transpose.length; i++) {
                    for (int columns = transpose.length - 1; columns >= 0; columns--) {
                        transpose[i][j] = copyOfInitial[i][columns];
                        if (j + 1 == transpose.length) {
                            j = 0;
                        } else {
                            j++;
                        }
                    }
                }
                printMatrix(transpose);
                break;
            }
            case 4: {
                int j = 0;
                int row = transpose.length - 1;
                for (int i = 0; i < transpose.length; i++) {
                    for (int columns = 0; columns < transpose.length; columns++) {
                        transpose[i][j] = copyOfInitial[row][columns];
                        if (j + 1 == transpose.length) {
                            j = 0;
                            row--;
                        } else {
                            j++;
                        }
                    }
                }
                printMatrix(transpose);
                break;
            }
        }
    }
}
