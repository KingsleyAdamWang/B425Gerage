package businessLogic.deliveryBL;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SendControllerTest {	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFare() {
		SendController controller = new SendController();
		assertEquals(1064.7/1000*30+10,controller.getFare("北京", "上海", 10));
	}

}
