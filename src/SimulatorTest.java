import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//main Execution
public class SimulatorTest extends JFrame {
	public final TestCanvas canvas;
	public JPanel p;
	public JButton btnTest;
	public JButton btnClear;
	
	
	public static void main(String[] args) {
		new SimulatorTest("SimulatorTest");
	}
	
	public SimulatorTest(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new TestCanvas();
		canvas.setBounds(0, 0, TestCanvas.CANVAS_WIDTH_MAX, TestCanvas.CANVAS_HEIGHT_MAX);
		canvas.setBackground(Color.white);
		setSize(canvas.getWidth(), canvas.getHeight() + 100);
		
		int buttonX = canvas.getWidth()/ 2 - 40;
		int buttonY = canvas.getHeight();
		
		btnTest = new JButton("TEST");
		btnTest.setBounds(buttonX, buttonY, 80, 30);
		btnTest.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					Test();
				}
			}
		);
		
		btnClear = new JButton("CLEAR");
		btnClear.setBounds(buttonX + 100, buttonY, 80, 30);
		btnClear.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					canvas.clear();
				}
			}
		);
		
		
		p = new JPanel();
		p.setLayout(null);
		p.add(canvas);
		p.add(btnTest);
		p.add(btnClear);
		getContentPane().add(p, BorderLayout.CENTER);
		
		
		setVisible(true);
		
	}
	
	//---this run when press "Test" button.
	public void Test(){
		Random rnd = new Random();
		
		//---create Point and Line
		Line sankaku = new Line();
		for(int n = 0; n < 3; n++)
			sankaku.addPoint(new Point(rnd.nextInt(canvas.getWidth()), rnd.nextInt(canvas.getHeight())));
		
		//---create Graphic
		canvas.addLine(sankaku);
		
		System.out.printf("%.1f‹\n",sankaku.getAngle());
	}

	
}