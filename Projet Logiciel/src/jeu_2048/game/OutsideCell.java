package jeu_2048.game;

public class OutsideCell extends Cell {
		
		protected int positionX;
		protected int positionY;
		protected Engine engine;
		protected boolean reached;
		protected String type;
		protected int weight;
		
		public OutsideCell(int x, int y, Engine E){
				this.positionX=x;
				this.positionY=y;
				this.engine=E;
				this.reached=false;
				this.weight=0;
				this.type="OutsideCell";
			}
			
			public Engine getEngine() {
				return this.engine;
			}
			
			public void enter(Ruban R) {
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


			
			public boolean isReached() {
				return false;
			}

			public void setReached(boolean b) {		
			}
			public void setTwinCell(Cell C) {				
			}
			public Cell getTwinCell() {
				return null;
			}
			public String getType() {
				return this.type;
			}
			public int getWeight() {
				return 0;
			}



	}
