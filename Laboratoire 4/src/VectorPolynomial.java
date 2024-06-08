import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorPolynomial implements Polynomial {
    private Vector<Term> vector;
    public VectorPolynomial() {
        vector = new Vector<>();
    }
    @Override
    public boolean addTerm (Term t) {
        int size_before= vector.size ();
        vector.add (t);
        int size_after= vector.size ();
        return size_after > size_before;


    }

    @Override
    public boolean removeTerm (Term t) {
        for (int i = 0; i < vector.size() ; i++) {
            if (vector.get(i).equals(t)) {
                vector.remove(i);
                return true;
            }
        }

        return false;
    }
    public void sort() {

        Collections.sort ( vector, new TermComparator () );
    }

    @Override
    public int getTermCount ( ) {
        return vector.size();
    }

    @Override
    public List<Character> getVariables() {
        List<Character> list = new ArrayList<> ();
        for (int i = 0; i < vector.size(); i++) {
            char variable = vector.get(i).getVariable();
            if (!list.contains(variable)) {
                list.add(variable);
            }
        }
        return list;
    }

    @Override
    public List<Integer> getExponents() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vector.size(); i++) {
            int exponent = vector.get(i).getExponent();
            if (!list.contains(exponent)) {
                list.add(exponent);
            }
        }
        return list;
    }

    @Override
    public List<Term> getTerms (char variable, int exponent) {
        List<Term> list = new ArrayList<> ();
        for (Term t : vector) {
            if (t.getVariable() == variable && t.getExponent() == exponent) {
                list.add(t);
            }
        }
        return list;
    }

    @Override
    public List<Term> getAllTerms ( ) {
        return vector;

    }

    @Override
    public String toString ( ) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vector.size(); i++) {
            str.append(vector.get ( i ).toString());
            if(vector.get ( i )!=vector.lastElement ())
            {
                if(vector.get ( i+1).getCoefficient ()>0)
                {
                    str.append("+");
                }
            }

        }
        return str.toString();
    }
}
