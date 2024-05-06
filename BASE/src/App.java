import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean fine = false;
        int scelta;
        Scanner sc = new Scanner(System.in);
        Movimenti listaMov = new Movimenti();
        ContiCorrenti listaCC = new ContiCorrenti();
        do{
            System.out.println("cosa vuoi fare?\n\t1) Crea un CC\n\t2) Fai un movimento\n\t3) visualizza i tuoi movimenti\n\t4) Visualizza saldo CC\n\t5) Fine");
            scelta=sc.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Il nuovo CC ha il numero: "+listaCC.newCC());
                    break;
                case 2:
                    System.out.println("Inserisci la data");
                    String data=sc.next();
                    System.out.println("Inserisci il numero del CC");
                    int numCC=sc.nextInt();
                    System.out.println("Inserisci l'importo");
                    double importo=sc.nextDouble();
                    ContoCorrente ccMov = listaCC.getCC(numCC);
                    listaMov.addMovimento(data, ccMov, importo);
                    break;
                case 3:
                    System.out.println("Inserisci il numero del CC");
                    int nuCC=sc.nextInt();
                    System.out.println(listaMov.getMovimentiPerCC(nuCC));
                    break;
                case 4:
                    System.out.println("Inserisci il numero del CC");
                    int nCC=sc.nextInt();
                    System.out.println(listaCC.getStringCC(nCC));
                    break;
                case 5:
                    fine=true;
                    break;
                default:
                    break;
            }
        }while(!fine);
    }
}
