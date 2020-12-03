package object_construction.interfaces;

abstract class Phone
{//TODO comments

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