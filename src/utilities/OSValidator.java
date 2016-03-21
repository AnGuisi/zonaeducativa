/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import javax.swing.UIManager;

/**
 *
 * @author Gleycer
 */
public class OSValidator {
   
    private static String OS = System.getProperty("os.name").toLowerCase();

    public OSValidator() {
    }
 
	
	private static  boolean isWindows() {
 
		return (OS.indexOf("win") >= 0);
 
	}
 
	private static  boolean isMac() {
 
		return (OS.indexOf("mac") >= 0);
 
	}
 
	private static boolean isUnix() {
 
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
 
	}
 
	private static boolean isSolaris() {
 
		return (OS.indexOf("sunos") >= 0);
 
	}
        
        public void validarOS() {
        if (isWindows()) {
                 try{
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    }catch(Exception e){
                        e.printStackTrace();
                                       }
                                    }
         if (isUnix()) {
                          try{
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    }catch(Exception e){
                        e.printStackTrace();
                                       }
                                  }
                                  }
 
    
}
