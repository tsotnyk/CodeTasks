package sts.liveranp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//public class Navigator {
//    //todo: fill in as needed
//
//    HashMap<Tower, List<Tower>> towerMap;
//
//    public Navigator(List<Tower> list){
//
//        this.towerMap = new HashMap<>();
//        for(int i = 0; i < list.size(); i++){
//            List<Tower> connecterList = new LinkedList<>();
//            for(int j = 0; j < list.size(); j++){
//                if (i!=j && connectedTower(list.get(i), list.get(j))){
//                    connecterList.add(list.get(j));
//                }
//            }
//            this.towerMap.put(list.get(i), connecterList);
//        }
//    }
//
//    private boolean connectedTower(Tower first, Tower second){
//        //todo
//        return true;
//    }
//
//    //todo: main goal:
//    boolean isRouteConnected(
//            Point first, Point second
//    ) {
//
//        // find tower for each point
//
//        return false;
//    }
//
//
//}

class Point{

    double x;
    double y;
}

class Tower{

    double x;
    double y;
    double r;

    public Tower(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
