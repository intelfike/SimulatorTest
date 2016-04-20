import java.awt.Color;
import java.util.ArrayList;

//---1D
public class Line{
	ArrayList<Point> points = new ArrayList<Point>();
	ArrayList<String> texts;
	Color color;

	public void addPoint(Point p){
		points.add(p);
	}
/*	public void addPoint(int x, int y){
		points.add(new Point(x, y));
	}

	public void setColor(Color color){
		this.color = color;
	}
*/
	public double getAngle(){
		Point p1 = points.get(0);
		Point p2 = points.get(1);
		Point p3 = points.get(2);
		double vec12[] ={p1.x - p2.x,  p1.y - p2.y };
		double vec23[] ={p3.x - p2.x,  p3.y - p2.y };

		double vec1223 = vec12[0]*vec23[0]+vec12[1]*vec23[1];
		double absvec12 = Math.sqrt(Math.pow(vec12[0], 2) + Math.pow(vec12[1], 2));
		double absvec23 = Math.sqrt(Math.pow(vec23[0], 2) + Math.pow(vec23[1], 2));

		return Math.toDegrees(Math.acos(vec1223 / (absvec12 * absvec23)));
	}
}