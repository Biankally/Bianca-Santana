import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("Create and Print ArrayList");
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Verde");
        colors.add("Amarelo");
        colors.add("Azul");
        colors.add("Branco");
        System.out.println(colors);

        System.out.println("Iterate ArrayList Elements");
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("Insert at First Position");
        colors.add(0, "Preto");
        System.out.println(colors);

        System.out.println("Retrieve Element by Index");
        if (colors.size() > 2) {
            String elementAtTwo = colors.get(2);
            System.out.println(elementAtTwo);
        } else {
            System.out.println("Indice 2 invalido");
        }

        System.out.println("Update ArrayList Element");
        if (!colors.isEmpty()) {
            String previous = colors.set(0, "Roxo");
            System.out.println(previous + " -> " + colors.get(0));
        }

        System.out.println("Remove Third Element");
        if (colors.size() > 2) {
            colors.remove(2);
        }
        System.out.println(colors);

        System.out.println("Search Element in ArrayList");
        boolean containsBlue = colors.contains("Azul");
        System.out.println(containsBlue);

        System.out.println("Sort ArrayList");
        Collections.sort(colors);
        System.out.println(colors);

        System.out.println("Copy ArrayList");
        ArrayList<String> colorsCopy = new ArrayList<>(colors);
        System.out.println(colorsCopy);

        System.out.println("Shuffle ArrayList");
        Collections.shuffle(colors);
        System.out.println(colors);

        System.out.println("Reverse ArrayList");
        Collections.reverse(colors);
        System.out.println(colors);

        System.out.println("Extract Sublist from ArrayList");
        int fromIndex = 0;
        int toIndex = Math.min(2, colors.size());
        List<String> sublist = colors.subList(fromIndex, toIndex);
        System.out.println(sublist);

        System.out.println("Compare Two ArrayLists");
        boolean areEqual = colors.equals(colorsCopy);
        System.out.println(areEqual);

        System.out.println("Swap ArrayList Elements");
        if (colors.size() > 2) {
            Collections.swap(colors, 0, 2);
        }
        System.out.println(colors);

        System.out.println("Join Two ArrayLists");
        ArrayList<String> moreColors = new ArrayList<>();
        moreColors.add("Cinza");
        moreColors.add("Laranja");
        ArrayList<String> joined = new ArrayList<>(colors);
        joined.addAll(moreColors);
        System.out.println(joined);

        System.out.println("Clone ArrayList");
        ArrayList<String> cloned = (ArrayList<String>) colors.clone();
        System.out.println(cloned);

        System.out.println("Clear ArrayList");
        ArrayList<String> clearTarget = new ArrayList<>(colors);
        clearTarget.clear();
        System.out.println(clearTarget);

        System.out.println("Check if ArrayList is Empty");
        System.out.println(clearTarget.isEmpty());

        System.out.println("Trim ArrayList Capacity");
        ArrayList<String> capacityList = new ArrayList<>(joined);
        capacityList.trimToSize();
        System.out.println(capacityList.size());

        System.out.println("Increase ArrayList Capacity");
        capacityList.ensureCapacity(50);
        System.out.println("Capacidade garantida");

        System.out.println("Replace Second Element");
        if (colors.size() > 1) {
            colors.set(1, "Magenta");
        }
        System.out.println(colors);

        System.out.println("Print Elements by Position");
        for (int index = 0; index < colors.size(); index++) {
            System.out.println(index + " -> " + colors.get(index));
        }
    }
}
