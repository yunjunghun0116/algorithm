public class ArrList<E> {
    private E[] list;
    private int size;

    public ArrList() {
        list = (E[]) new Object[1];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E value) {
        if (size == list.length - 1) {
            reSize(2 * list.length);
        }
        list[size++] = value;
    }

    public void addWithIndex(E value, int index) {
        if (size == list.length - 1) {
            reSize(2 * list.length);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = value;
        size++;
    }

    public void remove(E value) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(value)) {
                index = i;
                break;
            }
        }
        removeByIndex(index);
    }

    public void removeByIndex(int index) {
        for (int i = index; i < size; i++) {
            if (i == size - 1) {
                list[i] = null;
                break;
            }
            list[i] = list[i + 1];
        }
        size--;
        if (size < list.length / 4 - 1) {
            reSize(list.length / 2);
        }
    }

    public void reSize(int newSize) {
        E[] tempList = (E[]) new Object[newSize];
        System.arraycopy(list, 0, tempList, 0, list.length);
        list = tempList;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

}
