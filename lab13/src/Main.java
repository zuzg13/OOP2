public class Main {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int P = Integer.parseInt(args[2]);

        Matrix A = new Matrix(N, M);
        Matrix B = new Matrix(M, P);

        A.fillRandomly();
        B.fillRandomly();

        Matrix C1 = Matrix.multiply(A, B);
        Matrix C2 = Matrix.multiplyWithThreads(A, B);

        if(C1==null || C2==null)
        {
            System.out.println("Nieprawidlowe wymiary macierzy, anulowano mnozenie");
        }
        else
        {
            if(C1.equals(C2))
                System.out.println("Macierze są identyczne");
            else
                System.out.println("Macierze nie są identcyzne");
        }


    }
}