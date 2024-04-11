public class bible2 {
    public int[] solution(String[] keyinput, int[] board) {
        int[] startPoint = new int[]{0, 0};
        int widthMax = board[0] / 2;
        int heightMax = board[1] / 2;

        for (String key : keyinput) {
            switch (key) {
                case "left":
                    if (startPoint[0] - 1 >= (-1 * widthMax)) {
                        startPoint[0] = startPoint[0] - 1;
                    }
                    break;
                case "right":
                    if (startPoint[0] + 1 <= widthMax) {
                        startPoint[0] = startPoint[0] + 1;
                    }
                    break;
                case "up":
                    if (startPoint[1] + 1 <= heightMax) {
                        startPoint[1] = startPoint[1] + 1;
                    }
                    break;
                case "down":
                    if (startPoint[1] - 1 >= (-1 * heightMax)) {
                        startPoint[1] = startPoint[1] - 1;
                    }
                    break;
            }
        }
        return startPoint;
    }
}
