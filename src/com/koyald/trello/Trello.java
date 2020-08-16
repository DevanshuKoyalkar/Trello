package com.koyald.trello;

import com.koyald.trello.model.Board;
import com.koyald.trello.model.Card;
import com.koyald.trello.model.TrelloList;
import com.koyald.trello.model.User;

import java.util.ArrayList;
import java.util.List;

public class Trello {
    List<Board> boards;

    public Trello() {
        boards = new ArrayList<Board>();
    }

    public void addBoard(Board l){
        this.boards.add(l);
    }

    public void removeBoard(Board l){
        this.boards.remove(l);
    }

    public void show(){
        for( Board b: boards){
            b.showBoard();
        }
    }
}
