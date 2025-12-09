import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q10 {
    public static void main(String[] args){

        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
        String user = "postgres.snghnxpdoffuasscqmms";
        String password = "idpccpoo";

        final String SELECT_FILM_BY_FILM_ID = "Select title, rental_rate from film where film_id = ?";
        final int FILM_ID = 1000;

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = conn.prepareStatement(SELECT_FILM_BY_FILM_ID);
            ){
                pStm.setInt(1, FILM_ID);
                
                try(ResultSet rs = pStm.executeQuery();){
                    while(rs.next()){
                        System.out.println(rs.getString(1) + " - " + rs.getString(2));
                    }
                }
        } catch(SQLException sqle){
            System.out.println("Erro: " + sqle);
        }
    }
}
