package com.daong;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        
		MyLinkedList mli = new MyLinkedList();
		String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
		// a b c d m p s
        String[] data = stringData.split(" ");

        for (String s : data) {
            mli.add(new Node(s));
        }
        Scanner sc = new Scanner(System.in);
    	System.out.println("1) Add item\n"
    			+ "2) Next Item \n"
    			+ "3) Previous Item\n"
    			+ "4) Remove Current Item \n"
    			+ "0) Quit");
    	
        boolean running = true;
        while (running){
        	String value = "";
            int input = sc.nextInt();
            
        	sc.nextLine();
        	switch(input){
        	
        	case 1:
        		System.out.println("What do you want to add? ");
        		value = sc.nextLine();
        		mli.add(new Node(value));
        		break;
        	case 2:
        		System.out.println(mli.next());
        		break;
        	case 3:
        		System.out.println(mli.previous());
        		break;
        	case 4:
        		System.out.println(mli.remove() + "removed");
        		break;
        	case 0:
        		running = false;
        		break;
        	default:
        		System.out.println("1) Add item\n"
            			+ "2) Next Item \n"
            			+ "3) Previous Item\n"
            			+ "4) Remove Current Item \n"
            			+ "0) Quit");
        	}
        }
        sc.close();
        
	}
}

