package sort;

import java.util.Arrays;

/**
 * 选择排序.
 * <p>
 * <p>基本思想: 每次从未排序的队列中找到最值, 放在已排序队列的末尾, 这里即将最值与未排序的首位交换.
 * <p>时间复杂度: 选择排序和冒泡排序进行了相同的比较次数, 都是 n*(n-1)/2 次, 但是其交换次数较少. 平均和最坏情况时间复杂度为 O(N^2).
 * n 值较小时, 选择排序比冒泡排序快, 因为它进行交换的次数少.
 * <p>空间复杂度: 额外交换空间 O(1).
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class SelectSort {
	private SelectSort() {
	}

	/**
	 * 普通选择排序, 无任何优化.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sort(int[] arr) {
		arr = Arrays.copyOf(arr, arr.length);

		int min;
		for (int i = 0; i < arr.length - 1; ++i) {
			min = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}

		return arr;
	}
}
