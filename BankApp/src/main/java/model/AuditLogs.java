package model;

public class AuditLogs {
    private int id;
    private String email;
    private String action;
    private String description;

    public String email() {
        return email;
    }

    public String action() {
        return action;
    }

    public int id() {
        return id;
    }


    public String description() {
        return description;
    }



    public AuditLogs(int id, String email, String action, String description) {
        this.id = id;
        this.email=email;
        this.action = action;
        this.description = description;
    }


}
