package jeu_2048.game;


public class ReachableCell extends Cell {

	
	protected int positionX;
	protected int positionY;
	protected boolean reached;
	protected Engine engine;
	protected int weight;
	protected String type;
	
	
		public ReachableCell(int x, int y, Engine E){
			this.positionX=x;
			this.positionY=y;
			this.reached=false;
			this.engine=E;
			this.type="Regular";
			this.weight=1;	
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

		public void enter(Ruban R) {
			if (R.possessAlready(this)){
				if (R.getSecondLastCell() == this) {
					R.remove();
				}	
			}
			else {
				R.add(this);
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
		
		public String getType() {
			return this.type;
		}
		public int getWeight() {
			return this.weight;
		}

		public void setTwinCell(Cell C) {		
		}
		public Cell getTwinCell() {
			return null;
		}
}
