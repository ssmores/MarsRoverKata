package marsRover;

import java.io.*;
import java.util.Arrays;

//Import MarsRover class.
import marsRover.MarsRover;

public class MissionControl {
	//Parse function, taking text file and parsing into mission object. Mission object contains 
	//plateau size, list of directives for each rover.   
	
	//Assume commands are given in a text file called directions.txt.
	public static void main(String[] args) {
		//String fileName = "/Users/ssmores/src/industrial_logic/marsRover/resources/directions.txt";
		String fileName = args[0];
		String line = null;
		MarsRover mr = new MarsRover();
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			if((line = bufferedReader.readLine()) != null) {
				//Parse the first line to assign to MarsRover plateau coordinates
				String delim = " ";
				String[] parsedFirstLine = line.split(delim);

				
				mr.setPlateauUpperXCoor(Integer.parseInt((parsedFirstLine[0])));
				mr.setPlateauUpperYCoor(Integer.parseInt(parsedFirstLine[1]));
			
				while((line = bufferedReader.readLine()) != null) {
					//Set rover's coordinates.
					String[] roverStartPoints = line.split(delim);
					mr.initializeRoverPosition(roverStartPoints);

					//Direct rover.
					String drivingDir = bufferedReader.readLine();
					mr.explore(drivingDir);		
					System.out.println(mr.getxCordinate() + " " + mr.getyCordinate() + " " + mr.getDirectionFacing());
				}
			
			bufferedReader.close();
			
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + fileName + "'");
			ex.printStackTrace();
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}	
}
