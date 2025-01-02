public class problem1 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch (n){
            case 1:{
                int[] newArr = new int[slicer[1]+1];
                System.arraycopy(num_list,0,newArr,0,newArr.length);
                return newArr;
            }
            case 2:{
                int[] newArr = new int[num_list.length-slicer[0]+1];
                System.arraycopy(num_list,slicer[0],newArr,0,newArr.length);
                return newArr;
            }
            case 3:{
                int[] newArr = new int[slicer[1]-slicer[0]+1];
                System.arraycopy(num_list,slicer[0],newArr,0,newArr.length);
                return newArr;
            }
            case 4:
            default:{
                int size = ((slicer[1]-slicer[0]+1)/slicer[2]+1);
                int[] newArr = new int[size];
                int index = 0;
                for(int i = slicer[0];i<slicer[1];i+=slicer[2]){
                    newArr[index++] = num_list[i];
                }
                return newArr;
            }
        }
    }
}
