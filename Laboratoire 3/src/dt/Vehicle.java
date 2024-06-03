package dt;

public class Vehicle {
    private String ownerName;
    private String ownerAddress;
    protected String brand;
    protected String model;
    protected String licencePlate;
    protected float value;
    protected Vehicle(String ownerName, String ownerAddress, String brand, String model, String licencePlate, float value) throws VehicleException {
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.brand = brand;
        this.model = model;
        this.licencePlate = licencePlate;
        this.value = value;

        if(ownerName.isEmpty ())
        {
            throw new VehicleException("Owner name ");
        }
        if(ownerAddress.isEmpty ())
        {
            throw new VehicleException("Owner address ");
        }
        if(brand.isEmpty ())
        {
            throw new VehicleException("Brand");
        }
        if(model.isEmpty ())
        {
            throw new VehicleException("Model");
        }
        if(licencePlate.isEmpty ())
        {
            throw new VehicleException("Licence plate");
        }

    }
    public String getOwnerName ( ) {
        return ownerName;
    }

    public void setOwnerName (String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress ( ) {
        return ownerAddress;
    }

    public void setOwnerAddress (String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public float getValue ( ) {
        return value;
    }

    @Override
    public String toString ( ) {
        return (getOwnerName ()+ ", " + getOwnerAddress()+", "+this.brand+", "+this.model+", "+this.licencePlate+", "+this.value);
    }


    public static void main (String[] args) throws VehicleException {
        Vehicle vehicle=new Vehicle ( "Jean Tremblay", "1100 Notre-Dame", "Peugeot", "508", "ABC 123", 20000.0F );
        System.out.println (vehicle );
        vehicle.setOwnerName ( "Sam Tremblay" );
        System.out.println (vehicle );
        vehicle.setOwnerAddress ( "1100 Notre-Dame" );
        System.out.println (vehicle );

    }


}