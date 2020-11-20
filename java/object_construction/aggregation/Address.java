package object_construction.aggregation;

/**
 * Class that demonstrates a unidirectional relationship with Person. With this example, a Person HAS-AN Address.
 * Address does not HAS-A Person. However, both can exist independently from each other. As Address has multiple attributes,
 * it is its own object.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.19
 * @see Person
 */
class Address
{

    //Attributes
    private int number;
    private String street;
    private String city;


    //Constructors
    protected Address() {}

    protected Address( int number, String street, String city )
    {
        this.number = number;
        this.street = street;
        this.city = city;
    }


    //Getters & Setters
    protected int getNumber()
    {
        return number;
    }

    protected void setNumber( int number )
    {
        this.number = number;
    }

    protected String getStreet()
    {
        return street;
    }

    protected void setStreet( String street )
    {
        this.street = street;
    }

    protected String getCity()
    {
        return city;
    }

    protected void setCity( String city )
    {
        this.city = city;
    }

}