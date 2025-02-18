package LearnTestngExecution;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClassUtility;

public class LearnTestngBatchAndParallelExecution1 extends BaseClassUtility {
@Test(groups = "smoke")
public void Sample1()
{
	System.out.println("=========Execute Sample1======= ");
}
@Test(groups = "regression")
public void Sample2()
{
	System.out.println("=========Execute Sample2======= ");
}
@Test(groups = "smoke")
public void Sample3()
{
	System.out.println("=========Execute Sample3======= ");
}
}
