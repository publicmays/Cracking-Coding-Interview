// white - turn right
// black - turn left
public class LangtonsAnt {
	public class Color {
		int rows;
		int cols;
		int x; 
		int y;
		private ColorState colorState;
		private DirectionState directionState;

		Color[][] grid = new Color[rows][cols];

		public Color(int rows, int cols) {
			this.rows = rows;
			this.cols = cols;
			grid.directionState = new Right();
		}

		public void setColor(ColorState c) {
			colorState = c;
		}
		public void setDirection(DirectionState d) {
			directionState = d;
		}

		public void initializeGrid() {
			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < cols; ++j) {
					grid[i][j].colorState = randWhiteOrBlack();
				}
			}
		}

		void printKMoves(int k) {
			int x = 0, y = 0;
			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < cols; ++j) {
					if (grid[i][j].colorState == "white") 
						grid[i][j].directionState.turnRight(grid[i][j]);
					else 
						grid[i][j].directionState.turnLeft(grid[i][j])
					grid[i][j].directionState.moveForward(grid[i][j]);
					grid[i][j].colorState.flipColor(grid[i][j]);
					System.out.print(grid[i][j].colorState);
				}
				System.out.println();
			}
		}
	}

	interface ColorState {
		void flipColor(Color g);
	}
	class White implements ColorState {
		void flipColor(Color g) {
			g.setColor(new Black());
		}
	}
	class Black implements ColorState {
		void flipColor(Color g) {
			g.setColor(new White());
		}
	}

	interface DirectionState() {
		void turnRight(Color g);
		void turnLeft(Color g);
		void moveForward(Color g);
	}

	class Left implements DirectionState() {
		void turnRight(Color g) {
			g.setDirection(new Up());
		}
		void turnLeft(Color g) {
			g.setDirection(new Down());
		}
		void moveForward() {
			// [x][y-1]
		}
	}
	class Right implements DirectionState() {
		void turnRight(Color g) {
			g.setDirection(new Down());
		}
		void turnLeft(Color g) {
			g.setDirection(new Up());
		}
		void moveForward(Color g) {
			// [x][y+1]
		}
	}

	class Up implements DirectionState() {
		void turnRight() {
			g.setDirection(new Right()); 
		}
		void turnLeft() {
			g.setDirection(new Left());
		}
		void moveForward() {
			// [x-1][y]
		}
	}

	class Down implements DirectionState() {
		void turnRight() {
			g.setDirection(new Left());
		}
		void turnLeft() {
			g.setDirection(new Right());
		}
		void moveForward() {
			// [x+1][y]
		}
	}


}