public class TesteData {
        
    public static void main(String[] args) {
        
        Data d1 = new Data( 29, 2, 2024 );
        Data d2 = new Data( 29, 2, 2025 );

        System.out.println( d1 );
        System.out.println( d2 );

        d1.setAno( 2000 );
        System.out.println( d1 );

        d1.setAno( -2000 );
        System.out.println( d1 );
 
    }

}
