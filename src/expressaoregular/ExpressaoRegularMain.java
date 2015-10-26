/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressaoregular;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class ExpressaoRegularMain
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        // TODO code application logic here
        Scanner entrada = new Scanner( System.in );
        String texto_a_ser_verificado;
        String expressao;
        ExpressaoRegular expReg;
        String finalizaPrograma = "inicio";
        String fim = "fim";
        
        while(!finalizaPrograma.equals(fim))
        {
            System.out.println("### VERIFICAR Expressão Regular ###");
            System.out.println("Digite a expressão regular: ");
            expressao = entrada.nextLine();
            System.out.println("Digite o texto a ser verificado: ");
            texto_a_ser_verificado = entrada.nextLine();


            expReg = new ExpressaoRegular(texto_a_ser_verificado, expressao);

            if(expReg.verificaCompatibilidadeExpressaoRegularComTexto())
            {
                System.out.println("O texto É compatível com a expressão regular!");
                System.out.println();
            }
            else
            {
                System.out.println("O texto NÃO é compatível com a expressão regular!");
                System.out.println();
            }
            
            System.out.println("Deseja testar nova compatibilidade(pressione enter) ou finalizar o programa(fim): ");
            finalizaPrograma = entrada.nextLine();
            System.out.println();
            System.out.println();
            
        }//fim while
        
        System.out.println("### PROGRAMA FINALIZADO!!! ###");
    }
    
}
