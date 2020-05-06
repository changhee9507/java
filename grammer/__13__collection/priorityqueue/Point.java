
package __13__collection.priorityqueue;

public class Point implements Comparable<Point> {
	public int row;
	public int col;
	
	public Point() {}
	public Point(int r, int c) {
		this.row = r;
		this.col = c;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(row).append(",").append(col).append("]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		/*if(this == 0) {
			return true;
		}*/
		
		if(o instanceof Point) {
			Point p = (Point)o;
			if(this.row == p.row && this.col == p.col) return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + this.row;
		hash = 31 * hash + this.col;
		return hash;
	}
	@Override
	public int compareTo(Point o) {
		if(this.row == o.row) {
			return this.col- o.col;
		}else {
			return this.row - o.row;
		}
	}
}
