import java.util.Random;

class Nave {
    protected String nome;
    protected int precisione;
    protected int potenza;
    protected int salute;

    public Nave(String nome, int precisione, int potenza, int salute) {
        this.nome = nome;
        this.precisione = precisione;
        this.potenza = potenza;
        this.salute = salute;
    }

    public String getNome() {
        return nome;
    }

    public int getPrecisione() {
        return precisione;
    }

    public int getPotenza() {
        return potenza;
    }

    public int getSalute() {
        return salute;
    }

    public void subisciDanno(int danno) {
        salute -= danno;
        if (salute < 0) {
            salute = 0;
        }
    }

    public void attacca(Nave nemico, int tipoAttacco, Random random) {
        if (random.nextInt(100) < precisione) {
            int danno = calcolaDanno(tipoAttacco);
            nemico.subisciDanno(danno);
            System.out.println(nome + " usa " + nomeAttacco(tipoAttacco) + " e infligge " + danno + " danni a " + nemico.getNome());
        } else {
            System.out.println(nome + " usa " + nomeAttacco(tipoAttacco) + " ma fallisce il colpo");
        }
    }

    protected int calcolaDanno(int tipoAttacco) {
        return potenza;
    }

    protected String nomeAttacco(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1:
                return "Cannoni";
            case 2:
                return "Ariete";
            case 3:
                return "Carico Esplosivo";
            default:
                return "Attacco Fallimentare";
        }
    }
}

class NavePirata extends Nave {
    public NavePirata(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1:
                return (int)(potenza * 1.2);
            case 2:
                return (int)(potenza * 0.8);
            case 3:
                return (int)(potenza * 1.5);
            default:
                return potenza;
        }
    }
}

class NaveVichinga extends Nave {
    public NaveVichinga(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1:
                return (int)(potenza * 1.0);
            case 2:
                return (int)(potenza * 1.5);
            case 3:
                return (int)(potenza * 1.2);
            default:
                return potenza;
        }
    }
}

class NaveCeleste extends Nave {
    public NaveCeleste(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1:
                return (int)(potenza * 1.3);
            case 2:
                return (int)(potenza * 0.9);
            case 3:
                return (int)(potenza * 1.4);
            default:
                return potenza;
        }
    }
}

class NaveFantasma extends Nave {
    public NaveFantasma(String nome, int precisione, int potenza, int salute) {
        super(nome, precisione, potenza, salute);
    }

    @Override
    protected int calcolaDanno(int tipoAttacco) {
        switch (tipoAttacco) {
            case 1:
                return (int)(potenza * 1.1);
            case 2:
                return (int)(potenza * 1.2);
            case 3:
                return (int)(potenza * 1.6);
            default:
                return potenza;
        }
    }
}
