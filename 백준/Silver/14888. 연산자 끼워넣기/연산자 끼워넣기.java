import java.util.Scanner;

public class Main {
	static int max_value = -1000000000;
	static int min_value = 1000000000;
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];//숫자
		int[] arith = new int[4];//사칙연산 + - * /계산은 앞에서부터		
		//시작은 arr[0]부터, arr[1]부터 계산
		for(int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			arith[i] = sc.nextInt();//2 1 1 1
			count=count+arith[i];
		}

		inArith(arr,1,arr[0],arith[0],arith[1],arith[2],arith[3]);
		
		System.out.println(max_value);	
		System.out.println(min_value);
		
	}
	
	public static void inArith(int[] a,int index,int sum,int plus,int minus,int multi,int divide) {
		if(index > count) {//count == a의 마지막index와 동일
			min_value = Math.min(sum, min_value);
			max_value = Math.max(sum, max_value);
			return;
		}
		if(plus>0) {
			inArith(a,index+1,sum+a[index],plus-1,minus,multi,divide);
		}
		if(minus>0) {
			inArith(a,index+1,sum-a[index],plus,minus-1,multi,divide);
		}
		if(multi>0) {
			inArith(a,index+1,sum*a[index],plus,minus,multi-1,divide);
		}
		if(divide>0) {
			int newsum;
			if(sum >= 0) {
				newsum = sum / a[index];
			}else {
				newsum = (-1)*((sum*(-1))/a[index]);
			}
			inArith(a,index+1,newsum,plus,minus,multi,divide-1);
		}
		
	}

}
