package ui;

import processor.*;
import java.util.Scanner;

public class UserInterface {

    Scanner reader = new Scanner(System.in);

    public void start() {

        menuOptions();

        System.out.print("Your choice: ");

        int menuOption = reader.nextInt();
        System.out.println("");

        while (menuOption != 0) {

            switch (menuOption) {
                case 1: {
                    System.out.print("Enter size of first matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter first matrix: ");
                    A.generateMatrix();
                    System.out.print("\nEnter size of second matrix: ");
                    Matrix B = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter second matrix: ");
                    B.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A, B);
                    System.out.println("\nResult:");
                    process.addMatrix();
                    System.out.println("");
                    break;
                }
                case 2: {
                    System.out.println("Enter size of the matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter first matrix: ");
                    A.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A);
                    System.out.println("\nMultiply by: ");
                    process.printMatrix(process.multiplyBy(reader.nextInt(), A.getMatrix()));
                    System.out.println("");
                    break;
                }
                case 3: {
                    System.out.print("Enter size of first matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter first matrix: ");
                    A.generateMatrix();
                    System.out.print("\nEnter size of second matrix: ");
                    Matrix B = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter second matrix: ");
                    B.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A, B);
                    System.out.println("\nResult:");
                    process.multiplyMatrices();
                    System.out.println("");
                    break;
                }
                case 4: {
                    transposeMenu();
                    System.out.print("Your choice: ");
                    int transposeMenu = reader.nextInt();
                    System.out.println();
                    System.out.println("Enter matrix size");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter matrix: ");
                    A.generateMatrix();
                    System.out.println("");
                    MatrixProcessor process = new MatrixProcessor(A);
                    System.out.println("Result:");
                    process.transpose(transposeMenu);
                    System.out.println("");
                    break;
                }
                case 5: {
                    System.out.println("Enter size of the matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter matrix: ");
                    A.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A);
                    System.out.println("\nThe result is: \n" + process.determinant(A.getMatrix().length, A.getMatrix()) + "\n");
                    break;
                }
                case 6: {
                    System.out.println("Enter size of the matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("\nEnter matrix: ");
                    A.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A);
                    System.out.println("\nThe result is: ");
                    process.printMatrix(process.inverse());
                    System.out.println("");
                    break;
                }
            }
            menuOptions();
            menuOption = reader.nextInt();
        }

    }

    public void menuOptions() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinate");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
    }

    public void transposeMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
    }
}
