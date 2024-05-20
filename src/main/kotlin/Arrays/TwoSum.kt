package org.practice.datastructuresalgorithms.Arrays
//
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

private val checked = mutableSetOf<Int>()

fun findCompliment(nums: Array<Int>, target: Int) {
    val hash = nums.toHashSet()
    val pairFound = nums.any { num ->
        val diff = target - num
        when {
            //has already been checked for compliment
            checked.contains(num) -> false
            num == diff -> {
                if (nums.count { it == num } > 1 ) {
                    printCompliment(nums, num, num)
                } else addToChecked(num)
            }
            hash.contains(diff) -> printCompliment(nums, num, diff)
            else -> addToChecked(num)
        }
    }
    if (!pairFound) {
        println("Pair not found")
    }
}

private fun addToChecked(num: Int): Boolean{
    checked.add(num)
    return false
}

private fun printCompliment(nums: Array<Int>, num: Int, diff: Int): Boolean{
    val diffIndex = nums.indexOfFirst { it == diff }
    val numIndices = nums.mapIndexedNotNull { index, elem -> index.takeIf{ elem == num }}
    val num = numIndices[0]
    val diff = if(num == diff) numIndices[1] else diffIndex
        println("Pair found($num, $diff)")
    return true
}