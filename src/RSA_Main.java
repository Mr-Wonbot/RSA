
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
    
    public static void main(String[] args) throws Exception
    
    {
        
        String message = "m=93"; // message to send
        BigInteger bitMessage = new BigInteger(message.getBytes()); //convert message to bits
        BigInteger EncryptedMessage;
        String DecryptedMessage = "";
        Bob _Bob = new Bob();
        
        
        BigInteger n = _Bob.getN();
        BigInteger d = _Bob.getD();
        BigInteger e = _Bob.getE();
        
        Alice _Alice = new Alice(n,d,e); // Create Alice object that takes n and d as arguments
        
        EncryptedMessage = _Bob.encrypt(bitMessage); //Call encrypt method and passes bitMessage as an arguement
        
        bitMessage = _Alice.decrypt(EncryptedMessage);//Calls decrypt method and passess the above variable as an argument
        
        DecryptedMessage = new String(bitMessage.toByteArray()); //Converts bit back to String
        
        System.out.println("Alice received a message from Bob!\n The message says: " + DecryptedMessage);
        
        /////////////////////////////////Next process is from Bob to Noah
        message = "Emacs sucks!";
        bitMessage = new BigInteger(message.getBytes());
        Bob _Bob2 = new Bob();
        n = _Bob2.getN();
        d = _Bob2.getD();
        e = _Bob2.getE();
        
        Noah _Noah = new Noah(n,d,e);
        
        EncryptedMessage = _Bob2.encrypt(bitMessage);
        
        bitMessage = _Noah.decrypt(EncryptedMessage);
        
        DecryptedMessage = new String(bitMessage.toByteArray());
        
        System.out.println("Noah received a message from Bob!\n The message says: " + DecryptedMessage);
        
    }
    
}
