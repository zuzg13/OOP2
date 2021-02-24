/**
 * class Dean
 * represents Dean
 *
 * @author Zuzanna Grzesik
 * @version 1.0
 */
class Dean extends Man{

    private final String title;
    private final int startdate;
    private final int enddate;

    Dean(String _title, String _name, String _surname, int _startdate, int _enddate)
    {
        super(_name, _surname);
        title = _title;
        startdate = _startdate;
        enddate = _enddate;
    }

    /**
     * create formatted string with information about object
     * @return created string
     */
    @Override
    public String toString()
    {
        return title + " " +  super.toString() + ", Dean of the Faculty from " + startdate + " to " + enddate + ".";
    }

    /**
     * compares two deans
     * @param ob another object to compare
     * @return object that has later cadention end date
     */
    @Override
    public Man compare(Man ob) {
        if(!(ob instanceof Dean))
            return null;

        Dean b = (Dean) ob;

        if(enddate > b.enddate)
            return this;
        else
            return ob;
    }

    /**
     * counts average, since Dean don't have any grades, prints information about it
     * @return average
     */
    @Override
    public double average()
    {
        System.out.print("  [Average not applicable]");
        return super.average();
    }
}