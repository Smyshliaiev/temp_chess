package com.example;

import org.apache.commons.math3.linear.DefaultRealMatrixChangingVisitor;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class MainWorker {

    public static final int BOARD_HEIGHT = 3;
    public static final int BOARD_WIDTH = 3;
    private ChessBoard mChessBoard;

    private HashSet mHashSet = new HashSet();

    public MainWorker() {
        mChessBoard = new ChessBoard();
    }

    public void findUniqueConfigurations(){

        List<Integer> ids = new ArrayList<Integer>();
        Permutator permutator = new Permutator();

        IPiece king0 = new King(ids);
        IPiece king1 = new King(ids);
        IPiece king2 = new King(ids);

        permutator.addPiece(king0);
        permutator.addPiece(king1);
        permutator.addPiece(king2);

//        permutator.permutateShow();

        List<List<IPiece>> permutedListOfAllVariants = permutator.getPermutatedList();

        for (List<IPiece> variantListOfPieces : permutedListOfAllVariants) {
            for(IPiece piece: variantListOfPieces) {
//                System.out.print(piece.toString());

            }

            findUnique(variantListOfPieces);
            return;
//            System.out.println();
        }




//        king0.setPosition(new Position(0,0));
//        king1.setPosition(new Position(1,1));
//        king2.setPosition(new Position(2,2));

    }

    private void findUnique(List<IPiece> variantOfPermutedPieces) {

        findUniqueReq(variantOfPermutedPieces, variantOfPermutedPieces.size());

        System.out.println("hashset size: " + mHashSet.size());

    }

    private void findUniqueReq(List<IPiece> variantOfPermutedPieces, int reqDeep){

            ChessBoard chessBoard = new ChessBoard();
            chessBoard.getChessBoardMatrix().walkInRowOrder(new SetVisitor(variantOfPermutedPieces, reqDeep, chessBoard.getChessBoardMatrix().copy()));
    }


    private class SetVisitor extends DefaultRealMatrixChangingVisitor {
        private int mReqDeep;
        List<IPiece> mVariantOfPermutedPieces;
        ChessBoard mVisitorChessBoard;
        private RealMatrix realMatrixInOriginal;
        private RealMatrix realMatrixInOriginalCopy;


        private SetVisitor(List<IPiece> variantOfPermutedPieces, int reqDeep, RealMatrix realMatrix) {
            mReqDeep = reqDeep;
            mVariantOfPermutedPieces = variantOfPermutedPieces;
            //mVisitorChessBoard = chessBoard;
            this.realMatrixInOriginal = realMatrix;
        }

        @Override
        public double visit(int i, int j, double value) {
//            System.out.println("visit i: " + i + "j:" + j);
            if(realMatrixInOriginal.getEntry(i,j) == 0){
                RealMatrix copyOfInMatrix = realMatrixInOriginal.copy();
                //copyOfInMatrix.setEntry(i,j,1);
                IPiece piece =  mVariantOfPermutedPieces.get(mReqDeep);
                piece.setPosition(new Position(i,j));
                copyOfInMatrix = copyOfInMatrix.add(piece.getPieceMovementMatrix());
                System.out.println("visit i: " + i + ", j: " + j + ", deep: " + mReqDeep + ", copyOfInMatrix: " + copyOfInMatrix + ", orMatrix: " + realMatrixInOriginal);
                System.out.println("realMatrixInOriginal ref!!!!!:" + Integer.toHexString(System.identityHashCode(realMatrixInOriginal)));

//                if(mReqDeep == 0) {
//                    HashSet listOfUniquePos = iterateAllFigurePositions(mVariantOfPermutedPieces, mReqDeep, copyOfInMatrix);
//                    if (listOfUniquePos.size()==mVariantOfPermutedPieces.size()) {
//                        mHashSet.add(listOfUniquePos);
//                    }
//                }


                // id pos F1 < 2 and pos F2 < 2 and ... pos Fn < 2 then hashset.add (current F)
                //if(copyOfInMatrix.getEntry(piece.getPosition().getX(), piece.getPosition().getY() )


                if(mReqDeep>0) {
                    realMatrixInOriginal.walkInRowOrder(new SetVisitor(mVariantOfPermutedPieces, mReqDeep, copyOfInMatrix));
                }

//                if(deep == 0){
//                    mHasSet.add(new Positions(deep, prevPiecePosX, prevPiecePosY, i, j));
//                }

            }
            else{
                //System.out.println("cant visit i: " + i + ", j: " + j + ", deep: " + mReqDeep + ", matrix: " + realMatrixInOriginal);
            }

            return 0;
        }

        private HashSet iterateAllFigurePositions(List<IPiece> variantOfPermutedPieces, int deep, RealMatrix currentMatrix) {
            HashSet localHashSet = new HashSet();
            //List<UniquePosition> listOfUniqePos = new ArrayList<UniquePosition>();
            boolean isAllPositionsAreOk = true;
            for(IPiece piece: variantOfPermutedPieces){
                //System.out.println("curent poses of figures id: " + piece.getIdentifier() + ", pos: " + piece.getPosition());
                if(currentMatrix.getEntry(piece.getPosition().getX(), piece.getPosition().getY()) > Piece.HIT_VALUE){

                    isAllPositionsAreOk = false;
                    localHashSet.clear();
                }else if(currentMatrix.getEntry(piece.getPosition().getX(), piece.getPosition().getY()) == Piece.HIT_VALUE) {
                    System.out.println("unique curent poses of figures type: " + piece.getType() + ", pos: " + piece.getPosition());
                    localHashSet.add(new UniquePosition(piece.getType(), piece.getPosition()));
                }
            }
            return localHashSet;
        }

        @Override
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            --mReqDeep;
            System.out.println("start");
            super.start(rows, columns, startRow, endRow, startColumn, endColumn);
        }

        @Override
        public double end() {
            System.out.println("end");
            return super.end();
        }
    }

}
