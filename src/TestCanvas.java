import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

//---2D
public class TestCanvas extends JPanel {
	Graphics2D g2;

	public static final int CANVAS_WIDTH_MAX = 600;
	public static final int CANVAS_HEIGHT_MAX = 400;

	public ArrayList<Line> lines = new ArrayList<Line>();

	public TestCanvas(){
		setPreferredSize(new Dimension(CANVAS_WIDTH_MAX, CANVAS_HEIGHT_MAX));
	}

	public void paintComponent(Graphics g) {
		this.g2 = (Graphics2D)g;

		g.setColor(Color.white);
		g.fillRect(0, 0, CANVAS_WIDTH_MAX, CANVAS_HEIGHT_MAX);
		System.out.printf("paint\n");
		if(0 < lines.size())System.out.print("draw Point ");
		for(int i = 0; i < lines.size(); i++ ){
			Line line = lines.get(i);
			int[] x = new int[line.points.size()];
			int[] y = new int[line.points.size()];
			
			for(int j = 0; j < line.points.size(); j++){
				Point point = line.points.get(j);
				//this.points.add(point);
				x[j] = point.x;
				y[j] = point.y;
				g2.setColor(point.color);
				g2.drawRect(point.x, point.y, 3, 3);
				g2.drawString(point.text, point.x - 10, point.y - 10);
				System.out.print(j + ":");
			}
			g2.setColor(line.color);
			g2.drawPolygon(x, y, line.points.size());
		}
		System.out.println("\b|");
	}

	public void addLine(Line line){
		this.lines.add(line);
		repaint();
	}
	
	//---this run when press "Clear" button.
	public void clear(){
		lines.clear();
		if(0 < lines.size())
			System.out.printf("clear\n");
		else
			System.out.printf("fail clear\n");
		repaint();
	}
}