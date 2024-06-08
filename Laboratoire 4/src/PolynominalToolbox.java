import java.util.ArrayList;
import java.util.List;

public class PolynominalToolbox {

    public static Polynomial simplify (Polynomial poly) {

        Polynomial result = new LLPolynomial ( );


        for ( Term term : poly.getAllTerms ( ) ) {
            List<Term> same = poly.getTerms ( term.getVariable ( ), term.getExponent ( ) );
            double coefficient = 0;

            for ( Term term2 : same ) {
                coefficient += term2.getCoefficient ( );

            }
            if (coefficient != 0) {
                result.addTerm ( new Term ( coefficient, term.getVariable ( ), term.getExponent ( ) ) );
            }

            for ( Term term2 : same ) {
                poly.removeTerm ( term2 );
            }
        }
        return result;


    }

    public static Polynomial sum (Polynomial poly1, Polynomial poly2) {

        Polynomial p1 = simplify ( poly1 );
        Polynomial p2 = simplify ( poly2 );
        Polynomial result = new LLPolynomial ( );

        for ( Term term : p1.getAllTerms ( ) ) {
            boolean found = false;
            for ( Term term2 : p2.getAllTerms ( ) ) {
                if (term.getVariable ( ) == term2.getVariable ( ) && term.getExponent ( ) == term2.getExponent ( )) {
                    double total = term.getCoefficient ( ) + term2.getCoefficient ( );
                    if (total != 0) {
                        result.addTerm ( new Term ( total, term.getVariable ( ), term.getExponent ( ) ) );
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.addTerm ( new Term ( term.getCoefficient ( ), term.getVariable ( ), term.getExponent ( ) ) );
            }
        }
        for ( Term term : p2.getAllTerms ( ) ) {
            boolean found = false;
            for ( Term term2 : p1.getAllTerms ( ) ) {
                if (term.getVariable ( ) == term2.getVariable ( ) && term.getExponent ( ) == term2.getExponent ( )) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.addTerm ( new Term ( term.getCoefficient ( ), term.getVariable ( ), term.getExponent ( ) ) );
            }
        }
        return result;
        // simplify at the end
        /*
        Polynomial result= new LLPolynomial();
       for(Term term: poly1.getAllTerms())
       {
        result.addTerm(term);
       }
       for(Term term: poly2.getAllTerms())
       {
        result.addTerm(term);
       }
       return simplify(result);

        */

    }
}
