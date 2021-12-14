package sort;

import java.util.Arrays;

/**
 * 交换排序之冒泡排序.
 * <p>
 * <p>基本思想: 每次根据大小比较相邻的两项, 将最小或最大的元素慢慢移动到数组末尾.
 * <p>时间复杂度: 对数组中的 n 个元素, 第一趟有 n-1 次排序, 第二趟有 n-2 次排序, 以此类推, 共有 n*(n-1)/2 次. 平均和最坏情况时间复杂度为 O(N^2).
 * <p>空间复杂度: 额外交换空间 O(1).
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class BubbleSort {
	/**
	 * 输出比较次数和交换次数.
	 */
	private static final String PRINT = "第%s次排序%s, 比较%s次, 交换%s次%n";
	private static final String SEPARATOR = "排序%s---------------------------------------------------%n";

	private BubbleSort() {
	}

	/**
	 * 普通冒泡排序, 无任何优化.
	 * <p>外层循环控制循环趟数, 内层循环控制每一趟的比较及交换处理, 每趟排好一个元素.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sortV1(int[] arr) {
		System.out.printf(SEPARATOR, "1");
		int length = arr.length;
		arr = Arrays.copyOf(arr, length);

		for (int i = length - 1; i > 0; --i) {
			int exchange = 0;
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					exchange++;
				}
			}
			System.out.printf(PRINT, length - i, Arrays.toString(arr), i, exchange);
		}

		return arr;
	}

	/**
	 * 冒泡排序第一次优化.
	 * <p>如果遍历时发现未排序的已经有序, 则不需要继续执行循环, 直接退出.
	 * <p>设置一个标记 sorted, 默认为 true, 如果交换则设置为 false, 内层循环结束判断标记, 决定是否有序可以退出.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sortV2(int[] arr) {
		System.out.printf(SEPARATOR, "2");
		int length = arr.length;
		arr = Arrays.copyOf(arr, length);

		boolean sorted;
		for (int i = length - 1; i > 0; --i) {
			sorted = true;
			int exchange = 0;
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
					exchange++;
				}
			}
			System.out.printf(PRINT, length - i, Arrays.toString(arr), i, exchange);
			if (sorted) {
				break;
			}
		}

		return arr;
	}

	/**
	 * 冒泡排序第二次优化.
	 * <p>如果有序区之前的元素也是有序, 则需要扩大有序区, 避免无意义的比较.
	 * <p>设置一个标记记录最后一次交换的位置, 作为下一次循环的边界.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sortV3(int[] arr) {
		System.out.printf(SEPARATOR, "3");
		int length = arr.length;
		arr = Arrays.copyOf(arr, length);

		boolean sorted;
		int border = length - 1;
		int lastExchangeIndex = 0;
		for (int i = length - 1; i > 0; --i) {
			sorted = true;
			int exchange = 0;
			for (int j = 0; j < border; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					// 注释代码减少一次比较, 但是多了很多compare比较, 得不偿失
					//if (compare != 1) {
					//	sorted = false;
					//}
					sorted = false;
					lastExchangeIndex = j;
					exchange++;
				}
			}
			System.out.printf(PRINT, length - i, Arrays.toString(arr), border, exchange);
			if (sorted) {
				break;
			}
			border = lastExchangeIndex;
		}

		return arr;
	}

	/**
	 * 冒泡排序第三次优化.
	 * 使用双向比较和交换交叉进行.
	 * 适用于大部分元素已经有序的情况, 优点是在特定情况下减少循环次数, 缺点是代码量扩大了一倍.
	 * 针对有序区的优化, 需要设置两个边界.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sortV4(int[] arr) {
		System.out.printf(SEPARATOR, "4");
		int length = arr.length;
		arr = Arrays.copyOf(arr, length);

		boolean sorted;
		int leftBorder = 0;
		int rightBorder = length - 1;
		int leftLastExchangeIndex = 0;
		int rightLastExchangeIndex = 0;
		for (int i = length - 1; i > 0; --i) {
			int exchange = 0;
			sorted = true;
			// 从左往右
			for (int j = leftBorder; j < rightBorder; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					rightLastExchangeIndex = j;
					sorted = false;
					exchange++;
				}
			}
			System.out.printf(PRINT, length - i, Arrays.toString(arr), rightBorder - leftBorder, exchange);
			if (sorted) {
				break;
			}
			rightBorder = rightLastExchangeIndex;

			// 从右往左
			sorted = true;
			for (int j = rightBorder; j > leftBorder; --j) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					leftLastExchangeIndex = j;
					sorted = false;
					exchange++;
				}
			}
			System.out.printf(PRINT, length - i, Arrays.toString(arr), rightBorder - leftBorder, exchange);
			if (sorted) {
				break;
			}
			leftBorder = leftLastExchangeIndex;
		}
		return arr;
	}
}
