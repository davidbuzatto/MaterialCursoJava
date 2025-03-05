public class Data {
    
    private static final int[] DIAS_DO_MES = { 
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        this( 1, 1, 1970 );
    }

    public Data( int dia, int mes, int ano ) {
        setMes( mes );
        setAno( ano );
        setDia( dia );
    }

    @Override
    public String toString() {
        return String.format( "%02d/%02d/%04d", dia, mes, ano );
    }

    public int getDia() {
        return dia;
    }

    public void setDia( int dia ) {

        int diasDoMes = DIAS_DO_MES[mes-1];

        if ( mes == 2 && anoEhBissexto() ) {
            diasDoMes++;
        }

        if ( dia < 1 || dia > diasDoMes ) {
            this.dia = 1;
        } else {
            this.dia = dia;
        }
        
    }

    public int getMes() {
        return mes;
    }

    public void setMes( int mes ) {
        if ( mes < 1 || mes > 12 ) {
            this.mes = 1;
        } else {
            this.mes = mes;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno( int ano ) {
        if ( ano <= 0 ) {
            this.ano = 1970;
        } else {
            this.ano = ano;
        }
    }

    public boolean anoEhBissexto() {
        return ( ano % 400 == 0 ) || ( ano % 4 == 0 && ano % 100 != 0 );
    }

}
