package cpuscheduling;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class BrowseListener implements ActionListener {     

		public void actionPerformed(ActionEvent arg0) {   
			JFileChooser chooser= new JFileChooser();
			int choice = chooser.showOpenDialog(chooser);
			if (choice != JFileChooser.APPROVE_OPTION) return;
			File _chosenFile = chooser.getSelectedFile();
			chosenFile = _chosenFile.getPath();
			System.out.println(chosenFile);
			} 
		
		public String getFile() {
			return chosenFile;
		}
	public String chosenFile;
		} 
