public abstract class Participant{
    private String id;
    private String fullName;
    private String email;

    public Participant(String id, String fullName, String email){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public abstract String describeRole(); //metodo abstratp
    
    //________metodos get________________________

    public String getId() { //retorna o valor do ID
        return this.id;  
    }

    public String getFullName() { //retorna o valor do nome
        return this.fullName;  
    }

    public String getEmail() { //retorna o valor do e-mail
        return this.email;  
    }

    @Override 
    public String toString() { // Constroi e retorna a string formatada direito
        return "ID: " + this.id + " - Nome: " + this.fullName + " - E-mail: " + this.email;
    }

}

