/**
 * 
 */
package projetLog.Control;

import java.util.List;

import jeu_2048.game.BeginCell;
import jeu_2048.game.EndCell;
import jeu_2048.game.Engine;
import jeu_2048.game.Hole;
import jeu_2048.game.OutsideCell;
import jeu_2048.game.ReachableCell;
import jeu_2048.game.Ruban;
import jeu_2048.game.TeleportCell;
import jeu_2048.game.Wall;
import launcher.Item;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author demori_ant
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GameController {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Engine engine;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param Im
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public Ruban ruban;
	private int availableCell=0;
	private int x;
	private int y;
	private int Tx;
	private int Ty;

	
	public GameController(List<Item> items) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code

		this.engine = new Engine();
		this.engine.setHeight(9);	
		this.engine.setWidth(16);
		
		this.ruban=new Ruban();
		
        for (Item item : items) { 
            x=Integer.parseInt(item.getX());
            y=Integer.parseInt(item.getY());

        	if(item.getType().equals("BeginCell")) {		
				this.engine.getPlateau()[x][y]= new BeginCell(x,y,this.engine);					
				this.ruban.add(this.engine.getCell(x,y));
				availableCell++;
				}
        	if(item.getType().equals("ReachableCell")) {
				this.engine.getPlateau()[x][y]= new ReachableCell(x,y,this.engine);	
				availableCell++;
			}
          	if(item.getType().equals("EndCell")) {
				this.engine.getPlateau()[x][y]= new EndCell(x,y,this.engine);	
				availableCell++;
			}
        	if(item.getType().equals("OutsideCell")) {
				this.engine.getPlateau()[x][y]= new OutsideCell(x,y,this.engine);					
			}
        	if(item.getType().equals("Wall")) {
				this.engine.getPlateau()[x][y]= new Wall(x,y,this.engine);					
			}
        	if(item.getType().equals("TeleportCell")) {
				this.engine.getPlateau()[x][y]= new TeleportCell(x,y,this.engine);	
				availableCell++;

			}
			if(item.getType().equals("Hole")) {
				this.engine.getPlateau()[x][y]= new Hole(x,y,this.engine);
				availableCell++;
				availableCell++;
			}
         }
        for (Item item : items) {
  
            x=Integer.parseInt(item.getX());
            y=Integer.parseInt(item.getY());
            if(item.getType().equals("TeleportCell")) {
            	  Tx=Integer.parseInt(item.getTwinx());
                  Ty=Integer.parseInt(item.getTwiny());
            	this.engine.getCell(x,y).setTwinCell(this.engine.getCell(Tx, Ty));	
            }
        }
    	this.engine.setAvailableCells(availableCell);
	}
     
	public int getNumberOfLines(){
		return this.engine.getHeight();
	}
	
	public int getnumberOfColumns(){
		return this.engine.getWidth();
	}
	
}
	