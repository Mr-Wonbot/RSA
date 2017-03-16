
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
    
    public Alice(BigInteger n, BigInteger d, BigInteger e)
    {
        this.n = n;
        this.d = d;
        this.e = e;
    }
    
    public BigInteger decrypt(BigInteger message) 
    {
        return message.modPow(d, n);
    }

    
}
