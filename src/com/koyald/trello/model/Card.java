package com.koyald.trello.model;

public class Card {
    private static int count = 0;
    private String ID;
    private String name;
    private String description;
    private String assignee;

    public Card(String name) {
        this.ID = Integer.toString(++count);
        this.name = name;
        this.description = description;
        this.assignee = "NONE";
        System.out.println("new card created with ID:" + this.ID);
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void showCard(){
        String s = String.format("\t\t\t ID: %s, Name: %s, Description: %s, Assinee: %s", this.ID, this.name, this.description, this.assignee);
        System.out.println(s);
    }
}
