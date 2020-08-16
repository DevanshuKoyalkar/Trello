package com.koyald.trello.model;

import java.util.ArrayList;
import java.util.List;

public class TrelloList {
    private static int count = 0;
    private String ID;
    private String name;
    private List<Card> cards;

    public TrelloList(String name) {
        this.ID = Integer.toString(++count);
        this.name = name;
        cards = new ArrayList<Card>();
        System.out.println("new list created with ID:" + this.ID);

    }

    public void addCard(Card l){
        this.cards.add(l);
    }

    public void removeCard(Card l){
        this.cards.remove(l);
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void showList(){
        String s = String.format("\t ID: %S, Name: %s", this.ID, this.name);
        System.out.println(s);
        System.out.println("\t\t The cards in the List are:");
        for(Card c: cards){
            c.showCard();
        }
    }

    public void delete(){
        for(Card c: cards){
            cards.remove(c);
        }
    }
}
