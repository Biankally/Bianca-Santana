import java.util.Random;
import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a senha: ");
        long iniciarTempo = System.currentTimeMillis();
        String s = scanner.nextLine();
        long pararTempo = System.currentTimeMillis();
        long calcularTempoDigitacao = pararTempo - iniciarTempo;
        long segundos = calcularTempoDigitacao / 1000;

        System.out.println("Tempo levado para digitar: " + segundos);

        if (s.length() < 1 || s.length() > 10) {
            System.out.println("A senha deve conter entre 1 e 10 caracteres.");
        } else {
            String novaSenha = fortalecerSenha(s);
            System.out.println("Senha fortalecida: " + novaSenha);
        }
        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        char randomChar = characters.charAt(random.nextInt(characters.length()));
        int randomIndex = random.nextInt(s.length() + 1);
        StringBuilder sb = new StringBuilder(s);
        sb.insert(randomIndex, randomChar);
        return sb.toString();
    }

    public static int calcularTempoDigitacao(String senha) {
        return senha.length();
    }
}
