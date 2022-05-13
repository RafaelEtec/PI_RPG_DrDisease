package Final;
import java.util.Scanner;
/** 
   por:
   * Rafael Ferreira Goulart
   * Samuel J
   * Pedro
   * Vinícius
   * Mateus
**/
public class Main {
    
    // Declarando variáveis Globais
    public static Scanner ent = new Scanner(System.in);
    public static String strNomeJogador, strNomeDoenca, entComando;
    public static String strTituloDD = "|----------------------------------------( Dr. Disease )----------------------------------------|",
                         strComando= "\n| Informe o comando:                                                                            |",
                         strComandos = "| <Comandos>    ou     <cmd> --> Mostra essa lista de Comandos\n"
                                     + "| <Objetivo>    ou     <obj> --> Informa seu atual Objetivo\n"
                                     + "| <Status>      ou     <stt> --> Mostra informações sobre o número de contaminados e mortos\n"
                                     + "| <Habilidades> ou     <hab> --> Mostra suas habilidades\n"
                                     + "| <Progresso>   ou     <prg> --> Mostra seu Progresso no jogo\n"
                                     + "| <Doenca>      ou     <doe> --> Mostra informações sobre a Doença\n"
                                     + "| <Creditos>           <crd> --> Créditos do jogo\n"
                                     + "| <Instrucoes>  ou     <ins> --> Explica como jogar o jogo\n"
                                     + "| <> --> \n"
                                     + "| <> --> \n"
                                     + "| <Sair> --> Finaliza o Jogo ( Você perderá seu progresso! )";
    public static boolean boolJogando = true;
    public static boolean boolTutorial = false;
    
    public static void main(String[] args) {
        
        System.out.println(strTituloDD
                + "\n\n| Informe o nome do Jogador: ");
        strNomeJogador = ent.nextLine();
        
        System.out.println(strTituloDD
                + "\n  Olá "+strNomeJogador+"!"
                + "\n| Agora o nome de Doença:                                                                       |");
        strNomeDoenca = ent.nextLine();
        
        while (boolJogando) {
            System.out.println(strTituloDD+strComando);
            entComando = ent.next();
            mandaComando(entComando);
        }
    }
    
    public static void mandaComando(String entComando) {
        switch (entComando.toLowerCase()) {
            case "comandos":
                System.out.println(strComandos);
                break;
            case "objetivo":
                break;
            case "status":
                break;
            case "habilidades":
                break;
            case "progresso":
                break;
            case "doenca":
                break;
            case "creditos":
                break;
            case "instrucoes":
                break;
            case "sair":
                System.out.println(
                            "| Você está prestes a fechar o jogo!                                                            |"
                        + "\n| Tem certeza? <s> Sim! ou <n> Não!                                                             |");
                entComando = ent.next();
                if (entComando.toLowerCase().equals("s")) {
                    boolJogando = false;
                    System.out.println("| Fechando Jogo                                                                                 |");
                } else {
                    System.out.println("| Retornando ao jogo                                                                            |");
                }
                break;
        }
    }
}