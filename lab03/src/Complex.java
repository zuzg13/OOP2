/**
 * class Complex
 * represents complex numbers
 *
 * @author Zuzanna Grzesik
 * @version 1.0
 */

public class Complex{

    private double mRe, mIm;

    /**
     * defined constant for i, zero and 1
     */
    public final static Complex I = new Complex(0.0, 1.0);
    public final static Complex ZERO = new Complex();
    public final static Complex ONE = new Complex(1.0);


    /**
     * simple constructor, without any arguments
     */
    Complex()
    {
        mRe = 0.0;
        mIm = 0.0;
    }

    /**
     * simple constructor with real argument, set imaginary part to 0.0
     * @param Re
     */
    Complex(double Re)
    {
        mRe = Re;
        mIm = 0.0;
    }

    /**
     * simple constructor, set real and imaginary parts to values from arguments
     * @param Re
     * @param Im
     */
    Complex(double Re, double Im)
    {
        mRe = Re;
        mIm = Im;
    }

    /**
     *
     * @return Real part
     */
    public double getRe()
    {
        return mRe;
    }

    /**
     *
     * @return Imaginary part
     */
    public double getIm()
    {
        return mIm;
    }


    /**
     * overriden toString function
     * @return complex object formatted as complex number
     */
    @Override
    public String toString()
    {
        if(mIm==0.0)
            return Double.toString(mRe);
        else if(mRe==0.0)
            return mIm+"i";
        else
            return mRe+" + "+mIm+"i";
    }

    /**
     * sum two complex numbers
     * @param c1
     * @param c2
     * @return sum of two complex numbers
     */
    public static Complex add(Complex c1, Complex c2)
    {
        Complex c = new Complex(c1.getRe() + c2.getRe(), c1.getIm() + c2.getIm());
        return c;
    }

    /**
     * subtract two complex numbers
     * @param c1
     * @param c2
     * @return subtract of two complex numbers
     */
    public static Complex subtract(Complex c1, Complex c2)
    {
        Complex c = new Complex(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
        return c;
    }

    /**
     * multiply two complex numbers
     * @param c1
     * @param c2
     * @return multiplied two complex numbers
     */
    public static Complex multiply(Complex c1, Complex c2)
    {
        Complex c = new Complex(c1.getRe()*c2.getRe() - c1.getIm()*c2.getIm(),
                c1.getIm()*c2.getRe() +c1.getRe()*c2.getIm());
        return c;
    }

    /**
     * multiply complex number and real number
     * @param c1 complex number
     * @param b real number
     * @return multiplied complex number with real number
     */
    public static Complex multiply(Complex c1, double b)
    {
        Complex c = new Complex(c1.getRe()*b, c1.getIm()*b);
        return c;
    }

    /**
     * divide two complex numbers
     * @param c1
     * @param c2
     * @return divided two complex numbers
     */
    public static Complex divide(Complex c1, Complex c2)
    {
        double tmp = c2.getRe()*c2.getRe() + c2.getIm()*c2.getIm();
        Complex c = new Complex((c1.getRe()*c2.getRe() + c1.getIm()*c2.getIm())/tmp,
                (c1.getIm()*c2.getRe() - c1.getRe()*c2.getIm())/tmp);
        return c;
    }

    /**
     * @return module of complex number
     */
    public double mod()
    {
        return Math.sqrt(mRe*mRe + mIm*mIm);
    }

    /**
     * check whether two complex numbers are equal
     * @param c2
     * @return if two complex numbers are equal
     */
    public boolean equals(Complex c2)
    {
        return (mIm==c2.getIm() && mRe==c2.getRe());
    }

    /**
     * calculate sqrt of real numbers
     * @param a
     * @return real or complex number
     */
    public static Complex sqrt(double a)
    {
        if(a<0)
            return new Complex(0.0, Math.sqrt(-1. * a));
        else
            return new Complex(Math.sqrt(a), 0.0);



    }

    /**
     * conjugate complex number
     */
    public void conjugate()
    {
        mIm *= -1.;
    }

    /**
     * turns complex number into opposite
     */
    public void opposite()
    {
        mRe *= -1.;
        mIm *= -1.;
    }

    public boolean czyCzescZespolona()
    {
        return getIm()!=0.0;
    }


    public void test() {
        // Wykorzystanie konstruktorów:
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0, 5.1)); // 5.1i
        System.out.println();

        // Stałe typu Complex:
        System.out.println(Complex.I); // 1.0i
        System.out.println(Complex.ZERO); // 0.0
        System.out.println(Complex.ONE); // 1.0
        System.out.println();

        // Wykorzystanie metod zwracających wynik obliczeń:
        System.out.println("Re(c1) = " + c1.getRe()); // Re(c1) = 2.5
        System.out.println("Im(c1) = " + c1.getIm()); // Im(c1) = 13.1
        System.out.println("c1 + c2 = " + Complex.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i
        System.out.println("c1 - c2 = " + Complex.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i
        System.out.println("c1 * c2 = " + Complex.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i
        System.out.println("c1 * 15.1 = " + Complex.multiply(c1, 15.1)); // c1 * 15.1 = 37.75 + 197.81i
        System.out.println("c1 / c2 = " + Complex.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 - 1.4932931836846426i
        System.out.println("|c1| = " + c1.mod()); // |c1| = 13.336416310238668
        System.out.println("sqrt(243.36) = " + Complex.sqrt(243.36)); // sqrt(243.36) = 15.6
        System.out.println("sqrt(-243.36) = " + Complex.sqrt(-243.36)); // sqrt(-243.36) = 15.6i
        Complex c3 = new Complex(2.5, 13.1);
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equals(c3)); // true
        // Poniższe wywołanie - dla chętnych :)
        System.out.println(c1.equals("test ze zlym obiektem")); // false
        System.out.println();

        // Metoda zamieniająca liczbę na jej sprzężenie:
        c1.conjugate();
        System.out.println("c1* = " + c1); // c1* = 2.5 - 13.1i

        // Metoda zamieniająca liczbę na przeciwną:
        c1.opposite();
        System.out.println("-c1 = " + c1); // -c1 = -2.5 + 13.1i
    }

};



