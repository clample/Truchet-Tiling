//CS350 Project1 Chris Lample
//Creates a Truchet Tiling by giving tiles random orientations.
//Has 3 styles of tilings, and reads the parameters
//for tile type(1, 2, or 3) and tile size (in pixels)
//from a file named truchet.txt
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//To-Do: Change input to read from file

public class TruchetGenerator
{

	public static void main(String[] args)
	{
		Scanner s = null;
		
		//default values for tileStyle and tileSize
		int tileStyle = 1;
		int tileSize = 10;
		
		//read truchet.txt
		//truchet.txt should be spelled properly and in bin folder with Tiles and TruchetGenerator
		try {
			s = new Scanner(new BufferedReader(new FileReader("bin/truchet.txt")));
			tileStyle = s.nextInt();
			tileSize = s.nextInt();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		} finally {
			if (s != null) {
				s.close();
			}
		}
		
		JFrame application = new JFrame("Truchet"); // creates a new JFrame
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Tiles panel = new Tiles(tileStyle,tileSize);
		application.add( panel );
	    application.setSize( 500, 500 ); // set the desired size
	    application.setVisible( true ); // show the frame

	}

}
