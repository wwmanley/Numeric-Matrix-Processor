package processor;

// Make UI Package

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix();
        Matrix B = new Matrix();
        MatrixProcessor process = new MatrixProcessor(A, B);
        process.addMatrix();
    }
}
