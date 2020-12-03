package object_construction.interfaces;

class Samsung extends Phone implements Android, Case
{//TODO comments

    //Attributes
    private String model;
    private boolean isFoldable;


    //Constructors
    protected Samsung() {}

    public Samsung( long serialNumber, long mobileNumber, String model, boolean isFoldable )
    {
        super( serialNumber, mobileNumber );
        this.model = model;
        this.isFoldable = isFoldable;
    }


    //Setters & Getters
    public String getModel()
    {
        return model;
    }

    public void setModel( String model )
    {
        this.model = model;
    }

    public boolean isFoldable()
    {
        return isFoldable;
    }

    public void setFoldable( boolean foldable )
    {
        isFoldable = foldable;
    }

    //Inherited Methods
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
    public String[] getPlayStorePurchases()
    {
        //implementation...
        return new String[ 0 ];
    }

    @Override
    public String getColour()
    {
        //implementation...
        return null;
    }

    @Override
    public String getBrand()
    {
        //implementation...
        return null;
    }

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

}