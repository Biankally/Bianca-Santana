import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
public class FortalecerSenha {
    // Estrutura para gama de caracteres aleatorios//

    private static String insertRandomCharacter(String s) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        // Gerar um caractere aleatório
        char randomChar = characters.charAt(random.nextInt(characters.length()));
        int randomIndex = random.nextInt(s.length() + 1);

        //Usando o StringBuilder para inserir um novo caractere
        StringBuilder sb = new StringBuilder(s);
        sb.insert(randomIndex, randomChar);
        return sb.toString(); // Retorna a nova senha fortalecida
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a senha: ");
    //comecar captura do tempo levado para o usuario responder
    // tipo "long" e utilizado para armazenar um valor maior, pois milisegundos e um valor muito grande para um tipo int
        long iniciarTempo = System.currentTimeMillis();

        String s = scanner.nextLine();
    //parar cauptura do tempo levado para o usuario responder

        long pararTempo = System.currentTimeMillis();

        long calcularTempoDigitacao = pararTempo - iniciarTempo;

    //converter tempo para segundos e retornando um valor inteiro
    // Valor da conversao e muito grande para Int, por isso precisa ser convertido com (int) (metodo)
        long segundos = (int) (calcularTempoDigitacao / 1000);

        System.out.println("Tempo levado para digitar: " + segundos);
    //Verificando se a senha esta no intervalo menor ou igual a 1 menor ou igual a 10
    // Usando vetores pois existe um tamanho minimo e maximo de senha
        Vector<String> senhasFortalecidas = new Vector<>();
        senhasFortalecidas.add("Senha1");
        senhasFortalecidas.add("Senha2");
    //Comparando vetores
        if(s.length() < 1 || s.length() > 10) {
            System.out.println("A senha deve conter entre 1 e 10 caracteres.");
        } else {
        String novaSenha = insertRandomCharacter(s);
        System.out.println("Senha fortalecida: " + novaSenha);
   
        }
    scanner.close();
    }
}
