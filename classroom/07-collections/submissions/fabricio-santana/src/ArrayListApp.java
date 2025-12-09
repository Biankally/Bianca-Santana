import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Verde", "Amarelo", "Azul", "Branco"));
        System.out.println("Create and Print ArrayList: " + colors);

        System.out.println("Iterate ArrayList Elements:");
        for (String color : colors) {
            System.out.println(color);
        }

        colors.add(0, "Roxo");
        System.out.println("Insert at First Position: " + colors);

        if (colors.size() > 2) {
            String retrieved = colors.get(2);
            System.out.println("Retrieve Element by Index (2): " + retrieved);
        } else {
            System.out.println("Retrieve Element by Index (2): indice invalido");
        }

        if (!colors.isEmpty()) {
            String updated = colors.set(colors.size() - 1, "Violeta");
            System.out.println("Update ArrayList Element: substituido " + updated + " por Violeta");
            System.out.println("ArrayList After Update: " + colors);
        }

        if (colors.size() > 2) {
            String removed = colors.remove(2);
            System.out.println("Remove Third Element: " + removed);
            System.out.println("ArrayList After Removal: " + colors);
        } else {
            System.out.println("Remove Third Element: indice invalido");
        }

        boolean containsBlue = colors.contains("Azul");
        System.out.println("Search Element in ArrayList (Azul): " + containsBlue);

        Collections.sort(colors);
        System.out.println("Sort ArrayList: " + colors);

        ArrayList<String> copiedList = new ArrayList<>(colors);
        System.out.println("Copy ArrayList: " + copiedList);

        ArrayList<String> shuffledList = new ArrayList<>(colors);
        Collections.shuffle(shuffledList);
        System.out.println("Shuffle ArrayList: " + shuffledList);

        ArrayList<String> reversedList = new ArrayList<>(colors);
        Collections.reverse(reversedList);
        System.out.println("Reverse ArrayList: " + reversedList);

        int fromIndex = Math.min(1, colors.size());
        int toIndex = Math.min(3, colors.size());
        ArrayList<String> subList = new ArrayList<>(colors.subList(fromIndex, toIndex));
        System.out.println("Extract Sublist from ArrayList: " + subList);

        ArrayList<String> anotherList = new ArrayList<>(colors);
        boolean sameLists = colors.equals(anotherList);
        System.out.println("Compare Two ArrayLists: " + sameLists);

        if (colors.size() > 1) {
            ArrayList<String> swappedList = new ArrayList<>(colors);
            Collections.swap(swappedList, 0, swappedList.size() - 1);
            System.out.println("Swap ArrayList Elements: " + swappedList);
        } else {
            System.out.println("Swap ArrayList Elements: lista pequena demais");
        }

        ArrayList<String> joinedList = new ArrayList<>(colors);
        joinedList.addAll(Arrays.asList("Preto", "Branco"));
        System.out.println("Join Two ArrayLists: " + joinedList);

        @SuppressWarnings("unchecked")
        ArrayList<String> clonedList = (ArrayList<String>) colors.clone();
        System.out.println("Clone ArrayList: " + clonedList);

        ArrayList<String> listToClear = new ArrayList<>(colors);
        listToClear.clear();
        System.out.println("Clear ArrayList: " + listToClear);

        System.out.println("Check if ArrayList is Empty: " + listToClear.isEmpty());

        ArrayList<String> listForTrim = new ArrayList<>(joinedList);
        listForTrim.ensureCapacity(20);
        listForTrim.trimToSize();
        System.out.println("Trim ArrayList Capacity: " + listForTrim);

        ArrayList<String> listForEnsure = new ArrayList<>(colors);
        listForEnsure.ensureCapacity(20);
        System.out.println("Increase ArrayList Capacity: " + listForEnsure);

        if (colors.size() > 1) {
            String replaced = colors.set(1, "Laranja");
            System.out.println("Replace Second Element: substituido " + replaced + " por Laranja");
            System.out.println("ArrayList After Replacing Second Element: " + colors);
        } else {
            System.out.println("Replace Second Element: lista pequena demais");
        }

        System.out.println("Print Elements by Position:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(i + " -> " + colors.get(i));
        }
    }
}
