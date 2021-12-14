package sort;

import java.util.Arrays;

/**
 * 分配排序之桶排序/基数排序.
 * <p>
 * <p>基本思想: 采用分治策略, 将一个数据表分割成许多桶, 然后对各个桶里面的数据进行排序, 最后遍历桶将数据放回原始数组.
 * <p>时间复杂度: 桶排序的时间复杂度为 O(M+N), M 为桶的个数, N 为待排序数的个数.
 * <p>空间复杂度: 额外空间 O(M).
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class BucketSort {
	private BucketSort() {
	}

	/**
	 * 简单的桶排序.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sort(int[] arr) {
		if (arr.length == 0) {
			return new int[0];
		}
		arr = Arrays.copyOf(arr, arr.length);

		// 创建桶
		int max = Arrays.stream(arr).max().getAsInt();
		int[] buckets = new int[max + 1];

		// 向桶中放值
		for (int k : arr) {
			buckets[k] += 1;
		}

		int k = 0;
		int[] result = new int[arr.length];
		// 排除空桶
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i]; j++) {
				result[k++] = i;
			}
		}

		return result;
	}
}
