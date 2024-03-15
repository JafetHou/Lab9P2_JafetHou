
import javax.swing.JProgressBar;

public class Barra extends Thread{
    
    private JProgressBar barra;
    private boolean avanzar;

    public Barra(JProgressBar barra) {
        this.barra = barra;
        this.avanzar = true;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }
    
    @Override
    public void run(){
        
        while(avanzar){
            
            barra.setValue(barra.getValue()+1);
            
            if(barra.getValue()==10000000){
                    
                avanzar=false;
            }             
 
            try {
                
                Thread.sleep(0);
                
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}
