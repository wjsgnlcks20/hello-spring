package hello.hellospring.doamin;


import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
public class Member{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long member_id;
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setid(long id){
        this.member_id = id;
    }
    public long getid(){
        return this.member_id;
    }
}
