package com.daong;

public class Node extends ListItem{

	
	public Node(Object value){
		super(value);
	}
	@Override
	public ListItem next() {
		return this.next;
	}

	@Override
	public ListItem previous() {
		return this.previous;
	}

	@Override
	public int compareTo(ListItem item) {
		if (item != null){
			return super.getValue().toString().toLowerCase().compareTo(item.getValue().toString().toLowerCase());
		} else {
			return -1;	
		}
	}
	@Override
	public ListItem setNext(ListItem next) {
		this.next = next;
		return this.next;
		
	}
	@Override
	public ListItem setPrevious(ListItem previous) {
		this.previous = previous;
		return this.previous;
		
	}

}
