import java.util.Scanner;

public class StringReverser{

    public static String reverseString(String s){

        if(s == null){
            return "NullPointerException";
        }else if (s.isBlank()){
            return "A String está vazia";
        }else{
            String s_invertida = "";

            int tamanho = s.length();

            for(int i = tamanho-1; i >= 0 ; i--){
                s_invertida = s_invertida + s.charAt(i);
            }

            return s_invertida; 
        }
    }

    public static void main(String[] args){

        Scanner scanner =  new Scanner(System.in);

        String string_original = scanner.nextLine();

        String string_invertida = reverseString(string_original);

        System.out.println("String original: " + string_original);
        System.out.println("String invertida: " + string_invertida);

        scanner.close();
    }
}