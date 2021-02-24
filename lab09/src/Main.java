public class Main {
    public static void main(String[] args){

        Calc calculator;

        try{
            calculator = new Calc(args);
            calculator.calculate();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Nie podano nic do obliczenia!");
            System.exit(0);
        }

    }

}
