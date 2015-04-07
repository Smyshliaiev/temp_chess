package com.example;

/**
 * Created by Toxa on 07.04.2015.
 */
public class UniquePosition {
    PiecesType pieceType;
    Position piecePosition;

    public UniquePosition(PiecesType pieceType, Position piecePosition) {
        this.pieceType = pieceType;
        this.piecePosition = piecePosition;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + pieceType.ordinal();
        result = prime * result + piecePosition.getX();
        result = prime * result + piecePosition.getY();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        UniquePosition up = (UniquePosition)obj;
        if(pieceType != up.pieceType) return false;
        if(piecePosition.getX() != up.piecePosition.getX()) return false;
        if(piecePosition.getY() != up.piecePosition.getY()) return false;
        return true;
    }
}

