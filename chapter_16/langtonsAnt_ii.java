public class Board {
	private HashSet<Position> whites = new HashSet<Position>();
	private Ant ant = new Ant();
	private Position bottomRightCorner = new Position(0, 0);

	public Board() { }

	public void move() {
		ant.turn(isWhite(ant.position));
		flip (ant.position);
		ant.move();
		ensureFit(ant.position);
	}
	private void flip (Position position) {
		if (whites.contains(position))
			whites.remove(position);
		else
			whites.add(position.clone());
	}
	private ensureFit(Position position) {
		int row = position.row;
		int column = position.column;

		topLeftCorner.row = Math.min(topLeftCorner.row, row);
		topLeftCorner.column = Math.min(topLeftCorner.column, column);

		bottomRightCorner.row = Math.max(bottomRIghtCorner.row, row);
		bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
	}

	public boolean isWhite(Position p) {
		return whites.contains(p);
	}
	public boolean isWhite(int row, int column) {
		return whites.contains(new Position(row, column));
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int rowMin = topLeftCorner.row;
		rowMax = bottomRightCorner.row;
		int colMin = topLeftCorner.column;
		int colMax = bottomRightCorner.column;
		for (int r = rowMin; r <= rowMax; ++r) {
			for (int c = colMin; c <= colMax; ++c) {
				if (r == ant.position.row && c == ant.position.column)
					sb.append(ant.orientation);
				else if (isWhite(r, c))
					sb.append("X");
				else 
					sb.append("_");
			}
			sb.append("\n");
		}
		sb.append("Ant : " + ant.orientation + ". \n");
		return sb.toString();
	}
}