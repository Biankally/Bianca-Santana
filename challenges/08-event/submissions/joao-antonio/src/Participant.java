public abstract class Participant {
     private String id;
    private String fullName;
    private String email;

    public Participant(String id, String fullName, String email){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public abstract String describeRole(); 

    //get

    public String getId() { 
        return this.id;  
    }

    public String getFullName() { 
        return this.fullName;  
    }

    public String getEmail() { 
        return this.email;  
    }

    @Override 
    public String toString() { 
        return "ID: " + this.id + "\nNome completo: " + this.fullName + "\nE-mail: " + this.email;
    }
}
