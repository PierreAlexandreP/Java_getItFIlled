/**
 * 
 */
package jeu_2048.game;
import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author demori_ant
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Engine {

	private int height=9;
	private int width=16;
	private int availableCells = 0;
	private Cell[][] plateau = new Cell[height][width];

	public Engine() {
	}
	
	public Cell[][] getPlateau(){
		return this.plateau;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setWidth(int width){
	 this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	public int getAvailableCells(){
		return this.availableCells;
	}
	public void setAvailableCells(int nb){
	 this.availableCells=nb;
	}
	
	public Cell getCell(int l, int c){
		return this.plateau[l][c];
	}
	
	public void increase_availableCell() {
		this.availableCells++;
	}
	
	public Cell getRightCell(Cell C) {
		if(C.getPositionY()<this.width-1) {
		Cell D=this.getCell(C.getPositionX(),1+C.getPositionY());
		return D;
		}
		else {
		return C;
		}
	}
	public Cell getLeftCell(Cell C) {
		if(C.getPositionY()> 0) {
		Cell D=this.getCell(C.getPositionX(),C.getPositionY()-1);
		return D;
		}
		else {
		return C;
		}
	}
	public Cell getUpCell(Cell C) {
		if(C.getPositionX()> 0) {
		Cell D=this.getCell(C.getPositionX()-1,C.getPositionY());
		return D;
		}
		else {
		return C;
		}
	}
	public Cell getDownCell(Cell C) {
		if(C.getPositionX()<this.height-1) {
		Cell D=this.getCell(C.getPositionX()+1,C.getPositionY());
		return D;
		}
		else {
		return C;
		}
	}
	
	public Cell getNeighbor(Cell current_cell, String direction) {
		if(direction.equals("right")) {
			return this.getRightCell(current_cell);
		}
		else if(direction.equals("left")) {
			return this.getLeftCell(current_cell);
		}
		else if(direction.equals("up")) {
			return this.getUpCell(current_cell);
		}
		else if(direction.equals("down")) {
			return this.getDownCell(current_cell);
		}
		else  {
			return current_cell;			
		}
	}
	// Verifie que la partie est termin�e
	public boolean isOver(Ruban R){
		if ((R.getTab().size()==this.availableCells) && (R.getLastCell().getType()=="EndCell")){
			return true;
		}
		else {
			return false;
		}
		}

}
