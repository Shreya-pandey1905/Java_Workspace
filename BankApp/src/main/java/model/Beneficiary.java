package model;

public class Beneficiary {
    private int id;
    private String name;

    private long account_no;
    private String ifsc;
    private String nickname;
    private int user_id;

    public int user_id() {
        return user_id;
    }

    public Beneficiary(int id,String name, long account_no, String ifsc, String nickname,int user_id) {
this.id=id;
        this.name = name;
        this.account_no = account_no;
        this.ifsc = ifsc;
        this.nickname = nickname;
        this.user_id = user_id;
    }


    public long account_no() {
        return account_no;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String ifsc() {
        return ifsc;
    }

    public String nickname() {
        return nickname;
    }

}
