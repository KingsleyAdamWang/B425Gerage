package po;

public class ManageStrategyPO {

	public  static final double LOCAL_DISTANCE = 30.0;
	
	public  double[][] twoPlace = {{0,1064.7,1888.8,900},{1064.7,0,1213,266},{188.8,1213,0,1132},{900,266,1132}};
		
   public  ManageStrategyPO(){
   }
   
   
   public ManageStrategyPO(double[][] twoPlace){
	   this.twoPlace = twoPlace;
	   
   }
	
}
