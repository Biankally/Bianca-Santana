import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = leitor.nextLine();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("Senha invalida");
            leitor.close();
            return;
        }

        String senhaFortalecida = fortalecerSenha(senha); // CORREÇÃO AQUI
        System.out.println("Senha fortalecida: " + senhaFortalecida);

        leitor.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maiorTempo = -1;

        for (char letra = 'a'; letra <= 'z'; letra++) {
            for (int i = 0; i <= s.length(); i++) {
                String novaSenha = s.substring(0, i) + letra + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);

                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) return 0;

        int tempo = 2; // O primeiro caractere sempre leva 2 segundos

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

