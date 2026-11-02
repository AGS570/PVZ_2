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

	

	public boolean inBoard() {
		// TODO Auto-generated method stub
		return this.row >= 0 && this.row < GameWorld.NUM_ROWS && this.col >= 0 && this.col < GameWorld.NUM_COLS;
	}
	
	public Position newPosition() {
		int col = this.col-1;
		int row = this.row;
		
		return new Position(row,col);
	}
	
	public boolean isInPosition(Position np) {
		return this.isEqual(np);
	}
	
	public boolean isEqual(Position np) {
		return this.row  == np.row && this.col == np.col;
	}
	
	public boolean isInRow(Position np) {
		if(np.row == this.row)return true;
			
		return false;
	}

	public boolean ReachedHome() {
		// TODO Auto-generated method stub
		return this.col == 0;
	}

	/*public String positionToString() {
		// TODO Auto-generated method stub
		return this.row + " " + this.col;
	}*/
	
	
}
