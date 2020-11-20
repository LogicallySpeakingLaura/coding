package object_construction.aggregation;

/**
 * Class that demonstrates a unidirectional relationship with Address. With this example, a Person HAS-AN Address.
 * Address does not HAS-A Person. However, both can exist independently from each other.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.19
 * @see Address
 */
class Person
{

    //Attributes
    private int age;
    private String name;
    private Address address;


    //Constructors
    protected Person() {}

    protected Person( int age, String name, Address address ) //if there is no address, can be constructed with null
    {
        this.age = age;
        this.name = name;
        this.address = address;
    }


    //Getters & Setters
    public int getAge()
    {
        return age;
    }

    public void setAge( int age )
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }

}