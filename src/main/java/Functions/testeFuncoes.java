package Functions;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
/** 
   por Rafael Ferreira Goulart
**/
public class testeFuncoes {
    public static void main(String[] args) throws IOException {
        confereCaminhos();
        
        Scanner ent = new Scanner(System.in);
        String saida = "";
        String saidaOperacao = "";
        String opcoes = 
            "- <A> Soma\n" +
            "- <B> Subtração\n" +
            "- <C> Multiplicação\n" +
            "- <D> Divisão\n" +
            "- <E> Potência\n";
        boolean podeSair = false;
        
        try {
            System.out.println(opcoes);
            System.out.println("Insira o primeiro número: ");
            double num1 = ent.nextDouble();
            System.out.println("Insira o segundo número: ");
            double num2 = ent.nextDouble();
            System.out.println("Agora insira a Operação: ");
            String operacao = ent.next();

            switch (operacao.toLowerCase()) {
                case "a":
                    saidaOperacao = "Somando: "+num1+" + "+num2+" = ";
                    break;
                case "b":
                    saidaOperacao = "Subtraindo: "+num1+" - "+num2+" = ";
                    break;
                case "c":
                    saidaOperacao = "Multiplicando: "+num1+" * "+num2+" = ";
                    break;
                case "d":
                    saidaOperacao = "Dividindo: "+num1+" / "+num2+" = ";
                    break;
                case "e":
                    saidaOperacao = "Potenciando: "+num1+" ^ "+num2+" = ";
                    break;
            }
            do {
                double retorno = operacaoMat(num1, operacao, num2);
                System.out.println(saidaOperacao+retorno);
                String r = saidaOperacao + retorno;
                salvaOperacao(r);
                podeSair = true;
            } while (!podeSair);
        } catch (Exception ex){
            System.out.println("Letras não são permitidas!");
        }
    }
    
    public static double operacaoMat(double num1, String operacao, double num2) {
        double resultado = 0;
        switch (operacao.toLowerCase()) {
            case "a":
                resultado = num1 + num2;
                break;
            case "b":
                resultado = num1 - num2;
                break;
            case "c":
                resultado = num1 * num2;
                break;
            case "d":
                resultado = num1 / num2;
                break;
            case "e":
                resultado = 1;
                if (num1 == 0 && num2 == 0) {
                    resultado = 1;
                } else if (num1 == 0 && num2 >= 1) {
                    resultado = 0;
                } else {
                    for (int i = 1; i <= num2; i++) {
                        resultado = resultado * num1;
                    }
                }
                break;
        }
        return resultado;
    }
    
    public static void confereCaminhos() throws IOException {
        boolean existeDir = Files.exists(Path.of("./Operacoes"));
        boolean existeFil = Files.exists(Path.of("./Operacoes/historico.txt"));
        
        if (!existeDir) {
            Files.createDirectory(Path.of("./Operacoes"));
        }
        if (!existeFil) {
                Files.createFile(Path.of("./Operacoes").resolve("historico.txt"));
            }
    }
    
    public static void salvaOperacao(String txt) throws IOException {
        Path historico = Path.of("./Operacoes/historico.txt");
        
        Files.writeString(historico, txt + "\n", StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);
    }
}