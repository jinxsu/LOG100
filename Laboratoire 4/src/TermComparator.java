import java.util.Comparator;

public class TermComparator implements Comparator<Term> {
    @Override
    public int compare (Term o1, Term o2) {
        if(o1.getVariable ()!= o2.getVariable())
        {
            if(o1.getVariable ()==' ')
            {
                return 1;
            }
            if (o2.getVariable ( ) == ' ') {
                return -1;
            }
            return Character.compare (o1.getVariable (), o2.getVariable ());
        }
        return Integer.compare ( o2.getExponent (), o1.getExponent () );

    }
}
