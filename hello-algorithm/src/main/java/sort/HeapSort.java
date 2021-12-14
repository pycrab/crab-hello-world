package sort;

import java.util.Arrays;

/**
 * 堆排序.
 * <p>
 * <p>简介：堆排序是基于完全二叉树这种数据结构实现的排序算法. 简便起见, 完全二叉树使用数组存储, 可以根据索引快速定位元素.
 * <p>满二叉树：所有内部节点都有左右子节点, 最后一层为叶子节点.
 * <p>完全二叉树：其每一个节点都与深度为k的满二叉树中编号从 1 到 n 的节点一一对应, 即只允许最后一层有空缺节点, 且空缺在右边.
 * <p>最大堆要求节点的元素都不小于其子节点, 最小堆要求节点的元素都不大于其子节点.
 * <p>
 * <p>基本思想: 以最大堆为例, 首先将待排序数组通过交换构造一个大顶堆, 最后根节点一定是最大的数, 然后将根节点的数与数组的最后一个数交换, 即每次建堆并交换后仍保证剩余的数满足完全二叉树. 然后将剩余的 n-1 个节点重新建堆并交换, 直至有序.
 * <p>时间复杂度: 时间复杂度在三种情况下均为 O(NlogN).
 * <p>空间复杂度: 额外空间 O(1).
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
public final class HeapSort {
	private HeapSort() {
	}

	/**
	 * 堆排序.
	 *
	 * @param arr .
	 * @return .
	 */
	public static int[] sort(int[] arr) {
		int length = arr.length;
		arr = Arrays.copyOf(arr, length);

		// 1.首先构建大顶堆
		// 从最后一个非叶子节点开始,调整堆
		for (int curRoot = length / 2 - 1; curRoot >= 0; --curRoot) {
			adjustHeap(arr, curRoot, length - 1);
		}

		// 2.交换堆顶的数和数组末尾的数, 继续从上往下调整剩余的堆
		for (int tail = length - 1; tail > 0; --tail) {
			swap(arr, 0, tail);
			adjustHeap(arr, 0, tail - 1);
		}

		return arr;
	}

	/**
	 * 调整堆,传入参数根节点和尾节点.
	 *
	 * @param arr     .
	 * @param curRoot .
	 * @param tail    .
	 */
	private static void adjustHeap(int[] arr, int curRoot, int tail) {
		if (curRoot < arr.length / 2) {
			int left = 2 * curRoot + 1;
			int right = 2 * curRoot + 2;
			if (left <= tail) {
				if (arr[curRoot] < arr[left]) {
					swap(arr, curRoot, left);
					adjustHeap(arr, left, tail);
				}
			}
			if (right <= tail) {
				if (arr[curRoot] < arr[right]) {
					swap(arr, curRoot, right);
					adjustHeap(arr, right, tail);
				}
			}
		}

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
