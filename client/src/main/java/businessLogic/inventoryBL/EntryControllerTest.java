package businessLogic.inventoryBL;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.InventoryVo.EntryVO;

public class EntryControllerTest {

	@Test
	public void test() {
		EntryController controller = new EntryController();
		EntryVO vo = new EntryVO();
		assertEquals(true,controller.submit(vo));
	}

}
