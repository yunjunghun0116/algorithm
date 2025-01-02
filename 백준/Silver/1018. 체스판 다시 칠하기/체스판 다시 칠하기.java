import java.util.Scanner;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		String[] inputarr = new String[height];
		int[][] checkarr = new int[height-7][width-7];
		for(int i = 0; i < height; i++) {
			inputarr[i] = sc.next();
		}
		for(int i = 0; i < height-7; i++) {
			for(int j = 0; j < width-7; j++) {
				check(inputarr,checkarr,i,j);
			}
		}
		for(int i = 0; i < height-7; i++) {
			for(int j = 0; j < width-7; j++) {
				if(min>=checkarr[i][j]) {
					min = checkarr[i][j];
				}
			}
		}
		System.out.println(min);
		
		

	}
	public static void check(String[] input,int[][] result,int x,int y) {
		int cnt = 0;
		for(int i = x; i < x+8; i++) {
			for(int j = y; j < y+8; j++) {
				if(input[x].charAt(y)==input[i].charAt(j)) {
					if((x+y)%2==(i+j)%2) {
					}else {
						cnt++;
					}
				}else {
					if((x+y)%2!=(i+j)%2) {	
					}else {
						cnt++;
					}
				}
			}
		}
		result[x][y] = Math.min(cnt, 64-cnt);
	}

}
