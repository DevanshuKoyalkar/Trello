package com.koyald.trello;

import com.koyald.trello.model.Board;
import com.koyald.trello.model.Card;
import com.koyald.trello.model.TrelloList;
import com.koyald.trello.model.User;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String [] args) throws InterruptedException {
        TrelloManager manager = new TrelloManager();

        Scanner scanner = new Scanner(System.in);
        String command;
        while(true){
            TimeUnit.MILLISECONDS.sleep(250);
            try{
               command  = scanner.nextLine();
            }
            catch(Exception E){
                break;
            }

            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch (commandType) {
                case "MEMBER":
                    manager.addMember(new User(commands[1]));
                case "SHOW":
                    if (commands.length == 1)
                        manager.show();
                    else {
                        switch ( commands[1]) {
                            case "BOARD":
                                manager.showBoard(commands[2]);
                                break;
                            case "LIST":
                                manager.showList(commands[2]);
                                break;
                            case "CARD":
                                manager.showList(commands[2]);
                                break;
                        }
                    }
                    break;
                case "BOARD":
                    if (commands[1].equalsIgnoreCase("CREATE") )
                        manager.addBoard(new Board(commands[2]));
                    else if (commands[1].equalsIgnoreCase("DELETE") )
                        manager.removeBoard(commands[2]);
                    else if(commands[2].equalsIgnoreCase("ADD_MEMBER") )
                        manager.addMemberToBoard(commands[1], commands[3]);
                    else if(commands[2].equalsIgnoreCase("REMOVE_MEMBER") )
                        manager.removeMemberFromBoard(commands[1], commands[3]);
                    break;
                case "LIST":
                    if (commands[1].equalsIgnoreCase("CREATE") )
                        manager.addList(new TrelloList(commands[3]), commands[2]);
                    else if (commands[1].equalsIgnoreCase("DELETE") )
                        manager.removeList(commands[2]);
                    break;
                case "CARD":
                    if (commands[1].equalsIgnoreCase("CREATE") )
                        manager.addCard(new Card(commands[3]), commands[2]);
                    else if (commands[1].equalsIgnoreCase("DELETE") )
                        manager.removeCard(commands[2]);
                    else if(commands[1].equalsIgnoreCase("MOVE") )
                        manager.moveCard(commands[2], commands[3]);
                    break;
            }
        }
    }
}
