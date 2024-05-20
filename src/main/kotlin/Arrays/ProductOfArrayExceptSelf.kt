package org.practice.datastructuresalgorithms.Arrays
//
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
// elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
//
//
//Constraints:
//
//2 <= nums.length <= 105
//-30 <= nums[i] <= 30
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
// integer.

fun productWoSelf(nums: IntArray): IntArray {
    val n = nums.size
    val results = IntArray(n)
    val leftProducts = IntArray(n)
    val rightProducts = IntArray(n)

    // Initialize leftProducts and rightProducts
    // Using 1 will not change results
    leftProducts[0] = 1
    rightProducts[n - 1] = 1

    //Everything before i
    for(i in 1 until n){
        leftProducts[i] = leftProducts[i-1] * nums[i-1]
    }

    //Everything after i
    for(i in n-2 downTo 0){
        rightProducts[i] = rightProducts[i+1]*nums[i+1]
    }

    //Product of everything except i
    for(i in 0 until n) {
        results[i] = leftProducts[i] * rightProducts[i]
    }

    println(results.toList())
    return results
}