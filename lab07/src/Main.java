import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        int nx = Integer.parseInt(args[0]);
        int ny = Integer.parseInt(args[1]);
        double P = Double.parseDouble(args[2]);

        int i0 = nx - 2;
        int j0 = 1;
        Maze newmaze = new Maze(nx, ny, P);

        // Wypisywanie dostępnych opcji na ekran
        printOptions();

        newmaze.printMaze(newmaze.maze, nx, ny);
        System.out.println("\n");



        char z;
        System.out.print("Wybierz opcje: ");
        Scanner sc = new Scanner(System.in);
        z = sc.next().charAt(0);


        while (z != 'q')
        {
            switch (z)
            {
                case 'a' -> {
                    newmaze.nextStep(Direction.LEFT, i0, j0, newmaze.check, nx, ny);
                    i0 += Direction.LEFT.getX();
                    j0 += Direction.LEFT.getY();
                }
                case 'd' -> {
                    newmaze.nextStep(Direction.RIGHT, i0, j0, newmaze.check, nx, ny);
                    i0 += Direction.RIGHT.getX();
                    j0 += Direction.RIGHT.getY();
                }
                case 'w' -> {
                    newmaze.nextStep(Direction.UP, i0, j0, newmaze.check, nx, ny);
                    i0 += Direction.UP.getX();
                    j0 += Direction.UP.getY();
                }
                case 's' -> {
                    newmaze.nextStep(Direction.DOWN, i0, j0, newmaze.check, nx, ny);
                    i0 += Direction.DOWN.getX();
                    j0 += Direction.DOWN.getY();
                }
                case '0' -> {
                    newmaze = new Maze(nx, ny, P);
                    i0 = nx-2;
                    j0 = 1;
                }
            }
            printOptions();

            newmaze.printMaze(newmaze.maze, nx, ny);
            System.out.print("Wybierz opcje: ");
            z = sc.next().charAt(0);
        }
        sc.close();
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
