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
			while(currentItem != null){
			
				if(currentItem.compareTo(newItem) < 0){
					if (currentItem.next()== null){
						//今のオブジェクトの次のオブジェクトがなければ、今のオブジェクトが新しいオブジェクトより小さい場合追加する
						newItem.setPrevious(currentItem);
						currentItem.setNext(newItem);
						return true;	
					} else if (currentItem.next().compareTo(newItem) > 0){
						//新オブジェクトが今のオブジェクトより小さく、次のオブジェクトより大きい場合、今のオブジェクトと次のオブジェクトの間いに挿入。					
						newItem.setPrevious(currentItem);
						newItem.setNext(currentItem.next());
						currentItem.next().setPrevious(newItem);
						currentItem.setNext(newItem);
						return true;
					} 
				} else if (currentItem.compareTo(newItem) > 0){
					if (currentItem.previous() == null) {
						//新オブジェクト今のオブジェクトより大きく、今のオブジェクトの前にオブジェクトがない場合追加する。
						newItem.setNext(currentItem);
						currentItem.setPrevious(newItem);
						root = currentItem.previous();
						currentItem = root;
						return true;
					} else if (currentItem.previous().compareTo(newItem) < 0){
						//新オブジェクトが今のオブジェクトより大きく、前のオブジェクトより小さい場合、今のオブジェクトと前のオブジェクトの間に挿入。						
						newItem.setNext(currentItem);
						newItem.setPrevious(currentItem.previous());
						currentItem.previous().setNext(newItem);
						currentItem.setPrevious(newItem);
						return true;
					}
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
	public void traverse() {
		if (root == null){
			//リストに値がない
			System.out.println("This List is empty");
			
		} else {
			ListItem currentItem = root;
			while(currentItem != null) {
				System.out.println(currentItem.toString());
				currentItem = currentItem.next();
			}
		}
		
	}
	@Override
	public boolean remove(ListItem item) {
		ListItem currentItem = root;
		while (currentItem != null) {
			if (currentItem.compareTo(item) == 0){
				if (currentItem.next() != null){
					currentItem.next().setPrevious(currentItem.previous());	
				}
				if (currentItem.previous() != null){
					currentItem.previous().setNext(currentItem.next());	
				}
				if (currentItem == this.root){
					root = currentItem.next();
				}
				currentItem.setNext(null);
				currentItem.setPrevious(null);
				currentItem = null;
				return true;
			} else {
				currentItem = currentItem.next();
			}
		}
			
		return false;
	}

}
