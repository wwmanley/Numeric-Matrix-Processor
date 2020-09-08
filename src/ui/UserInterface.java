package ui;

import processor.*;
import java.util.Scanner;

public class UserInterface {

    Scanner reader = new Scanner(System.in);

    public void start() {

        menuOptions();

        System.out.print("Your choice: ");

        int menuOption = reader.nextInt();

        while (menuOption != 0) {

            switch (menuOption) {
                case 1: {
                    System.out.print("Enter size of first matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("Enter first matrix: ");
                    A.generateMatrix();
                    System.out.print("Enter size of second matrix: ");
                    Matrix B = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("Enter second matrix: ");
                    B.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A, B);
                    process.addMatrix();
                    break;
                }
                case 2: {
                    System.out.println("Enter size of first matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("Enter first matrix: ");
                    A.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A);
                    System.out.println("Multiply by: ");
                    process.multiplyBy(reader.nextInt());
                    break;
                }
                case 3: {
                    System.out.print("Enter size of first matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("Enter first matrix: ");
                    A.generateMatrix();
                    System.out.print("Enter size of second matrix: ");
                    Matrix B = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("Enter second matrix: ");
                    B.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A, B);
                    process.multiplyMatrixes();
                    break;
                }
                case 4: {
                    System.out.println("Enter size of first matrix: ");
                    Matrix A = new Matrix(reader.nextInt(), reader.nextInt());
                    System.out.println("Enter first matrix: ");
                    A.generateMatrix();
                    MatrixProcessor process = new MatrixProcessor(A);
                    transposeMenu();
                    process.transpose(reader.nextInt());
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
        System.out.println("0. Exit");
    }

    public void transposeMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
    }
}
