package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 测试七大排序算法.
 *
 * @author pycrab.
 * @date 2021/12/14.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SortTest {
	private static final int[] EXPECTED = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

	static Stream<int[]> param() {
		return Stream.of(
				new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
				new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
				new int[]{4, 20, 5, 13, 8, 16, 6, 19, 3, 15, 2, 18, 1, 11, 9, 17, 14, 0, 12, 7, 10}
		);
	}

	@Order(0)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试冒泡排序1")
	public void testBubbleSort1(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, BubbleSort.sortV1(param));
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试冒泡排序2")
	public void testBubbleSort2(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, BubbleSort.sortV2(param));
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试冒泡排序3")
	public void testBubbleSort3(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, BubbleSort.sortV3(param));
	}

	@Order(3)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试冒泡排序4")
	public void testBubbleSort4(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, BubbleSort.sortV4(param));
	}

	@Order(4)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试选择排序")
	public void testSelectSort(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, SelectSort.sort(param));
	}

	@Order(5)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试插入排序")
	public void testInsertSort(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, InsertSort.sort(param, 1));
	}

	@Order(6)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试希尔排序")
	public void testShellSort(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, InsertSort.shellSort(param));
	}

	@Order(7)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试桶排序")
	public void testBucketSort(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, BucketSort.sort(param));
	}

	@Order(8)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试归并排序")
	public void run(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, MergeSort.sort(param));
	}

	@Order(9)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试快速排序")
	public void testQuickSort(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, QuickSort.sort(param, 0, param.length - 1));
	}

	@Order(10)
	@ParameterizedTest
	@MethodSource("param")
	@DisplayName("测试堆排序")
	public void testHeapSort(int[] param) {
		Assertions.assertArrayEquals(EXPECTED, HeapSort.sort(param));
	}
}
