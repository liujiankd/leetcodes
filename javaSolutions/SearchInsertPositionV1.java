/* This version will traverse the array, and the oj judges Timeout. */

pulic class SearchInsertPositionV1 {
    public int searchInsert(int[] A, int target) {
        int index = 0;
        while(index < A.length) {
            if(target <= A[index]) {
                break;
            }
            index++;
        }
        return index;
    }
}
