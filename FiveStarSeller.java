package amazon;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


public class FiveStarSeller {
	static class Rating implements Comparable<Rating> {
        int num;
        int den;
        public Rating(int num, int den) {
            this.num = num;
            this.den = den;
        }
        public double value() {
            return (double)num / den;
        }
        public Rating succ() {
            return new Rating(num + 1, den + 1);
        }
        public double gain() {
            return succ().value() - value();
        }
        public int compareTo(Rating other) {
            return -Double.compare(gain(), other.gain());
        }
    }
	public static void main(String[] args) {
		//=[[4,4],[1,2],[3,6]], 
		List<List<Integer>> a=new ArrayList<>();
		List<Integer> a1=new ArrayList<>();
		a1.add(2);
		a1.add(4);
		List<Integer> a2=new ArrayList<>();
		a2.add(3);
		a2.add(9);
		List<Integer> a3=new ArrayList<>();
		a3.add(4);
		a3.add(5);
		List<Integer> a4=new ArrayList<>();
		a4.add(2);
		a4.add(10);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		
		
		int count= fiveStarReviews(a,70);
		System.out.println(count);

	}
    public static int fiveStarReviews(List<List<Integer>> ratings, int threshold) {
        // WRITE YOUR BRILLIANT CODE HERE
        int numRats = ratings.size();
        // priority queue ordered by gain descending
        PriorityQueue<Rating> rats = new PriorityQueue<>(
                ratings.stream().map(r -> new Rating(r.get(0), r.get(1))).collect(Collectors.toList()));
        // how much more do we need to reach threshold
        double diff = threshold / 100.0 - rats.stream().mapToDouble(r -> r.value()).sum() / numRats;
        // count of five star reviews added
        int count = 0;
        while (diff > 0) {
            Rating s = rats.poll();
            rats.offer(s.succ());
            diff -= s.gain() / numRats;
            count++;
        }
        return count;
    }
}
