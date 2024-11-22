package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[]=new DigitalVideoDisc[20];
	private int qtyOrdered=0;
	public void addDVD( DigitalVideoDisc dvd) {
		itemsInStore[qtyOrdered++]=dvd;
		System.out.println("The disc has been added.");
	}
	public void removeDVD(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsInStore[i].equals(disc)) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}
				itemsInStore[qtyOrdered - 1] = null;
	            qtyOrdered--;
	            System.out.println("The disc has been removed.");
	            break;
			}
		}
	}
	public void print() {
		System.out.println("Items:");
		for(int i=0;i<qtyOrdered;i++) {
			System.out.println(itemsInStore[i].toString());
		}
	}
	
}
