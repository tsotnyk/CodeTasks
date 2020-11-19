package sts.airbnb.codeTasks;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<CandidatePath> list = new LinkedList<>();
        List<CandidatePath> resultList = new LinkedList<>();

        for (int i = 0; i < candidates.length && candidates[i] <= target; i++){
            list.add(new CandidatePath(target, candidates[i]));
        }

        while (!list.isEmpty()){
            List<CandidatePath> tmpList = new LinkedList<>();

            while (!list.isEmpty()){
                CandidatePath candidatePath = list.remove(0);
                if (candidatePath.target == 0){
                    resultList.add(candidatePath);
                }else if (candidatePath.target > 0) {
                    for (int i = 0; i < candidates.length && candidates[i] <= candidatePath.target; i++) {
                        tmpList.add(new CandidatePath(candidatePath, candidates[i]));
                    }
                }
            }
            list = tmpList;
        }

        return getUniqCandidatePath(resultList);

    }

    private List<List<Integer>> getUniqCandidatePath(List<CandidatePath> resultList) {

        HashSet<List<Integer>> setUniqList = new HashSet<>();

        for (CandidatePath candidatePath : resultList){
            Collections.sort(candidatePath.path);
            setUniqList.add(candidatePath.path);
        }
        return new ArrayList<>(setUniqList);
    }

    class CandidatePath{

        int target;
        List<Integer> path;

        public CandidatePath(int target, int candidate){

            this.target = target - candidate;
            this.path = new LinkedList<>(Collections.singletonList(candidate));
        }

        public CandidatePath(CandidatePath candidatePath, int candidate){

            this.target = candidatePath.target - candidate;
            this.path = new LinkedList<>(candidatePath.path);
            this.path.add(candidate);
        }
    }

}
