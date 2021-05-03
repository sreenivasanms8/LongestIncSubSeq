package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();

        int[] arraySeq = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        ArrayList<int[]> iterationsArray = new ArrayList<int[]>();

        for (int i = 0; i < arraySeq.length; i++){

            int element;
            element = arraySeq[i];

            if (i == 0){
                dumpToArrList(element, iterationsArray);
            }
            else{
                cloneAddDumpToArrList(element, iterationsArray);
                dumpToArrList(element, iterationsArray);
            }
        }

        printArraysInList(iterationsArray);

        System.out.println();

        ArrayList<int[]> incSeqArrayDB = new ArrayList<int[]>();

        DesgIncSeqArrayDB(iterationsArray, incSeqArrayDB);

        printArraysInList(incSeqArrayDB);

        double endTime = System.currentTimeMillis();

        double TotalTime = endTime-startTime;

        System.out.println("");

        System.out.println("The total time it took to execute this program was "+TotalTime+ " ms.");

    }

    static void DesgIncSeqArrayDB (ArrayList<int[]> iterationsArray, ArrayList<int[]> incSeqArrayDB){

        for (int k = 0; k < iterationsArray.size(); k++){

            int[] temparray = iterationsArray.get(k);

            if (temparray.length != 1){
                boolean incArrVal = true;
                for(int i = 1; i < temparray.length; i++){
                    if(temparray[i]>temparray[i-1]){
                        incArrVal = true;
                    }
                    else{
                        incArrVal = false;
                        break;
                    }
                }

                if (incArrVal == true) {
                    incSeqArrayDB.add(temparray);
                }

            }

        }

    }

    static void dumpToArrList (int elem, ArrayList<int[]> iterationsArray){
        int[] temparray = new int[1];
        temparray[0] = elem;
        iterationsArray.add(temparray);
    }

    static void cloneAddDumpToArrList(int elem, ArrayList<int[]> iterationsArray){

        ArrayList<int []> iterationsArrayClone = (ArrayList<int []>) iterationsArray.clone();

        for (int i = 0; i < iterationsArrayClone.size(); i++){

            int[] existarray = iterationsArrayClone.get(i);

            int[] temparray= new int[((iterationsArrayClone.get(i).length)+1)];

            int n = temparray.length;

            int element  = elem;

            for (int j = 0; j < existarray.length; j++){
                temparray[j] = existarray[j];
            }
            temparray[n-1] = element;

            iterationsArray.add(temparray);

        }

    }

    static void printArraysInList(ArrayList<int[]> iterationsArray){

        for (int i = 0; i < iterationsArray.size(); i++){

            int x;

            System.out.print("At position "+i+" in the arraylist: ");

            int[] temparr = iterationsArray.get(i);
            System.out.print("The array is [");
            for (int j = 0; j < temparr.length; j++){
                System.out.print(temparr[j]+" ");
            }
            System.out.print("]."+" ");

            System.out.println("The length of the array is "+iterationsArray.get(i).length+".");

        }

    }

}