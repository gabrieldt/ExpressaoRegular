/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressaoregular;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author gabriel
 */
public class TesteExpressaoRegular
{
    @Test
    public void teste()
    {
        String expressao ="teste minha rotina";
        String texto_a_ser_verificado = "## teste minha rotina ##";
        
        ExpressaoRegular expReg = new ExpressaoRegular(texto_a_ser_verificado, expressao);
        
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("a.c");
        expReg.setTexto_a_ser_verificado("abc");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular(".");
        expReg.setTexto_a_ser_verificado("aab");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("a.c.");
        expReg.setTexto_a_ser_verificado("axci");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("a*b.");
        expReg.setTexto_a_ser_verificado("aaaabc");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("^a*$");
        expReg.setTexto_a_ser_verificado("aaaaaaaa");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("^b*a*c*$");
        expReg.setTexto_a_ser_verificado("bbaacc");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("^a*$");
        expReg.setTexto_a_ser_verificado("");
        assertTrue(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular("a.c.");
        expReg.setTexto_a_ser_verificado("a.c");
        assertFalse(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
        expReg.setExpressao_Regular(".");
        expReg.setTexto_a_ser_verificado("");
        assertFalse(expReg.verificaCompatibilidadeExpressaoRegularComTexto());
        
    }
}
