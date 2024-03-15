
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Hora implements Runnable {
    
    private JLabel hora, fecha;
    
    
    public Hora(JLabel hora, JLabel fecha) {
        this.hora = hora;
        this.fecha = fecha;
    }   

    @Override
    public void run() {
        while(true){
            Date h=new Date();
            DateFormat f=new SimpleDateFormat("hh:mm:ss");
            hora.setText( f.format(h) );
            DateFormat c= new SimpleDateFormat("dd/MM/YYYY");
            fecha.setText(c.format(h));
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                
            }
        }        
    }
}
