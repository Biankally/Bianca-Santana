import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a senha: ");
        String s = scanner.nextLine();

        if (s.length() < 1 || s.length() > 10) {
            System.out.println("A senha deve conter entre 1 e 10 caracteres.");
        } else {
            String novaSenha = fortalecerSenha(s);
            System.out.println("Senha fortalecida: " + novaSenha);
        }
        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = 0;
        for (int pos = 0; pos <= s.length(); pos++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(pos, c);
                String candidata = sb.toString();
                int tempo = calcularTempoDigitacao(candidata);
                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = candidata;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;
        int tempo = 2; // primeiro char
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}
