package sort;

import java.util.Arrays;

/**
 * 快速排序.
 * <p>
 * <p>基本思想: 采用分治策略, 选择一个基准数作为分界点, 使左边的数小于基准数, 右边的数大于基准数; 之后分别对左边和右边的数进行此操作.
 * <p>时间复杂度: 跳跃式交换, 最坏时间复杂度为 O(N^2), 平均时间复杂度为 O(NlogN). 快速排序在平均情况下优于冒泡排序.
 * <p>空间复杂度: 额外空间 O(1).
 * <p>
 * <p>对小数组可以用插入排序优化.
 * <blockquote><pre>
 *     if (left + M >= right) {
 *         InsertSort.sort(arr, left, right);
 *         return;
 *     }
 * </pre></blockquote>
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class QuickSort {
	private QuickSort() {
	}

	/**
	 * 最常用的快速排序.
	 *
	 * @param arr   .
	 * @param left  .
	 * @param right .
	 * @return .
	 */
	public static int[] sort(int[] arr, int left, int right) {
		arr = Arrays.copyOf(arr, arr.length);

		if (left + 6 >= right) {
			return InsertSort.sort(arr, left, right);
		}
		if (left > right) {
			return arr;
		}

		// 选择基准数
		int mid = partition(arr, left, right);

		// 递归地排序左边和右边
		arr = sort(arr, left, mid - 1);
		arr = sort(arr, mid + 1, right);

		return arr;
	}

	private static int partition(int[] arr, int left, int right) {
		// 1、取第一个数作为基准数, i 和 j 为左右游标
		int temp = arr[left];
		int i = left;
		int j = right;

		while (i != j) {
			// 2、左右游标扫描
			// 先判断右边
			while (arr[j] >= temp && i < j) {
				j--;
			}
			// 再判断左边
			while (arr[i] <= temp && i < j) {
				i++;
			}

			// 3、左右游标相遇, 交换两个数的位置
			if (i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		// 4、将基准数归位
		arr[left] = arr[i];
		arr[i] = temp;
		return i;
	}
}
