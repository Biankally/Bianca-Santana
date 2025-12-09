import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private final List<RentalSummary> summaries;
    private final String path;

    public Report(String path, List<RentalSummary> summaries) {
        this.summaries = summaries;
        this.path = path;
    }

    public void generateCSV() {
        System.out.printf("Gerando CSV para %d entidades\n", summaries.size());
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.path))) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
