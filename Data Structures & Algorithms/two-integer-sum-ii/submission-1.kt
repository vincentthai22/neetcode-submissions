class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var index1 = 0;
        var index2 = numbers.size-1;

        while(index1 < index2) {
            var total = numbers[index1] + numbers[index2]
            if(total > target) {
                index2--;
            } else if (total == target) {
                return intArrayOf(index1+1, index2+1);
            } else {
                index1++;
            }
        }
        return numbers;
    }
}
