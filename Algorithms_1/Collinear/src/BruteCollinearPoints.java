import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

	private LineSegment[] segmentArray;
	private int segmentCount;
	
	public BruteCollinearPoints(Point[] points) { 
		
		checkArray(points);
		
		segmentArray = new LineSegment[2];
		segmentCount = 0;
		
		for (int i = 0; i < points.length - 3; i++) {
			for (int j = i + 1; j < points.length - 2; j++) {
				for (int j2 = j + 1; j2 < points.length - 1; j2++) {
					for (int k = j2 + 1; k < points.length; k++) {
						if (comparePoints(points[i], points[j], points[j2], points[k])) {
							addSegments(points[i], points[k]);
						}
					}
				}
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

	// Compare the 4 points' slope and return the boolean value
	private boolean comparePoints(Point p1, Point p2, Point p3, Point p4) {
		return ((p1.slopeTo(p2) == p2.slopeTo(p3)) && (p2.slopeTo(p3) == p3.slopeTo(p4))); 
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
	
	public static void main(String[] args) {

	    // read the n points from a file
	    In in = new In(args[0]);
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
}