import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static final String QUEEN = "Q";
	private static final String BISHOP = "B";
	private static final String PAWN = "P";
	private static final String KNIGHT = "N";
	private static final String ROOK = "R";
	static String[][] bboard = new String[4][4];
	static String[][] wboard = new String[4][4];
	static 	int moves =0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		int i,j;
		for(int a0 = 0; a0 < g; a0++){
			int w = in.nextInt();
			int b = in.nextInt();
			int m = in.nextInt();
			String[][] white = new String[w][3];
			String s = null;
			for(int white_i=0; white_i < w; white_i++){
				for(int white_j=0; white_j < 3; white_j++){
					white[white_i][white_j] = in.next();
				}
				i = 4-Integer.valueOf(white[white_i][2]);
				j = Math.abs('A' - white[white_i][1].charAt(0));
				wboard[i][j] =  white[white_i][0];
			}
			String[][] black = new String[b][3];
			for(int black_i=0; black_i < b; black_i++){
				for(int black_j=0; black_j < 3; black_j++){
					black[black_i][black_j] = in.next();

				}
				i = 4-Integer.valueOf(black[black_i][2]);
				j = Math.abs('A' - black[black_i][1].charAt(0));
				bboard[i][j] =  black[black_i][0];
			}

			moves = 0;
			makeMove(wboard,bboard,m);

		}
	}

	static void makeMove(String[][] currentBoard,String[][]opponentBoard, int max){
		// check for each row if there is any piece
		int i,j;
		boolean win = false;
		int cost = Integer.MAX_VALUE;
		int wi=0,wj=0,li=0,lj=0;
		int[] move = new int[4];
		for(i = 0;i<4;i++){
			for(j=0;j<4;j++){
				if(wboard[i][j] != null){
					if(check(i,j,wboard[i][j],bboard)){
						win = true;
						break;
					}else{
						move = findNextMove(currentBoard,opponentBoard);
						li = move[0];
						lj = move[1];
						wi = move[2];
						wj = move[3];
					}
				}
			}
		}


		if(win)System.out.println("YES");
		else{
			moves++;
			if(moves > max)
				System.out.println("NO");
			else
				// make best move
				currentBoard[wi][wj] = currentBoard[li][lj];
				currentBoard[li][lj] = null;
				
				makeMove(opponentBoard,currentBoard,max);
		}
	}
	
	private static int[] findNextMove(String[][] currentBoard, String[][] opponentBoard) {
		int[] move = new int[4];
		
		return move;
	}

	private static void applyPromotions(String[][] currentBoard) {
		// TODO Auto-generated method stub
		
	}

	private static boolean check(int i, int j,String piece,String[][] opponentBoard) {

		// if PAWN
		if(piece.equals(PAWN)){
			// check [i-1,j-1], [i+1,j-1], [i-1][j+1] and [i+1][j+1] in bboard
			return isPiece(i-1,j-1,QUEEN,opponentBoard) ||
					isPiece(i-1,j+1,QUEEN,opponentBoard) ||
					isPiece(i+1,j-1,QUEEN,opponentBoard) ||
					isPiece(i+1,j+1,QUEEN,opponentBoard);

		}else if(piece.equals(ROOK)){ // if Rook
			//check [i, 0-3] and [0-3,j]
			for(int t = 0;t<4;t++){
				if(isPiece(i,t,QUEEN,opponentBoard) || isPiece(t,j,QUEEN,opponentBoard)) return true;
			}
		}else if(piece.equals(BISHOP)){ // if Bishop
			// for each i-1,j-1 until i>=0 and j > =0
			// for each i-1,j+1 until i>=0 and j<4
			// for each i+1,j-1 until j>=0 and i<4
			// for each i+1,j+1 until i<4 and j<4
			for(int k = -1;k>=1;k++)
				if(k!=0)
					for(int l = -1;l>=1;l++)
						if(j!=0)
							if(isPiece(i+k,j+k,QUEEN,opponentBoard)) return true;
		}else if(piece.equals(KNIGHT)){
			// check [i-2,j-1], [i-2][j+1], [i-1][j-2],[i-1,j+2],[i+2,j-1], [i+2][j+1], [i+1][j-2],[i+1,j+2]
			return isPiece(i-2,j-1,QUEEN,opponentBoard) ||
					isPiece(i-2,j+1,QUEEN,opponentBoard) || 
					isPiece(i-1,j-2,QUEEN,opponentBoard) ||
					isPiece(i-1,j+2,QUEEN,opponentBoard) ||
					isPiece(i+2,j-1,QUEEN,opponentBoard) ||
					isPiece(i+2,j+1,QUEEN,opponentBoard) ||
					isPiece(i+1,j-2,QUEEN,opponentBoard) ||
					isPiece(i+1,j+2,QUEEN,opponentBoard);
		}else{ // if Queen
			return check(i,j,BISHOP,opponentBoard) || check(i,j,ROOK,opponentBoard);
		}

		return false;
	}

	static boolean isPiece(int i,int j, String piece, String[][] board){
		if(i<0  || i> 3 || j<0 || j>3)return false;
		else
			if(board[i][j] != null && board[i][j].equals(piece)) return true;
			else return false;
	}
}
