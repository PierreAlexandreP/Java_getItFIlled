package jeu_2048.game;
import java.awt.Color;
import java.util.ArrayList;

public class Ruban {

	private ArrayList<Cell> tab;
	
	public Ruban() {
		this.tab = new ArrayList <Cell>();
		}
	
	public void add(Cell c) {
		this.tab.add(c);
		c.setReached(true);
	}

	public void remove() {
		this.tab.get(this.tab.size()-1).setReached(false);
		this.tab.remove(this.tab.size()-1);
	}
	
	public Cell getLastCell() {
		return this.tab.get(this.tab.size()-1);
	}
	public Cell getSecondLastCell() {
		if(this.tab.size()>1) {
		return this.tab.get(this.tab.size()-2);
		}
		else {
	    return this.tab.get(this.tab.size()-1);	
		}
	}
	public int countCell(Cell C) {
		int count=0;
		int size=this.tab.size();
		for(int i=0;i<size;i++) {
			if(this.tab.get(i)==C) {
				count++;
			}
		}		
		return count;		
	}
	
	public String getDirection (Cell C1, Cell C2) {
		String direction;
		int colonne =C1.getPositionX();
		int ligne =C1.getPositionY();
		int colonneSuivante =C2.getPositionX();
		int ligneSuivante =C2.getPositionY();
		System.out.println(colonne+" "+ligne+" "+colonneSuivante+" "+ligneSuivante);
		if (colonneSuivante==colonne+1 && ligne == ligneSuivante) {
			direction = "down";
		}
		else if (colonneSuivante==colonne-1 && ligne == ligneSuivante) {
			direction = "up";
		}
		else if (colonneSuivante==colonne && ligneSuivante==ligne+1) {
			direction = "right";
		}
		else if (ligneSuivante==ligne-1 && colonneSuivante==colonne) {
			direction = "left";
		}
		else {
			direction = "rien";
		}
		return direction;
	}
	
	public void go(String direction) {
		Cell current_cell  = this.getLastCell();
		Cell next_cell = current_cell.getEngine().getNeighbor(current_cell, direction);
		next_cell.enter(this);
	}
	
	
	public boolean possessAlready(Cell C) {
		return this.tab.contains(C);		
	}
	
	public ArrayList <Cell> getTab(){
		return this.tab;
	}
}

