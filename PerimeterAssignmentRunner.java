import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            numPoints = numPoints + 1;
            prevPt = currPt;
        }
        
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avgLength = getPerimeter(s) /(double) getNumPoints(s);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(largestSide < currDist){
                largestSide = currDist;
                //System.out.println("SideLength" + (i) + "<"+ "SideLength" + (i+1));
            }
            else if(largestSide > currDist){
                largestSide = largestSide;
                //System.out.println("SideLength" + (i) + ">"+ "SideLength" + (i+1));
            }
            else{
                //System.out.println("SideLength" + (i) + "=="+ "SideLength" + (i+1));
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        //System.out.println("all sides are equal");
        return largestSide;
    } 
    
        public double getLargestX(Shape s) {
        // Put code here
        int largestX =0;
        //for each point of shape s
        for (Point currPt : s.getPoints()) {
            //set 
            int Value = currPt.getX();
            if(largestX < Value){
            largestX = Value;
            }
        }
        // return largest x value
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largePerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s = new Shape(fr);
            double perm = getPerimeter(s);
            if (largePerim < perm){
                largePerim = perm;
            }
            else if (largePerim > perm){
                largePerim = largePerim;
            }
            else {
                largePerim = perm;
                System.out.println("all perim are equal");
            }
        }
        return largePerim;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;
        double largePerim =0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s = new Shape(fr);
            double perm = getPerimeter(s);
            if (largePerim < perm){
                largePerim = perm;
                temp = f;
            }
            else if (largePerim > perm){
                largePerim = largePerim;
                temp = temp;
            }
            else{
                largePerim = perm;
                System.out.println("all perim are equal");
                temp = temp;
            }        
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("Number of Points = " + numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("Average Length = " + averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);
        System.out.println("------------------");
        //double largePerim = getLargestPerimeterMultipleFiles();
        //System.out.println("Largest perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        double length = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + length);
        System.out.println("------------------");
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String lrgPerimFile = getFileWithLargestPerimeter();
        System.out.println("File Name: " +lrgPerimFile);
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
        System.out.println("------------------");
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter(); 
    }
}
