/**
 * class Man
 * represents man
 *
 *
 * @author Zuzanna Grzesik
 * @version 1.0
 */

abstract class Man {
    private final String name;
    private final String surname;

    Man(String _name, String _surname)
    {
        name = _name;
        surname = _surname;
    }

    /**
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return surname
     */
    public String getSurname()
    {
        return surname;
    }


    /**
     * create formatted string with information about object
     * @return created string
     */
    @Override
    public String toString()
    {
        return getName()+" "+getSurname();
    }

    abstract public Man compare(Man ob);

    /**
     * count average
     * @return average
     */
    public double average() {
        return 0.0;
    }
}






