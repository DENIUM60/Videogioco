import java.util.Random;

public class Nave {
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

    public int getSalute() {
        return salute;
    }

    public void subisciDanno(int danno) {
        salute -= danno;
        if (salute < 0) {
            salute = 0;
        }
    }

    public void recuperaSalute(int valore) {
        salute += valore;
    }

    public void modificaPrecisione(int valore) {
        precisione += valore;
    }

    public void attacca(Nave nemico, int tipoAttacco, Random random) {
        if (tipoAttacco == 0) {
            System.out.println(nome + " usa Attacco Fallimentare, ma non infligge danni!");
            return;
        }

        if (random.nextInt(100) < calcolaPrecisione(tipoAttacco)) {
            int danno = calcolaDanno(tipoAttacco);
            nemico.subisciDanno(danno);
            System.out.println(nome + " usa " + nomeAttacco(tipoAttacco) + " e infligge " + danno + " danni a " + nemico.getNome());
        } else {
            System.out.println(nome + " usa " + nomeAttacco(tipoAttacco) + " ma fallisce il colpo");
        }
    }

    protected int calcolaDanno(int tipoAttacco) {
        return tipoAttacco == 0 ? 0 : potenza;
    }

    protected int calcolaPrecisione(int tipoAttacco) {
        return precisione;
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
