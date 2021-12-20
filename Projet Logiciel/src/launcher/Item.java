package launcher;

public class Item {
    private String type;
    private String x;
    private String y;
    private String twinx;
    private String twiny;


    @Override
    public String toString() {
        return "Item [type=" + type + ", x=" + x + ", y="
                + y + ", twinx=" + twinx + ", twiny=" + twiny + "]";
    }


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}


	public String getTwinx() {
		return twinx;
	}


	public void setTwinx(String twinx) {
		this.twinx = twinx;
	}


	public String getTwiny() {
		return twiny;
	}


	public void setTwiny(String twiny) {
		this.twiny = twiny;
	}
}