package dt;

public final class Truck extends Vehicle {

    private String[] materials;
    private long permit;
    private String company;
    public Truck ( String[] materials,long permit, String company,String ownerName, String ownerAddress, String brand, String model, String licencePlate, float value) throws VehicleException, TruckException {
        super ( ownerName, ownerAddress, brand, model, licencePlate, value );
        setMaterials ( materials );
        this.permit = permit;
        this.company = company;
        if(materials==null||materials.length==0||materials.length>this.materials.length)
        {
            throw new TruckException ( "materials" );
        }
        if(company.isEmpty ()||company.trim ().isEmpty ())
        {
            throw new VehicleException ( "company" );
        }
        if(permit==0)
        {
            throw new VehicleException ( "permit" );
        }


    }

    public String[] getMaterials ( ) {
        return materials;
    }

    public void setMaterials (String[] materials) {
        this.materials = new String[5];
        for (int i = 0; i < this.materials.length; i++) {
            if (i< materials.length){
                this.materials[i] = materials[i];
            }
            else{
                this.materials[i] = null;
            }


        }
//        if(materials.length == 0){
//            this.materials = new String[5];
//        }
//        if(materials.length == 5){
//            System.arraycopy ( materials, 0, this.materials, 0, this.materials.length  );
//        }
//        else {
//            System.arraycopy ( materials, 0, this.materials, 0, Math.min ( materials.length, 5 ) );
//        }


    }

    public long getPermit ( ) {
        return permit;
    }

    public void setPermit (long permit) {
        this.permit = permit;
    }

    public String getCompany ( ) {
        return company;
    }

    public void setCompany (String company) {
        this.company = company;
    }

    @Override
    public String toString ( ) {

        StringBuilder materialString = new StringBuilder ( );
        materialString.append ( "[" );

        for ( String material : getMaterials ( )) {
            if(material==null)
            {
                break;
            }
            materialString.append ( "/" ).append ( material ).append ( "/" );
        }
        materialString.append ("]");
        return super.toString ( )+ ( ", "+materialString +", "+getPermit ()+", "+getCompany ());
    }
    public static void main (String[] args) throws VehicleException {
        Truck truck= new Truck ( new String[]{"traffic cones", "sand", "wood", "furniture"}, 3003, "Griffintown","Jean Montagne", "1122 Peel", "Toyota", "Tundra", "RST 002", 45000.0F);
        System.out.println(truck);
        Truck truck1= new Truck ( new String[]{"traffic cones", "sand", "wood", "furniture", "plants", "hats"}, 3003, "Griffintown","Jean Montagne", "1122 Peel", "Toyota", "Tundra", "RST 002", 45000.0F );
        System.out.println(truck1);
        Truck truck2= new Truck ( new String[]{}, 3003, "Griffintown","Jean Montagne", "1122 Peel", "Toyota", "Tundra", "RST 002", 45000.0F );
        System.out.println(truck2);

    }
}
