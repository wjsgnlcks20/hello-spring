package hello.hellospring.doamin;

public class Member{
    private long member_id;
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setMember_id(long id){
        this.member_id = id;
    }
    public long getMember_id(){
        return this.member_id;
    }
}
