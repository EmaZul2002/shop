import java.util.Random;
import java.util.Objects;

public class ContoCorrente {
    private int numCC;
    private double saldo;
    private int contatoreMovimenti;
    private static Random r = new Random();

    public ContoCorrente(){
        numCC= r.nextInt();
        if (numCC<0){
            numCC*=-1;
        }
        saldo=0;
        contatoreMovimenti=0;
    }

    public ContoCorrente(int numCC, double saldo, int contatoreMovimenti) {
        this.numCC = numCC;
        this.saldo = saldo;
        this.contatoreMovimenti = contatoreMovimenti;
    }

    public int getNumCC() {
        return this.numCC;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getContatoreMovimenti() {
        return this.contatoreMovimenti;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContoCorrente)) {
            return false;
        }
        ContoCorrente contoCorrente = (ContoCorrente) o;
        return numCC == contoCorrente.numCC && saldo == contoCorrente.saldo && contatoreMovimenti == contoCorrente.contatoreMovimenti;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCC, saldo, contatoreMovimenti);
    }

    @Override
    public String toString() {
        return "Numero Conto corrente: "+numCC+"\n\tSaldo: "+saldo+"\n\tNumero transazioni: "+contatoreMovimenti;
    }
    
    public void movimento(double importo){
        saldo+=importo;
        contatoreMovimenti++;               
    }

}
