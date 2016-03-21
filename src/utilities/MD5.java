/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/**
 *
 * @author Gleycer
 */
public class MD5 {
   public static void MD5(String texto) throws Exception {

      
      MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
      md.update(texto.getBytes());
      byte[] digest = md.digest();

      // Se escribe byte a byte en hexadecimal
      for (byte b : digest) {
         System.out.print(Integer.toHexString(0xFF & b));
      }
      System.out.println();

      // Se escribe codificado base 64. Se necesita la librería
      // commons-codec-x.x.x.jar de Apache
      byte[] encoded = Base64.encodeBase64(digest);
      System.out.println(new String(encoded));
   }
}
