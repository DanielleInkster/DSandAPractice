package org.practice.datastructuresalgorithms.Arrays

// You are given an integer array height of length n. There are n vertical lines drawn such that
// the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
// Find two lines that together with the x-axis form a container, such that the container contains
// the most water.
//
// Return the maximum amount of water a container can store.
//
// Notice that you may not slant the container.

fun waterContainer(nums: IntArray): Int {
    var maxVolume = 0

    // pointers
    var left = 0
    var right = nums.size - 1

    // assessing products
    while (left < right) {
        // calculate number of entries between i and right
        val width = right - left
        val height = minOf(nums[left], nums[right])
        val currentVolume = height * width

        maxVolume = maxOf(currentVolume, maxVolume)

        if (currentVolume < maxVolume) {
            right--
        } else {
            left++
        }
    }
    println(maxVolume)
    return maxVolume
}
