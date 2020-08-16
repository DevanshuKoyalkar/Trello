package  com.koyald.trello.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static int count = 0;
    private String ID;
    private String name;
    private PrivacyType privacy;
    private String URL;
    List<User> members;
    List<TrelloList> lists;

    public Board(String name) {
        this.name = name;
        this.ID = Integer.toString(++count);
        this.privacy = PrivacyType.PUBLIC;
        this.URL = this.ID;
        members = new ArrayList<User>();
        lists  = new ArrayList<TrelloList>();
        System.out.println("new board created with ID:" + this.ID);
    }

    public void addUser(User u){
        this.members.add(u);
    }

    public void removeUser(User u){
        this.members.remove(u);
    }

    public void addList(TrelloList l){
        this.lists.add(l);
    }

    public void removeList(TrelloList l){
        this.lists.remove(l);
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

    public PrivacyType getPrivacy() {
        return privacy;
    }

    public void setPrivacy(PrivacyType privacy) {
        this.privacy = privacy;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<TrelloList> getLists() {
        return lists;
    }

    public void setLists(List<TrelloList> lists) {
        this.lists = lists;
    }

    public void showBoard(){
        String s = String.format("ID: %S, Name: %s, Privacy: %s, URL: %s", this.ID, this.name, this.privacy, this.URL);
        System.out.println(s);
        System.out.println("\t The users in the board are:");
        for(User u: members){
            u.show();
        }
        System.out.println("\t The lists in the board are:");
        for(TrelloList l: lists){
            l.showList();
        }
    }

    public void delete(){
        for(TrelloList l: lists){
            l.delete();
            lists.remove(l);
        }
    }
}
