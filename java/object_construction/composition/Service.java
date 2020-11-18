package object_construction.composition;

class Service
{

    private String serviceGiven;

    protected Service() {}

    protected Service( String serviceGiven )
    {
        this.serviceGiven = serviceGiven;
    }

    protected String getServiceGiven() {
        return serviceGiven;
    }

    protected void setServiceGiven(String serviceGiven) {
        this.serviceGiven = serviceGiven;
    }

}