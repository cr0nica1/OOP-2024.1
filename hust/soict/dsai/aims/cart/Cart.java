package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBER_ORDERED =20;
	private DigitalVideoDisc itemsOrdered[]=
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full.");
		}else {
			itemsOrdered[qtyOrdered++]=disc;
			System.out.println("The disc has been added.");
			
		}
		
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdlist) {
		if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full.");
		}else {
			for(int i=0; i<dvdlist.length;i++ ) {
				itemsOrdered[qtyOrdered++]=dvdlist[i];
				if(qtyOrdered>=MAX_NUMBER_ORDERED) {
					System.out.println("The cart is full.");
					break;
				}
			}
			System.out.println("The list of discs have been added.");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc1,DigitalVideoDisc disc2) {
		if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full.");
			return;
		}
		itemsOrdered[qtyOrdered++]=disc1;
		System.out.println("Disc 1 has been added.");
		if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full.");
			return;
		}
		itemsOrdered[qtyOrdered++]=disc2;
		System.out.println("Disc 2 has been added.");
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].equals(disc)) {
	            
	            for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }
	            itemsOrdered[qtyOrdered - 1] = null;
	            qtyOrdered--;
	            System.out.println("The disc has been removed.");
	            break;
	        }
	    }
	}
	public float totalCost() {
		float cost=0;
		for(int i=0;i< qtyOrdered;i++) {
			if (itemsOrdered[i]!=null) {
				cost+= itemsOrdered[i].getCost();
			}
		}
		return cost;
	}
	public void print() {
		System.out.println("");
		System.out.println("Ordered Items:");
		for(int i=0;i<qtyOrdered;i++) {
			System.out.println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: "+this.totalCost());
	}
	public void search(int id) {
		for(int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i].isMatch(id)==true) {
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		
		}
		System.out.println("Not Found");
	}
	public void search(String title) {
		for(int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i].isMatch(title)==true) {
				System.out.println(itemsOrdered[i].toString());
			return;
			}
		}
		System.out.println("Not Found");
	}
}
