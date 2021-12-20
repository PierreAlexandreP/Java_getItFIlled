/**
 * 
 */
package projetLog.hmi;

import javax.swing.JFrame;

import launcher.Item;
import projetLog.Control.GameController;

import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.KeyEvent;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author demori_ant
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GameWindow extends JFrame implements KeyListener {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GamePanel gamePanel;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GameController gameController;

	/** 
	 * (non-Javadoc)
	 * @see KeyListener#keyTyped(KeyEvent e)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public GameWindow(String titre, List<Item> items){
		this.gamePanel = new GamePanel(75, items);
		this.add(gamePanel);
		this.gameController = this.gamePanel.gameController;
		this.setTitle("GetItFilled");
		this.addKeyListener(this);
	}
	public void keyPressed(KeyEvent e){
		
	}
	public void keyTyped(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
		int touche = e.getKeyCode();
		String mvt = "";
		if(touche == KeyEvent.VK_LEFT){
			mvt = "left";
		} else if(touche == KeyEvent.VK_RIGHT){
			mvt = "right";
		} else if(touche == KeyEvent.VK_UP){
			mvt = "up";
		} else if (touche == KeyEvent.VK_DOWN){
			mvt = "down";
		}
		this.gameController.ruban.go(mvt);
		this.gamePanel.repaint();
		if(this.gameController.engine.isOver(this.gameController.ruban)) {
			System.out.println("Vous avez gagné");
			
		}
	}
}