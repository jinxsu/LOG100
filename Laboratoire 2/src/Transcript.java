public class Transcript {

    public static String getReport(Grade[] grades)
    {
        StringBuilder reportCard = new StringBuilder();
        float mean=0F;

        for(Grade grade: grades)
        {
            reportCard.append(grade.convertToString()).append("\n");
            mean+=grade.getPercent();
        }

        reportCard.append("Mean: ").append(mean/grades.length);
        return reportCard.toString();
    }

    public static String getReport(Grade[] grades, String department)
    {
        StringBuilder reportCard = new StringBuilder();
        int count=0;
        float mean=0F;

        for(Grade grade: grades)
        {
            if(grade.getDepartment ( ).equals(department))
            {
                reportCard.append(grade.convertToString()).append("\n");
                mean+=grade.getPercent();
                count++;


            }


        }
        reportCard.append("Mean: ").append(mean/count);

        return reportCard.toString();

    }
    public static void main(String[] args)
    {
        Grade[] myGrades = new Grade[]{
                new Grade("LOG", 100, 'A'),
                new Grade("GTI", 121, 68.5F ),
                new Grade("LOG", 121),
                new Grade("LOG", 320, 'B'),
                new Grade("MAT", 144, 57F),
                new Grade("MAT", 210, 'E'),
                new Grade("MAT", 350, 74.99F)
        };
        System.out.println( getReport(myGrades));
        System.out.println ( );
        System.out.println (getReport(myGrades, "LOG") );
        System.out.println ( );
        System.out.println (getReport(myGrades, "MAT") );
        System.out.println ( );
        System.out.println (Grade.getInstanceCount() );
    }

}
