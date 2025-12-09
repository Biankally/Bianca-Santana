public class RainForest extends Forest {
    public RainForest(long treeCount) {
        this.treeCount = treeCount+1;
    }
    public static void main(String[] birds) {
        System.out.print(new RainForest(5).treeCount);
    } 
} 

class Forest {
    public long treeCount;
    
    public Forest(long treeCount) {
        this.treeCount = treeCount+2;
    } 
} 