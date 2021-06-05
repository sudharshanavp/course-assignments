import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {
	
	private LineSegment[] segmentArray;
	private int segmentCount;
		
	
	public FastCollinearPoints(Point[] points) {
		
		checkArray(points);
				
		segmentArray = new LineSegment[2];
		segmentCount = 0;
		
		LinkedList<Point> collinearPointsLL = new LinkedList<Point>();
		
		for (Point point : points) {
			
			double prevSlope = 0.0;
			Arrays.sort(points, point.slopeOrder());
			
			for (int i = 0; i < points.length; i++) {
				
				double currentSlope = point.slopeTo(points[i]);
				
				if (i == 0 || currentSlope != prevSlope) {
					
					if (collinearPointsLL.size() >= 3) {
						addSegments(collinearPointsLL.getFirst(), collinearPointsLL.getLast());
					}
					collinearPointsLL.clear();
				}
				collinearPointsLL.add(points[i]);
				prevSlope = currentSlope;
			}
		}
		
	}
	
	private void checkArray(Point[] points) {
		// TODO Auto-generated method stub
		IllegalArgumentException e = new IllegalArgumentException();
		
		if (points == null) {
			throw e;
		}
		
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = 0; j < points.length; j++) {
				if (points[i] == null || points[j] == null) {
					throw e; 
				}
				
				if ((i != j) && (points[i].compareTo(points[j]) == 0)) {
					throw e;
				}
			}
		}
	}
	
	// Add the points to the segment array
	private void addSegments(Point point1, Point point2) {
		LineSegment segment = new LineSegment(point1, point2);
		
		if (segmentCount == segmentArray.length)
		   resizeArray(segmentCount * 2);
		
	   	segmentArray[segmentCount++] = segment;
	}
   
	// resize function to make the array dynamic
	private void resizeArray(int capacity) {	
	   assert capacity >= segmentCount;
	   
	   LineSegment[] copyArray = new LineSegment[capacity];
	   copyArray = Arrays.copyOf(segmentArray, segmentCount);
	   segmentArray = copyArray;
	}
	
    public int numberOfSegments() {
    	return segmentCount;
    }
    public LineSegment[] segments() {
    	return segmentArray;
    }
}