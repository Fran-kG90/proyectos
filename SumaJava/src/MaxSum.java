import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MaxSum {

	public static int findMax(List<Integer> list) {

		if (list == null || list.size() == 0) {
			return Integer.MIN_VALUE;
		}

		return Collections.min(list);
	}

	public static void main(String[] args) {
		int suma = 0;
		List<Integer> list = new LinkedList<>(Arrays.asList(5, 9, 7, 11));

//    	   Collections.sort(list);

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return Integer.compare(i2, i1); // descending-order sorting
			}
		});

		for (int index = 0; index < list.size() && index < 2; index++) {

			suma += list.get(index);
		}

	
		System.out.println("sort : " + list);
		System.out.println("Sum de dos numeros grandes - " + suma);

		//int sum = list.stream().mapToInt(i -> i).sum();

	}
}