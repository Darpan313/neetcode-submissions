class Solution {
    public boolean isValidSudoku(char[][] board) {
        //each row
        for(int i=0; i< board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]!= '.') {
                    if(rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
                if(board[j][i]!= '.') {
                    if(colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
            }
        }
        //each 3x3 box
        for(int l=0; l<9; l+=3) {
            for(int k=0; k<9; k+=3) {
                Set<Character> boxSet = new HashSet<>();
                for(int i=0+l; i<3+l;i++) {
                    for (int j=0+k; j<3+k; j++) {
                        if(board[i][j]!= '.') {
                            if(boxSet.contains(board[i][j])) {
                                return false;
                            }
                            boxSet.add(board[i][j]);
                        }
                    }
                }
            } 
        }
        return true;
    }
}
