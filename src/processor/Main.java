package processor;

// Make UI Package

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix();
        MatrixProcessor process = new MatrixProcessor(A);
        process.multiplyBy();
    }
}
