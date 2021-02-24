import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanNum {

    public static void main(String[] args) {


        System.out.println("Podaj licze wieksza od 1:");
        Scanner sc = new Scanner(System.in);

        int nx;
        boolean flag = false;

        while(!flag)
        {
            try
            {
                try
                {
                    nx = sc.nextInt();
                }
                catch (InputMismatchException e)
                {
                    sc.next();
                    throw new WrongValue("Podaj liczbe calkowia");
                }

                if(nx < 2)
                {
                    throw new WrongValue(nx,"Zbyt mala wartosc nx");
                }
                flag = true;

            }
            catch (WrongValue val)
            {
                System.out.println("Blad: " + val + "!");
            }
        }

        sc.close();
    }
}
