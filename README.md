Assignment2-heap-sort

Made by Onalbayev Nursalim SE-2425

Code Review Observations

CROSS-REVIEW:

HeapSort :

Implemented with bottom-up heapify, reducing constant factors.

Integrated PerformanceTracker (comparisons, swaps, array accesses, time).

Covered edge cases with JUnit 5 tests (empty array, single element, duplicates, sorted/reverse).

Code is modular, clear, and follows Maven project structure.

ShellSort :

Provides a working implementation of Shell Sort.

Currently lacks performance metrics and unit tests.

Uses a basic gap sequence (n/2, n/4, …, 1), which does not guarantee sub-quadratic complexity.

Repository shows minimal commits and could benefit from cleaner commit history and documentation.
Empirical Results (Summary)

HeapSort: Benchmarks confirm O(n log n) growth. Performance scales smoothly from n = 100 to n = 100,000. Results match theoretical expectations.

ShellSort: No performance measurements were provided. Based on theory, ShellSort can outperform quadratic algorithms and sometimes compete with HeapSort for small n, but it deteriorates to O(n²) in the worst case with the basic gap sequence.