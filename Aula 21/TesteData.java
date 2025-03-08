import java.util.Arrays;

public class TesteData {
        
    public static void main(String[] args) {
        
        Data[] datas = new Data[]{
            new Data( 8, 3, 2025 ),
            new Data( 3, 3, 2025 ),
            new Data( 10, 4, 2025 ),
            new Data( 1, 10, 2020 )
        };

        System.out.println();
        for ( Data d : datas ) {
            System.out.println( d );
        }

        ordenar( datas );
        // ou
        // Arrays.sort( datas );
        System.out.println();

        for ( Data d : datas ) {
            System.out.println( d );
        }
 
    }

    public static void ordenar( Data[] datas ) {

        for ( int i = 0; i < datas.length; i++ ) {
            for ( int j = 0; j < datas.length - 1; j++ ) {
                if ( datas[j].compareTo( datas[j+1] ) > 0 ) {
                    Data t = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = t;
                }
            }
        }

    }

}
