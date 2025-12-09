import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class FilmFileReader {
    private FilmFileReader() {}

    public static List<Film> read(Path path) throws Exception {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        List<Film> out = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String raw = lines.get(i);
            if (raw == null) continue;
            String line = raw.trim();
            if (line.isEmpty()) continue;

            // pula cabeçalho se detectar "title;"
            if (i == 0 && line.toLowerCase().startsWith("title;")) continue;

            String[] p = line.split(";", -1);
            if (p.length < 5) continue; // malformada → ignora

            try {
                String title = p[0].trim();
                int languageId = Integer.parseInt(p[1].trim());
                int rentalDuration = Integer.parseInt(p[2].trim()); // "rent_duration" no arquivo
                double rentalRate = Double.parseDouble(p[3].trim().replace(',', '.'));
                double replacementCost = Double.parseDouble(p[4].trim().replace(',', '.'));

                if (!title.isEmpty()) {
                    out.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                }
            } catch (NumberFormatException ex) {
                // linha com números inválidos → ignora sem derrubar o programa
            }
        }
        return out;
    }
}
