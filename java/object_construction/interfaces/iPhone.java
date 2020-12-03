package object_construction.interfaces;

class iPhone extends Phone implements iOS
{//TODO comments

    //Attributes
    private float model;
    private String colour;


    //Constructors
    protected iPhone() {}

    protected iPhone( long serialNumber, long mobileNumber, float model, String colour )
    {
        super( serialNumber, mobileNumber );
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
    public String getOSName()
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