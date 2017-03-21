import java.util.Random;
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
public class Alice {
    
    private BigInteger n, d, e;
    private final int length = 1024;
    
    public Alice()
    {
        Random random = new Random();     
            
        //generates random number of 1024 bit length that are probably prime 
        BigInteger p = BigInteger.probablePrime(length, random); 
    	BigInteger q = BigInteger.probablePrime(length, random);
            
        n = p.multiply(q); // public key   (p*q)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE))); // phi(n) = (p-1)(q-1)

        e = new BigInteger("2"); // public key
        
        while (phi.gcd(e).intValue() > 1) 
            e = e.add(BigInteger.ONE);

       d = e.modInverse(phi); // private key     e*d = 1(mod phi(n))...solve for d
    }
    
     public BigInteger getPublicKey_N()
    {
        return n;
    }
    
    public BigInteger getPublicKey_E()
    {
        return e;
    }
    
    public BigInteger decrypt(BigInteger message) 
    {
        return message.modPow(d, n);
    }
    
    public String convertToString(BigInteger message)
    {
        return new String(message.toByteArray());
    }

    
}
