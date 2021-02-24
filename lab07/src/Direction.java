public enum Direction{
    LEFT,
    RIGHT,
    UP,
    DOWN;

    private int x;
    private int y;

    Direction(){
        switch (name()) {
            case "LEFT" -> {
                x = 0;
                y = -1;
            }
            case "RIGHT" -> {
                x = 0;
                y = 1;
            }
            case "UP" -> {
                x = -1;
                y = 0;
            }
            case "DOWN" -> {
                x = 1;
                y = 0;
            }
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return "[" + x + ", " + y + "]";
    }
}