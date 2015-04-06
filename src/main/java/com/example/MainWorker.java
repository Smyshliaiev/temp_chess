package com.example;

import org.apache.commons.math3.linear.DefaultRealMatrixChangingVisitor;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class MainWorker {

    public static final int BOARD_HEIGHT = 3;
    public static final int BOARD_WIDTH = 3;
    private ChessBoard mChessBoard;

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
//        permutator.addPiece(king2);

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

//        for(IPiece piece: variantOfPermutedPieces) {
//            mChessBoard.getChessBoardMatrix().walkInColumnOrder(new SetVisitor(piece));
//        }
        //ChessBoard chessBoard = new ChessBoard();
        findUniqueReq(variantOfPermutedPieces, variantOfPermutedPieces.size()-1, null);

    }

    private void findUniqueReq(List<IPiece> variantOfPermutedPieces, int reqDeep, ChessBoard chessBoard){
        if(chessBoard == null) {
            chessBoard = new ChessBoard();
        }

        if(reqDeep>=0){
            System.out.println("new recursion for chessboard: " + chessBoard + ", deep: " + reqDeep);
            IPiece piece = variantOfPermutedPieces.get(reqDeep);
            //System.out.println(piece);
            //mChessBoard.getChessBoardMatrix().add(piece.getPieceMovementMatrix());
            //check for free places

            //iterate 1st piece movement
            chessBoard.getChessBoardMatrix().walkInColumnOrder(new SetVisitor(variantOfPermutedPieces, reqDeep, chessBoard));
        }

//        --reqDeep;
//        // go to process next nested pieces
//        findUniqueReq(variantOfPermutedPieces, reqDeep);
    }


    private class SetVisitor extends DefaultRealMatrixChangingVisitor {
        private int mReqDeep;
        List<IPiece> mVariantOfPermutedPieces;
        ChessBoard mVisitorChessBoard;


        private SetVisitor(List<IPiece> variantOfPermutedPieces, int reqDeep, ChessBoard chessBoard) {
            mReqDeep = reqDeep;
            mVariantOfPermutedPieces = variantOfPermutedPieces;
            mVisitorChessBoard = chessBoard;
        }

        @Override
        public double visit(int i, int j, double value) {
            if(mVisitorChessBoard.getChessBoardMatrix().getEntry(i,j) == Piece.FREE_VALUE) {

                //mChessBoard.getChessBoardMatrix().setEntry(i, j, Piece.HIT_VALUE);
                IPiece piece =  mVariantOfPermutedPieces.get(mReqDeep);
                piece.setPosition(new Position(j,i));
                RealMatrix realMatrixCombined = mVisitorChessBoard.getChessBoardMatrix().add(piece.getPieceMovementMatrix());

                findUniqueReq(mVariantOfPermutedPieces, mReqDeep - 1, mVisitorChessBoard.clearAndCopy(realMatrixCombined));
                System.out.println("visit deep: " + mReqDeep + ", " + mVariantOfPermutedPieces.get(mReqDeep) + ", i: " + i + ", j: " + j);
            }
            return 0;
        }

        @Override
        public double end() {
            --mReqDeep;
            // go to process next nested pieces
//            findUniqueReq(mVariantOfPermutedPieces, mReqDeep);
            return super.end();
        }
    }

}
