package org.codeoshare.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class SorterTest {

	@Test
	public void testStrategy() throws Exception {
		List<Integer> list= new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(30);
		list.add(2);
		list.add(20);
		
		Sorter sorter = new InsertionSorter();
		List<Integer> list2 = sorter.sort(list);
		for (Integer integer : list2) {
			System.out.println(integer);
		}
		
		Sorter sorter2 = new SelectionSorter();
		List<Integer> list3 = sorter2.sort(list);
		for (Integer integer : list3) {
			System.out.println(integer);
		}
		
		assertEquals(list2, list3);
	}
}
