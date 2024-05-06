import java.util.ArrayList;

public class ContiCorrenti {
    
    private ArrayList<ContoCorrente> listaCC;
    public ContiCorrenti() {
        listaCC = new ArrayList<ContoCorrente>();
    }
    public int newCC(){
        ContoCorrente cc = new ContoCorrente();
        listaCC.add(cc);
        return cc.getNumCC();
    }
    public ContoCorrente getCC(int numCC){
        for (ContoCorrente cc : listaCC) {
            if (cc.getNumCC()==numCC){
                return cc;
            }
        }
        return null;
    }
    public String getStringCC(int numCC){
        for (ContoCorrente cc : listaCC) {
            if (cc.getNumCC()==numCC){
                return cc.toString();
            }
        }
        return null;
    }
}
