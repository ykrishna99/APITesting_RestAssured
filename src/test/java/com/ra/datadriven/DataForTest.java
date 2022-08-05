package com.ra.datadriven;

import org.testng.annotations.DataProvider;

public class DataForTest {

	@DataProvider(name = "dataForDelete")
	public Object[] dataForDelete1() {

		return new Object[] { 8 };
	}

	@DataProvider(name = "DataForPost")
	public Object[][] createData() {

		return new Object[][] { { "Albert", "Einstein", 1 }, { "Thomas", "Edison", 2 }, { "Henry", "Ford", 2 } };

	}

}
