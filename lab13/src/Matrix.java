import java.util.ArrayList;
import java.util.Random;

/**
 * klasa Matrix reprezentująca macierz
 */
public class Matrix{

    private final int n;
    private final int m;
    private final double [][] matrix;

    /**
     * konstruktor klasy matrix, inicjalizuje wymiary macierzy i samą macierz
     * @param _n pierwszy wymiar macierzy
     * @param _m drugi wymiar macierzy
     */
    public Matrix(int _n, int _m)
    {
        n = _n;
        m = _m;
        matrix = new double [n][m];
        System.out.println("Tworze macierz o wymiarach "+n+"x"+m);
    }

    /**
     * wypełnia macierz losowymi wartościami
     */
    public void fillRandomly()
    {
        Random rand = new Random();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                matrix[i][j] = rand.nextDouble() * 100;
        System.out.println("Wypełniam macierz losowymi wartościami...");
    }

    /**
     * wypisuje zawartość macierzy
     */
    public void print()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * @return wartość wymiaru n macierzy
     */
    public int getN()
    {
        return n;
    }

    /**
     * @return wartość wymairu m macierzy
     */
    public int getM()
    {
        return m;
    }

    /**
     * zwraca wartość elementu o danych współrzędnych w macierzy
     * @param _n pierwsza współrzędna
     * @param _m druga współrzędna
     * @return wartość elementu
     */
    public double getElement(int _n, int _m)
    {
        return matrix[_n][_m];
    }

    /**
     * wstawia daną wartość do odpowiedniego miejsca w macierzy
     * @param _n pierwsza współrzędna
     * @param _m druga współrzędna
     * @param val wartość do wstawienia
     */
    public void insertElement(int _n, int _m, double val)
    {
        matrix[_n][_m] = val;
    }

    /**
     * zwiększa aktualną wartość elementu o danych wspolrzednych o val
     * @param _n pierwsza wspolrzedna
     * @param _m druga wspolrzedna
     * @param val wartość o ktora zwiekszamy aktualna wartosc elementu
     */
    public void plusElement(int _n, int _m, double val)
    {
        matrix[_n][_m] += val;
    }

    /**
     * mnozy ze soba dwie macierze i zwraca macierz wynikowa
     * @param a macierz pierwsza
     * @param b macierz druga
     * @return macierz wynikowa mnozenia a i b
     */
    public static Matrix multiply(Matrix a, Matrix b)
    {
        if(a.getM() != b.getN())
            return null;

        System.out.println("Wymiary macierzy prawidłowe, mnożę macierze");

        Matrix c = new Matrix(a.getN(), b.getM());

        for(int i=0;i<a.getN();i++)
        {
            for(int j=0;j<b.getM();j++)
            {
                c.insertElement(i, j, 0.);
                for(int k=0;k<b.getN();k++)
                {
                    c.plusElement(i, j, a.getElement(i, k)*b.getElement(k, j));
                }
            }
        }

        return c;

    }

    /**
     * mnoze ze soba dwie macierze w sposob wielowatkowy i zwraca macierz wynikową
     * @param a macierz pierwsza
     * @param b macierz druga
     * @return macierz wynikowa mnozenia a i b
     */
    public static Matrix multiplyWithThreads(Matrix a, Matrix b)
    {
        if(a.getM()!=b.getM())
            return null;

        System.out.println("Wymiary macierzy prawidłowe, mnożę macierze");

        int N = a.getN();
        int P = b.getM();

        Matrix C = new Matrix(N, P);
        ArrayList<Thread> threads = new ArrayList<>(N*P);
        int idx = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < P; j++)
            {
                final int I = i;
                final int J = j;
                C.insertElement(I, J, 0);

                Thread thread = new Thread(() ->
                {
                    for (int k = 0; k < a.getM(); k++)
                    {
                        C.plusElement(I, J, a.getElement(I, k) * b.getElement(k, J));
                    }
                });

                threads.add(idx, thread);
                threads.get(idx).start();
                idx++;
            }
        }
        for(int i = 0; i < N*P; i++) {
            try {
                threads.get(i).join();
            } catch(java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
        return C;
    }


    /**
     * sprawdza czy dwie macierze (obiekty) są do siebie identcyzne
     * @param obj obiekt to porownania
     * @return czy są identyczne czy nie
     */
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Matrix))
            return false;

        Matrix other = (Matrix) obj;

        if(m != other.getM() || n != other.getN())
            return false;

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(getElement(i, j)!=other.getElement(i, j))
                    return false;

        return true;

    }

}

