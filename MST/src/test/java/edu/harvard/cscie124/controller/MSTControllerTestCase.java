package edu.harvard.cscie124.controller;

import org.junit.Test;

public class MSTControllerTestCase {

	@Test
	public void executeMST_Test_With_16_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 16, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_32_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 32, 5, index);
		}
	}
	
	
	@Test
	public void executeMST_Test_With_64_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 64, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_128_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 128, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_256_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 256, 5, index);
		}
	}
	
	
	@Test
	public void executeMST_Test_With_512_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 512, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_1024_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 1024, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_2048_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 2048, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_4096_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 4096, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_8192_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 8192, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_16384_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 16384, 5, index);
		}
	}
	
	@Test
	public void executeMST_Test_With_32768_Nodes(){
		MSTController mstControler = new MSTController();
		for(int index = 2; index < 5; index++){
			mstControler.executeMST(0, 32768, 5, index);
		}
	}
	
}
