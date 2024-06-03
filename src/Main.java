

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
        System.out.println ( "Enter the operation you want to perform: " );
        System.out.println (" 1- Element Count" );
        System.out.println (" 2- Average" );
        System.out.println (" 3- Max value" );
        System.out.println (" 4- Min value" );

        if (args.length < 2) {
            System.out.println("Invalid operation " + (args.length > 0 ? args[0] : ""));
            return;
        }

        int operation;
        try {
            operation = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid operation " + args[0]);
            return;
        }
        double[] values = new double[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            values[i - 1] = Double.parseDouble(args[i]);
        }

        switch (operation) {
            case 1:
                System.out.println("Element Count: " + elemenCount(values));
                break;
            case 2:
                System.out.println("Average: " + average(values));
                break;
            case 3:

                System.out.println("Max: " + maxValue ( values )+ " Min: " + minValue ( values ) );
                break;
            default:
                System.out.println("Invalid operation " + operation);
                break;
        }
        }

    /**
     *
     * @param a
     * @param b
     * @return
     */

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

    /**
     *
     * @param matA
     * @param matB
     * @return
     */
    public static double[][] multiply(double[][] matA, double[][] matB) {
        int rows = matA.length;
        int columns = matB[0].length;

        double[][] answer;
        if (rows == matB[0].length) {
            answer = new double[rows][columns];
            for ( int i = 0; i < rows; i++ ) {
                double total = 0;
                for ( int j = 0; j < columns; j++ ) {
                    for ( int k = 0; k < matA[0].length; k++ ) {
                        total += matA[i][k] * matB[k][j];
                    }
                    answer[i][j] = total;


                }
            }

        } else {
            answer = new double[][]{{Double.NaN}};
        }
        return answer;

    }

    /**
     *
     * @param mat
     */
    public static void printMat(double[][] mat) {
        for (double[] row : mat) {
            System.out.print("[ ");
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }

    /**
     *
     * @param tab
     * @return
     */
    public static int elemenCount (double[] tab) {
        int count=0;

            for (double val : tab) {
                count += 1;
            }

        return count-1;
    }

    /**
     *  Il cherche la moyenne des valeurs du tableau et pour obtenir la quantite d'element, on utilise la fonction elemenCount()
     * @param tab tableu dans lequel on veut obtenir la moyenne
     * @return la moyenne
     */
    public static  double average(double[] tab)
    {

        double average=0;
            for (double val : tab) {
                average += val;
            }

        return average / elemenCount(tab);
    }

    /**
     *
     * @param tab tableau dans lequel on cherche la valeur maximale
     * @return la valeur maximale du tableau
     */
    public static double maxValue(double[] tab)
    {
        double max=Float.NEGATIVE_INFINITY;

            for (double val : tab) {
                if (val > max) {
                    max = val;
                }

            }

        return max;
    }

    /**
     * Trouve la valeur minimum du tableau et la retourne
     * @param tab tableau dans lequel on cherche la valeur minimale
     * @return la valeur min du tableau
     */
    public static double minValue(double[] tab)
    {
        double min=Float.MAX_VALUE;

            for (double val : tab) {
                if (val < min) {
                    min = val;
                }
            }

        return min;
    }
}
