
import java.math.BigInteger;
import java.util.Random;

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
    
    private BigInteger n, d, e, signature;
    private final int length = 1024;
    
    public Bob()
    {
        Random random = new Random();     
        
        //generates random number of 1024 bit length that are probably prime 
        BigInteger p = BigInteger.probablePrime(length, random); 
	BigInteger q = BigInteger.probablePrime(length, random);
        
        n = p.multiply(q); // public key   (p*q)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE))); // phi(n) = (p-1)(q-1)
        
        e = new BigInteger("3"); // public key
        while (phi.gcd(e).intValue() > 1) 
            e = e.add(new BigInteger("2"));
        
        d = e.modInverse(phi); // private key     e*d = 1(mod phi(n))...solve for d
    }
    
    public BigInteger getN() 
    {
        return n;
    }

    public BigInteger getE() 
    {
        return e;
    }

    public BigInteger getD() 
    {
        return d;
    }
    
    public BigInteger encrypt(BigInteger m) throws Exception 
    {
        if (m.compareTo(n) >= 0) 
            throw new Exception();
         else 
        {
            signature = m.modPow(d, n);
            return m.modPow(e, n);
        }
    }



}
