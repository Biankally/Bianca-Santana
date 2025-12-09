import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollatzSequence {

    public static int proximoTermo(int n) {
        if (n % 2 == 0)
            return n / 2;
        return (n * 3) + 1;
    }

    public static Object[] gerarESomar(int semente) {
        if (semente <= 0)
            return new Object[]{new ArrayList<Integer>(), 0};

        List<Integer> sequencia = new ArrayList<>();
        int termoAtual = semente;

        while (termoAtual != 1) {
            sequencia.add(termoAtual);
