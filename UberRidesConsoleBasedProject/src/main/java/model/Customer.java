package model;

public class Customer {
    private long id ;
    private String name;

    private String email;
    private String phone;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Customer( long id,String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }


}
