
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class Barra extends Thread{
    
    private JProgressBar barra;
    private boolean avanzar;
    private JTextArea texto;
    private File arch=null;

    public Barra(JProgressBar barra, JTextArea texto) {
        this.barra = barra;
        this.texto = texto;
        this.avanzar = true;
    }

    public File getArch() {
        return arch;
    }

    public void setArch(File arch) {
        this.arch = arch;
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
                try {
                    FileReader fr = null;
                    BufferedReader br = null;
                    fr = new FileReader(arch);
                    br = new BufferedReader(fr);
                    String linea;
                    texto.setText("");
                    
                    while((linea=br.readLine()) !=null  ){     
                            
                        texto.append(linea);
                        texto.append("\n");

                    }
                    br.close();
                    fr.close();
                    
                } catch (IOException e) {
                    
                }
            }             
 
            try {
                
                Thread.sleep(0);
                
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}
