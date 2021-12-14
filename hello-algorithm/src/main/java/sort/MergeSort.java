package sort;

import java.util.Arrays;

/**
 * 归并排序.
 * <p>
 * <p>基本思想: 采用分治策略将待排序元素分成大小大致相同的两个子集合, 分别对两个子集合进行排序, 最终将子集合合并成要求的集合.
 * <p>时间复杂度: 采用递归的方式平均和最坏时间复杂度为 O(NlogN), 如果是数据有序的极端情况, 采用自然合并排序需要 O(N) 时间.
 * <p>空间复杂度: 额外空间 O(n).
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class MergeSort {
	private MergeSort() {
	}

	/**
	 * 递归形式的归并排序.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sort(int[] arr) {
		arr = Arrays.copyOf(arr, arr.length);

		int len = arr.length;
		int middle = arr.length / 2;
		if (len > 1) {
			// 1.对数组进行二分, 直到每个序列只有一个有序的数
			int[] left = Arrays.copyOfRange(arr, 0, middle);
			int[] right = Arrays.copyOfRange(arr, middle, len);
			left = sort(left);
			right = sort(right);

			// 2.对子序列进行合并
			merge(arr, left, right);
		}

		return arr;
	}

	/**
	 * 合并子序列.
	 * 采用两个指针 l 和 r 分别指向两个子序列头部, 一个指针 i 指向结果数组头部.
	 * 比较 l 和 r 处的值填入 i 处, 填入后指针分别向后移动.
	 * 如果有一个子序列没遍历完, 则继续遍历完成复制.
	 *
	 * @param arr   .
	 * @param left  .
	 * @param right .
	 */
	private static void merge(int[] arr, int[] left, int[] right) {
		int i = 0;
		int l = 0;
		int r = 0;
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				arr[i] = left[l];
				l++;
			} else {
				arr[i] = right[r];
				r++;
			}
			i++;
		}

		while (l < left.length) {
			arr[i] = left[l];
			l++;
			i++;
		}
		while (r < right.length) {
			arr[i] = right[r];
			r++;
			i++;
		}
	}
}
