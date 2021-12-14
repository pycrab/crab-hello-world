package sort;

import java.util.Arrays;

/**
 * 插入排序之希尔排序.
 * <p>
 * <p>基本思想: 插入排序的基本思想是将一个元素插入到有序的数组中, 得到一个仍然有序的数组. 时间复杂度为 O(N^2), 适用于少量元素的排序. 复杂度等同冒泡排序.
 * <p>希尔排序是插入排序的升级, 将一个序列通过步长划分为多个序列, 对每个序列进行插入排序, 然后再通过更小的步长划分序列并排序, 直到步长为1, 此时即为直接插入排序.
 * <p>时间复杂度: 通过多次划分排序使得宏观上此序列已经有序, 相对于插入排序减少了元素移动的次数. 平均和最坏情况时间复杂度为 O(N^2). 当数组有序时, 时间复杂度降为 O(N).
 * <p>空间复杂度: 额外空间 O(1).
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class InsertSort {
	private InsertSort() {
	}

	/**
	 * 直接插入排序.
	 *
	 * @param arr  .
	 * @param step 步长.
	 * @return .
	 */
	public static int[] sort(int[] arr, int step) {
		arr = Arrays.copyOf(arr, arr.length);

		// 如果有奇数个数, 从下标为步长处开始; 如果为偶数个, 从下标为步长 +1 处开始, 才能不漏元素. 综述, 从步长处开始保证不漏元素.
		for (int i = step; i < arr.length; ++i) {
			int j = i;
			int temp = arr[j];
			while (j - step >= 0 && arr[j - step] > temp) {
				arr[j] = arr[j - step];
				j -= step;
			}
			arr[j] = temp;
		}

		return arr;
	}

	/**
	 * 希尔排序.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] shellSort(int[] arr) {
		arr = Arrays.copyOf(arr, arr.length);

		// 设置步长每次为原来的一半, 直到步长为1
		for (int step = arr.length / 2; step > 0; step /= 2) {
			//使用插入排序法从步长那组开始 向前 对每个子序列排序
			arr = sort(arr, step);
		}

		return arr;
	}

	public static int[] sort(int[] arr, int left, int right) {
		if (left > right) {
			return arr;
		}
		int[] copyArr = new int[arr.length];
		System.arraycopy(arr, 0, copyArr, 0, left);
		System.arraycopy(arr, right + 1, copyArr, right + 1, arr.length - right - 1);

		int length = right - left + 1;
		int[] destArr = new int[length];
		System.arraycopy(arr, left, destArr, 0, length);

		destArr = sort(destArr, 1);
		System.arraycopy(destArr, 0, copyArr, left, length);
		return copyArr;
	}
}
