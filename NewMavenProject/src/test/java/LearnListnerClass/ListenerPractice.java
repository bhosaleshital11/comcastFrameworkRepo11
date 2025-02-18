package LearnListnerClass;

import java.time.Duration;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClassUtility;

public class ListenerPractice extends BaseClassUtility
{
@Test
public void Testing() throws InterruptedException
{
	Thread.sleep(Duration.ofSeconds(20));
	System.out.println("executing=================");
}
}
