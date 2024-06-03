public class Grade {

    private String department;
    private int courseNum;
    private float percent=0F;
    private char letter='E';
    private static int instanceCount=0;

    public Grade() {
        instanceCount++;
    }

    /**
     *
     * @param dept
     * @param courseNum
     */
    public Grade(String dept, int courseNum) {
        this.department=dept;
        this.courseNum=courseNum;
        instanceCount++;
    }

    /**
     *
     * @param dept
     * @param courseNum
     * @param percent
     */
    public Grade(String dept, int courseNum, float percent) {
        this.department=dept;
        this.courseNum=courseNum;
        this.percent=percent;
        this. letter= convertPercentageToLetter(percent);
        instanceCount++;
    }

    /**
     *
     * @param dept
     * @param courseNum
     * @param letter
     */
    public Grade(String dept, int courseNum, char letter) {
        this.department=dept;
        this.courseNum=courseNum;
        this.letter=letter;
        this.percent=convertLetterToPercent(letter);
        instanceCount++;
    }

    public String getDepartment ()
    {
        return this.department;
    }
    public int getCourseNum()
    {
        return this.courseNum;
    }
    public float getPercent()
    {

        return this.percent;
    }
    public char getLetter()
    {
        return this.letter;
    }

    public static int getInstanceCount()
    {
        return instanceCount;
    }

    /**
     *
     * @param percent
     * @return
     */
    private char convertPercentageToLetter( float percent)
    {
        char letter;

        if(percent>=75 && percent<=100)
        {
            letter='A';
        }
        else if( percent>=66 && percent<75)
        {
            letter='B';
        }
        else if( percent>=57 && percent<66)
        {
            letter='C';
        }
        else if( percent>=50 && percent<57)
        {
            letter='D';
        }
        else{
            letter='E';
        }
        return letter;

    }

    /**
     *
     * @param letter
     * @return
     */
    private float convertLetterToPercent( char letter)
    {
        float percent;

        if(letter=='A')
        {
            percent=(float)(75+100)/2;
        }
        else if(letter=='B')
        {
            percent=(float)(66+75)/2;
        }
        else if(letter=='C')
        {
            percent=(float)(57+66)/2;
        }
        else if(letter=='D')
        {
            percent=(float)(50+57)/2;
        }
        else
        {
            percent=(float)(0+50)/2;

        }
        // peut se faire avec un switch case aussi
        /*
        percent = switch (letter) {
            case 'A' -> ( float ) ( 75 + 100 ) / 2;
            case 'B' -> ( float ) ( 66 + 75 ) / 2;
            case 'C' -> ( float ) ( 57 + 66 ) / 2;
            case 'D' -> ( float ) ( 50 + 57 ) / 2;
            default -> ( float ) ( 0 + 50 ) / 2;
        };

         */

        return percent;

    }

    /**
     *
     * @return
     */
    public String convertToString(){
        return ( getDepartment ()+getCourseNum()+" "+getLetter()+" "+getPercent());
    }
    public static void main(String[]args)
    {  Grade g1= new Grade("LOG", 100, 'A');
        System.out.println(g1.convertToString());
        Grade g2= new Grade("GTI", 121, 68.5F );
        System.out.println(g2.convertToString());
        Grade g3= new Grade("LOG", 121);
        System.out.println( g3.convertToString());
        Grade g4= new Grade("LOG", 320, 'B');
        System.out.println(g4.convertToString());
        Grade g5= new Grade("MAT", 144, 57F);
        System.out.println(g5.convertToString());
        Grade g6= new Grade("MAT", 210, 'E');
        System.out.println( g6.convertToString());
        Grade g7= new Grade("MAT", 350, 74.99F);
        System.out.println(g7.convertToString());
    }




}