
import java.math.BigInteger;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Won
 */

public class RSA_Main {
    
    public static void main(String[] args)
    
    {
        Bob _Bob = new Bob();
        Alice _Alice = new Alice();
        Noah _Noah = new Noah();
        
        String message = "m=93";
        
        ////////Bob to Alice...
        BigInteger bitMessage = _Bob.convertToBit(message);    
        
        BigInteger n = _Alice.getPublicKey_N();
        BigInteger e = _Alice.getPublicKey_E();
        
        BigInteger encryptedMessage = _Bob.encryption(bitMessage, e, n);
        BigInteger decryptedMessage =  _Alice.decrypt(encryptedMessage);
        String finalDecodedMessage = _Alice.convertToString(decryptedMessage);
        
        System.out.println("Alice received a message from Bob!\n The message says: " + finalDecodedMessage);
        
        
        ///////Bob to Noah...   
        
        n = _Noah.getPublicKey_N();
        e = _Noah.getPublicKey_E();
        
        encryptedMessage = _Bob.encryption(bitMessage, e, n);
        decryptedMessage =  _Noah.decrypt(encryptedMessage);
        finalDecodedMessage = _Noah.convertToString(decryptedMessage);
        
        System.out.println("Noah received a message from Bob!\n The message says: " + finalDecodedMessage);

        
    }
    
}
