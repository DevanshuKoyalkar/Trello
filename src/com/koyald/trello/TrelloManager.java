package com.koyald.trello;

import com.koyald.trello.model.*;
import com.koyald.trello.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrelloManager {
    Map<String, User> usermap;
    Map<String, Board> boardmap;
    Map<String, Card> cardmap;
    Map<String, TrelloList> listmap;
    Map<String, String> list_board;
    Map<String, String> card_list;
    Trello t;

    public TrelloManager() {
        usermap = new HashMap<String, User>();
        boardmap = new HashMap<String, Board>();
        cardmap = new HashMap<String, Card>();
        listmap = new HashMap<String, TrelloList>();
        list_board = new HashMap<String, String>();
        card_list = new HashMap<String, String>();
        t = new Trello();
    }

    public void addBoard(Board b){
        boardmap.put(b.getID(), b);
        t.addBoard(b);
    }

    public void removeBoard(String ID){
        boardmap.get(ID).delete();
        t.removeBoard(boardmap.get(ID));
        boardmap.remove(ID);
    }

    public void addMember(User u){
        usermap.put(u.getUserID(), u);
    }

    public void addMemberToBoard(String ID, String userID){
        boardmap.get(ID).addUser(usermap.get(userID));
    }

    public void removeMemberFromBoard(String ID, String userID){
        boardmap.get(ID).removeUser(usermap.get(userID));
    }


    public void addList(TrelloList l, String boardID){
        listmap.put(l.getID(), l);
        list_board.put(l.getID(), boardID);
        boardmap.get(boardID).addList(l);
    }

    public void removeList(String ID){
        String boardID = list_board.get(ID);
        boardmap.get(boardID).removeList(listmap.get(ID));
        list_board.remove(ID);
        listmap.remove(ID);
    }

    public void addCard(Card c, String listID){
        cardmap.put(c.getID(), c);
        card_list.put(c.getID(), listID);
        listmap.get(listID).addCard(c);
    }

    public void removeCard(String ID){
        String listID = card_list.get(ID);
        listmap.get(listID).removeCard(cardmap.get(ID));
        cardmap.remove(ID);
        card_list.remove(ID);
    }

    public void moveCard(String ID, String toID){
        String listID = card_list.get(ID);
        listmap.get(listID).removeCard(cardmap.get(ID));
        listmap.get(toID).addCard(cardmap.get(ID));
        card_list.put(ID, toID);
    }

    public void addUser(User user){
        usermap.put(user.getUserID(), user);
    }

    public  void show(){
        t.show();
    }

    public void showBoard(String ID){
        boardmap.get(ID).showBoard();
    }

    public void showList(String ID){
        listmap.get(ID).showList();
    }

    public void showCard(String ID){
        cardmap.get(ID).showCard();
    }
}
