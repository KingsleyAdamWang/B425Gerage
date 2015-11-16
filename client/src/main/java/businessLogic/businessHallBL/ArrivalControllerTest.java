package businessLogic.businessHallBL;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.ArrivalVO;

public class ArrivalControllerTest {

	@Test
	public void testSubmit() {
		ArrivalController controller = new ArrivalController();
		ArrivalVO vo = new ArrivalVO();
		assertEquals(true,controller.submit(vo));
	}

}
