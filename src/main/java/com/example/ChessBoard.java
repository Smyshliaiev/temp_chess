package com.example;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Toxa on 06.04.2015.
 */
public class ChessBoard {

    private RealMatrix mRealMatrix;
    private static int mWidth = MainWorker.BOARD_WIDTH;
    private static int mHeight = MainWorker.BOARD_HEIGHT;

    public ChessBoard() {
        //mRealMatrix = MatrixUtils.createRealMatrix(width, height);
        mRealMatrix = MatrixUtils.createRealMatrix(mWidth, mHeight);
    }

    public static int getWidth() {
        return mWidth;
    }

    public void setWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public static int getHeight() {
        return mHeight;
    }

    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public RealMatrix getChessBoardMatrix() {
        return mRealMatrix;
    }

    public static ChessBoard clearAndCopy(RealMatrix mRealMatrix){
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.mRealMatrix = mRealMatrix.copy();
        return chessBoard;
    }
}
