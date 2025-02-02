public class NaveVichinga extends Nave {
    public NaveVichinga(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1: return (int) (potenza * 1.0);
            case 2: return (int) (potenza * 1.5);
            case 3: return (int) (potenza * 1.2);
            default: return 0;
        }
    }

    @Override
    protected int calcolaPrecisione(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1: return (int) (precisione * 1.1);
            case 2: return (int) (precisione * 0.9);
            case 3: return (int) (precisione * 1.0);
            default: return precisione;
        }
    }
}
