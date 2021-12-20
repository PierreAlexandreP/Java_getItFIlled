package jeu_2048.game;

public class BeginCell extends Cell{


	protected int positionX;
	protected int positionY;
	protected Engine engine;
	protected boolean reached;
    protected String type;
    protected int weight;
    
	public BeginCell(int x, int y,Engine E) {
		this.positionX=x;
		this.positionY=y;		
		this.reached=true;
		this.engine = E;
		this.type="BeginCell";
		this.weight=1;	
	}
	
    
	public String getType() {
		return this.type;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public Engine getEngine() {
		return this.engine;
	}
	public int getWeight() {
		   return this.weight;
	}
	
	public boolean isReached() {
		return this.reached;
	}
	public void setReached(boolean reached) {
		this.reached = reached;
	}
	
	public void enter(Ruban R) {
			if (R.getTab().size()==2) {
				R.remove();
			}	
		}
  
	
	
	
	
	public Cell getTwinCell() {
		return null;
	}
	public void setTwinCell(Cell C) {	
	}	
}
