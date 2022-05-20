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
    public static String strNomeJogador, strNomeDoenca, entComando, strEntPais, strSeuPais, strAgenteInf;
    public static String strTituloDD = "|----------------------------------------( Dr. Disease )----------------------------------------|",
                         strComando= "\n| Informe o comando:                                                                            |",
                         strComandos = "| <Comandos>    ou     <cmd> --> Mostra essa lista de Comandos\n"
                                     + "| <Infectar>    ou     <inf> --> Propaga a sua doença"
                                     + "| <Evoluir>     ou     <evo> --> Evolui a sua doença"
                                     + "| <Objetivo>    ou     <obj> --> Informa seu atual Objetivo\n"
                                     + "| <Status>      ou     <stt> --> Mostra informações sobre o número de contaminados e mortos\n"
                                     + "| <Habilidades> ou     <hab> --> Mostra suas habilidades\n"
                                     + "| <Progresso>   ou     <prg> --> Mostra seu Progresso no jogo\n"
                                     + "| <Doenca>      ou     <doe> --> Mostra informações sobre a Doença\n"
                                     + "| <Creditos>           <crd> --> Créditos do jogo\n"
                                     + "| <Tutorial>  ou       <tut> --> Explica como jogar o jogo\n"
                                     + "| <Sair> --> Finaliza o Jogo ( Você perderá seu progresso! )";
    public static boolean boolJogando = true, boolTutorial = false;
    public static int contaminados = 0, mortos = 0, entPais, populacaoPais, entAgenteInf;
    public static double porcentagemCont = 0, porcentagemMortos = 0;
    
    public static void main(String[] args) {
        
        System.out.println(strTituloDD
                + "\n\n| Informe o nome do Jogador: ");
        strNomeJogador = ent.nextLine();
        
        System.out.println(strTituloDD
                + "\n  Olá "+strNomeJogador+"!"
                + "\n| Agora o nome de Doença:                                                                       |");
        strNomeDoenca = ent.nextLine();
        entAgenteInf = agenteInfeccioso();
        
        entPais = armazenaPais();
        
        while (boolJogando) {
            System.out.println(strTituloDD+strComando);
            entComando = ent.next();
            mandaComando(entComando);
        }
    }
    
    public static int armazenaPais() {
        System.out.println("| Escolha o primeiro País a ser infectado: \n"
                         + "| <0> Brasil \n"
                         + "| <1> Argentina \n"
                         + "| <2> Uruguai \n"
                         + "| <3> Paraguai \n"
                         + "| <4> Bolívia \n"
                         + "| <5> Peru \n"
                         + "| <6> Chile \n"
                         + "| <7> Colômbia \n"
                         + "| <8> Equador \n"
                         + "| <9> Venezuela \n"
                         + "| <10> Guiana \n"
                         + "| <11> Suriname \n");
        entPais = ent.nextInt();
        
        switch(entPais) {
            case 0:
                populacaoPais = 200000000;
                strSeuPais = "Brasil";
                break;
            case 1:
                populacaoPais = 45000000;
                strSeuPais = "Argentina";
                break;
            case 2:
                populacaoPais = 3500000;
                strSeuPais = "Uruguai";
                break;
            case 3:
                populacaoPais = 7000000;
                strSeuPais = "Paraguai";
                break;
            case 4:
                populacaoPais = 11000000;
                strSeuPais = "Bolívia";
                break;
            case 5:
                populacaoPais = 33000000;
                strSeuPais = "Peru";
                break;
            case 6:
                populacaoPais = 18000000;
                strSeuPais = "Chile";
                break;
            case 7:
                populacaoPais = 46000000;
                strSeuPais = "Colômbia";
                break;
            case 8:
                populacaoPais = 13000000;
                strSeuPais = "Equador";
                break;
            case 9:
                populacaoPais = 31000000;
                strSeuPais = "Venezuela";
                break;
            case 10:
                populacaoPais = 210000;
                strSeuPais = "Guiana";
                break;
            case 11:
                populacaoPais = 550000;
                strSeuPais = "Suriname";
                break;
        }
        return entPais;
    }
    
    public static int agenteInfeccioso() {
        System.out.println(
                  "| Agora escolha o agente Infeccioso: \n"
                + "| <0> Vírus \n"
                + "| <1> Bactéria \n"
                + "| <2> Fungo \n");
        entAgenteInf = ent.nextInt();
        switch (entAgenteInf) {
            case 0:
                strAgenteInf = "Vírus";
                break;
            case 1:
                strAgenteInf = "Bactéria";
                break;
            case 2:
                strAgenteInf = "Fungo";
                break;
        }
        return entAgenteInf;
    }
    
    public static void mandaComando(String entComando) {
        switch (entComando.toLowerCase()) {
            case "comandos":
                System.out.println(strComandos);
                break;
            case "objetivo":
                menuObjetivo(entPais);
                break;
            case "status":
                menuStatus();
                break;
            case "habilidades":
                menuHabilidades();
                break;
            case "progresso":
                menuProgresso();
                break;
            case "doenca":
                menuDoenca(strNomeDoenca, strAgenteInf);
                break;
            case "creditos":
                menuCreditos();
                break;
            case "tutorial":
                break;
            case "infectar":
                menuInfectar();
                break;
            case "evoluir":
                menuEvoluir();
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
    
    public static void menuObjetivo(int entPais) {
        if (entPais == 1 || entPais == 4 || entPais == 7 || entPais == 9 || entPais == 10) {
            System.out.println("| Seu atual objetivo é contaminar toda a população da " + strSeuPais
                             + "\n| População Total: " + populacaoPais);
        } else {
            System.out.println("| Seu atual objetivo é contaminar toda a população do " + strSeuPais
                             + "\n| População Total: " + populacaoPais);
        }
    }
    
    public static void menuDoenca(String strNomeDoenca, String strAgenteInf) {
        System.out.println(
                strTituloDD
            + "\n| Nome da doença: " + strNomeDoenca
            + "\n| Agente Infeccioso: " + strAgenteInf);
    }
    
    public static void menuCreditos() {
        System.out.println(
                strTituloDD
            + "\n| Este jogo foi Pensado e Desenvolvido por: "
            + "\n| Rafael Ferreira Goulart"
            + "\n| Samuel José da Costa"
            + "\n| Pedro Henrique Fogaça do Nascimento"
            + "\n| Vinícius de Souza Oliveira"
            + "\n| Matheus Garcia Manoel"
            + "\n\n| Proposto pelo Professor Fernando Fernandes"
            + "\n| Responsável pela matéria do Projeto Integrador: Desenvolvimento de Lógica");
    }
    
    public static void menuStatus() {
        System.out.println(
                strTituloDD
            + "\n| Número de Infectados: " + contaminados
            + "\n| Número de Mortos: " + mortos);
    }
    
    public static void menuProgresso() {
        System.out.println(
                strTituloDD
            + "\n| Porcentagem de Infectados: " + porcentagemCont
            + "\n| Porcentagem de Mortos: " + porcentagemMortos);
    }
    
    public static void menuInfectar() {
        
    }
    
    public static void menuEvoluir() {
        
    }
    
    public static void menuHabilidades() {
        
    }
}