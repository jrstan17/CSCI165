package lab6;

public class Point
{
	//instance variables
	private int X = 0;
	private int Y = 0;
	
	//no argument constructor
	public Point(){}
	
	//copy constructor
	public Point(Point copy){
		if(copy != null){
			this.X = copy.X;
			this.Y = copy.Y;
		}
	}
	
	//overloaded constructor
	public Point(int x, int y){
		X = x;
		Y = y;
	}
	
	//setters
	public void setX(int x){
		X = x;
	}
	
	public void setY(int y){
		Y = y;
	}
	public void setCoords(int x, int y){
		X = x;
		Y = y;
	}
	
	//getters
	public int getX(){
		return X;
	}
	
	public int getY(){
		return Y;
	}
	
	public double distance(int X, int Y){
		return Math.sqrt(Math.pow(X-this.X,2)+Math.pow(Y-this.Y,2));
	}
	
	public boolean equals(Point p){
		return (this.X == p.X && this.Y == p.Y);
	}
		
	public String toString(){
		return "(" + X + "," + Y + ")";
	}
}









