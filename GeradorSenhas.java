import java.util.Scanner;

public class GeradorSenhas {
    public static void main(String[] args){
        int idMenu = 0;
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
                    break;
                case 2:
                    break;
                case 4:
                    System.out.println("\n Saindo ....");
                    break;
            }
        }
    }
}
