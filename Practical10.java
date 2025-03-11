 class Game {
    public static void Sudoku(int size) {
        int boxWidth = String.valueOf(size).length() + 2; 
        String firstLine = "-".repeat(boxWidth); 

        int[][] array = new int[size][size];
        for (int vl = 0; vl < size; vl++) {
            for (int hl = 0; hl < size; hl++) {
                array[vl][hl] = (vl + hl) % size + 1;
            }
        }
        
        int oneThirdNumbers = (size * size) / 3;
        while (oneThirdNumbers > 0) {
            int hl = (int) ((System.nanoTime() >> 3) % size);
            int vl = (int) ((System.nanoTime() >> 5) % size); 

            if (array[hl][vl] != 0) {
                array[hl][vl] = 0;
                oneThirdNumbers--;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int vl = 0; vl < size; vl++) {
            for (int hl = 0; hl < size; hl++) {
                sb.append(" ").append(firstLine);
            }
            sb.append(" \n");
            for (int hl = 0; hl < size; hl++) {
                if (array[vl][hl] == 0) {
                    sb.append(String.format("|%" + boxWidth + "s", " "));
                } else {
                    sb.append(String.format("|%" + boxWidth + "d", array[vl][hl]));
                }
            }
            sb.append("|\n");
        }
        for (int hl = 0; hl < size; hl++) {
            sb.append(" ").append(firstLine);
        }
        sb.append(" \n");
        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        int size = 10;
        Sudoku(size);
    }
}

