import java.util.ArrayList;

public class EventApp {
  public static void main(String[] args) {
    ArrayList<Participant> participants = new ArrayList<>();

    ProfessionalParticipant professional1 = new ProfessionalParticipant("1", "João Carvalho Filho", "joão@gmail.com", "IDP");
    ProfessionalParticipant professional2 = new ProfessionalParticipant("2", "Lucas Oliveira", "lucas@gmail.com", "STF");

    StudentParticipant participant1 = new StudentParticipant(
      "3",
      "Matheus Nilton Biolowons",
      "Matheusn.biolowons@gmail.com",
      "Engenharia de Software",
      3);
    StudentParticipant participant2 = new StudentParticipant(
      "4",
      "Felipe Nogueira",
      "felipe@gmail.com",
      "Ciencia da Computação",
      6);

    participants.add(professional1);
    participants.add(professional2);
    participants.add(participant1);
    participants.add(participant2);

    // https://github.com/fabriciosantana/poo/blob/e8a8184cf9808809888545778671bed10acc74ce/challenges/08-event/test/EventAppTest.java#L33
    System.out.println("Participantes cadastrados");

    for (Participant participant : participants) {
      System.out.println("\n");
      System.out.printf("%s\n%s", participant.toString(), participant.describeRole());
    }
  }
}