import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q11 {
    public static void main(String[] args){

        String url = "jdbc:postgresql://localhost:5431/dvdrental";
        String user = "postgres";
        String password = "postgres";

        final String SELECT_FILM_BY_FILM_ID = "Select title, rental_rate from film where film_id = ?";
        final String UPDATE_RENTAL_RATE = "Update film set rental_rate = ? where film_id = ?";

        final int FILM_ID = 1000;
        final double NEW_RENTAL_RATE_VALUE = 12.34;
        
        try(Connection dvdRentalConnection = DriverManager.getConnection(url, user, password);
            PreparedStatement selecFilmByIdStatement = dvdRentalConnection.prepareStatement(SELECT_FILM_BY_FILM_ID);
            PreparedStatement updateRentalRateStatement = dvdRentalConnection.prepareStatement(UPDATE_RENTAL_RATE);
            ){
                dvdRentalConnection.setAutoCommit(false);
                
                updateRentalRateStatement.setDouble(1, NEW_RENTAL_RATE_VALUE);
                updateRentalRateStatement.setInt(2, FILM_ID); 

                updateRentalRateStatement.executeUpdate();

                selecFilmByIdStatement.setInt(1, FILM_ID);
                
                try(ResultSet rs = selecFilmByIdStatement.executeQuery();){
                    while(rs.next()){
                        System.out.println(rs.getString(1) + " - " + rs.getString(2));
                    }
                }

                dvdRentalConnection.rollback();

        } catch(SQLException sqle){
            System.out.println("Erro: " + sqle);
        }
    }
}
