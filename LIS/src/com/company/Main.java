package com.company;

import java.util.*;

/**
 * When executing the program, if you get an OutOfMemory/Java-Heap-Space or Insufficient Memory error,
 * try to increase the memory allotted to Java depending on your computer's RAM capability.
 */

public class Main {

    public static void main(String[] args){

        double startTime = System.currentTimeMillis();

        /**
         * Enter the Entry Set below.
         */
        int[] arraySeq = new int[]{47977, 71932, 77315, 75753, 73694, 78354, 53874, 41401};

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

        /**
         * The iterationsArray that is built below gives the PowerSet P(S) of the Original Set S minus the empty set ∅. That is, iterationsArray = {P(S) – ∅}.
         * If you wish to print the iterationsArray, remove the comment-outs.
         **/
        //printArraysInList(iterationsArray);
        //System.out.println();

        ArrayList<int[]> incSeqArrayDB = new ArrayList<int[]>();
        DesgIncSeqArrayDB(iterationsArray, incSeqArrayDB);

        /**
         * The following method prints just the increasing sequences from the PowerSet, take away the empty set ∅ and the sets with size one.
         * If you wish to print them, remove the comment-outs.
         **/
        //printArraysInList(incSeqArrayDB);
        //System.out.println();

        DesgLISArrays(incSeqArrayDB);

        double endTime = System.currentTimeMillis();
        double TotalTime = endTime-startTime;
        System.out.println("");
        System.out.println("The total time it took to execute this algorithm was "+TotalTime+ " ms.");

    }

    static void DesgLISArrays(ArrayList<int[]> incSeqArrayDB){

        ArrayList<int[]> incSeqForLIS = incSeqArrayDB;

        ArrayList<int[]> LISArray= new ArrayList<>();

        int maxsize= 0 ;

        for(int i = 0; i < incSeqForLIS.size(); i++){
            int [] currentArray = incSeqForLIS.get(i);

            if (currentArray.length > maxsize){
                maxsize = currentArray.length;
            }

        }
        System.out.println("");
        System.out.println("The Longest increasing sequence has a length of "+ maxsize+".");

        for(int j = 0; j < incSeqForLIS.size(); j++){
            int [] currentArray = incSeqForLIS.get(j);

            if (currentArray.length == maxsize){
                LISArray.add(incSeqForLIS.get(j));
            }
        }

        printArraysInList(LISArray);
        System.out.println("");
        System.out.println("");
        System.out.println("There is/are "+LISArray.size()+" LIS/s with size "+maxsize+" as listed above.");

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

            for (int i = 0; i < iterationsArray.size(); i++) {

                    System.out.println("");

                    int x;

                    System.out.print("At position " +(i+1)+ " in the arraylist: ");

                    int[] temparr = iterationsArray.get(i);
                    System.out.print("The array is [");
                    for (int j = 0; j < temparr.length; j++) {
                        System.out.print(temparr[j] + " ");
                    }
                    System.out.print("]." + " ");
            }

    }

}