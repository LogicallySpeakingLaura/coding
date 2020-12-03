package object_construction.interfaces;

/**
 * Standard abstract superclass used to demonstrate multiple inheritance with Interfaces.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.03
 * @see ./inheritance/Shape for a detailed description of this type of Class
 */
abstract class Phone
{

    //Attributes
    private long serialNumber;
    private long mobileNumber;


    //Constructors
    protected Phone() {}

    protected Phone( long serialNumber, long mobileNumber )
    {
        this.serialNumber = serialNumber;
        this.mobileNumber = mobileNumber;
    }


    //Setters & Getters
    protected long getSerialNumber()
    {
        return serialNumber;
    }

    protected void setSerialNumber( long serialNumber )
    {
        this.serialNumber = serialNumber;
    }

    protected long getMobileNumber()
    {
        return mobileNumber;
    }

    protected void setMobileNumber( long mobileNumber )
    {
        this.mobileNumber = mobileNumber;
    }



    //Methods
    protected abstract void powerOn();

    protected abstract void powerOff();

}