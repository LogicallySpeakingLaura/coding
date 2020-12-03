package object_construction.interfaces;

/**
 * Subclass to demonstrate how an Interface can be used for multiple inheritance.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.03
 * @see ./inheritance/Cylinder for a detailed description of this type of Class
 * @see Android for interface
 * @see Case for interface
 */
class Samsung extends Phone implements Android, Case //can use multiple interfaces, separate with a comma
{

    //Attributes
    private String model;
    private boolean isFoldable;


    //Constructors
    protected Samsung() {}

    protected Samsung( long serialNumber, long mobileNumber, boolean hasWarranty, String model, boolean isFoldable )
    {
        super( serialNumber, mobileNumber );
        this.model = model;
        this.isFoldable = isFoldable;
        hasWarranty = this.getWarranty(); //no point of local var as interface makes this constant
    }


    //Setters & Getters
    protected boolean getWarranty() //if there are attributes to access in interface can only use a getter
    {                               //no setter as they are constant
        return Case.HAS_WARRANTY;
    }

    protected String getModel()
    {
        return model;
    }

    protected void setModel( String model )
    {
        this.model = model;
    }

    protected boolean isFoldable()
    {
        return isFoldable;
    }

    protected void setFoldable( boolean foldable )
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
    public String[] getPlayStorePurchases() //these 5 methods inherited from 2 different interfaces and must be implemented
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