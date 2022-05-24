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
    public static String strCrashou = "| Crashou o Sistema, provavelmente por você ter tentado inserir palavras invés de números";
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
    public static int contaminados = 0, mortos = 0, entPais, populacaoPais, entAgenteInf = -1, dificuldade;
    public static double porcentagemCont = 0, porcentagemMortos = 0;
    public static int[] habilidades = new int[7];
    
    // 0 - Res frio
    // 1 - Res calor
    // 2 - Infecciosidade
    // 3 - Mortalidade
    // 4 - Força de propagação
    // 5 - Tempo de vida ou durabilidade
    // 6 - resistência à vacina
    // 
    // 
    // 
    // 
    // Fácil (Sem cura) --- Normal (Tem cura) --- Difícil (A cura evolui mais rápido)
    
    public static void main(String[] args) {
        menuTutorial();
        
        System.out.println(strTituloDD
                + "\n| Informe o nome do Jogador: ");
        strNomeJogador = ent.nextLine();
        
        dificuldade = armazenaDificuldade(dificuldade);
        
        strNomeDoenca = nomeDoenca();
        
        entAgenteInf = agenteInfeccioso();
        
        entPais = armazenaPais();
        
        while (boolJogando) {
            System.out.println(strTituloDD+strComando);
            entComando = ent.next();
            mandaComando(entComando);
        }
    }
    
    public static String nomeDoenca() {
        System.out.println(strTituloDD
                + "\n| Olá "+strNomeJogador+"!"
                + "\n| Agora o nome da Doença:                                                                       |");
        strNomeDoenca = ent.next();
        return strNomeDoenca;
    }
    
    public static int armazenaDificuldade(int dificuldade) {
        String strArmazenaDificuldade = strTituloDD
                + "\n| Escolha a dificuldade: "
                + "\n| <0> Fácil   - Não há Cura "
                + "\n| <1> Normal  - Há Cura "
                + "\n| <2> Difícil - A Cura evolui mais rápido" + "\n";
        mostraTextoLento(strArmazenaDificuldade);
        dificuldade = ent.nextInt();
        return dificuldade;
    }
    
    public static void mostraTextoLento(String texto) {
        for (int posChar = 0; posChar < texto.length(); posChar++) {
            try {
                Thread.sleep(15);
                System.out.print(texto.charAt(posChar));
            } catch (InterruptedException ex) {
                System.out.println("| Algo deu Errado");
            }
        }
    }
    
    public static int armazenaPais() {
        String strEscolhePais =   "| Escolha o primeiro País a ser infectado: \n"
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
                             + "| <11> Suriname \n" + "\n";
        mostraTextoLento(strEscolhePais);
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
        String strPedeAgenteInf = 
                  "| Agora escolha o agente Infeccioso: \n"
                + "| <0> Vírus \n"
                + "| <1> Bactéria \n"
                + "| <2> Fungo \n"
                + "| <3> Arma Biológica \n" + "\n";
        mostraTextoLento(strPedeAgenteInf);
        entAgenteInf = ent.nextInt();
        while (entAgenteInf < 0 || entAgenteInf > 3) {
            System.out.println(
                  "| Presta atenção! Escolhe denovo: \n"
                + "| <0> Vírus \n"
                + "| <1> Bactéria \n"
                + "| <2> Fungo \n"
                + "| <3> Arma Biológica");
            entAgenteInf = ent.nextInt();
        }
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
            case 3:
                strAgenteInf = "Arma Biológica";
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
                menuTutorial();
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
        String strObjetivo;
        if (entPais == 1 || entPais == 4 || entPais == 7 || entPais == 9 || entPais == 10) {
            strObjetivo = "| Seu atual objetivo é contaminar toda a população da " + strSeuPais
                             + "\n| População Total: " + populacaoPais + "\n";
        } else {
            strObjetivo = "| Seu atual objetivo é contaminar toda a população do " + strSeuPais
                             + "\n| População Total: " + populacaoPais + "\n";
        }
        mostraTextoLento(strObjetivo);
    }
    
    public static void menuDoenca(String strNomeDoenca, String strAgenteInf) {
        String strDoenca =
                strTituloDD
            + "\n| Nome da doença: " + strNomeDoenca
            + "\n| Agente Infeccioso: " + strAgenteInf + "\n";
        mostraTextoLento(strDoenca);
    }
    
    public static void menuCreditos() {
        String strCreditos = 
                strTituloDD
            + "\n| Este jogo foi Pensado e Desenvolvido por: "
            + "\n| Rafael Ferreira Goulart"
            + "\n| Samuel José da Costa"
            + "\n| Pedro Henrique Fogaça do Nascimento"
            + "\n| Vinícius de Souza Oliveira"
            + "\n| Matheus Garcia Manoel"
            + "\n\n| Proposto pelo Professor Fernando Fernandes"
            + "\n| Responsável pela matéria do Projeto Integrador: Desenvolvimento de Lógica" + "\n";
        mostraTextoLento(strCreditos);
    }
    
    public static void menuStatus() {
        String strStatus = 
                strTituloDD
            + "\n| Número de Infectados: " + contaminados
            + "\n| Número de Mortos: " + mortos + "\n";
        mostraTextoLento(strStatus);
    }
    
    public static void menuProgresso() {
        String strProgresso =
                strTituloDD
            + "\n| Porcentagem de Infectados: " + porcentagemCont
            + "\n| Porcentagem de Mortos: " + porcentagemMortos + "\n";
        mostraTextoLento(strProgresso);
    }
    
    public static void menuInfectar() {
        
    }
    
    public static void menuEvoluir() {
        
    }
    
    public static void menuHabilidades() {
        
    }
    
    public static void menuTutorial() {
        System.out.println(
                strTituloDD
              + "\n| Olá Humano, Raptamos você e mais alguns terráqueos para que nos ajudasse numa missão. \n"
              + "| Nós somos da raça Onaiab, e Aihab é nosso Planeta-Natal, se encontra hà bilhões de quilômetros daqui.\n"
              + "| Somos responsáveis pela Ordem Planetária, e quando encontramos planetas habitados, fazemos testes nele.\n"
              + "| Para julgar se os habitantes são realmente capazes de controlar o astro em que vive.\n"
              + "| Possuímos diversas técnicas de como testá-los."
              + "| E é aqui que precisamos de sua ajuda, você será responsável por criar uma praga que será lançada na Terra,\n"
              + "| Seu objetivo é contaminar todos do planeta, e eventualmente matá-los com uma praga evoluída.\n"
              + "| "
                      + "\n"
              + "| \n"
              + "| \n");
    }
}