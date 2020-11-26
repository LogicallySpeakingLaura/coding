package sorts;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main( String[] args ) {
        Merge m = new Merge();

        ArrayList<String> str = new ArrayList<>();
        str.add( "c" );
        str.add( "a" );
        str.add( "g" );
        str.add( "z" );
        str.add( "b" );


        ArrayList<Integer> l = new ArrayList<>();
        l.add( 5 );
        l.add( 2 );
        l.add( 9 );
        l.add( 15 );
        l.add( 1 );

        int[] a = new int[] {5,2,9,15,1,20,0,8,13,4,7,21,6};

        String[] arr = new String[] {"c","a","g","z","b"};

        for ( String element : arr )
            System.out.print( element + ", ");
        System.out.println();
        m.sortObjectArray( arr );
        for ( String element : arr )
            System.out.print( element + ", ");

    }
}
