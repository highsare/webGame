package sar.pkg.games.vo;

public class Dots {
	private int coord_x;
	private int coord_y;
	private int color;	//black is 1
	private int a_positionScore;
	private int b_positionScore;
	private int c_positionScore;
	private int d_positionScore;
	private int positionScore;
	private boolean positioned;
	
	public Dots() {super();}
	
	

	public Dots(int coord_x, int coord_y, int color, int a_positionScore, int b_positionScore, int c_positionScore,
			int d_positionScore, int posiotionScore ,boolean positioned) {
		super();
		this.coord_x = coord_x;
		this.coord_y = coord_y;
		this.color = color;
		this.a_positionScore = a_positionScore;
		this.b_positionScore = b_positionScore;
		this.c_positionScore = c_positionScore;
		this.d_positionScore = d_positionScore;
		this.positionScore = positionScore;
		this.positioned = positioned;
	}



	public int getCoord_x() {
		return coord_x;
	}

	public void setCoord_x(int coord_x) {
		this.coord_x = coord_x;
	}

	public int getCoord_y() {
		return coord_y;
	}

	public void setCoord_y(int coord_y) {
		this.coord_y = coord_y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public boolean isPositioned() {
		return positioned;
	}

	public void setPositioned(boolean positioned) {
		this.positioned = positioned;
	}

	public int getA_positionScore() {
		return a_positionScore;
	}

	public void setA_positionScore(int a_positionScore) {
		this.a_positionScore = a_positionScore;
	}

	public int getB_positionScore() {
		return b_positionScore;
	}

	public void setB_positionScore(int b_positionScore) {
		this.b_positionScore = b_positionScore;
	}

	public int getC_positionScore() {
		return c_positionScore;
	}

	public void setC_positionScore(int c_positionScore) {
		this.c_positionScore = c_positionScore;
	}

	public int getD_positionScore() {
		return d_positionScore;
	}
	
	public void setD_positionScore(int d_positionScore) {
		this.d_positionScore = d_positionScore;
	}



	public int getPositionScore() {
		return positionScore;
	}



	public void setPositionScore(int positionScore) {
		this.positionScore = positionScore;
	}
	
}
