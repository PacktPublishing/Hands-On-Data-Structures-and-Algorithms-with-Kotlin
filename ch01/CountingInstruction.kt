fun main(args: Array<String>) {
    val x = 10
	val y = x * 2
	for (i in 0..y) {
        if (i % 2 == 0) {
            println("$i is Even")
        } else {
            println("$i is Odd");
        }
    }
}


// Output
/*
0 is Even
1 is Odd
2 is Even
3 is Odd
4 is Even
5 is Odd
6 is Even
7 is Odd
8 is Even
9 is Odd
10 is Even
11 is Odd
12 is Even
13 is Odd
14 is Even
15 is Odd
16 is Even
17 is Odd
18 is Even
19 is Odd
20 is Even
*/