package enumSet;

public enum PackType {
	plastic("快递袋"), paper("纸箱"), wood("木箱"), other("其他");

	private String packType;

	private PackType(String string) {
		packType = string;
	}

	public static PackType getPackType(String string) {
		switch (string) {
		case "快递袋":
			return plastic;
		case "纸箱":
			return paper;
		case "木箱":
			return wood;
		case "其他":
			return other;
		default:
			return null;
		}

	}
	
	
	public String getPackTypeString(){
		
		return packType;
	}

}
