package com.kactech.jeromq;

import java.lang.reflect.Array;
import java.util.Map.Entry;
import java.util.TreeMap;

public class KacUtils {
	public static class Arrays {
		public static <T> T[] copyOf(T[] original, int newLength) {
			return (T[]) copyOf(original, newLength, original.getClass());
		}

		public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
			T[] copy = ((Object) newType == (Object) Object[].class)
					? (T[]) new Object[newLength]
					: (T[]) Array.newInstance(newType.getComponentType(), newLength);
			System.arraycopy(original, 0, copy, 0,
					Math.min(original.length, newLength));
			return copy;
		}

		public static byte[] copyOf(byte[] original, int newLength) {
			byte[] copy = new byte[newLength];
			System.arraycopy(original, 0, copy, 0,
					Math.min(original.length, newLength));
			return copy;
		}
	}

	public static <K, V> Entry<K, V> lastEntry(TreeMap<K, V> map) {
		Entry<K, V> ret = null;
		for (Entry<K, V> e : map.entrySet())
			ret = e;
		return ret;
	}

	public static <K, V> Entry<K, V> floorEntry(TreeMap<K, V> map, K key) {
		Entry<K, V> ret = null;
		for (Entry<K, V> e : map.entrySet())
			if (((Comparable<K>) e.getKey()).compareTo(key) <= 0)
				ret = e;
			else
				break;
		return ret;
	}
}
