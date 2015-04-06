package com.example;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class Main {
    public static void main(String[] args) {

//        double [][] dm1 = {{1, 2},{3,4}};
//        double [][] dm2 = {{10, 20},{30,40}};
//        RealMatrix rm1 = MatrixUtils.createRealMatrix(dm1);
//        RealMatrix rm2 = MatrixUtils.createRealMatrix(dm2);
//
//        RealMatrix rm3 = rm1.add(rm2);
//
//        rm3.setEntry(1,0, 55);


        MainWorker mainWorker = new MainWorker();
        mainWorker.findUniqueConfigurations();
    }

}
