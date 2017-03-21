
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
public class Bob {
    
    public BigInteger convertToBit(String message)
    {
        BigInteger bitMessage = new BigInteger(message.getBytes());
        
        return bitMessage;
    }
    
    public BigInteger encryption(BigInteger message, BigInteger e, BigInteger n)
    {
        return message.modPow(e, n); 
    }

}
