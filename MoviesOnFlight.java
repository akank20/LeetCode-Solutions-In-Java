package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoviesOnFlight {

	public static void main(String[] args) {
		  List<Integer> movieDurations = new ArrayList<>();
		  movieDurations.add(90);
		  movieDurations.add(85);
		  movieDurations.add(75);
		  movieDurations.add(60);
		  movieDurations.add(120);
		  movieDurations.add(150);
		  movieDurations.add(125); // [0, 6]
		  int d = 250;
		  System.out.println(Arrays.toString(pairOfLongestMovies(movieDurations, d)));
		}

		static class Movie {
		  int id;
		  int duration;
		  Movie(int i, int d) {
		    id = i;
		    duration = d;
		  }
		}

		public static int[] pairOfLongestMovies(List<Integer> movieDurations, int d) {
			// Assume movieDurations is not null, size >= 2
			int n = movieDurations.size();
			List<Movie> movies = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				movies.add(new Movie(i, movieDurations.get(i)));
			}
			// Sort
			Collections.sort(movies, (m1, m2) -> {
				return m1.duration - m2.duration;
			});
			// Two Pointers
			int lo = 0, hi = n - 1;
			int maxLen = -1;
			int maxLo = -1, maxHi = -1;
			while (lo < hi) {
				int sum = movies.get(lo).duration + movies.get(hi).duration;
				if (sum > d - 30) {
					--hi;
				} else { // sum <= d - 30
					if (sum > maxLen) { // update
						maxLen = sum;
						maxLo = lo;
						maxHi = hi;
					}
					if (sum == d - 30)
						break;
					++lo;
				}
			}
			return new int[] { movies.get(maxLo).id, movies.get(maxHi).id };
		}
	
}

