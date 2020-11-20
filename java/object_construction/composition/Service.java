package object_construction.composition;

/**
 * Class that demonstrates a HAS-A relationship for composition. For this example, both objects cannot exist without the other.
 * The Provider cannot be a Provider if there is no Service to give, A Service does not exist if there is nothing to distribute it.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.19
 * @see Provider
 */
class Service
{

    //Attribute
    private String serviceGiven;


    //Constructors
    protected Service() {}

    protected Service( String serviceGiven )
    {
        this.serviceGiven = serviceGiven;
    }


    //Getter & Setter
    protected String getServiceGiven() {
        return serviceGiven;
    }

    protected void setServiceGiven( String serviceGiven ) {
        this.serviceGiven = serviceGiven;
    }

}