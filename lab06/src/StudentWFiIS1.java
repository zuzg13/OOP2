public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty;
    private int rok;

    public StudentWFiIS1(String _imie, String _nazwisko, int _id, int _rok, String _przed1, double _gr1, String _przed2, double _gr2, String _przed3, double _gr3)
    {
        super(_imie, _nazwisko, _id, _gr1, _gr2, _gr3);
        przedmioty = new String[] {_przed1, _przed2, _przed3};
        rok = _rok;
    }

    @Override
    public String toString()
    {
        return "[" + rok + "] " + super.toString();
    }

    @Override
    public double srednia()
    {
        return super.average();
    }

    @Override
    public void listaPrzedmiotow()
    {
        for(int i=0;i<przedmioty.length;i++)
        {
            System.out.print("\t");
            System.out.println((i+1)+". "+przedmioty[i]+": "+getGrade(i));
        }
    }
}
