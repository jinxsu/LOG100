public class Driver {
    public static void main (String[] args) {
        Term t0 = new Term(3d, 'x', 2); // 3x^2
        Term t1 = new Term(-2d, 'y', 3); // –2y^3
        Term t2 = new Term(4d, 'x', 1); // 4x
        Term t3 = new Term(8d, ' ', 0); // 8

        System.out.println (t0);
        System.out.println (t1 );
        System.out.println (t2 );
        System.out.println (t3 );
    }
}