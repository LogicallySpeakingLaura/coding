package comparisons;

import java.util.Comparator;

/**
 * Class that demonstrates how to use the Comparator interface to compare two different objects.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.17
 * @see Liquid for compared object
 */
class CompareWeight implements Comparator<Liquid>
{

    @Override
    public int compare( Liquid l1, Liquid l2 )
    {
        return l1.getWeight() > l2.getWeight() ? 1 : //if first object weight bigger than second, return 1
                l1.getWeight() < l2.getWeight() ? -1 : //else return -1 if second bigger
                        0; //if both weights are the same return 0
    }

}