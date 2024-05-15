import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //Question 1
        int[] tab = {3,2,8};
        int[] tab2 = {4,7,1};
        System.out.println ( sum ( tab,tab2 ));

        //Question 2
        double[][] tab3 = {{2,3},{4,5},{6,7}};
        double[][] tab4 = {{6,7},{8,9}};

        System.out.println ("Tab 3" );
        printMat ( tab3 );

        System.out.println ("Tab 4" );
        printMat ( tab4 );

        System.out.println ("Answer:" );
        printMat ( multiply ( tab3,tab4 ) );

        //Question 3
        Scanner sc = new Scanner (System.in);
        System.out.println ( "Enter the operation you want to perform: " );
        System.out.println (" 1- Element Count" );
        System.out.println (" 2- Average" );
        System.out.println (" 3- Max value" );
        System.out.println (" 4- Min value" );

        int data= sc.nextInt ( );

        switch (data)
        {
            case 1: elemenCount ( tab3 );
                break;
            case 2: average ( tab3 );
                break;
            case 3: maxValue ( tab3 );
                break;
            case 4: minValue ( tab3 );
                break;
            default:
                System.out.println ("Invalid value" );
                break;
        }



    }
    public static int sum(int[] a, int[] b){
        int value1=0;
        int value2=0;
        for ( int i = 0, aLength = a.length; i < aLength; i++ ) {

            value1 += ( int ) ( a[i] * Math.pow ( 10, ( ( a.length - i ) - 1 ) ) );
        }
        for ( int i = 0; i < b.length; i++ ) {

            value2 += ( int ) ( b[i]* Math.pow ( 10, ( ( b.length - i ) - 1 ) ) );
        }
        return value1+value2;
    }
    public static double[][] multiply(double[][] matA, double[][] matB)
    {
        int rows=Math.min (matA.length, matB.length);
        int columns=Math.min (matA[0].length, matB[0].length);

        double [][] answer = new double[rows][columns];
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < columns; j++ ) {

                answer[i][j] += matA[i][j] * matB[i][j];

            }
        }

        return answer;

    }
    public static void printMat(double[][] mat) {
        for (double[] row : mat) {
            System.out.print("[ ");
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }

    public static int elemenCount (double[][] tab) {
        int count=0;
        for (double[] row : tab) {
            for (double val : row) {
                count += 1;
            }
        }
        return count;
    }
    public static  double average(double[][] tab)
    {

        double average=0;
        for (double[] row : tab) {
            average += row[0];
            for (double val : row) {
                average += val;
            }
        }
        return average / elemenCount(tab);
    }
    public static double maxValue(double[][] tab)
    {
        double max=-100000;
        for (double[] row : tab) {
            for (double val : row) {
                if (val > max) {
                    max = val;
                }

            }
        }
        return max;
    }
    public static double minValue(double[][] tab)
    {
        double min=-100000;
        for (double[] row : tab) {
            for (double val : row) {
                if (val < min) {
                    min = val;
                }
            }
        }
        return min;
    }
}
