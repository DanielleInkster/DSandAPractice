package org.practice.datastructuresalgorithms.Arrays

//Given an unsorted integer array, find a pair with the given sum in it.
//
//For example,
//
//Input: nums = [8, 7, 2, 5, 3, 1]
// target = 10
// Output: Pair found (8, 2) or Pair found (7, 3)
//
// Input: nums = [5, 2, 6, 8, 1, 9]
// target = 12
// Output: Pair not found

private val checked = mutableSetOf<Int>()

fun findCompliment(nums: IntArray, target: Int) {
    val hash = nums.toHashSet()
    val pairFound = nums.any { num ->
        val diff = target - num
        when {
            //has already been checked for compliment
            checked.contains(num) -> false
            num == diff -> {
                if (nums.count { it == num } > 1 ) {
                    printCompliment(num, num)
                } else addToChecked(num)
            }
            hash.contains(diff) -> printCompliment(num, diff)
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

private fun printCompliment(num: Int, diff: Int): Boolean{
    println("Pair found($num, $diff)")
    return true
}