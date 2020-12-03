package object_construction.interfaces;

/**
 * Subclass to demonstrate how an Interface can be used for double inheritance.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.03
 * @see ./inheritance/Cylinder for a detailed description of this type of Class
 * @see iOS for interface
 */
class iPhone extends Phone implements iOS //implements for reference to interface
{

    //Attributes
    private float model;
    private String colour;


    //Constructors
    protected iPhone() {}

    protected iPhone( long serialNumber, long mobileNumber, float model, String colour )
    {
        super( serialNumber, mobileNumber ); //serialNumber and mobileNumber inherited from Phone
        this.model = model;
        this.colour = colour;
    }


    //Setters & Getters
    public float getModel()
    {
        return model;
    }

    public void setModel( float model )
    {
        this.model = model;
    }

    protected String getColour()
    {
        return colour;
    }

    protected void setColour( String colour )
    {
        this.colour = colour;
    }


    //Inherited Methods
    @Override
    protected void powerOn()
    {
        //implementation...
    }

    @Override
    protected void powerOff()
    {
        //implementation...
    }

    @Override
    public String getOSName() //these 3 methods inherited from interface and must be implemented
    {
        //implementation...
        return null;
    }

    @Override
    public long getOSVersion()
    {
        //implementation...
        return 0;
    }

    @Override
    public String[] getAppStorePurchases()
    {
        //implementation...
        return new String[ 0 ];
    }

}