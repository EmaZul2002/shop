import java.util.Random;
import java.util.Objects;

public class Movimento {
    private int numMovimento;
    private String data;
    private ContoCorrente CC;
    private double importo;
    private static Random r = new Random();

    public Movimento() {
    }

    public Movimento(String data, ContoCorrente CC, double importo) {
        this.numMovimento = r.nextInt();
        if (numMovimento<0){
            numMovimento*=-1;
        }
        this.data = data;
        this.CC = CC;
        this.importo = importo;
        CC.movimento(importo);
    }

    public int getNumMovimento() {
        return this.numMovimento;
    }

    public String getData() {
        return this.data;
    }

    public ContoCorrente getCC() {
        return this.CC;
    }

    public double getImporto() {
        return this.importo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Movimento)) {
            return false;
        }
        Movimento movimento = (Movimento) o;
        return numMovimento == movimento.numMovimento && Objects.equals(data, movimento.data) && Objects.equals(CC, movimento.CC) && importo == movimento.importo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numMovimento, data, CC, importo);
    }

    @Override
    public String toString() {
        return "Numero Movimento: "+numMovimento+"\n\tData: "+data+"\n\tNumero Conto Corente: "+CC.getNumCC()+"\n\tImporto: "+importo;
    }
    
}
