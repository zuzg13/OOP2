public class Main {

    public static void main(String[] args) {

        Complex c1 = new Complex();
        c1.test();

        double a, b, c;
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);

        FunKwadratowa fun = new FunKwadratowa(a, b, c);
        fun.miejsca_zerowe();

    }
}

/**
 * class FunKwadratowa
 * help calculate roots or complex roots for function with parameters a, b, c
 */
class FunKwadratowa{

    private double ma, mb, mc;

    /**
     * constructor, set argument values as parameters of function
     * @param a
     * @param b
     * @param c
     */
    FunKwadratowa(double a, double b, double c)
    {
        ma = a;
        mb = b;
        mc = c;
    }

    /**
     * calculates calculate roots or complex roots for function
     */
    public void miejsca_zerowe()
    {
        double delta = mb*mb - 4*ma*mc;
        Complex pierw_delta = Complex.sqrt(delta);
        if(pierw_delta.czyCzescZespolona())
        {
            Complex x1,x2;
            x1 = new Complex(-1. * mb / (2*ma), pierw_delta.getIm()/(2*ma));
            x2 = new Complex(-1. * mb / (2*ma), -1. *pierw_delta.getIm()/(2*ma));
            System.out.println("x1 = " + x1 + ", x2 = " +  x2);
        }
        else
        {
            double x1, x2;
            x1 = (-1. * mb + pierw_delta.getRe())/ (2*ma);
            x2 = (-1. * mb - pierw_delta.getRe())/ (2*ma);
            System.out.println("x1 = " + x1 + ", x2 = " +  x2);
        }


    }





}

