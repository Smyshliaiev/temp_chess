package com.example;

import org.apache.commons.math3.linear.RealMatrix;

import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class King extends Piece {

    public King(List<Integer> pieceIdentifiers) {
        mPieceId = pieceIdentifiers.size();
        pieceIdentifiers.add(mPieceId);

        mPiecesType = PiecesType.KING;
        mPosition = new Position(-100, -100);
    }

    @Override
    public PiecesType getType() {
        return mPiecesType;
    }

//    @Override
//    public void setType(PiecesType pieceType) {
//        mPiecesType = pieceType;
//    }

    @Override
    public Position getPosition() {
        return mPosition;
    }

    @Override
    public void setPosition(Position position) {
        mPosition = position;
        fillMatrixWithPieceMovements();

    }

    @Override
    public void setAvailableMovements(ChessBoard board, Position position) {

    }

    @Override
    public int getIdentifier() {
        return mPieceId;
    }

    @Override
    public RealMatrix getPieceMovementMatrix() {
        return mRealMatrix;
    }


    @Override
    protected void fillMatrixWithPieceMovements() {

        if( checkGoodBounds(getPosition(), 0, 0)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY(), HIT_VALUE);
        if( checkGoodBounds(getPosition(), 1, 0)) mRealMatrix.setEntry(getPosition().getX()+1, getPosition().getY(), HIT_VALUE);
        if( checkGoodBounds(getPosition(), 1, 1)) mRealMatrix.setEntry(getPosition().getX()+1, getPosition().getY()+1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), 0, 1)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY()+1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), -1, 1)) mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY()+1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), -1, 0)) mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY(), HIT_VALUE);
        if( checkGoodBounds(getPosition(), -1, -1)) mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY()-1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), 0, -1)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY()-1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), 1, -1)) mRealMatrix.setEntry(getPosition().getX()+1, getPosition().getY()-1, HIT_VALUE);
    }

}
