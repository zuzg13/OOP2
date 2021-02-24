public enum Option {
    RESET,
    LEFT,
    RIGHT,
    UP,
    DOWN,
    EXIT;

    private char c;
    private String description;
    private Direction direction;


    Option(){
        switch (name()) {
            case "RIGHT" -> {
                c = 'd';
                description = "Przesuniecie w prawo";
                direction = Direction.RIGHT;
            }
            case "LEFT" -> {
                c = 'a';
                description = "Przesuniecie w lewo";
                direction = Direction.LEFT;
            }
            case "UP" -> {
                c = 'w';
                description = "Przesuniecie w gore";
                direction = Direction.UP;
            }
            case "DOWN" -> {
                c = 's';
                description = "Przesuniecie w dol";
                direction = Direction.DOWN;
            }
            case "RESET" -> {
                c = '0';
                description = "Resetowanie gry";
            }
            case "EXIT" -> {
                c = 'q';
                description = "Zakonczenie gry";
            }
        }
    }

    public char getChar()
    {
        return c;
    }

    public String getDescription()
    {
        return description;
    }

    public Direction getDirection()
    {
        return direction;
    }

    @Override
    public String toString(){
        if(c == '0' || c == 'q'){
            return "'" + getChar() + "' ==> opcja " + name() + ", opis: " + getDescription();
        }
        return "'" + getChar() + "' ==> opcja "+ name() + ", opis: " + getDescription() + ", wektor przesuniecia: " + getDirection();
    }
}