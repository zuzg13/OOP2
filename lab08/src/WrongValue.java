public class WrongValue extends Exception{

    public WrongValue(String str)
    {
        super(str);
    }

    public WrongValue(int nx, String str)
    {
        super(str + ": " + nx);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
