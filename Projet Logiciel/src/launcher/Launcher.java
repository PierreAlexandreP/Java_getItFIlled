/**
 * 
 */
package launcher;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Dimension;

import jeu_2048.game.Engine;
import projetLog.hmi.GameWindow;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author demori_ant
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Launcher {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void main(String[] args){

        XMLReader read = new XMLReader();
        List<Item> readConfig = read.readConfig("config.xml");
		GameWindow window = new GameWindow("Get It Filled", readConfig);
		window.setPreferredSize(new Dimension(1290, 800));
		window.pack();
		window.setVisible(true);
	}
}
