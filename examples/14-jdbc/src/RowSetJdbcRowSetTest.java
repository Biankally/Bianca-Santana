import java.sql.ResultSetMetaData; 
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetJdbcRowSetTest { 

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres"; 
    private static final String USERNAME = "postgres"; 
    private static final String PASSWORD = "postgres"; 

    public static void main(String args[]) { 
        
        try(JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()){
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT * FROM film LIMIT 10");
            rowSet.execute();

            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.printf("Filmes:%n%n");

            for (int i = 1; i <= numberOfColumns; i++){
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (rowSet.next()){
                for (int i = 1; i <= numberOfColumns; i++){
                    System.out.printf("%-8s\t", rowSet.getObject(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}