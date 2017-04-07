package com.daong;

public class MyLinkedList implements ListNode{
	ListItem root = null;
	
	public MyLinkedList(){
		root = null;
	}
	public MyLinkedList(ListItem node){
		root = node;
	}
	
	@Override
	public boolean add(ListItem newItem) {
		if (root == null){
			//新規追加
			root = newItem;
			return true;
		}
		
		//root がある場合。
		if (root != null){
			ListItem currentItem = root; //今のアイテムはRootにする。
			while (currentItem.previous() != null) {
				currentItem = currentItem.previous();
			}
			while(true){
			
				if(currentItem.next()== null && currentItem.compareTo(newItem) < 0){
					//今のオブジェクトの次のオブジェクトがなければ、今のオブジェクトが新しいオブジェクトより小さい場合追加する
					newItem.setPrevious(currentItem);
					currentItem.setNext(newItem);
					return true;
				} else if (currentItem.compareTo(newItem) > 0 && currentItem.previous() == null) {
					//新オブジェクト今のオブジェクトより大きく、今のオブジェクトの前にオブジェクトがない場合追加する。
					newItem.setNext(currentItem);
					currentItem.setPrevious(newItem);
					root = currentItem.previous();
					currentItem = root;
					return true;
				} else if (currentItem.compareTo(newItem) < 0 && currentItem.next().compareTo(newItem) > 0){
					//新オブジェクトが今のオブジェクトより小さく、次のオブジェクトより大きい場合、今のオブジェクトと次のオブジェクトの間いに挿入。					
					newItem.setPrevious(currentItem);
					newItem.setNext(currentItem.next());
					currentItem.next().setPrevious(newItem);
					currentItem.setNext(newItem);
					return true;
				} else if (currentItem.compareTo(newItem) > 0 && currentItem.previous().compareTo(newItem) < 0){
					//新オブジェクトが今のオブジェクトより大きく、前のオブジェクトより小さい場合、今のオブジェクトと前のオブジェクトの間に挿入。
					newItem.setNext(currentItem);
					newItem.setPrevious(currentItem.previous());
					currentItem.previous().setNext(newItem);
					currentItem.setPrevious(newItem);
					return true;
				} else if (newItem.compareTo(currentItem) == 0){
					//同じオブジェクトが存在すれば追加しない。
					return false;
				}  
				
				//条件に当てはまらない場合次のオブジェクトを参照し、また繰り返す。
				currentItem = currentItem.next();
				
			}
			
		}
		
		return false;
	}

	@Override
	public ListItem next() {
		ListItem currentItem = root;
		if (root.next() != null){
			root = root.next();
		}
		return currentItem;
	}

	@Override
	public ListItem previous() {
		ListItem currentItem = root;
		if (root.previous() != null){
			root = root.previous();
		}
		
		return currentItem;
		
	}

	@Override
	public ListItem remove() {
		
		ListItem currentItem = root;
		if (root.next() != null){
			root.next().setPrevious(root.previous());
		}
		if (root.previous() != null){
			root.previous().setNext(root.next());
		}
		
		if (root.previous() != null){
			root = root.previous();
		} else if (root.next() != null){
			root = root.next();
		}  

		return currentItem;
	}

}
