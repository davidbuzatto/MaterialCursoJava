import java.util.Arrays;
import java.util.Comparator;

public class Exemplo {

    private static class Pessoa {
        String nome;
        int idade;
        Pessoa( String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }
        @Override
        public String toString() {
            return nome + " " + idade;
        }
    }

    private static class ComparadorPessoas implements Comparator<Pessoa> {

        @Override
        public int compare( Pessoa o1, Pessoa o2 ) {
            return o1.nome.compareTo( o2.nome );
        }

    }

    public static void main( String[] args ) {
        
        Pessoa[] pessoas = {
            new Pessoa( "David", 40 ),
            new Pessoa( "Fernanda", 41 ),
            new Pessoa( "Aurora", 5 )
        };

        System.out.println();
        for ( Pessoa p : pessoas ) {
            System.out.println( p );
        }

        // versão com a instância do comparador definido acima
        //Arrays.sort( pessoas, new ComparadorPessoas() );
        
        // versão com a instância de uma classe interna anônima
        /*Arrays.sort( pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare( Pessoa o1, Pessoa o2 ) {
                return o1.nome.compareTo( o2.nome );
            }
        });*/

        // versão passando uma expressão lambda
        Arrays.sort( pessoas, ( o1, o2 ) -> {
            return o1.nome.compareTo( o2.nome );
        });

        System.out.println();
        for ( Pessoa p : pessoas ) {
            System.out.println( p );
        }

    }

}