public class NavePirata extends Nave {
    public NavePirata(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1: return (int) (potenza * 1.2);
            case 2: return (int) (potenza * 0.8);
            case 3: return (int) (potenza * 1.5);
            default: return 0;
        }
    }

    @Override
    protected int calcolaPrecisione(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1: return (int) (precisione * 0.9);
            case 2: return (int) (precisione * 1.2);
            case 3: return (int) (precisione * 0.8);
            default: return precisione;
        }
    }
}
