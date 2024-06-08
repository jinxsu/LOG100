import java.util.*;


public class LLPolynomial implements Polynomial {
    LinkedList<Term> listOfTerms = new LinkedList<>();
    @Override
    public boolean addTerm (Term t) {
        int size_before= listOfTerms.size ();
        listOfTerms.add (t);
        int size_after= listOfTerms.size ();
        return size_after > size_before;


    }

    @Override
    public boolean removeTerm (Term t) {
        for (int i = 0; i < listOfTerms.size() ; i++) {
            if (listOfTerms.get(i).equals(t)) {
                listOfTerms.remove(i);
                return true;
            }
        }

        return false;
    }
    public void sort() {

       Collections.sort ( listOfTerms, new TermComparator () );
    }

    @Override
    public int getTermCount ( ) {
        return listOfTerms.size();
    }

    @Override
    public List<Character> getVariables() {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < listOfTerms.size(); i++) {
            char variable = listOfTerms.get(i).getVariable();
            if (!list.contains(variable)) {
                list.add(variable);
            }
        }
        return list;
    }

    @Override
    public List<Integer> getExponents() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listOfTerms.size(); i++) {
            int exponent = listOfTerms.get(i).getExponent();
            if (!list.contains(exponent)) {
                list.add(exponent);
            }
        }
        return list;
    }

    @Override
    public List<Term> getTerms (char variable, int exponent) {
        List<Term> list = new ArrayList<> ();
        for (Term t : listOfTerms) {
            if (t.getVariable() == variable && t.getExponent() == exponent) {
                list.add(t);
            }
        }
        return list;
    }

    @Override
    public List<Term> getAllTerms ( ) {
      return listOfTerms;

    }

    @Override
    public String toString ( ) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < listOfTerms.size(); i++) {
            str.append(listOfTerms.get ( i ).toString());
            if(listOfTerms.get ( i )!=listOfTerms.getLast ())
            {
                if(listOfTerms.get ( i+1).getCoefficient ()>0)
                {
                    str.append("+");
                }
            }


        }
        return str.toString();
    }
}
