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
    public static String strNomeJogador, strNomeDoenca, entComando, strEntPais, strSeuPais, strAgenteInf, strDificuldade;
    public static String strTituloDD = "|----------------------------------------( Dr. Disease )----------------------------------------|",
                         strComando= "\n| Informe o comando:                                                                            |",
                         strComandos = "| <Comandos>    ou     <cmd> --> Mostra essa lista de Comandos\n"
                                     + "| <Infectar>    ou     <inf> --> Propaga a sua doença"
                                     + "| <Evoluir>     ou     <evo> --> Evolui a sua doença"
                                     + "| <AtacaLab>    ou     <lab> --> Ataca um laboratório de cura"
                                     + "| <Objetivo>    ou     <obj> --> Informa seu atual Objetivo\n"
                                     + "| <Status>      ou     <stt> --> Mostra informações sobre o número de contaminados e mortos\n"
                                     + "| <Habilidades> ou     <hab> --> Mostra suas habilidades\n"
                                     + "| <Progresso>   ou     <prg> --> Mostra seu Progresso no jogo\n"
                                     + "| <Doenca>      ou     <doe> --> Mostra informações sobre a Doença\n"
                                     + "| <Creditos>           <crd> --> Créditos do jogo\n"
                                     + "| <Tutorial>  ou       <tut> --> Explica como jogar o jogo\n"
                                     + "| <Sair> --> Finaliza o Jogo ( Você perderá seu progresso! )";
    public static boolean boolJogando = true, boolTutorial = false;
    public static int contaminados = 0, mortos = 0, entPais, populacaoPais, entAgenteInf, dificuldade, nivelDoenca = 0, paisFrio, paisCalor;
    public static double porcentagemCont = 0, porcentagemMortos = 0, porcentagemCura = 0;
    public static int[] habilidades = new int[7];
    public static String[] strHabilidades = {"Resistência ao Frio", "Resistência ao Calor", "Infecciosidade", "Mortalidade", "Força de Propagação", "Tempo de vida", "Resistência à vacina"};

    // Res frio - 0
    // Res calor - 1
    // Infecciosidade - 2
    // Mortalidade - 3
    // Força de propagação - 4
    // Tempo de vida ou durabilidade - 5
    // resistência à vacina - 6
    // 
    // 
    // 
    // 
    // Fácil (Sem cura) --- Normal (Tem cura) --- Difícil (A cura evolui mais rápido)
    
    public static void main(String[] args) {
        
        System.out.println(strTituloDD
                + "\n| Informe o nome do Jogador: ");
        strNomeJogador = ent.nextLine();
        
        dificuldade = armazenaDificuldade(dificuldade);
        
        strNomeDoenca = nomeDoenca();
        
        entPais = armazenaPais();
        
        salvaHabilidades();
        
        entAgenteInf = agenteInfeccioso();
        
        System.out.println(strTituloDD + "\n" + strComandos);
        while (boolJogando) {
            System.out.println(strTituloDD+strComando);
            entComando = ent.next();
            mandaComando(entComando);
        }
    }
    
    public static String nomeDoenca() {
        System.out.println(strTituloDD
                + "\n| Olá "+strNomeJogador+"!"
                + "\n| Agora o nome de Doença:                                                                       |");
        strNomeDoenca = ent.next();
        return strNomeDoenca;
    }
    
    public static void salvaHabilidades() {
        int pontos = 14;
        while (pontos > 0) {
            for (int pos = 0; pos < habilidades.length; pos++) {
                System.out.println("| Você tem: "+pontos+" pontos para atribuir às habilidades.");
                System.out.println(strHabilidades[pos]+": ");
                int atribui = ent.nextInt();
                while (atribui > pontos) {
                    System.out.println("| Você possui apenas: "+pontos+" pontos!");
                    System.out.println(strHabilidades[pos]+": ");
                    atribui = ent.nextInt();
                }
                habilidades[pos] = habilidades[pos] + atribui;
                pontos = pontos - atribui;
            }
        }
    }
    
    public static int armazenaDificuldade(int dificuldade) {
        String strArmazenaDificuldade = strTituloDD
                + "\n| Escolha a dificuldade: "
                + "\n| <0> Fácil   - Não há Cura "
                + "\n| <1> Normal  - Há Cura "
                + "\n| <2> Difícil - A Cura evolui mais rápido" + "\n";
        do {
            mostraTextoLento(strArmazenaDificuldade);
            dificuldade = ent.nextInt();
        } while (dificuldade < 0 || dificuldade > 2);
        switch(dificuldade) {
            case 0:
                strDificuldade = "Fácil";
                break;
            case 1:
                strDificuldade = "Normal";
                break;
            case 2:
                strDificuldade = "Difícil";
                break;
        }
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
        String strMostraAgenteInf = 
                  "| Agora escolha o agente Infeccioso: \n"
                + "| <0> Vírus ~ +4 Infecciosidade ~ +2 Mortalidade\n"
                + "| <1> Bactéria ~ +3 Tempo de Vida ~ +3 Resistência à vacina\n"
                + "| <2> Fungo ~ +2 Resistência ao Frio ~ +2 Resistência ao Calor\n"
                + "| <3> Arma Biológica ~ +2 Infecciosidade ~ +4 Mortalidade\n" + "\n";
        mostraTextoLento(strMostraAgenteInf);
        entAgenteInf = ent.nextInt();
        switch (entAgenteInf) {
            case 0:
                strAgenteInf = "Vírus";
                habilidades[2] = habilidades[2] + 4;
                habilidades[3] = habilidades[3] + 2;
                break;
            case 1:
                strAgenteInf = "Bactéria";
                habilidades[5] = habilidades[5] + 3;
                habilidades[6] = habilidades[6] + 3;
                break;
            case 2:
                strAgenteInf = "Fungo";
                habilidades[0] = habilidades[0] + 2;
                habilidades[1] = habilidades[1] + 2;
                break;
            case 3:
                strAgenteInf = "Arma Biológica" + "\n";
                habilidades[2] = habilidades[2] + 2;
                habilidades[3] = habilidades[3] + 4;
        }
        return entAgenteInf;
    }
    
    public static void mandaComando(String entComando) {
        switch (entComando.toLowerCase()) {
            case "comandos":
                System.out.println(strComandos);
                break;
            case "cmd":
                System.out.println(strComandos);
                break;
            case "objetivo":
                menuObjetivo(entPais);
                break;
            case "obj":
                menuObjetivo(entPais);
                break;
            case "status":
                menuStatus();
                break;
            case "stt":
                menuStatus();
                break;
            case "habilidades":
                menuHabilidades();
                break;
            case "hab":
                menuHabilidades();
                break;
            case "progresso":
                menuProgresso();
                break;
            case "prg":
                menuProgresso();
                break;
            case "doenca":
                menuDoenca(strNomeDoenca);
                break;
            case "doe":
                menuDoenca(strNomeDoenca);
                break;
            case "creditos":
                menuCreditos();
                break;
            case "crd":
                menuCreditos();
                break;
            case "tutorial":
                menuTutorial();
                break;
            case "tut":
                menuTutorial();
                break;
            case "infectar":
                menuInfectar();
                break;
            case "inf":
                menuInfectar();
                break;
            case "evoluir":
                menuEvoluir();
                break;
            case "evo":
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
        System.out.println("| Dificuldade do Jogo: " + strDificuldade);
        mostraTextoLento(strObjetivo);
    }
    
    public static void menuDoenca(String strNomeDoenca) {
        String strDoenca =
                strTituloDD
            + "\n| Nome da doença: " + strNomeDoenca
            + "\n| Nível: " + nivelDoenca
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
            + "\n| Número de Mortos: " + mortos
            + "\n| "
            + "\n| Cura: " + porcentagemCura + "\n";
        mostraTextoLento(strStatus);
    }
    
    public static void menuProgresso() {
        calculaPorcentagem();
        String strProgresso =
                strTituloDD
            + "\n| Porcentagem de Infectados: " + porcentagemCont
            + "\n| Porcentagem de Mortos: " + porcentagemMortos + "\n";
        mostraTextoLento(strProgresso);
    }
    
    public static void calculaPorcentagem() {
        porcentagemCont = populacaoPais%contaminados;
        porcentagemMortos = populacaoPais%mortos;
    }
    
    public static void menuInfectar() {
        calculoInfectar();
    }
    
    public static void calculoInfectar() {
        int infectar = 100;
        switch (nivelDoenca) {
            case 0:
                contaminados = contaminados + infectar;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    
    public static void menuEvoluir() {
        podeEvoluir();
    }
    
    public static boolean podeEvoluir() {
        boolean podeEvoluir = false;
        double necessario = 0;
        String strEvoluidoComSuc = strTituloDD + "\n| Evoluído com Sucesso! " + "\n| Nível: " + nivelDoenca;
        if (contaminados >= 80%populacaoPais) {
            nivelDoenca = 5;
            maisPontosDeHabilidades(8);
            System.out.println(strEvoluidoComSuc);
        } else if (contaminados >= 60%populacaoPais) {
            nivelDoenca = 4;
            maisPontosDeHabilidades(8);
            System.out.println(strEvoluidoComSuc);
        } else if (contaminados >= 40%populacaoPais) {
            nivelDoenca = 3;
            maisPontosDeHabilidades(8);
            System.out.println(strEvoluidoComSuc);
        } else if (contaminados >= 20%populacaoPais) {
            nivelDoenca = 2;
            maisPontosDeHabilidades(4);
            System.out.println(strEvoluidoComSuc);
        } else if (contaminados >= 10%populacaoPais) {
            nivelDoenca = 1;
            maisPontosDeHabilidades(2);
            System.out.println(strEvoluidoComSuc);
        } else {
            System.out.println("| Você não pode evoluir!");
            switch (nivelDoenca) {
                case 0:
                    necessario = 10%populacaoPais;
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 1:
                    necessario = 20%populacaoPais;
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 2:
                    necessario = 40%populacaoPais;
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 3:
                    necessario = 60%populacaoPais;
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 4:
                    necessario = 80%populacaoPais;
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
            }
        }
        return podeEvoluir;
    }
    
    public static void maisPontosDeHabilidades(int maisPontos) {
        
    }
    
    public static void menuHabilidades() {
        System.out.println(strTituloDD);
        for (int pos = 0; pos < strHabilidades.length; pos++) {
            System.out.println(strHabilidades[pos] + ": " + habilidades[pos]);
        }
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