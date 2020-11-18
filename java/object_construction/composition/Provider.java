package object_construction.composition;

class Provider
{

    private Service service;

    protected Provider() {}

    protected Provider( Service service )
    {
        this.service = new Service( "product provided" );
    }

    protected Service getService() {
        return service;
    }

    protected void setService(Service service) {
        this.service = service;
    }
}
