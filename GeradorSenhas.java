import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GeradorSenhas {
    public static void main(String[] args){
        int idMenu = 0;
        int idMenuSenha;
        String maiusculas = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String minusculas = "qwertyuiopasdfghjklzxcvbnm";
        String numeros = "1234567890";
        String simbulos = "!@#$%*(){}[]/?";
        Scanner scanner = new Scanner(System.in);
        while (idMenu != 4) {
            System.out.println("\n\n === Gerador De Senhas === ");
            System.out.println("\n 1 - Gerar nova senha");
            System.out.println(" 2 - Ler senhas geradas");
            System.out.println(" 3 - Apagar todas as senhas salvas");
            System.out.println(" 4 - Sair\n\n");
            System.out.print("Digite a opção desejada: ");
            idMenu = scanner.nextInt();
            switch (idMenu){
                case 1:
                    System.out.println("\n\n === Gerar nova senha === ");
                    System.out.println("\n 1 - Senha Extremamente Forte ");
                    System.out.println(" 2 - Senha Forte ");
                    System.out.println(" 3 - Senha Média ");
                    System.out.println(" 4 - Senha Fraca \n\n");
                    System.out.print("Digite a opção desejada: ");
                    idMenuSenha = scanner.nextInt();
                    String conjunto = "";
                    switch (idMenuSenha){
                        case 1:
                            conjunto = maiusculas + minusculas + numeros + simbulos;
                            break;
                        case 2:
                             conjunto = maiusculas + simbulos + numeros;
                            break;
                        case 3:
                             conjunto = maiusculas + minusculas + numeros;
                            break;
                        case 4:
                             conjunto = minusculas + numeros;
                            break;
                    }
                    System.out.print("\n Digite o tamanho da Senha: ");
                    int tamanho = scanner.nextInt();

                    Random random = new Random();
                    StringBuilder senha = new StringBuilder();

                    for (int c = 0;c < tamanho;c++){
                        int posicao = random.nextInt(conjunto.length());
                        senha.append(conjunto.charAt(posicao));
                    }
                    try{
                        System.out.println("\n Senha gerada: " + senha);
                    FileWriter fw = new FileWriter("senhas.txt" ,true);
                    fw.write(senha.toString() + "\n");
                    fw.close();
                    } catch (IOException e){
                        System.out.println("ERRO / Senha não foi gravada!");
                    }
                    break;
                case 2:
                    System.out.println("\n\n === Listando as senhas geradas === \n");
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("senhas.txt"));
                        String linha;
                        while ((linha = br.readLine()) != null){
                            System.out.println(linha +"\n");
                        }
                        br.close();
                    } catch (IOException e){
                        System.out.println("ERRO / Não conseguiu ler nenhum dado do arquivo senhas.txt");
                    }
                    break;
                case 3:
                    try {
                        FileWriter fw = new FileWriter("senhas.txt", false);
                        fw.write("");
                        fw.close();
                        System.out.println("\n\n Senhas excluídas com sucesso!");
                    } catch (IOException e){
                        System.out.println("ERRO / Não conseguiu excluir senhas");
                    }
                    break;
                case 4:
                    System.out.println("\n Saindo ....");
                    break;
            }
        }
    }
}
