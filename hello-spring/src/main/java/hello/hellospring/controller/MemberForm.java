package hello.hellospring.controller;

import hello.hellospring.doamin.Member;

public class MemberForm {
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
