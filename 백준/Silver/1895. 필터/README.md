# [Silver IV] 필터 - 1895 

[문제 링크](https://www.acmicpc.net/problem/1895) 

### 성능 요약

메모리: 12392 KB, 시간: 100 ms

### 분류

브루트포스 알고리즘, 구현, 정렬

### 제출 일자

2025년 2월 13일 17:52:17

### 문제 설명

<p>The median of 9 numbers is the fifth number when the numbers are arranged in either increasing or decreasing order. For example, the median of the 9 numbers 1, 3, 4, 1, 2, 6, 8, 4, 10 is 4 because 1 <= 1 <= 2 <= 3 <= 4 <= 4 <= 6 <= 8 <= 10. </p>

<p>An image I is a two dimensional R × C array of pixels, 3 <= R <= 40, 3 <= C <= 40. A pixel has an integer grey level value V, 0 <= V <= 255. </p>

<p>Median filter is an image processing operation to remove noise. The filter can be implemented by moving a 3 × 3 window over the image and finding the median of the 9 pixel values covered by the 3 × 3 window. </p>

<p>For example, given the 6 × 5 image </p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/filter1.gif" style="height:160px; opacity:0.9; width:200px"></p>

<p>the 4 × 3 filtered image is </p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/filter2.gif" style="height:110px; width:150px"></p>

<p>You can easily check that as the 3 × 3 window moves along the top row from left to right, the three window contents are as shown below (the boundaries of the 3 × 3 window are shown via thick lines) </p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/filter3.gif" style="height:160px; width:460px"></p>

<p>The corresponding medians for these positions of the 3 × 3 windows are 36, 36 and 21 respectively; hence they constitute the top row of the filtered image J. The pixel values of the other rows of the filtered image J can be found similarly. </p>

<p>Write a program to output an integer which is the number of pixels in the filtered image J whose values are greater than or equal to a threshold T. </p>

<p>For the threshold T = 40, the program should output 7 for the above example because there are 7 pixels in the filtered image J whose values are larger than or equal to T. </p>

### 입력 

 <p>The input consists of R + 2 lines. The first line contains the two integers R (the number of rows) and C (the number of columns) separated by a blank. The subsequent R lines contain the image: each line contains C pixel values, with a single blank between two adjacent pixel values. The last line contains the single integer T, the threshold value. </p>

<p> </p>

### 출력 

 <p>The output contains a single integer, which is the number of pixels in the filtered image J whose values are larger than or equal to the threshold. </p>

