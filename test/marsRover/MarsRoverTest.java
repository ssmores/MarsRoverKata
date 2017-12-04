package marsRover;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsRoverTest {
	
	@Test
	public void initializeLocation() {
		MarsRover rover = new MarsRover();
		String[] location = new String[] {"2", "3", "N"};
		rover.initializeRoverPosition(location);
		assertEquals(rover.getxCordinate(), 2);
		assertEquals(rover.getyCordinate(), 3);
		assertEquals(rover.getDirectionFacing(), "N");
	}
	
	@Test
	public void movesForwardNorth() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(5);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(1);
		rover.setyCordinate(4);
		rover.setDirectionFacing("N");
		rover.explore("M");
		assertEquals(rover.getyCordinate(), 5);
	}
	
	@Test
	public void movesForwardNorthAtEdge() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(4);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(1);
		rover.setyCordinate(5);
		rover.setDirectionFacing("N");
		rover.explore("M");
		assertEquals(rover.getyCordinate(), 5);
	}

	@Test
	public void movesForwardEast() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(5);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(3);
		rover.setyCordinate(0);
		rover.setDirectionFacing("E");
		rover.explore("M");
		assertEquals(rover.getxCordinate(), 4);
	}
	
	@Test
	public void movesForwardEastAtEdge() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(3);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(3);
		rover.setyCordinate(0);
		rover.setDirectionFacing("E");
		rover.explore("M");
		assertEquals(rover.getxCordinate(), 3);
	}
	
	@Test
	public void movesForwardSouth() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(5);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(1);
		rover.setyCordinate(4);
		rover.setDirectionFacing("S");
		rover.explore("M");
		assertEquals(rover.getyCordinate(), 3);
	}
	
	@Test
	public void movesForwardSouthAtEdge() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(5);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(3);
		rover.setyCordinate(0);
		rover.setDirectionFacing("S");
		rover.explore("M");
		assertEquals(rover.getyCordinate(), 0);
	}
	
	@Test
	public void movesForwardWest() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(5);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(5);
		rover.setyCordinate(1);
		rover.setDirectionFacing("W");
		rover.explore("M");
		assertEquals(rover.getxCordinate(), 4);
	}
	
	@Test
	public void movesForwardWestAtEdge() {
		MarsRover rover = new MarsRover();
		rover.setPlateauUpperXCoor(5);
		rover.setPlateauUpperYCoor(5);
		rover.setxCordinate(0);
		rover.setyCordinate(4);
		rover.setDirectionFacing("S");
		rover.explore("M");
		assertEquals(rover.getxCordinate(), 0);
	}
	
	
	@Test
	public void turnsLeftWToS() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("W");
		rover.explore("L");
		assertEquals(rover.getDirectionFacing(), "S");
	}
	
	@Test
	public void turnsLeftSToE() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("S");
		rover.explore("L");
		assertEquals(rover.getDirectionFacing(), "E");
	}
	
	@Test
	public void turnsLeftEToN() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("E");
		rover.explore("L");
		assertEquals(rover.getDirectionFacing(), "N");
	}
	
	@Test
	public void turnsLeftNToW() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("N");
		rover.explore("L");
		assertEquals(rover.getDirectionFacing(), "W");
	}
	
	@Test
	public void turnsRightNToE() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("N");
		rover.explore("R");
		assertEquals(rover.getDirectionFacing(), "E");
	}
	
	@Test
	public void turnsRightEToS() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("E");
		rover.explore("R");
		assertEquals(rover.getDirectionFacing(), "S");
	}
	
	@Test
	public void turnsRightSToW() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("S");
		rover.explore("R");
		assertEquals(rover.getDirectionFacing(), "W");
	}
	
	@Test
	public void turnsRightWToN() {
		MarsRover rover = new MarsRover();
		rover.setDirectionFacing("W");
		rover.explore("R");
		assertEquals(rover.getDirectionFacing(), "N");
	}
	
}
