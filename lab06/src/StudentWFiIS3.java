public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;
    private StudentWFiIS3 student;


    public StudentWFiIS3(String _imie, String _nazwisko, int _id, int _rok, String _przed1, double _gr1, String _przed2, double _gr2, String _przed3, double _gr3)
    {
        super(_imie, _nazwisko, _id, _gr1, _gr2, _gr3);
        student = this;
        stud = new StudentUSOS()
        {
            @Override
            public String toString()
            {
                return "[" + _rok + "] " + _imie + " " + _nazwisko + ", id number: " + _id + ", grades: [" + _gr1 + ", " + _gr2 + ", " + _gr3 + "]";
            }

            @Override
            public double srednia()
            {
                return student.average();
            }

            @Override
            public void listaPrzedmiotow()
            {
                System.out.print("\t");
                System.out.println("1. " + _przed1 + " " + _gr1);
                System.out.print("\t");
                System.out.println("2. " + _przed2 + " " + _gr2);
                System.out.print("\t");
                System.out.println("3. " + _przed3 + " " + _gr3);
            }
        };
    }

    public String toString()
    {
        return stud.toString();
    }

    public double srednia()
    {
        return stud.srednia();
    }

    public void listaPrzedmiotow()
    {
        stud.listaPrzedmiotow();
    }


}