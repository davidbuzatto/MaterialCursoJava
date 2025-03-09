import java.lang.reflect.Field;
import java.util.Arrays;

public class Exemplo {

    public static void main( String[] args ) {

        Data d = new Data();
        Class klass = d.getClass();

        System.out.println();
        System.out.println( d );

        System.out.println( klass.getName() );
        System.out.println( klass.getCanonicalName() );
        System.out.println( klass.getPackageName() );
        System.out.println( Arrays.toString( klass.getInterfaces() ) );

        try {
            for ( Field f : klass.getDeclaredFields() ) {
                System.out.println( f );
                System.out.println( f.getName() );
                if ( f.getName().equals( "dia" ) ) {
                    f.setAccessible( true );
                    System.out.println( f.get( d ) );
                    f.set( d, 1000 );
                }
            }
        } catch ( IllegalAccessException exc ) {
            exc.printStackTrace();
        }

        System.out.println( d );

    }

}