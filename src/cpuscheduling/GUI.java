package cpuscheduling;

import java.awt.Button;

import javax.swing.JFrame;

public class GUI{
	public GUI() {
		
	}

	public void makeFrame() {
		Test test = new Test();
		JFrame frame = new JFrame();
		final int frameWidth = 300;
		final int frameHeight = 400;
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("CPU Schceduling Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Button browse = new Button("Browse");
		browse.setSize(100, 60);
		browse.setActionCommand("Browse");
		browse.addActionListener(listener);
		frame.add(browse);
		file = listener.getFile();
		Button execute = new Button("Run");
		}
	
	public BrowseListener listener = new BrowseListener();
	public String file;
	}

