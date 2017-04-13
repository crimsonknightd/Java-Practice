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
			//�V�K�ǉ�
			root = newItem;
			return true;
		}
		
		//root ������ꍇ�B
		if (root != null){
			ListItem currentItem = root; //���̃A�C�e����Root�ɂ���B
			while (currentItem.previous() != null) {
				currentItem = currentItem.previous();
			}
			while(currentItem != null){
			
				if(currentItem.compareTo(newItem) < 0){
					if (currentItem.next()== null){
						//���̃I�u�W�F�N�g�̎��̃I�u�W�F�N�g���Ȃ���΁A���̃I�u�W�F�N�g���V�����I�u�W�F�N�g��菬�����ꍇ�ǉ�����
						newItem.setPrevious(currentItem);
						currentItem.setNext(newItem);
						return true;	
					} else if (currentItem.next().compareTo(newItem) > 0){
						//�V�I�u�W�F�N�g�����̃I�u�W�F�N�g��菬�����A���̃I�u�W�F�N�g���傫���ꍇ�A���̃I�u�W�F�N�g�Ǝ��̃I�u�W�F�N�g�̊Ԃ��ɑ}���B					
						newItem.setPrevious(currentItem);
						newItem.setNext(currentItem.next());
						currentItem.next().setPrevious(newItem);
						currentItem.setNext(newItem);
						return true;
					} 
				} else if (currentItem.compareTo(newItem) > 0){
					if (currentItem.previous() == null) {
						//�V�I�u�W�F�N�g���̃I�u�W�F�N�g���傫���A���̃I�u�W�F�N�g�̑O�ɃI�u�W�F�N�g���Ȃ��ꍇ�ǉ�����B
						newItem.setNext(currentItem);
						currentItem.setPrevious(newItem);
						root = currentItem.previous();
						currentItem = root;
						return true;
					} else if (currentItem.previous().compareTo(newItem) < 0){
						//�V�I�u�W�F�N�g�����̃I�u�W�F�N�g���傫���A�O�̃I�u�W�F�N�g��菬�����ꍇ�A���̃I�u�W�F�N�g�ƑO�̃I�u�W�F�N�g�̊Ԃɑ}���B						
						newItem.setNext(currentItem);
						newItem.setPrevious(currentItem.previous());
						currentItem.previous().setNext(newItem);
						currentItem.setPrevious(newItem);
						return true;
					}
				} else if (newItem.compareTo(currentItem) == 0){
					//�����I�u�W�F�N�g�����݂���Βǉ����Ȃ��B
					return false;
				}  
				//�����ɓ��Ă͂܂�Ȃ��ꍇ���̃I�u�W�F�N�g���Q�Ƃ��A�܂��J��Ԃ��B
				currentItem = currentItem.next();
			}
			
		}
		
		return false;
	}

	@Override
	public void traverse() {
		if (root == null){
			//���X�g�ɒl���Ȃ�
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
