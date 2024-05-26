# [Bronze I] 오르막길 - 2846 

[문제 링크](https://www.acmicpc.net/problem/2846) 

### 성능 요약

메모리: 14248 KB, 시간: 128 ms

### 분류

구현

### 제출 일자

2023년 7월 20일 18:50:25

### 문제 설명

<p>Tomislav has recently discovered that he’s completely out of shape. He actually becomes tired while walking down the stairs! One morning he woke up and decided to come in good shape. His favourite sport is cycling, so he decided to ride a tour on the local hills.</p>

<p>The route he is taking is described as a sequence of N numbers which represent the height of the road at evenly spaced points of the route, from the beginning to the end of it. Tomislav is interested in the largest segment of the route which goes up the hill he has to ride, according to the information he has. Let’s call such a segment a ‘climb’. Tomislav is too tired to bother about details, so he will only take into account the height difference of a climb, not its length.</p>

<p>A climb is more strictly defined as a consecutive increasing subsequence of at least two numbers describing the road. The size of the climb is the difference between the last and first number in the subsequence.</p>

<p>For example, let’s consider a route described by the following sequence of heights: 12 3_5_7_10 6 1_11. Underlined numbers represent two different climbs. The size of the first climb is 7. The second climb is larger, with size 10. Points with heights 12 and 6 are not parts of any climb.</p>

<p>Help Tomislav and calculate the largest climb! </p>

### 입력 

 <p>The first line of input contains a positive integer N (1 ≤ N ≤ 1000), the number of measured points on the route.</p>

<p>The second line of input contains N positive integers P<sub>i</sub>(1 ≤ P<sub>i</sub> ≤ 1000), the heights of measured points on the route.</p>

### 출력 

 <p>The first and only line of output should contain the size of the largest climb. If the route in the input does not contain any climbs, output 0.</p>

