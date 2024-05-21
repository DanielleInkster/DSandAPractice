package org.practice.datastructuresalgorithms.Arrays

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
// i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
// Notice that the solution set must not contain duplicate triplets.
//
//
// Example 1:
//
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation:
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:
//
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:
//
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
//
//
// Constraints:
//
// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105

fun threeSums(
    nums: IntArray,
    sum: Int = 0,
): List<IntArray> {
    // sort from smallest to largest value
    nums.sort()
    val list = mutableListOf<IntArray>()

    // iterate through list
    for (i in 0 until nums.size - 2) {
        // pointers
        var left = i + 1
        var right = nums.size - 1

        // assessing pointer sums
        while (left < right) {
            if (nums[i] + nums[left] + nums[right] == sum) {
                list.add(intArrayOf(nums[i], nums[left], nums[right]))
                break
            } else if (nums[i] + nums[left] + nums[right] < sum) {
                left++
            } else {
                right--
            }
        }
    }
    println(list.map { it.toList() })
    return list
}
