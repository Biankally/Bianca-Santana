import java.util.ArrayList;
import java.util.List;


public class EventApp {

    public static void main(String[] args) {
        List<Participant> participantsList = new ArrayList<>();

        participantsList.add(new StudentParticipant(

            "24201186",
            "Leticia Tavares",
            "leletavares@mail.com",
            "Engenharia de Software",
            3

        ));

        participantsList.add(new StudentParticipant(

            "12345678",
            "Patricia Batista",
            "patibatista@mail.com",
            "Ciência da Computação",
            8

        ));

        participantsList.add(new ProfessionalParticipant(

            "87654321",
            "Carla Mendes",
            "carlamendes@orgtec.com",
            "organizacao de tec"

        ));

        participantsList.add(new ProfessionalParticipant(

            "11223344",
            "Daniel Oliveira",
            "danielo@inovahub.com",
            "Innovacao hub"

        ));
        
           
        System.out.println("IDP TEC WEEK - LISTA DE PARTICIPANTES");
       

        for (Participant p : participantsList) {
         
            System.out.println(p.toString());
            
            System.out.println(p.describeRole());
            
         
        }
        
        System.out.println("fim da lista");
    }
}

       
    


        