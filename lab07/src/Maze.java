import java.util.Random;

public class Maze {

    public char[][] maze;
    CheckStep check = (board, i0, j0, dir) -> maze[i0 + dir.getX()][j0 + dir.getY()] == ' ';

    public Maze(int x, int y, double P)
    {
        maze = new char[x][y];
        Random generator = new Random();

        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                double p = generator.nextDouble();
                if (i == 0 || j == 0 || i == x-1 || j == y-1)
                    maze[i][j] = 'X';
                else if (p < P)
                    maze[i][j] = 'X';
                else
                    maze[i][j] = ' ';
            }
        }

        maze[0][y - 2] = ' ';
        maze[x - 2][1] = 'o';
    }

    public void printMaze(char[][] maze, int x, int y)
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void nextStep(Direction dir, int i0, int j0, CheckStep check, int x, int y)
    {
        if (check.test(maze, i0, j0, dir))
        {
            maze[i0][j0] = ' ';
            maze[i0 + dir.getX()][j0 + dir.getY()] = 'o';

            if (maze[0][y - 2] == 'o')
            {
                System.out.println("GRATULACJE, WYGRALES!");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("NIE UDALO SIE WYKONAC TAKIEGO RUCHU.");
        }
    }


}