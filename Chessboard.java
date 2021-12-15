public class Chessboard
{
	public static class Field
	{
		private char	row;
		private byte	column;
		private Chesspiece		piece = null;
		private boolean	marked = false;

		public Field (char row, byte column) {}

		public void put (Chesspiece piece) {}

		public Chesspiece take () {}

		public void mark () {}

		public void unmark ()  {}

		public String toString ()
		{
			String	s = (marked)? "xx" : "--";
			return (piece == null)? s : piece.toString ();
		}
	}

	public static final int	NUMBER_OF_ROWS = 8;
	public static final int	NUMBER_OF_COLUMNS = 8;

	public static final int	FIRST_ROW = 'a';
	public static final int	FIRST_COLUMN = 1;

	private Field[][]	fields;

	public Chessboard ()
	{
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char	row = 0;
		byte	column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++)
		{
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++)
			{
				fields[r][c] = new Field (row, column);
				column++;
			}
		}
	}

	public String toString () {}

	public boolean isValidField (char row, byte column) {}


	public abstract class Chesspiece
	{
		private char	color;
		// w - white, b - black

		private char	name;
		// K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
		// P � Pawn

		protected char	row = 0;
		protected byte	column = -1;

		protected Chesspiece (char color, char name) {}

		public String toString ()
		{
			return "" + color + name;
		}

		public boolean isOnBoard ()
		{
			return Chessboard.this.isValidField (row, column);
		}

		public void moveTo (char row, byte column) throws NotValidFieldException
		{
			if (!Chessboard.this.isValidField (row, column))
				throw new NotValidFieldException ("bad field: " + row + column );

			this.row = row; this.column = column;

			int	r = row - FIRST_ROW;
			int	c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put (this);
		}

		public void moveOut () {}

		public abstract void markReachableFields ();

		public abstract void unmarkReachableFields ();
	}

	public class Pawn extends Chesspiece
	{
		public Pawn (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark ();
			}
		}

		public void unmarkReachableFields ()
		{
			byte col = (byte) (column + 1);

			if (Chessboard.this.isValidField (row, col))
			{
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark ();
			}
		}
	}

	public class Rook extends Chesspiece {}

	public class Knight extends Chesspiece {}

	public class Bishop extends Chesspiece {}

	public class Queen extends Chesspiece {}

	public class King extends Chesspiece {}

}