/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.awt.AWTEvent;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import views.viewPrincipal;
import views.viewVerificarSesion;

/**
 *
 * @author Gleycer
 */
public class CalcularInactividad {
viewPrincipal view;
viewVerificarSesion viewVerificarSesion;
int var = 0;


    public void setView(viewPrincipal view) {
        this.view = view;
    }

    
   public void obtenerEventos()  { 
    
    long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK
    + AWTEvent.MOUSE_EVENT_MASK
    + AWTEvent.KEY_EVENT_MASK;

Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener()
{

        @Override
        public void eventDispatched(AWTEvent event) {
            
            var = 0;
            
        }
 
}, eventMask);
     

                                  }
   
    public void calcularInactividad() {
     
   Timer timer = new Timer (600000, new ActionListener ()
{
    public void actionPerformed(ActionEvent e)
    {
        
        var++;
        if (var == 2) {
         viewVerificarSesion viewV = new viewVerificarSesion(new javax.swing.JFrame(), true, Dialog.ModalityType.APPLICATION_MODAL);
         viewV.setTxtUsuario(view.getUsuario());
         viewV.setVisible(true);
        
                      }
     }
});

timer.start();
                                    }
   
                             }
