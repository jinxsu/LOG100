package dt;

public class VehicleException extends Exception {
    private String parameter;
    public VehicleException(String attribut)
    {
        this.parameter= attribut;

    }
    public String getParameter()
    {
        return this.parameter;
    }
}
