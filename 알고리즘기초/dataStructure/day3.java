public class day3 {
    public static void main(String[] args) {

        ArrList<Integer> arrList = new ArrList<>();
        for (int i = 1; i < 3; i++) {
            arrList.add(i);
        }
        arrList.printAll();
        arrList.remove(1);
        arrList.printAll();
        arrList.removeByIndex(2);
        arrList.removeByIndex(2);
        arrList.removeByIndex(2);
        arrList.removeByIndex(2);
        arrList.removeByIndex(2);
        arrList.printAll();
        System.out.println(arrList.getSize());
        arrList.addWithIndex(11, 2);
        arrList.printAll();

        System.out.println(arrList.getSize());

    }
}

