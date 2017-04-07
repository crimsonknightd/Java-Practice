package com.daong;

public abstract class ListItem {
	protected ListItem next = null;
	protected ListItem previous = null;
	private Object value;
	
	public ListItem(){}
	
	public ListItem(Object value) {
		super();
		this.value = value;

	}

	@Override
	public String toString() {
		return value.toString();
	}
	

	public abstract ListItem setNext(ListItem next);
	public abstract ListItem setPrevious(ListItem previous);
	public abstract ListItem next();
	public abstract ListItem previous();
	public abstract int compareTo(ListItem item);
	
	protected Object getValue(){
		return value;
	}
		
}
