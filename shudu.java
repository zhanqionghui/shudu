 import java.util.HashMap;
 2 import java.util.Map;
 3 
 4 public class T2 {
 5     public static final int N=3;
 6     public static void main(String[] args) {
 7         int x[][]={
 8                 {0,2,0,0,0,9,0,1,0,0},
 9                 {5,0,6,0,0,0,3,0,9,0},
10                 {0,8,0,5,0,2,0,6,0,0},
11                 {0,0,5,0,7,0,1,0,0,0},
12                 {0,0,0,2,0,8,0,0,0,0},
13                 {0,0,4,0,1,0,8,0,0,0},
14                 {0,5,0,8,0,7,0,3,0,0},
15                 {7,0,2,3,0,0,4,0,5,0},
16                 {0,4,0,0,0,0,0,7,0,0},
17         };
18         
19         function(x,0,0);
20         
21     }
22 　　
23     private static void function(int[][] x, int r, int c) {
24         if (r>=x.length) {
25             show(x);
26             return;
27         }
28         if (c==0&&(r==x.length/N||r==x.length/N*2||r==x.length)) {
29             if (!checkedbox(x,r)) {
30                 return;
31             };
32             
33         }
34         if (c>=x.length) {
35             function(x, r+1, 0);
36             return;
37         }
38         
39         if (x[r][c]==0) {
40             for (int i = 1; i <= x.length; i++) {
41                 if (checked(x,r,c,i)) {
42                     x[r][c]=i;
43                     function(x, r, c+1);
44                     x[r][c]=0;
45                 }
46             }
47         }else{
48             function(x, r, c+1);
49         }
50     }
51     private static boolean checkedbox(int[][] x, int r) {
52         for (int k = 0; k < x.length; k+=x.length/N) {
53             Map<Integer, Integer> map=new HashMap<>();
54             for (int i = r-N; i < r; i++) {
55                 for (int j = k; j < k+x.length/N; j++) {
56                     if (map.containsKey(x[i][j])) {
57                         return false;
58                     }
59                     map.put(x[i][j], 1);
60                 }
61             }
62             
63         }
64         return true;
65     }
66 
67     private static boolean checked(int[][] x, int r, int c, int i) {
68         for (int j = 0; j < x.length; j++) {
69             if (x[j][c]==i) {
70                 return false;
71             }
72             if (x[r][j]==i) {
73                 return false;
74             }
75         }
76         return true;
77     }
78 
79     private static void show(int[][] x) {
80         for (int i = 0; i < x.length; i++) {
81             for (int j = 0; j < x.length; j++) {
82                 System.out.print(x[i][j]+" ");
83             }
84             System.out.println();
85         }
86         System.out.println();
87     }
88 
89 }