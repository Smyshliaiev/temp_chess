package com.example;

import javafx.geometry.Pos;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Toxa on 06.04.2015.
 */
public abstract class Piece implements IPiece {

    protected static final double HIT_VALUE = 1;
    protected static final double FREE_VALUE = 0;

    protected int mPieceId;
    protected PiecesType mPiecesType;
    protected Position mPosition;
    protected RealMatrix mRealMatrix;

    protected Piece() {
        mRealMatrix = MatrixUtils.createRealMatrix(ChessBoard.getWidth(), ChessBoard.getHeight());
    }

    protected abstract void fillMatrixWithPieceMovements();

    public void clearMatrix(){
        mRealMatrix = MatrixUtils.createRealMatrix(ChessBoard.getWidth(), ChessBoard.getHeight());
    }

    protected boolean checkGoodBounds(Position position, int diffX, int diffY){

        if((position.getX() + diffX)  < 0 || (position.getY() + diffY) < 0 ){
            return false;
        }
        if((position.getX() +diffX)>= ChessBoard.getWidth() || (position.getY() + diffY) >= ChessBoard.getHeight() ){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: ").
                append(getIdentifier()).
                append(", type: ").
                append(getType()).
                append(", position: ").
                append(getPosition()).
                append("; ");

        return builder.toString();
    }
}
