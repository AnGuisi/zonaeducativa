package utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import views.viewDialogWithTime;

public class CuentaRegresiva 
{
viewDialogWithTime view;
int cuentaRegresiva = 60;

    public void setView(viewDialogWithTime view) {
        this.view = view;
    }

    public CuentaRegresiva() {
    }

        public void calcularCuentaRegresiva() {
     
   Timer timer = new Timer (1000, new ActionListener ()
{
    public void actionPerformed(ActionEvent e)
    {
        
        cuentaRegresiva--;
        view.setLabelTiempo(Integer.toString(cuentaRegresiva));
        if (cuentaRegresiva == 0) {
        view.dispose();
        
                      }
     }
});

timer.start();
                                    }
    }
