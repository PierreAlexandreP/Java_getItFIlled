package jeu_2048.game;


public class Hole extends Cell {

	
	protected int positionX;
	protected int positionY;
	protected boolean reached;
	protected Engine engine;
	protected String type;
	protected int weight;
		
		public Hole(int x, int y, Engine E){
			this.positionX=x;
			this.positionY=y;
			this.reached=false;
			this.engine=E;
			this.weight=2;
			this.type="Hole";
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
		
		public int getWeight() {
			return this.weight;
		}
		public String getType() {
			return this.type;
		}
		public void enter(Ruban R) {
				if (R.getSecondLastCell() == this) {
					R.remove();
				}
				else if(R.countCell(this)<2){
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

		public void setTwinCell(Cell C) {		
		}
		public Cell getTwinCell() {
			return null;
		}
}
