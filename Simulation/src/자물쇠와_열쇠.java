import java.io.IOException;

public class 자물쇠와_열쇠 {


    // 자물쇠 -> N x N
    // 열쇠 -> M x M

    // 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 존재
    // 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조

    // 열쇠 회전 -> 열쇠 패딩 -> 2중 for문 검사
    public boolean solution(int[][] key, int[][] lock) {
        int paddingSize = lock.length - 1;

        for (int i = 0; i < 4; i++) {
            key = rotate(key);
            int[][] newKey = pad(key, paddingSize);

            for (int j = 0; j < newKey.length- paddingSize; j++) { // 0 ~ 4
                for (int k = 0; k < newKey.length - paddingSize; k++) {
                    if (open(j, k, newKey, lock)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private boolean open(int x, int y, int[][] newKey, int[][] lock) {

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {

                if (newKey[x + i][y + j] + lock[i][j] != 1) {
                    return false;
                }

            }
        }
        return true;

    }

    private int[][] rotate(int[][] key) {
        int[][] rotatedKey = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotatedKey[i][j] = key[key.length - 1 - j][i];
            }
        }

        return rotatedKey;
    }


    private int[][] pad(int[][] key, int padSize) {
        int[][] paddedKey = new int[key.length + padSize * 2][key.length + padSize * 2];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                paddedKey[padSize + i][padSize + j] = key[i][j];
            }
        }
        return paddedKey;
    }


    public static void main(String[] args) throws IOException {

        자물쇠와_열쇠 s = new 자물쇠와_열쇠();
        System.out.println(s.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));


    }
}
