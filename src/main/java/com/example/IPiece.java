package com.example;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Toxa on 06.04.2015.
 */
public interface IPiece {
    PiecesType getType();
    //void setType(PiecesType piece);

    Position getPosition();
    void setPosition(Position position);

    void setAvailableMovements(ChessBoard board, Position position);

    int getIdentifier();

    RealMatrix getPieceMovementMatrix();

    void clearMatrix();
}
