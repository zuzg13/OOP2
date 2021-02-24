/**
 * class Student
 * represent student
 *
 * @author Zuzanna Grzesik
 * @version 1.0
 */
class Student extends Man{

    private final double[] grades;
    private final int id;

    Student(String _name, String _surname, int _id, double gr1, double gr2, double gr3)
    {
        super(_name, _surname);
        id = _id;
        grades = new double[3];
        grades[0] = gr1;
        grades[1] = gr2;
        grades[2] = gr3;
    }

    /**
     * compares averages of two students
     * @param ob another object to compare
     * @return object that has greater average
     */
    @Override
    public Man compare(Man ob) {
        if(!(ob instanceof Student))
            return null;

        Student b = (Student) ob;

        if(average() > b.average())
            return this;
        else
            return ob;
    }

    /**
     * create formatted string with information about object
     * @return created string
     */
    @Override
    public String toString()
    {
        return super.toString() + ", id number: "+id
                +", grades: ["+grades[0]+", "+grades[1]+", "+grades[2]+"]";
    }

    /**
     * count average of student
     * @return average
     */
    @Override
    public double average()
    {
        double sum=0;
        for (double grade : grades) sum += grade;

        return sum/grades.length;
    }
}