package lk.ijse.dep.service;

public class BoardImpl implements Board {
        private final Piece[][] piece;
        private final BoardUI boardUI;

        public BoardImpl(BoardUI boardUI) {
                this.boardUI = boardUI;
                piece = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        }
        @Override
        public BoardUI getBoardUI() {
                return boardUI;
        }

        @Override
        public int findNextAvailableSpot(int col) {
                for (int i = 0; i < piece.length; i++) {
                        for (int j = 0; j < piece[i].length; j++) {
                                if (piece[i][j] == Piece.EMPTY) {
                                        return i;
                                }
                        }
                }
                return -1;
        }

        @Override
        public boolean isLegalMove(int col) {
                for (int i = 0; i < piece.length; i++) {
                        for (int j = 0; j < piece[i].length; j++) {
                                if (piece[i][j] == Piece.EMPTY){
                                        return false;
                                }
                        }
                }
                return true;
        }

        @Override
        public boolean existsLegalMoves() {
                for(int i = 0; i < piece.length;i++){
                        for(int j = 0; j < piece[i].length;j++){
                                if(piece[i][j] == Piece.EMPTY){
                                        return true;
                                }
                        }
                }
                return false;
        }

        @Override
        public void updateMove(int col, Piece move) {
                piece[col][findNextAvailableSpot(col)] = move;
                if(piece[col][findNextAvailableSpot(col)] == Piece.EMPTY) {
                        for (int i = 0; i < piece.length; i++) {
                                for (int j = 0; j < piece[i].length; j++) {
                                        if (piece[i][j] == Piece.EMPTY) {
                                                break;
                                        }
                                }
                        }
                }
        }

        @Override
        public Winner findWinner() {
                for (int i=0;i < NUM_OF_COLS;i++){
                        for (int j=0; j < NUM_OF_ROWS;j++){
                                System.out.println(piece[i][j]);
                                if(piece[i][1].equals(Piece.BLUE)) {
                                        if ((piece[i][1].equals(piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][0].equals(piece[i][1]))) {
                                                return new Winner(Piece.BLUE ,i,0,i,3);
                                        } else if ((piece[i][1].equals(piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][3].equals(piece[i][4]))){
                                                return new Winner(Piece.BLUE,i,0,i,4);
                                        }
                                }
                                if(piece[i][1].equals(Piece.GREEN)) {
                                        if ((piece[i][1].equals(piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][0].equals(piece[i][1]))) {
                                                return new Winner(Piece.GREEN ,i,0,i,3);
                                        } else if ((piece[i][1].equals(piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][3].equals(piece[i][4]))){
                                                return new Winner(Piece.GREEN,i,0,i,4);
                                        }
                                }
                                if(piece[2][j].equals(Piece.BLUE)) {
                                        if ((piece[2][j].equals(piece[3][j])) && (piece[1][j].equals(piece[2][j])) && (piece[0][j].equals(piece[1][j]))){
                                                return new Winner(Piece.BLUE,2,j,1,j);
                                        } else if ((piece[2][j].equals(piece[3][j])) && (piece[1][j].equals(piece[2][j])) && (piece[4][j].equals(piece[3][j]))) {
                                                return new Winner(Piece.BLUE,2,j,4,j);
                                        } else if ((piece[2][j].equals(piece[3][j])) && (piece[4][j].equals(piece[3][j])) && piece[5][j].equals(piece[4][j])) {
                                                return new Winner(Piece.BLUE,2,j,5,j);
                                        }
                                }
                                if (piece[2][j].equals(Piece.GREEN)){
                                        if ((piece[2][j].equals(piece[3][j])) && (piece[1][j].equals(piece[2][j])) && (piece[0][j].equals(piece[1][j]))){
                                                return new Winner(Piece.GREEN,2,j,1,j);
                                        }
                                        if ((piece[2][j].equals(piece[3][j])) && (piece[4][j].equals(piece[3][j])) && (piece[5][j].equals(piece[4][j]))){
                                                return new Winner(Piece.GREEN,2,j,5,j);
                                        }
                                }
                        }
                }
                return new Winner(Piece.EMPTY);
        }
}
