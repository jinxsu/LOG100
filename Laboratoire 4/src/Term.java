public class Term {
    private double coefficient;
    private char variable;
    private int exponent;
    public Term(double coefficient, char variable, int exponent) throws ZeroCoefficientException
    {
        if(coefficient==0.0)
        {
            throw new ZeroCoefficientException();
        }
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;
    }



    public double getCoefficient() {
        return coefficient;
    }
    public char getVariable() {
        return variable;
    }
    public int getExponent() {
        return exponent;
    }

    @Override
    public String toString ( ) {
        StringBuilder sb = new StringBuilder();
        if(variable!=' ')
        {
            sb.append(variable);
        }
        if(exponent!=0 && exponent!=1)
        {
            sb.append("^").append(exponent);
        }
        return coefficient+sb.toString();
    }
}
