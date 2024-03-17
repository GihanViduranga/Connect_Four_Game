package lk.ijse.dep.service;

public class BoardImpl implements Board {
        private final Piece[][] piece;
        private final BoardUI boardUI;
        private final int NUM_OF_COLS = 7;
        private final int NUM_OF_ROWS = 6;

        public BoardImpl(BoardUI boardUI) {
                this.boardUI = boardUI;
                piece = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
                for (int i = 0; i < NUM_OF_COLS; i++) {
                        for (int j = 0; j < NUM_OF_ROWS; j++) {
                                piece[i][j] = Piece.EMPTY;
                        }
                }
        }
        public Piece[][] getPiece(){
                return piece;
        }
        @Override
        public BoardUI getBoardUI() {
                return boardUI;
        }

        @Override
        public int findNextAvailableSpot(int col) {
                for (int i = 0; i < NUM_OF_COLS; i++) {
                        if (piece[col][i] == Piece.EMPTY) {
                                return i;
                        }
                }
                return -1;
        }

        @Override
        public boolean isLegalMove(int col) {
                if (findNextAvailableSpot(col) == 1) {
                        return false;
                }
                return true;
        }

        @Override
        public boolean existsLegalMoves() {
                /*for(int i = 0; i < NUM_OF_COLS;i++){
                        for(int j = 0; j < NUM_OF_ROWS;j++){
                                if(piece[i][j] == Piece.EMPTY){
                                        return true;
                                }
                        }
                }*/
                for (int col = 0; col < NUM_OF_COLS; col++) {
                        if (isLegalMove(col) ) {
                                return true;
                        }
                }
                return false;
        }

        @Override
        public void updateMove(int col, Piece move) {
                for (int i = 0; i < piece[col].length; i++) {
                        if (piece[col][i] == Piece.EMPTY) {
                                piece[col][i] = move;
                                break;
                        }
                }
//                piece[col][findNextAvailableSpot(col)] = move;
//                if(piece[col][findNextAvailableSpot(col)] == Piece.EMPTY) {
//                        for (int i = 0; i < piece.length; i++) {
//                                for (int j = 0; j < piece[i].length; j++) {
//                                        if (piece[i][j] == Piece.EMPTY) {
//                                                break;
//                                        }
//                                }
//                        }
//                }
        }

        @Override
        public void updateMove(int col, int row, Piece move) {
                piece[col][row] = move;
        }

        @Override
        public Winner findWinner() {
                /*for (int i = 0; i < NUM_OF_COLS; i++) {
                        for (int j = 0; j < NUM_OF_ROWS; j++) {
                                if (piece[i][1] == Piece.BLUE) {

                                        if (((piece[i][1] == piece[i][2]) && (piece[i][3] == piece[i][2])) && (piece[i][1] == piece[i][0])) {
                                                return (new Winner(Piece.BLUE, i, 0, i, 3));
                                        } else if (((piece[i][1] == piece[i][2]) && (piece[i][3] == piece[i][2])) && (piece[i][1] == piece[i][4])) {
                                                return new Winner(Piece.BLUE, i, 1, i, 4);
                                        }

                                }

                                if (piece[i][1] == Piece.GREEN) {

                                        if (((piece[i][1] == piece[i][2]) && (piece[i][3] == piece[i][2])) && (piece[i][1] == piece[i][0])) {
                                                return new Winner(Piece.GREEN, i, 0, i, 3);
                                        } else if (((piece[i][1] == piece[i][2]) && (piece[i][3] == piece[i][2])) && (piece[i][1] == piece[i][4])) {
                                                return new Winner(Piece.GREEN, i, 1, i, 4);
                                        }

                                }

                                if (piece[2][j] == Piece.BLUE) {

                                        if (((piece[2][j] == piece[3][j]) && (piece[2][j] == piece[1][j])) && (piece[1][j] == piece[0][j])) {
                                                return new Winner(Piece.BLUE, 0, j, 3, j);
                                        } else if (((piece[2][j] == piece[3][j]) && (piece[3][j] == piece[4][j])) && (piece[2][j] == piece[1][j])) {
                                                return new Winner(Piece.BLUE, 1, j, 4, j);
                                        } else if (((piece[2][j] == piece[3][j]) && (piece[3][j] == piece[4][j])) && (piece[4][j] == piece[5][j])) {
                                                return new Winner(Piece.BLUE, 2, j, 5, j);
                                        }
                                }
                                if (piece[2][j] == Piece.GREEN) {

                                        if (((piece[2][j] == piece[3][j]) && (piece[2][j] == piece[1][j])) && (piece[1][j] == piece[0][j])) {
                                                return new Winner(Piece.GREEN, 0, j, 3, j);
                                        } else if (((piece[2][j] == piece[3][j]) && (piece[3][j] == piece[4][j])) && (piece[2][j] == piece[1][j])) {
                                                return new Winner(Piece.GREEN, 1, j, 4, j);
                                        } else if (((piece[2][j] == piece[3][j]) && (piece[3][j] == piece[4][j])) && (piece[4][j] == piece[5][j])) {
                                                return new Winner(Piece.GREEN, 2, j, 5, j);
                                        }
                                }
                        }
                }
                return new Winner(Piece.EMPTY);
        }
}*/
               for (int i=0; i<NUM_OF_COLS; i++){
                        for (int j=0; j<NUM_OF_ROWS; j++){
                                if (piece[1][j].equals(Piece.BLUE)){
                                        if ((piece[1][j].equals (piece[2][j])) && (piece[2][j].equals(piece[3][j])) && (piece[3][j].equals(piece[4][j]))){
                                                return new Winner(Piece.BLUE, j, 1, j, 4);
                                       }else if ((piece[1][j].equals(piece[2][j])) && (piece[2][j].equals(piece[3][j])) && (piece[1][j].equals(piece[0][j]))){
                                                return new Winner(Piece.BLUE, j, 0, j, 3 );
                                        }else if ((piece[2][j].equals(piece[3][j])) && (piece[3][j].equals(piece[4][j])) && (piece[4][j].equals(piece[5][j]))){
                                                return new Winner(Piece.BLUE, j, 2,j, 5);
                                        }
                                }

                                if (piece[1][j].equals(Piece.GREEN)){
                                        if ((piece[1][j].equals (piece[2][j])) && (piece[2][j].equals(piece[3][j])) && (piece[3][j].equals(piece[4][j]))){
                                                return new Winner(Piece.GREEN, j, 1, j, 4);
                                        }else if ((piece[1][j].equals(piece[2][j])) && (piece[2][j].equals(piece[3][j])) && (piece[1][j].equals(piece[0][j]))){
                                                return new Winner(Piece.GREEN, j, 0, j, 3 );
                                        }else if ((piece[2][j].equals(piece[3][j])) && (piece[3][j].equals(piece[4][j])) && (piece[4][j].equals(piece[5][j]))){return new Winner(Piece.GREEN, j, 2,j, 5);
                                        }
                                }

                                if (piece[i][1].equals(Piece.BLUE)){
                                        if ((piece[i][1].equals (piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][3].equals(piece[i][4]))){
                                                return new Winner(Piece.BLUE, i, 1, i, 4);
                                        }else if ((piece[i][1].equals(piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][1].equals(piece[i][0]))){
                                                return new Winner(Piece.BLUE, i, 0, i, 3 );
                                        }
                                }

                                if (piece[i][1].equals(Piece.GREEN)){
                                        if ((piece[i][1].equals (piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][3].equals(piece[i][4]))){
                                                return new Winner(Piece.GREEN, i, 1, i, 4);
                                        }else if ((piece[i][1].equals(piece[i][2])) && (piece[i][2].equals(piece[i][3])) && (piece[i][1].equals(piece[i][0]))){
                                                return new Winner(Piece.GREEN, i, 0, i, 3 );
                                        }
                                }
                        }

                }

                return new Winner(Piece.EMPTY);
        }
}


