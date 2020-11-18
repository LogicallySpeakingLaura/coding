package comparisons;

/**
 * Class that demonstrates how to use the Comparable interface to compare two different objects.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.17
 */
class Liquid implements Comparable<Liquid> //need to implement Comparable interface and specify object type
{

    //Attributes
    private int volume;
    private int weight;


    //Constructors
    protected Liquid() {}

    protected Liquid( int volume, int weight )
    {
        this.volume = volume;
        this.weight = weight;
    }


    //Comparisons
    @Override
    public int compareTo( Liquid that ) //can only compare one attribute within class construction
    {
        return this.getVolume() > that.getVolume() ? 1 : //if current object volume bigger than compared, return 1
                this.getVolume() < that.getVolume() ? -1 : //else return -1 if compared bigger
                        0; //if both volumes are the same return 0
    }


    //Getters & Setters
    public int getVolume()
    {
        return volume;
    }

    public void setVolume( int volume )
    {
        this.volume = volume;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight( int weight )
    {
        this.weight = weight;
    }

}