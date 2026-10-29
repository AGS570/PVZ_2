package logic;

public class Position {

	private int row;
	private int col;
	public Position(int row, int col) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col= col;
	}
	
	public String toString() {
		return row + " " + col;
	}

	public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
 
    public boolean isValid(int r, int c) {
    	if(this.row < r && this.row >= 0 && this.col < c && this.col >=0) return true;
    	return false;
    }

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean inBoard() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Position newPosition() {
		int col = this.col-1;
		int row = this.row;
		
		return new Position(row,col);
	}
	
	public boolean isInPosition(Position np) {
		return this.equals(np);
	}
	
	private boolean equals(Position np) {
		return this.row  == np.row && this.col == np.col;
	}
}
