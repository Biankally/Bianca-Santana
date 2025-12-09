
import java.util.Arrays;

public class Q03 {
    public static void main(String[] args){

        int[] vetor = {14, 40, 16, 22, 60};

        for (int i = 0; i< 5; i++) {
            for (int j = 0; j < 4; j++){
                if (vetor[j] < vetor[j+1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(vetor));
    }
}

