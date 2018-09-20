//This method is not overtime.Use only one "for"

public class Solution {
    public static int totalFruit(int[] tree) {
        int temp;
		int first = -1;
		int count = 0;
		int a = -1;
		int sum = 1;
		int b = -1;
		int c = 0;
        int [] arr = new int[100000];
        if(tree.length == 1)
            return 1;
        for(int i = 0; i < tree.length; i++){
			if(count == 0){
				first = i;
				a = tree[i];
				count++;
				continue;
			}
			if(sum == 1 && tree[i] != a){
				b = tree[i];
				sum++;
			}
			
			if(sum == 3){
				arr[c++] = count;
				i = first;
				count = 0;
				b = -1;
				sum = 1;
				continue;
			}
			if(tree[i] != a && tree[i] != b){
				sum++;
			}
			else{
				count++;	
			}
			if(i == tree.length - 1)
				arr[c++] = count;
        }
			temp = arr[0];
			for(int j = 1; j <= c; j++){
				if(arr[j] > temp)
					temp = arr[j];
			}
			return temp;
    }
}


//This method is overtime. Use two "for"

class Solution {
    public int totalFruit(int[] tree) {
        int a = 0;
        int temp;
        int [] arr = new int[40001];
        for(int i = 0; i < tree.length; i++){
            int sum = 1;
            int count = 1;
            int tmp = -1;
            for(int j = i + 1; j < tree.length; j++){
                if(tree[i] != tree[j] && count < 2){
                    count++;
                    tmp = tree[j];
                }
                if(tree[i] != tree[j] && tree[j] != tmp && count == 2)
                    count++;
                if(count == 3)
                    break;
                sum++;
            }
            arr[a++] = sum;
        }
        temp = arr[0];
        for(int j = 1; j <= a; j++){
            if(arr[j] > temp)
                temp = arr[j];
        }
        return temp;
    }
}

Title:
LeetCode 904 ------ Fruit Into Baskets

Algorithm analysis:
//take two type fruit into two baskets.For example,take a kind of fruit into one basket and 
//take another kind of fruit into the other.Now start from "i = 0" and calculate the"count" every step.
//But when loop the third kind of fruit and the loop will stop and continue to start from "i = 1" and so
//on.So take the value of count into an array when i=0,i=1,i=2.....Finally figure the maximum of the array
//
