/**
 * class Graduate
 *
 * @author Zuzanna Grzesik
 * @version 1.0
 */
class Graduate extends Student{

    private final String title;
    private final int grad_date;

    Graduate(String _title, String _name, String _surname, int _id, int gd, double gr1, double gr2, double gr3)
    {
        super(_name, _surname, _id, gr1, gr2, gr3);
        title = _title;
        grad_date = gd;
    }

    /**
     * create formatted string with information about object
     * @return created string
     */
    @Override
    public String toString()
    {
        return  title + " " + super.toString() + ", year of graduation: " + grad_date;
    }

}