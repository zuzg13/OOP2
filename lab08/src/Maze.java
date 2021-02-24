import java.util.Random;

public class Maze {

    public char[][] maze;
    int mx, my;
    int x_win, y_win;

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
        mx = x - 2;
        my = 1;
        x_win = 0;
        y_win = y - 2;

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

    public void nextStep(Direction dir) throws WallException {
        if(maze[mx + dir.getX()][my + dir.getY()] == ' ')
        {
            maze[mx][my] = ' ';
            mx += dir.getX();
            my += dir.getY();
            maze[mx][my] = 'o';

            if (maze[x_win][y_win] == 'o')
            {
                System.out.println("GRATULACJE, WYGRALES!");
                System.exit(0);
            }
        }
        else
        {
            throw new WallException("Granica labiryntu lub ściana, nie można wykonać ruchu.");
        }
    }


}