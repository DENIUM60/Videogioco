public class NaveFantasma extends Nave {
    public NaveFantasma(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1: return (int) (potenza * 1.1);
            case 2: return (int) (potenza * 1.2);
            case 3: return (int) (potenza * 1.6);
            default: return 0;
        }
    }

    @Override
    protected int calcolaPrecisione(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1: return (int) (precisione * 1.0);
            case 2: return (int) (precisione * 0.8);
            case 3: return (int) (precisione * 1.4);
            default: return precisione;
        }
    }
}
