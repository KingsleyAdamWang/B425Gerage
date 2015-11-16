package businessLogic.intermediateBL;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.EntruckVO;
import businessLogic.businessHallBL.EntruckController;

public class EntruckControllerTest {

	@Test
	public void test() {
		EntruckController controller = new EntruckController();
		EntruckVO vo = new EntruckVO();
		assertEquals(true,controller.submit(vo));
	}

}
