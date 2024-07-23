class Solution {

    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int rflag = 0, cflag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        rflag = 1;
                        cflag = 1;
                    }
                    if (i == 0 && j != 0) {
                        rflag = 1;
                        arr[0][0] = 0;
                    }
                    if (j == 0 && i != 0) {
                        cflag = 1;
                        arr[0][0] = 0;
                    }
                    if (arr[i][0] != 0) {
                        arr[i][0] = 0;
                    }
                    if (arr[0][j] != 0) {
                        arr[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (arr[0][i] == 0) {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = 0;
                }
            }
        }
        if (rflag == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[0][j] = 0;
                }
            }
        }
        if (cflag == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][0] = 0;
                }
            }
        }
    }
}
