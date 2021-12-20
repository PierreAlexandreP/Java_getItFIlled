/**
 * 
 */
package projetLog.hmi;

import javax.swing.JPanel;

import jeu_2048.game.Cell;
import launcher.Item;
import projetLog.Control.GameController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author demori_ant
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GamePanel extends JPanel {

	public GameController gameController;
	private int squareSize;
 GamePanel(int i, List<Item> items){
		this.squareSize = i;
		this.gameController = new GameController(items);		
	}
	
	Color col = Color.red;

	
	public void paint(Graphics g){
		int l = this.gameController.getNumberOfLines();
		int c = this.gameController.getnumberOfColumns();
		ArrayList<Cell> teleport = new ArrayList <Cell>();
		Cell t1;
		Cell t2;
		
		// Coloriage des cases du plateau en noir
		for (int ligne = 0; ligne<l ; ligne++){
			for (int colonne = 0 ; colonne < c ; colonne++){
				col = new Color(30,30,50);
			    g.setColor(col);
				g.fillRect(colonne*(this.squareSize+5), ligne*(this.squareSize+5), this.squareSize, this.squareSize);
				if(this.gameController.engine.getCell(ligne, colonne).getType().equals("Wall")) {
					col = new Color(200,200,200);	
				    g.setColor(col);
					g.fillRect(colonne*(this.squareSize+5)+5, ligne*(this.squareSize+5)+5, this.squareSize-10, this.squareSize-10);
				}
	
			  if(this.gameController.engine.getCell(ligne, colonne).getType().equals("OutsideCell")) {
				col = new Color(0,0,0);	
			    g.setColor(col);
				g.fillRect(colonne*(this.squareSize+5), ligne*(this.squareSize+5), this.squareSize+5, this.squareSize+5);
			}
		}
		}
		int CompteurTeleport =0;

		// Coloriage des cases spéciales
		for (int ligne = 0; ligne<l ; ligne++){
			for (int colonne = 0 ; colonne < c ; colonne++){
			
			
				if(this.gameController.engine.getCell(ligne, colonne).getType().equals("EndCell")) {
					col=new Color(0,0,255);
				    g.setColor(col);
					g.fillRect(colonne*(this.squareSize+5), ligne*(this.squareSize+5), this.squareSize, this.squareSize);
				}
				if(this.gameController.engine.getCell(ligne, colonne).getType().equals("Hole")) {
					col=new Color(135,31,120);
				    g.setColor(col);
					g.fillRect(colonne*(this.squareSize+5), ligne*(this.squareSize+5), this.squareSize-60, this.squareSize-60);
					g.fillRect(colonne*(this.squareSize+5), ligne*(this.squareSize+5)+this.squareSize-15, this.squareSize-60, this.squareSize-60);
					g.fillRect(colonne*(this.squareSize+5)+this.squareSize-15, ligne*(this.squareSize+5), this.squareSize-60, this.squareSize-60);
					g.fillRect(colonne*(this.squareSize+5)+this.squareSize-15, ligne*(this.squareSize+5)+this.squareSize-15, this.squareSize-60, this.squareSize-60);
					g.fillRect(colonne*(this.squareSize+5)+10, ligne*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);

				}
				if(this.gameController.engine.getCell(ligne, colonne).getType().equals("TeleportCell")) {
					t1=this.gameController.engine.getCell(ligne, colonne);
					t2=t1.getTwinCell();
					System.out.println(t1.getPositionX()+"  "+t1.getPositionY());
					System.out.println(t2.getPositionX()+"  "+t2.getPositionY());

					if(!teleport.contains(t1)) {
					if (CompteurTeleport<2) {
						col=new Color(0,0,255);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+1, ligne*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+10, ligne*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
						
						col=new Color(0,0,255);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+1, t2.getPositionX()*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
						g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+10, t2.getPositionX()*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);					
					}
					if (CompteurTeleport<4 && CompteurTeleport>=2) {
						col=new Color(255,0,0);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+1, ligne*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+10, ligne*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
						
						col=new Color(255,0,0);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+1, t2.getPositionX()*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+10, t2.getPositionX()*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
						
					}
					if (CompteurTeleport<6 && CompteurTeleport>=4) {
						col=new Color(0,255,0);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+1, ligne*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+10, ligne*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
						
						col=new Color(0,255,0);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+1, t2.getPositionX()*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+10, t2.getPositionX()*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
						
					}
					if (CompteurTeleport>=6) {
						col=new Color(158,68,68);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+1, ligne*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+10, ligne*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
	
						col=new Color(158,68,68);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+1, t2.getPositionX()*(this.squareSize+5)+1, this.squareSize-1, this.squareSize-1);
						col = new Color(30,30,50);
					    g.setColor(col);
						g.fillRect(t2.getPositionY()*(this.squareSize+5)+10, t2.getPositionX()*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
						
					}
					teleport.add(t1);
					teleport.add(t2);
					CompteurTeleport=CompteurTeleport+2;
					}
				}
				g.setFont(g.getFont().deriveFont(Font.BOLD, 15.0f));
		//		g.drawString(i + "", colonne*(this.squareSize+5) + this.squareSize/2, ligne*(this.squareSize+5) + this.squareSize/2);

			}
		}
		// Ruban
		for (int ligne = 0; ligne<l ; ligne++){
			for (int colonne = 0 ; colonne < c ; colonne++){
				boolean i = this.gameController.engine.getCell(ligne, colonne).isReached();
				if(i) {
					col = new Color(65,140,60);
					g.setColor(col);
					g.fillRect(colonne*(this.squareSize+5)+10, ligne*(this.squareSize+5)+10, this.squareSize-20, this.squareSize-20);
					if (this.gameController.engine.getCell(ligne, colonne)==this.gameController.ruban.getLastCell()) {
						col = new Color(0,189,0);
						g.setColor(col);
						g.fillRect(colonne*(this.squareSize+5)+15, ligne*(this.squareSize+5)+15, this.squareSize-30, this.squareSize-30);
					}			
				}
			}
		}
		
		// Intersections des cases
		if (this.gameController.ruban.getTab().size()>1) {
			for (int parcourt = 0; parcourt<this.gameController.ruban.getTab().size()-1 ; parcourt++){
					int colonne =this.gameController.ruban.getTab().get(parcourt).getPositionX();
					int ligne =this.gameController.ruban.getTab().get(parcourt).getPositionY();
					int colonneSuivante =this.gameController.ruban.getTab().get(parcourt+1).getPositionX();
					int ligneSuivante =this.gameController.ruban.getTab().get(parcourt+1).getPositionY();
					// BIEN INDIQUER LES 4 DEPLACEMENTS POSSIBLES = PAS BESOIN DES RETOURS. A CHAQUE FOIS ON COMPLETE LE RUBAN AVANT
					//deplacement Bas
					if (colonneSuivante==colonne+1) {
						col = new Color(65,140,60);
					g.setColor(col);
					g.fillRect(ligne*(this.squareSize+5)+5,colonne*(this.squareSize+5),this.squareSize-20,this.squareSize);
				}
					//deplacement haut
					if (colonneSuivante==colonne-1) {
					col = new Color(65,140,60);
					g.setColor(col);
					g.fillRect(ligneSuivante*(this.squareSize+5)+20,colonneSuivante*(this.squareSize+5)+20,this.squareSize-30,this.squareSize+15);
				}
					//deplacement Droite 
					if (ligneSuivante==ligne+1) {
					col = new Color(65,140,60);
					g.setColor(col);
					g.fillRect(ligne*(this.squareSize+5)+20,colonne*(this.squareSize+5)+20,(this.squareSize+5)+10,this.squareSize-40);	
				}
					//deplacement Gauche 
					if (ligneSuivante==ligne-1) {
					col = new Color(65,140,60);
					g.setColor(col);
					g.fillRect(ligneSuivante*(this.squareSize+5)+20,colonneSuivante*(this.squareSize+5)+20,(this.squareSize+5)+10,this.squareSize-40);	
				}
			}
		}
	}
}
	
	

	