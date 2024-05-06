import java.util.ArrayList;

public class Movimenti {
    private ArrayList<Movimento> registroMovimenti;

    public Movimenti() {
        registroMovimenti = new ArrayList<Movimento>();
    }

    public void addMovimento(String data, ContoCorrente CC, double importo){
        Movimento m = new Movimento(data, CC, importo);
        registroMovimenti.add(m);
    }

    public String getMovimentiPerCC(int numCC){
        String s = "";
        for (Movimento movimento : registroMovimenti) {
            if (movimento.getCC().getNumCC()==numCC){
                s+=movimento.toString()+"\n";
            }
        }
        return s;
    }

}
