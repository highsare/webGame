package sar.pkg.games.ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import sar.pkg.games.vo.Dots;

public class OhhmokAI {
		
	public Dots react(ArrayList<Dots> dlist) {
		
		
		Dots dots = new Dots();
		
		Dots[][] board = new Dots[10][10];
		
		int mv = 0;
		int x = 0;
		int y = 0;
		
		for (Dots each_dots : dlist) {
			board[each_dots.getCoord_x()][each_dots.getCoord_y()] = each_dots;
		}
		
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[j].length; i++) {

				if (board[j][i] == null) {
					board[j][i] = new Dots(j, i, 0, 0, 0, 0, 0, 0, false);
				}
				
			}
		}
		
		dots = scoringAround(board);
		return dots;
	}
	
	private int checkArround(int x,int y,Dots[][] board) {
		ArrayList<Integer> cntlist = new ArrayList<Integer>();
		
		for (int p = -1; p <= 1; p++) {
			for (int k = -1; k <= 1; k++) {
				if (p==0 && k==0) {
					continue;
				}
				int count = 0;
				boolean empty = false;
				String color = "";
				
				for (int i = 1; i <= 5; i++) {
					int xi = x + (i*p);
					int yi = y + (i*k);
					if (i == 1) {
						//처음에만 동작
						if (x - (i*p) >= 0 && y - (i*k) >= 0  && x - (i*p) < 10 && y - (i*k) < 10) {
							//영역을 넘는지
							if (board[x - (i*p)][y - (i*k)] != null) {
								//돌 놓여있음
								if (board[x - (i*p)][y - (i*k)].getColor() == 0) {
									//흰색
									color = "white";
									count += 1;
								}else{
									//검은 색
									color = "black";
									count += 1;
								}
							} else {
								//돌 없음
								
							}
						}
					}
					
					
					if (xi >= 0 && yi >= 0 && xi < 10 && yi < 10)  {
						//경계를 넘지 않았는지 체크
						if (board[xi][yi] != null) {
							//돌이 존재함	
							
							//어떤 색의 돌인지 판별
							if (board[xi][yi].getColor() == 0) {
								//흰색
								if (color.equals("") || color.equals("white") || i == 1) {
									//흰색의 스택을 쌓는다
									if (!color.equals("black")) {
										count += 1;					
									}
									color = "white";
								}
								else{
									//흰색 스택 끝
									break; // i-for break;
								}
							}else{
								//검은 색
								if (color.equals("") || color.equals("black") || i == 1) {
									//검은색의 스택을 쌓는다
									if (!color.equals("white")) {
										count += 1;					
									}
									color = "black";
								}else{
									//검은색 스택 끝
									break; // i-for break;
								}
							}
						}else {
							//빈 공간
							if (empty) {
								break;
							}
							empty = true;
						}
					}
				} // i-for문 끝
				count *= count;
				if (color.equals("black")) {
					count++;
				}
				cntlist.add((Integer)count);	
			} //k-for문 끝
		} //p-for문 끝
		
		Collections.sort(cntlist);
		return cntlist.get(7);
	}// checkAround 끝
	
	public Dots scoringAround(Dots[][] board) {
		
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
			
				if (board[j][i].isPositioned() == true) {
					
					int color = board[j][i].getColor();
					
					for (int p = -1; p <= 1; p++) {
						for (int q = -1; q <= 1; q++) {
							if (p == 0 && q == 0) {
								continue;
							}
							
							for (int k = 1; k < 5; k++) {
								int x = j + (p*k);
								int y = i + (q*k);
								
								if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
									//영역 체크
									
									if (board[x][y].isPositioned() == false) {
										switch(10*p+q) {
										case -11:board[x][y].setA_positionScore(board[x][y].getA_positionScore() +(6 - k));break;
										case -10:board[x][y].setB_positionScore(board[x][y].getB_positionScore() +(6 - k)); break;
										case -9:board[x][y].setC_positionScore(board[x][y].getC_positionScore() +(6 - k)); break;
										case -1:board[x][y].setD_positionScore(board[x][y].getD_positionScore() +(6 - k)); break;
										case 1:board[x][y].setD_positionScore(board[x][y].getD_positionScore() +(6 - k)); break;
										case 9:board[x][y].setC_positionScore(board[x][y].getC_positionScore() +(6 - k)); break;
										case 10:board[x][y].setB_positionScore(board[x][y].getB_positionScore() +(6 - k)); break;
										case 11:board[x][y].setA_positionScore(board[x][y].getA_positionScore() +(6 - k));break;
											default : break;
										}										
									}else if(board[x][y].getColor() != color) {
										//색이 다른 돌 만남
										break;
									}
								}
							}//K-FOR
						}//Q-FOR
					}//P-FOR
					
				}//POSITIONED-IF
			}//I-FOR
		}//J-FOR
		
		Dots dots = new Dots();
		
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				int mv=0;
				int positionScore = board[j][i].getA_positionScore()*board[j][i].getA_positionScore()
						+board[j][i].getB_positionScore()*board[j][i].getB_positionScore()
						+board[j][i].getC_positionScore()*board[j][i].getC_positionScore()
						+board[j][i].getD_positionScore()*board[j][i].getD_positionScore();
				board[j][i].setPositionScore(positionScore);
				if (mv < board[j][i].getPositionScore()) {
					mv = board[j][i].getPositionScore();
					dots.setCoord_x(j);
					dots.setCoord_y(i);
				}
			}
		}
		dots.setColor(-1);
		dots.setPositioned(true);
		
		return dots;
	}

	public int doesBlackWin(ArrayList<Dots> dlist) {
		Dots[][] board = new Dots[10][10];
		
		for (Dots each_dots : dlist) {
			board[each_dots.getCoord_x()][each_dots.getCoord_y()] = each_dots;
		}
		
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				if (board[j][i] != null) {
					if (board[j][i].isPositioned() == true) {
						int color = board[j][i].getColor();
						
						for (int p = -1; p <= 1; p++) {
							for (int q = -1; q <= 1; q++) {
								if (p == 0 && q == 0) {
									continue;
								}
								int cnt = 1;
								for (int k = 1; k < 6; k++) {
									int x = j + (p*k);
									int y = i + (q*k);
									int xx = j - (p*k);
									int yy = i - (q*k);
									
									if (k == 1) {
										if (xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9) {
											//영역 체크
											if (board[xx][yy] != null) {
												if (board[xx][yy].getColor() == color) {
													break;
												}
											}
											
										}
									}
									
									if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
										//영역 체크
										if (board[x][y] != null) {
											if (board[x][y].getColor() == color) {
												cnt++;
											}else {
												break;
											}
										}else {
											break;
										}
										
									}else {
										break;
									}
								}//K-FOR
								System.out.println("[j:"+j+"/i:"+i+"/D:"+(10*p+q)+"/Col:"+color+"]"+"cnt: "+cnt);
								switch(cnt) {
								case 5:
									if (color == 1) {
										return 1;
									}else {
										return -1;
									}
								default: break;
								}
							}//Q-FOR
						}//P-FOR
						System.out.println();
					}//POSITIONED-IF
				}
			}//I-FOR
		}//J-FOR
		return 0;
	}
}

//.......8ㅅ8