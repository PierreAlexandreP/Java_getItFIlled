package jeu_2048.game;

public abstract class Cell {
	

	protected int positionX;
	protected int positionY;
	protected boolean reached;
	protected Engine engine;
	protected String type;
	protected int weight;
	
	public abstract void enter(Ruban R);
	public abstract String getType();
	public abstract int getWeight();
	public abstract Cell getTwinCell();	
	public abstract boolean isReached();
	public abstract void setReached(boolean b);
	public abstract void setTwinCell(Cell C);

	
	public int getPositionX() {
		return this.positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public Engine getEngine() {
		return this.engine;
	}	
}
