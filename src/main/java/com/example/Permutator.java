package com.example;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class Permutator {

    private List<IPiece> mPieceList = Lists.newArrayList();

    public void addPiece(IPiece piece){
        mPieceList.add(piece);
    }

    public void permutateShow(){
        List<List<IPiece>> answer = getPermutatedList();
        for (List<IPiece> list1 : answer) {
            for(IPiece item: list1) {
                System.out.print(item.toString());
            }
            System.out.println();
        }

    }

    public List<List<IPiece>> getPermutatedList() {
        int x = 0;
        List<List<IPiece>> newPerm = Lists.newArrayList();
        int permSize = Collections2.permutations(mPieceList).size();

        Collection<List<IPiece>> perm = Collections2.permutations(mPieceList);
        for (Iterator<List<IPiece>> it = perm.iterator(); it.hasNext(); x++) {
            if (x >= permSize) {
                break;
            }

            List<IPiece> list = it.next();
            List<IPiece> item = Lists.partition(list, mPieceList.size()).get(0);
            newPerm.add(item);
        }

        return newPerm;
    }

}
