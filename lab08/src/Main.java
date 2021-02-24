import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        int nx = Integer.parseInt(args[0]);
        int ny = Integer.parseInt(args[1]);
        double P = Double.parseDouble(args[2]);

        Maze newmaze = new Maze(nx, ny, P);

        // Wypisywanie dostępnych opcji na ekran
        printOptions();

        newmaze.printMaze(newmaze.maze, nx, ny);
        System.out.println("\n");


        char z;
        System.out.print("Wybierz opcje: ");
        Scanner sc = new Scanner(System.in);
        z = sc.next().charAt(0);
        Option option;


        while (z != 'q')
        {

            try
            {
                option = selectOption(z);
            }
            catch (OptionNotRecognizedException e)
            {
                System.out.println(e);
                printOptions();
                continue;
            }


            if(option == Option.RESET)
            {
                newmaze = new Maze(nx, ny, P);
                continue;
            }


            try
            {
                newmaze.nextStep(option.getDirection());
            }
            catch (WallException e)
            {
                System.out.println(e);
            }


           printOptions();

            newmaze.printMaze(newmaze.maze, nx, ny);
            System.out.print("Wybierz opcje: ");
            z = sc.next().charAt(0);
        }
        sc.close();
    }

    private static Option selectOption(char znak) throws OptionNotRecognizedException{
        return switch (znak) {
            case 'd' -> Option.RIGHT;
            case 'w' -> Option.UP;
            case 's' -> Option.DOWN;
            case 'a' -> Option.LEFT;
            case '0' -> Option.RESET;
            case 'q' -> Option.EXIT;
            default -> throw new OptionNotRecognizedException("Nie ma takiej opcji! Wybierz jedną z dostępnych opcji.");
        };

    }

    public static void printOptions()
    {
        System.out.println("Dostepne opcje:");
        System.out.println(Option.RESET.toString());
        System.out.println(Option.LEFT.toString());
        System.out.println(Option.RIGHT.toString());
        System.out.println(Option.UP.toString());
        System.out.println(Option.DOWN.toString());
        System.out.println(Option.EXIT.toString() + "\n");
    }
}
