# 33. Search in Rotated Sorted Array [Medium]

The [link](https://leetcode.com/problems/search-in-rotated-sorted-array/) of question.

## Description

You are given an integer array `nums` sorted in ascending order, and an integer `target`.

Suppose that `nums` is rotated at some pivot unknown to you beforehand (i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

*If `target` is found in the array return its index, otherwise, return `-1`.*

Example 1:
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

Example 2:
```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

Example 3:
```
Input: nums = [1], target = 0
Output: -1
```

Constraints:
```
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
-10^4 <= target <= 10^4
```
All values of `nums` are **unique**.
`nums` is guranteed to be rotated at some pivot.

## 题目分析

最直接的算法当然是直接从头向后找、这样的时间复杂度为`O(N)`

题目要考察的目标应当是二分查找。先定位反转点、再定位目标值，时间复杂度`O(logN)`

<!--  -->

题目的测试样例存在“未旋转”情况……