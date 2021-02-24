import java.lang.reflect.Method;
import java.util.Arrays;

public class Calc {
    String[] userInput;
    double[] parameters;

    public Calc(String[] args){

        userInput = splitArgs(args[0]);
    }

    public void calculate()
    {
        Class<?> aClass;
        try
        {
             aClass = Class.forName("java.lang.Math");
             if(userInput.length > 3 || userInput.length == 1)
             {
                 System.err.println("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby.");
                 System.exit(0);
             }

            var types = new Class[userInput.length - 1];

            for (int i = 0; i < userInput.length - 1; i++)
            {
                types[i] = double.class;
            }

            parameters = new double[userInput.length - 1];

            try
            {
                for (int i = 0; i < userInput.length - 1; i++)
                {
                    parameters[i] = Double.parseDouble(userInput[i + 1]);
                }
            }
            catch(NumberFormatException e)
            {
                System.err.println("Argumenty funkcji musza byc liczbami!");
                System.exit(0);
            }

            Method m = null;

            try
            {
                m = aClass.getMethod(userInput[0], types);
            }
            catch(NoSuchMethodException e)
            {
                System.err.println("Nie ma takiej metody!");
                System.exit(0);
            }


            if (m.getParameterCount() == 1)
            {
                System.out.println("Wynik: " + m.invoke(m, parameters[0]));
            }
            else if (m.getParameterCount() == 2)
            {
                System.out.println("Wynik: " + m.invoke(m, parameters[0], parameters[1]));
            }
            else if (m.getParameterCount() == 3)
            {
                System.out.println("Wynik: " + m.invoke(m, parameters[0], parameters[1], parameters[2]));
            }
            else
            {
                System.err.println("Nie można obliczyc wyniku!");
                System.exit(0);
            }
        }
        catch(Exception e)
        {
            System.err.println("Niepoprawna funkcja");
        }






    }

    public static String[] splitArgs(String arg){
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }


}
