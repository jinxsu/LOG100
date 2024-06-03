package dt;

public final class Suv  extends Vehicle{
    private byte capacity;
    private byte childSeatCount;
    private byte airbagCount;

    public Suv (byte capacity, byte childSeatCount,byte airbagCount,
                String ownerName, String ownerAddress, String brand,
                String model, String licencePlate, float value) throws VehicleException {

        super ( ownerName, ownerAddress, brand, model, licencePlate, value );

        if(capacity <= 0)
        {
            throw new VehicleException ( "capacity" );
        }
        if(childSeatCount <= 0 )
        {
            throw new VehicleException ( "childSeatCount" );
        }
        if(airbagCount <= 0 )
        {
            throw new VehicleException ( "airbagCount" );
        }

        this.capacity = capacity;
        this.childSeatCount = childSeatCount;
        this.airbagCount = airbagCount;
    }

    public byte getCapacity ( ) {
        return capacity;
    }

    public void setCapacity (byte capacity)  {

        this.capacity = capacity;
    }

    public byte getChildSeatCount ( ) {
        return childSeatCount;
    }

    public void setChildSeatCount (byte childSeatCount)  {

        this.childSeatCount = childSeatCount;
    }

    public byte getAirbagCount ( ) {
        return airbagCount;
    }

    public void setAirbagCount (byte airbagCount) {

        this.airbagCount = airbagCount;
    }

    @Override
    public String toString ( ) {
        return super.toString ( )+ (", "+getCapacity ()+", "+getChildSeatCount ()+", "+getAirbagCount ());
    }

    public static void main (String[] args)  {
        try{
            Suv cheapSuv = new Suv ( ( byte ) 5, ( byte ) 4, ( byte ) 2, "Jeanne Tremblay", "1100 Notre-Dame", "Fiat", "500X", "ABC 123", 25000.F );
            Suv mediumSuv = new Suv ( ( byte ) 7, ( byte ) 2, ( byte ) 2, "Pierre Maisonneuve", "", "Honda", "Odyssey", "FHG 789", 36000.f );
            Suv expensiveSuv = new Suv ( ( byte ) 8, ( byte ) 2, ( byte ) 2, "Justin Levesque", "1400 McGill", "BMW", "X6", "", 74000.f );
            System.out.println ( cheapSuv );
            System.out.println ( mediumSuv );
            System.out.print ( expensiveSuv );
        }catch(VehicleException ve){
            System.out.println ( );
            System.err.println ("Error with Vehicle constructor parameter "+ ve.getParameter());
        }



    }

}

