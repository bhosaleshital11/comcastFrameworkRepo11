package LearnTestngExecution;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClassUtility;

public class LearnTestngBatchAndParallelExecution2 extends BaseClassUtility{
	@Test(groups = "regression")
	public void Sample4()
	{
		System.out.println("=========Execute Sample4======= ");
	}
	@Test(groups = "smoke")
	public void Sample5()
	{
		System.out.println("=========Execute Sample5======= ");
	}
	@Test(groups = "regression")
	public void Sample6()
	{
		System.out.println("=========Execute Sample6======= ");
	}
	}

