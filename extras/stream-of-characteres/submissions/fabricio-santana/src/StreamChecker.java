
import java.util.List;

class StreamChecker 
{   

    private final List<String> wordsList;
    private final StringBuilder lastSuffix;

    public StreamChecker(String[] words) 
    {
        this.wordsList = List.of(words);
        this.lastSuffix = new StringBuilder();
    }
    
    public boolean query(char letter) 
    {
        boolean result = false;

        lastSuffix.append(Character.toString(letter));

        for (int i = lastSuffix.length(); i > 0; i--) {
            if (this.wordsList.contains(lastSuffix.substring(i-1, lastSuffix.length()))){
                result = true;
                break;
            }
        }
        return result;
    }
}
