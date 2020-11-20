package object_construction.composition;

import java.util.List;

/**
 * Class that demonstrates a HAS-A relationship for composition. For this example, both objects cannot exist without the other.
 * The Provider cannot be a Provider if there is no Service to give, A Service does not exist if there is nothing to distribute it.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.19
 * @see Service
 */
class Provider
{

    //Attribute
    private List<Service> services;


    //Constructors
    protected Provider() {}

    protected Provider( List<Service> services )
    {
        this.services = services;
    }


    //Getter & Setter
    public List<Service> getServices()
    {
        return services;
    }

    public void setServices( List<Service> services )
    {
        this.services = services;
    }

}