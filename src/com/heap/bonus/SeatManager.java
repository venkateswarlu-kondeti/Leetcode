package com.heap.bonus;

import java.util.PriorityQueue;
//1845. Seat Reservation Manager
public class SeatManager {
    public PriorityQueue<Integer> heap;
    public SeatManager(int n) {
        heap=new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            heap.add(i);
        }
    }

    public int reserve() {
        return heap.remove();
    }

    public void unreserve(int seatNumber) {
        heap.add(seatNumber);
    }
    public static void main(String[] args){
        SeatManager seatManager=new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }
}
