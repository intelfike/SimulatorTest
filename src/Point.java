import java.awt.Color;

//---0D
public class Point{
	int x;
	int y;
	String text = "";
	Color color = Color.black;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
/*---Don't use now
	public Point(){
		this(0,0);
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public String toString(){
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public void setText(String text){
		this.text = text;
	}
	public String getText(){
		return this.text;
	}

	public void setColor(Color color){
		this.color = color;
	}
*/
}