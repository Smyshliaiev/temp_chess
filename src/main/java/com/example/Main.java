package com.example;

import org.apache.commons.math3.linear.DefaultRealMatrixChangingVisitor;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class Main {
    public static void main(String[] args) {

//        double [][] dm1 = {{0, 0},{0, 0}};
//        double [][] dm2 = {{10, 20},{30,40}};
//        RealMatrix rm1 = MatrixUtils.createRealMatrix(dm1);
//        RealMatrix rm2 = MatrixUtils.createRealMatrix(dm2);
//
//        RealMatrix rm3 = rm1.add(rm2);
//
//        rm3.setEntry(1,0, 55);

//        HashSet<List<UniquePosition>> mHashSet = new HashSet<List<UniquePosition>>();
//
//        List<UniquePosition> list1 = new ArrayList<UniquePosition>();
//        list1.add(new UniquePosition(1, new Position(1,1)));
//        list1.add(new UniquePosition(2, new Position(2,2)));
//        list1.add(new UniquePosition(2, new Position(1,1)));
//
//        List<UniquePosition> list2 = new ArrayList<UniquePosition>();
//        list2.add(new UniquePosition(1, new Position(1,1)));
//        list2.add(new UniquePosition(2, new Position(2,2)));
//        list2.add(new UniquePosition(2, new Position(1,1)));
//
//        List<UniquePosition> list3 = new ArrayList<UniquePosition>();
//        list3.add(new UniquePosition(1, new Position(1,1)));
//        list3.add(new UniquePosition(2, new Position(2,2)));
//        list3.add(new UniquePosition(2, new Position(1,2)));
//
//
//        mHashSet.add(list1);
//        mHashSet.add(list2);
//        mHashSet.add(list3);


        MainWorker mainWorker = new MainWorker();
        mainWorker.findUniqueConfigurations();
    }

}
