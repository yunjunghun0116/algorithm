import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        int result = solution("1745");
        System.out.println(result);
    }

    static List<String> result = new ArrayList<>();
    static Set<Integer> resultSet = new HashSet<>();

    static String resultString = "";

    public static int solution(String numbers) {

        int answer = 0;

        resultString = numbers;
        permutation("",numbers.length());

        boolean[] dp = new boolean[(int) Math.pow(10,numbers.length())];
        dp[0] = true;
        dp[1] = true;
        for(int i = 2; i < dp.length; i++){
            if(!dp[i]){
                for(int j = i+i; j < dp.length; j+=i){
                    dp[j] = true;
                }
            }
        }

        for(String str : result){
            setResultSet(str,"");
        }

        for(Integer value :resultSet){
            System.out.println(value);
            if(dp[value]) continue;
            answer++;
        }

        return answer;
    }

    public static void permutation(String currentStr,int size){

        if(currentStr.length() == size){
            result.add(currentStr);
            return;
        }

        Set<Integer> strSet = new HashSet<>();
        for(int i = 0; i < currentStr.length(); i++){
            strSet.add(Integer.parseInt(String.valueOf(currentStr.charAt(i))));
        }

        for(int i = 0; i < size;i++){
            if(strSet.contains(i)){
                continue;
            }
            permutation(currentStr+i,size);
        }


    }

    public static void setResultSet(String number,String input){
        // 0123456
        if(input.length() == number.length()){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < number.length(); i++){
                if(String.valueOf(input.charAt(i)).equals("1")){
                    str.append(resultString.charAt(Integer.parseInt(String.valueOf(number.charAt(i)))));
                }
            }
            if(str.toString().isEmpty()) return;
            resultSet.add(Integer.parseInt(str.toString()));
            return;
        }
        for(int i = 0; i < 2; i++){
            setResultSet(number,input+i);
        }

    }

}
