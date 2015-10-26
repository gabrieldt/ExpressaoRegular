/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressaoregular;

import java.util.Arrays;

/**
 *
 * @author gabriel
 */
public class ExpressaoRegular
{
    private String texto_a_ser_verificado;
    private String expressao_Regular;

    public ExpressaoRegular(String textoParaVerificar, String expressaoRegular)
    { 
        this.texto_a_ser_verificado = textoParaVerificar;
        this.expressao_Regular = expressaoRegular;
    }
     
    public String getTexto_a_ser_verificado()
    {
        return texto_a_ser_verificado;
    }

    public String getExpressao_Regular()
    {
        return expressao_Regular;
    }

    public void setTexto_a_ser_verificado(String texto_a_ser_verificado)
    {
        this.texto_a_ser_verificado = texto_a_ser_verificado;
    }

    public void setExpressao_Regular(String expressaoRegular)
    {
        this.expressao_Regular = expressaoRegular;
    }

    @Override
    public String toString()
    {
        return "ExpressaoRegular{" + "texto_a_ser_verificado=" + texto_a_ser_verificado + ", expressao_Regular=" + expressao_Regular + '}';
    }
    
    //funcao que verifica a compatibilidade entra o texto digitado e a expressao regular
    //convertida para regex do java
    //se for compativel retorna true caso contrario false
    boolean verificaCompatibilidadeTextoExpressaoRegular(String texto, String expressaoRegular)
    {
        return texto.matches(expressaoRegular);
    }
    
    //verifica compatibilidade da expressao e do texto digitados pelo usuario
    boolean verificaCompatibilidadeExpressaoRegularComTexto()
    {
        //expressao regular reconhecida pelo java
        String padraoExpressaoRegular = "";
        
        //verifica se tem marcador de fim de expressao
        //se nao tiver pode acrescentar na expressao regular qualquer caractere
        //0 indica que nao tem marcador 1 caso contrario
        int verificaMarcadorFimExpressao = 0;
        
        //verifica se tem marcador de fim de expressao
        //se nao tiver pode acrescentar na expressao regular qualquer caractere
        //0 indica que nao tem marcador 1 caso contrario
        int verificaMarcadorInicioExpressao = 0;
        
        //se a expressao regular digitada pelo usuario for vazia
        //e o texto digitado for diferente de vazio retorna false
        if(this.expressao_Regular.compareTo("") == 0)
            if(this.expressao_Regular.compareTo(this.texto_a_ser_verificado) != 0)
                return false;
        
        if(this.texto_a_ser_verificado.startsWith("## "))
        {
            //procura "## " no inicio do texto
            String[] textoArray;
            
            textoArray = this.texto_a_ser_verificado.split("## ");
            this.setTexto_a_ser_verificado(textoArray[1]);
        }
        
        if(this.texto_a_ser_verificado.endsWith(" ##"))
        {
            //procura " ##" no fim do texto
            String[] textoArray;
            
            textoArray = this.texto_a_ser_verificado.split(" ##");
            this.setTexto_a_ser_verificado(textoArray[0]);
        }
        
        //se o texto e a expressao regular forem iguais retorna true
        if(this.texto_a_ser_verificado.compareTo(this.expressao_Regular) == 0)
        {
            //texto e expressao sao iguais
            return true;
        }
        
        for(int cont=0; cont < this.expressao_Regular.length(); cont++)
        {
            
            if(this.expressao_Regular.charAt(cont) == '^')
            {
                //o caractere 'ˆ' indica o inicio da sequencia
                //de entrada entao a expressao regular inicia agora
                verificaMarcadorInicioExpressao = 1;
                padraoExpressaoRegular = "";
            }
            else if(this.expressao_Regular.charAt(cont) == '$')
            {
                //como e o fim da sequencia de entrada indicado por '$'
                //nao há mais nada a adicionar na expressao regular
                verificaMarcadorFimExpressao = 1;
                break;
            }
            else if(this.expressao_Regular.charAt(cont) == '.')
            {
                //qualquer caractere unico
                //equivalente a = [a-zA-Z0-9\\p{Punct}]
                padraoExpressaoRegular += "[\\p{Graph}]";
            }
            else if(this.expressao_Regular.charAt(cont) == 'c')
            {
                //qualquer caractere unico
                padraoExpressaoRegular += "[c]";
            }
            else if(this.expressao_Regular.charAt(cont) == '*')
            {
                //indica zero ou mais ocorrencias da regra
                //que precede '*'
                padraoExpressaoRegular += "*";
            }
            else
            {
                //acrescenta o proximo caractere na expressao regular
                padraoExpressaoRegular += "[" + this.expressao_Regular.charAt(cont) + "]";
            } 
        }
        
        if(verificaMarcadorFimExpressao == 0)
            padraoExpressaoRegular += "[\\p{Graph}]*";
        
        if(verificaMarcadorInicioExpressao == 0)
            padraoExpressaoRegular = "[\\p{Graph}]*" + padraoExpressaoRegular;
        //System.out.println(padraoExpressaoRegular);
        
        //verifica a compatibilidade
        return verificaCompatibilidadeTextoExpressaoRegular(this.texto_a_ser_verificado, padraoExpressaoRegular);
    }
    
    
}
