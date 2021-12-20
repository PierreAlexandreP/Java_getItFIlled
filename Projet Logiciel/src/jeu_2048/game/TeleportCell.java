package jeu_2048.game;

import java.awt.Color;
import java.util.ArrayList;

public class TeleportCell extends Cell {

	
	protected int positionX;
	protected int positionY;
	protected boolean reached;
	protected Engine engine;
	protected Cell twinCell;
	protected int weight;
	protected String type;
	
	
		public TeleportCell(int x, int y, Engine E){
			this.positionX=x;
			this.positionY=y;
			this.reached=false;
			this.engine=E;
			this.type="TeleportCell";
		}
		public void setTwinCell(Cell twin) {
			this.twinCell=twin;
		}	
		public Cell getTwinCell() {
			return this.twinCell;
		}
		public Engine getEngine() {
			return this.engine;
		}
		
		
		public boolean isReached() {
			return reached;
		}
		public void setReached(boolean reached) {
			this.reached = reached;
		}
		public String getType() {
			return this.type;
		}
		public int getWeight() {
			return this.weight;
		}

		public void enter(Ruban R) {
				if (R.getSecondLastCell() != this) {
					if (!R.possessAlready(this)){
					ArrayList <Cell> subRuban = new ArrayList <Cell>();
					Cell current=R.getLastCell();
					Cell twin=this.twinCell;
					String direction=R.getDirection(current, this);
					Cell ultimate = this.engine.getNeighbor(twin, direction);
					subRuban.add(this);
					subRuban.add(twin);		
						while (ultimate.getType()=="TeleportCell"){
							subRuban.add(ultimate);
							subRuban.add(ultimate.getTwinCell());
							ultimate = this.engine.getNeighbor(ultimate.getTwinCell(), direction);
						}
					subRuban.add(ultimate);						
					if(!ultimate.isReached() && ultimate.getType() != "Wall" && ultimate.getType() != "OutsideCell") {
						for(int i=0; i<subRuban.size();i++) {
							R.add(subRuban.get(i));
						}				
					}
						else {	
						}
					}
				}
			    else {
			    	R.remove();
			    	while(R.getLastCell().getType()=="TeleportCell") {
			    	R.remove();
			    	}
			    }
				
			}	
		public int getPositionY() {
			return positionY;
		}

		public void setPositionY(int positionY) {
			this.positionY = positionY;
		}

		public int getPositionX() {
			return positionX;
		}

		public void setPositionX(int positionX) {
			this.positionX = positionX;
		}
}
