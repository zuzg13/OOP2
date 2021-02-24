public class StudentWFiIS2 implements StudentUSOS {
    private String[] przedmioty;
    private int rok;
    private Student stud;

    public StudentWFiIS2(String _imie, String _nazwisko, int _id, int _rok, String _przed1, double _gr1, String _przed2, double _gr2, String _przed3, double _gr3)
    {
        stud = new Student(_imie, _nazwisko, _id, _gr1, _gr2, _gr3);
        rok = _rok;
        przedmioty = new String[] {_przed1, _przed2, _przed3};
    }


    @Override
    public String toString()
    {
        return "[" + rok + "] " + stud.toString();
    }

    @Override
    public double srednia()
    {
        return stud.average();
    }

    @Override
    public void listaPrzedmiotow()
    {
        for (int i = 0; i < przedmioty.length; i++)
        {
            System.out.print("\t");
            System.out.println(i+1 + ". " + przedmioty[i] + ": " + stud.getGrade(i));
        }
    }
}
