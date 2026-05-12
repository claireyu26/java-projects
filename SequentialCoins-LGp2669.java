public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //11/2/24
        //Luogu Gold Coins #2669
        //The king gave the knights gold coins as wages. On the first day, the knight received one gold coin; on the next two days (the second and third days), he received two gold coins each day; on the next three days (the fourth, fifth, and sixth days), he received three gold coins each day; on the next four days (the seventh, eighth, ninth, and tenth days), he received four gold coins each day...; this wage distribution pattern would continue like this: when the knight received one gold coin each day, he would receive one gold coin each day
        // n received every day n. After the knight has completed the next round of n+1, Every day, he receives n+1 Gold coins.

        //Please calculate first k. How many gold coins did the knight get in total during the day?
        System.out.println("After 6 days, the knight will receive "+ goldCoins(6)+" coins."); //should be 14
        System.out.println("After 1000 days, the knight will receive "+ goldCoins(1000)+" coins."); //should be 29820

    }
    static int goldCoins(int n){
        int sum=0;
        int count=0; //count should not exceed n.
       // while (count<n) {
            for (int i = 0; i < n; i++) {
                for (int j=0; j<i;j++){
                    if (count<n){ //check every time we want to add something
                        sum+=i;
                        count+=1;
                    }

                }
            }
       // }
        return sum;
    }
}
