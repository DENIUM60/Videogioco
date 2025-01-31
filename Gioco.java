import java.util.Scanner;
import java.util.Random;

public class Gioco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Scegli una mappa per la battaglia:");
        System.out.println("1. Arcipelago Misterioso Bonus: Precisione +10");
        System.out.println("2. Mari Ghiacciati Malus: Potenza -5");
        System.out.println("3. Fosse delle Anime Perdute Bonus: Salute +20");

        int sceltaMappa = scanner.nextInt();

        int bonusPrecisione = 0;
        int malusPotenza = 0;
        int bonusSalute = 0;

        switch (sceltaMappa) {
            case 1:
                System.out.println("Hai scelto Arcipelago Misterioso");
                bonusPrecisione = 10;
                break;
            case 2:
                System.out.println("Hai scelto Mari Ghiacciati");
                malusPotenza = 5;
                break;
            case 3:
                System.out.println("Hai scelto Fosse delle Anime Perdute");
                bonusSalute = 20;
                break;
            default:
                System.out.println("Scelta non valida. Mappa priva di modificatori");
        }

        Nave[] navi = new Nave[4];
        navi[0] = new NavePirata("Capitan Zaffiro", 70 + bonusPrecisione, 50 - malusPotenza, 100 + bonusSalute);
        navi[1] = new NaveVichinga("Ragnar il Tempestoso", 60 + bonusPrecisione, 60 - malusPotenza, 110 + bonusSalute);
        navi[2] = new NaveCeleste("Helia la Custode", 80 + bonusPrecisione, 40 - malusPotenza, 80 + bonusSalute);
        navi[3] = new NaveFantasma("Ombra Silente", 65 + bonusPrecisione, 55 - malusPotenza, 90 + bonusSalute);

        System.out.println("\nScegli due navi per la battaglia:");

        for (int i = 0; i < navi.length; i++) {
            System.out.println((i + 1) + ". " + navi[i].getNome());
        }

        System.out.print("Prima nave: ");
        int scelta1 = scanner.nextInt() - 1;
        System.out.print("Seconda nave: ");
        int scelta2 = scanner.nextInt() - 1;
        Nave nave1 = navi[scelta1];
        Nave nave2 = navi[scelta2];

        System.out.println("\nInizia la battaglia tra " + nave1.getNome() + " e " + nave2.getNome() + "!");

        while (nave1.getSalute() > 0 && nave2.getSalute() > 0) {

            System.out.println("\nTurno di " + nave1.getNome() + ":");
            int tipoAttacco1 = scegliAttacco(scanner, nave1);
            nave1.attacca(nave2, tipoAttacco1, random);

            System.out.println("Vita di " + nave2.getNome() + ": " + nave2.getSalute());

            if (nave2.getSalute() <= 0) {
                System.out.println(nave2.getNome() + " è stato distrutto!");
                break;
            }

            eventoCasuale(random, nave1, nave2);

            System.out.println("\nTurno di " + nave2.getNome() + ":");
            int tipoAttacco2 = scegliAttacco(scanner, nave2);
            nave2.attacca(nave1, tipoAttacco2, random);

            System.out.println("Vita rimanente di " + nave1.getNome() + ": " + nave1.getSalute());

            if (nave1.getSalute() <= 0) {
                System.out.println(nave1.getNome() + " è stato distrutto!");
                break;
            }

            eventoCasuale(random, nave1, nave2);
        }

        if (nave1.getSalute() > 0) {
            System.out.println("\nLa battaglia è finita! Il vincitore è " + nave1.getNome());
        } else if (nave2.getSalute() > 0) {
            System.out.println("\nLa battaglia è finita! Il vincitore è " + nave2.getNome());
        } else {
            System.out.println("\nLa battaglia è finita! Entrambe le navi sono state distrutte");
        }

        scanner.close();
    }

    private static int scegliAttacco(Scanner scanner, Nave nave) {
        System.out.println("Scegli un tipo di attacco per " + nave.getNome() + ":");
        System.out.println("1. Cannoni");
        System.out.println("2. Ariete");
        System.out.println("3. Carico Esplosivo");
        int scelta = scanner.nextInt();
        return scelta;
    }

    private static void eventoCasuale(Random random, Nave nave1, Nave nave2) {
        int evento = random.nextInt(100);
        if (evento < 30) {
            int tipoEvento = random.nextInt(3) + 1;
            switch (tipoEvento) {
                case 1:
                    System.out.println("\nEvento: Tempesta Improvvisa");
                    System.out.println("La precisione di entrambe le navi diminuisce di 10");
                    nave1.precisione -= 10;
                    nave2.precisione -= 10;
                    break;
                case 2:
                    System.out.println("\nEvento: Trovato Tesoro Sommerso");
                    System.out.println("Entramble navi recuperano 20 punti salute");
                    nave1.salute += 20;
                    nave2.salute += 20;
                    break;
                case 3:
                    System.out.println("\nEvento: Scogli Nascosti");
                    System.out.println("Le navi subiscono 15 danni a causa di scogli affioranti");
                    nave1.subisciDanno(15);
                    nave2.subisciDanno(15);
                    break;
            }
        }
    }
}

