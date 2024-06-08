import java.util.List;

public interface Polynomial {
    public boolean addTerm(Term t);
    public boolean removeTerm(Term t);
    public int getTermCount();

    public List<Character> getVariables();
    public List<Integer> getExponents();

    public List<Term> getTerms(char variable, int exponent);
    public List<Term> getAllTerms();

}

