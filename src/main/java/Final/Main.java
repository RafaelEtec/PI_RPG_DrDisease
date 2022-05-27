package Final;
import java.util.Scanner;
import java.util.Random;
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
    public static String respostaP1, respostaP2, strNomeJogador, strNomeDoenca, entComando, strEntPais, strSeuPais, strAgenteInf, strDificuldade;
    public static String strTituloDD = "|----------------------------------------( Dr. Disease )----------------------------------------|",
                         strComando= "\n| Informe o comando:                                                                            |",
                         strComandos = "| <Comandos>    ou     <cmd> --> Mostra essa lista de Comandos                                  |\n"
                                     + "| <Infectar>    ou     <inf> --> Propaga a sua doença                                           |\n"
                                     + "| <Evoluir>     ou     <evo> --> Evolui a sua doença                                            |\n"
                                     + "| <AtacaLab>    ou     <lab> --> Ataca um laboratório de cura                                   |\n"
                                     + "| <Objetivo>    ou     <obj> --> Informa seu atual Objetivo                                     |\n"
                                     + "| <Status>      ou     <stt> --> Mostra informações sobre o número de contaminados e mortos     |\n"
                                     + "| <Habilidades> ou     <hab> --> Mostra suas habilidades                                        |\n"
                                     + "| <Progresso>   ou     <prg> --> Mostra seu Progresso no jogo                                   |\n"
                                     + "| <Doenca>      ou     <doe> --> Mostra informações sobre a Doença                              |\n"
                                     + "| <Creditos>           <crd> --> Créditos do jogo                                               |\n"
                                     + "| <Historia>    ou     <his> --> Mostra novamente a história do jogo                            |\n"
                                     + "| <Sair> --> Finaliza o Jogo ( Você perderá seu progresso! )                                    |\n";
    public static boolean boolJogando = true, boolTutorial = true;
    public static int contaminados = 0, mortos = 0, entPais, populacaoPais, entAgenteInf, jogadas = 0, dificuldade, nivelDoenca = 0, paisFrio, paisCalor;
    public static double porcentagemCont = 0, porcentagemMortos = 0, porcentagemCura = 0;
    public static int[] habilidades = new int[7];
    public static int[] habPais = {0, 0};
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
        
        menuHistoria();
        
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
            boolJogando = verificaVitoria(jogadas);
        }
    }
    
    public static boolean verificaVitoria(int jogadas) {
        boolJogando = true;
        if (contaminados >= populacaoPais ) {
            System.out.println(strTituloDD);
            if (entPais == 1 || entPais == 4 || entPais == 7 || entPais == 9 || entPais == 10) {
                System.out.println("| Parabéns! Você contaminou todos da " + strSeuPais + "\n| Em: " + jogadas + " Jogadas!");
            } else {
                System.out.println("| Parabéns! Você contaminou todos do " + strSeuPais + "\n| Em: " + jogadas + " Jogadas!");
            }
            boolJogando = false;
        }
        return boolJogando;
    }
    
    public static String nomeDoenca() {
        System.out.println(strTituloDD
                + "\n| Olá "+strNomeJogador+"!"
                + "\n| Agora o nome da Doença:                                                                       |");
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
                while (atribui > pontos || atribui < 0) {
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
        do {
            System.out.println("| Atenção! Insira novamente:");
            mostraTextoLento(strEscolhePais);
            entPais = ent.nextInt();
        } while (entPais < 0 || entPais > 11);
        switch(entPais) {
            case 0:
                populacaoPais = 200000000;
                strSeuPais = "Brasil";
                habPais[0] = 3;
                habPais[1] = 5;
                break;
            case 1:
                populacaoPais = 45000000;
                strSeuPais = "Argentina";
                habPais[0] = 3;
                habPais[1] = 1;
                break;
            case 2:
                populacaoPais = 3500000;
                strSeuPais = "Uruguai";
                habPais[0] = 4;
                habPais[1] = 1;
                break;
            case 3:
                populacaoPais = 7000000;
                strSeuPais = "Paraguai";
                habPais[0] = 1;
                habPais[1] = 4;
                break;
            case 4:
                populacaoPais = 11000000;
                strSeuPais = "Bolívia";
                habPais[0] = 2;
                habPais[1] = 2;
                break;
            case 5:
                populacaoPais = 33000000;
                strSeuPais = "Peru";
                habPais[0] = 1;
                habPais[1] = 4;
                break;
            case 6:
                populacaoPais = 18000000;
                strSeuPais = "Chile";
                habPais[0] = 5;
                habPais[1] = 0;
                break;
            case 7:
                populacaoPais = 46000000;
                strSeuPais = "Colômbia";
                habPais[0] = 1;
                habPais[1] = 3;
                break;
            case 8:
                populacaoPais = 13000000;
                strSeuPais = "Equador";
                habPais[0] = 1;
                habPais[1] = 5;
                break;
            case 9:
                populacaoPais = 31000000;
                strSeuPais = "Venezuela";
                habPais[0] = 4;
                habPais[1] = 2;
                break;
            case 10:
                populacaoPais = 210000;
                strSeuPais = "Guiana";
                habPais[0] = 1;
                habPais[1] = 5;
                break;
            case 11:
                populacaoPais = 550000;
                strSeuPais = "Suriname";
                habPais[0] = 2;
                habPais[1] = 5;
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
        do {
            mostraTextoLento(strMostraAgenteInf);
            entAgenteInf = ent.nextInt();
        } while (entAgenteInf < 0 || entAgenteInf > 3);
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
            case "historia":
                menuHistoria();
                break;
            case "his":
                menuHistoria();
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
        if (contaminados == 0) {
            porcentagemCont = 0;
            porcentagemMortos = 0;
        } else {
            porcentagemCont = populacaoPais * (contaminados / 100);
            porcentagemMortos = populacaoPais * (mortos / 100);
        }
    }
    
    public static void menuInfectar() {
        calculoInfectar();
    }
    
    public static void calculoInfectar() {
        int infectar = 200;
        int infectados = infectar;
        switch (nivelDoenca) {
            case 0:
                infectados = somaInfectar(infectar);
                break;
            case 1:
                infectar = 400;
                infectados = somaInfectar(infectar);
                break;
            case 2:
                infectar = 800;
                infectados = somaInfectar(infectar);
                break;
            case 3:
                infectar = 1600;
                infectados = somaInfectar(infectar);
                break;
            case 4:
                infectar = 3200;
                infectados = somaInfectar(infectar);
                break;
            case 5:
                infectar = 6400;
                infectados = somaInfectar(infectar);
                break;
        }
        contaminados = contaminados + (infectados);
        String mensagem = mensagemInfectar(infectados);
        mostraTextoLento(mensagem);
        jogadas++;
    }
    
    public static int somaInfectar(int infectar) {
        Random ran = new Random();
        int randomInfecciosidade = ran.nextInt(habilidades[2]);
        infectar = ran.nextInt(infectar + (infectar / 2));
        int infectados = infectar;
        if (randomInfecciosidade == 0) {
            infectados = infectar - (habPais[0]%infectar) - (habPais[1]%infectar) + infectar + (infectar * habilidades[4] / 10);
        } else {
            infectados = infectar - (habPais[0]%infectar) - (habPais[1]%infectar) + (infectar + (infectar * randomInfecciosidade / 10)) + (infectar * habilidades[4] / 10);
        }
        return infectados;
    }
    
    public static String mensagemInfectar(int infectados) {
        Random ran = new Random();
        int posMsg = 0, guardaMsg = -1;
        boolean podeSair = false;
        String mensagem = "";
        String[] mensagens = 
        {
            "| Após sair às ruas e tossir um pouco, você infectou: " + infectados + " pessoas.\n",
            "| Que cheiro forte é esse? Seu perfume contaminado infectou: " + infectados + " pessoas.\n",
            "| Bastou uma viajem de Uber para contaminar: " + infectados + " pessoas\n",
            "| Não fui eu! O fedor dos seus peidos contaminou: " + infectados + " pessoas\n",
            "| Tinder dos horrores: Aquela doce garota passou sua doença para: " + infectados + " pessoas\n",
            "| Baladas são ótimas para contaminar pessoas: " + infectados + " infectados\n",
            "| Estava tão difícil escolher os produtos no mercado, seu toque amaldiçoado infectou: " + infectados + " pessoas\n",
            "| Pra que higiene? " + infectados + " pessoas que usaram o mesmo banheiro que você se infectaram.\n",
            "| É uma pena sua namorada ter te deixado, mas veja pelo lado bom, ela passou sua doença para: " + infectados + " pessoas\n",
            "| Superman: Seus olhares infectaram: " + infectados + " pessoas\n",
            "| Você vai à padaria e compra 6 pães, a nota de 2 reais suja passou por " + infectados + " pessoas\n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
            "| " + infectados + " \n",
        };
        while (!podeSair) {
            posMsg = ran.nextInt(mensagens.length);
            if (posMsg == guardaMsg) {
                posMsg = ran.nextInt(mensagens.length);
            } else {
                guardaMsg = posMsg;
                podeSair = true;
            }
        }
        mensagem = mensagens[posMsg];
        return mensagem;
    }
    
    public static void menuEvoluir() {
        podeEvoluir();
    }
    
    public static boolean podeEvoluir() {
        boolean podeEvoluir = false;
        double necessario = 0;
        String strEvoluidoComSuc = strTituloDD + "\n| Evoluído com Sucesso! ";
        if (contaminados >= (populacaoPais*0.8)) {
            nivelDoenca = 5;
            System.out.println(strEvoluidoComSuc + "\nNível: "+nivelDoenca);
            maisPontosDeHabilidades(8);
        } else if (contaminados >= (populacaoPais*0.6)) {
            nivelDoenca = 4;
            System.out.println(strEvoluidoComSuc + "\nNível: "+nivelDoenca);
            maisPontosDeHabilidades(8);
        } else if (contaminados >= (populacaoPais*0.4)) {
            nivelDoenca = 3;
            System.out.println(strEvoluidoComSuc + "\nNível: "+nivelDoenca);
            maisPontosDeHabilidades(8);
        } else if (contaminados >= (populacaoPais*0.2)) {
            nivelDoenca = 2;
            System.out.println(strEvoluidoComSuc + "\nNível: "+nivelDoenca);
            maisPontosDeHabilidades(4);
        } else if (contaminados >= (populacaoPais*0.1)) {
            nivelDoenca = 1;
            System.out.println(strEvoluidoComSuc + "\nNível: "+nivelDoenca);
            maisPontosDeHabilidades(2);
        } else {
            System.out.println("| Você não pode evoluir!");
            switch (nivelDoenca) {
                case 0:
                    necessario = (populacaoPais*0.1);
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 1:
                    necessario = (populacaoPais*0.2);
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 2:
                    necessario = (populacaoPais*0.4);
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 3:
                    necessario = (populacaoPais*0.6);
                    System.out.println("| Evolução possível quando: \n| Contaminados >= " + necessario);
                    break;
                case 4:
                    necessario = (populacaoPais*0.8);
                    System.out.println("| Evolução possível quando2: \n| Contaminados >= " + necessario);
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
    
    public static void menuHistoria() {
        String opcao1p1 = 
                strTituloDD
              + "\n       Macacos me mordam! Acalme-se, não há o que temer, além do mais, VOCÊ concordou em estar aqui, temos um contrato hehehehe.\n"
              + "| E eu sou o Doutor Disease, ex integrante do grupo de cientistas da Umbrella Corporation, acredite, fazíamos experimentos extraordinários lá.\n"
              + "| Infelizmente o laboratório foi fechado, assim como boa parte dos meu colegas foram mortos, ou transformados em seres carnívoros.\n"
              + "| Mas fazer o que, essas coisas acontecem. E passado é passado, estou seguindo em frente, e com uma nova... digamos \"Praga\".\n";
        String opcao2p1 = 
                strTituloDD
              + "\n|      Sou o Doutor Disease, ex integrante do grupo de cientistas da Umbrella Corporation, acredite, fazíamos experimentos extraordinários lá.\n"
              + "| Infelizmente o laboratório foi fechado, assim como boa parte dos meu colegas foram mortos, ou transformados em seres carnívoros.\n"
              + "| Mas fazer o que, essas coisas acontecem. E passado é passado, estou seguindo em frente, e com uma nova... digamos \"Praga\".\n";
        
        String strHistoria1 = 
                strTituloDD
              + "\n|      Bom dia jovem Cobaia. Já fazem 8 horas desde que eu te seques... Que você pegou no sono eu iria dizer.\n"
              + "| Caso não se lembre do por quê você está aqui, eu lhe contarei novamente.\n\n"
              + "| <1> Sequestrado!?, Quem é você!?, onde é que eu tô!? Me tira daqui!\n"
              + "| <2> Realmente não me lembro de nada, me conta aí...\n";
        String strHistoria2 = 
                "| <1> E o que eu tenho a ver com isso!? \n"
              + "| <2> Sinto muito pelos seus colegas, mas não me leve a mal, o que eu tenho a ver com isso? \n";
        
        System.out.println(strHistoria1);
        int opcao1 = pegaOpcao();
        switch (opcao1) {
            case 1:
                System.out.println("| <1> Sequestrado!?, Quem é você!?, onde é que eu tô!? Me tira daqui! ");
                System.out.println(opcao1p1);
                respostaP1 = opcao1p1;
                break;
            case 2:
                System.out.println("| <2> Realmente não me lembro de nada, me conta aí... \n");
                System.out.println(opcao2p1);
                respostaP1 = opcao2p1;
                break;
        }
        System.out.println(strHistoria2);
        int opcao2 = pegaOpcao();
        
        System.out.println(
                strTituloDD
              + "\n|      Ah, é claro, você está infectado com essa praga, mas não se preocupe, Você é o que chamamos de paciente zero."
              + "| E está carregando essa doença com toda segurança, ou pelo menos só você está seguro.\n"
              + "| Por que seu objetivo é espalhar essa praga por toda uma nação\n"
              + "| \n");
    }
    
    public static int pegaOpcao() {
        String strOpcaoInvalida = "Opção inválida! Informe novamente: ";
        int opcao = ent.nextInt();
        while (opcao < 1 || opcao > 2) {
            System.out.println(strOpcaoInvalida);
            opcao = ent.nextInt();
        }
        return opcao;
    }
}