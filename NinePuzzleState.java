//represents the current state
public class NinePuzzleState {
	String currentConfig;
	int currentLevel;
	NinePuzzleState previousConfig;
	
	public NinePuzzleState(String config, int level, NinePuzzleState previous ){
		currentConfig = config;
		currentLevel = level;
		previousConfig = previous;
	}
	
	public String[] getMoves(){
		String[] moves = null; //this will hold possible configs 
		int position = currentConfig.indexOf('9'); //find position of 9
		if (position == 0){
			moves = new String[2];
			moves[0] = swapChars(currentConfig,0,1);
			moves[1] = swapChars(currentConfig,0,3);
		}
		else if(position == 1){
			moves = new String[3];
			moves[0] = swapChars(currentConfig,1,0);
			moves[1] = swapChars(currentConfig,1,2);
			moves[2] = swapChars(currentConfig,1,4);
		}
		else if (position ==2){
			moves = new String[2];
			moves[0] = swapChars(currentConfig,2,1);
			moves[1] = swapChars(currentConfig,2,5);
		}
		else if (position ==3){
			moves = new String[3];
			moves[0] = swapChars(currentConfig,3,0);
			moves[1] = swapChars(currentConfig,3,4);
			moves[2] = swapChars(currentConfig,3,6);
		}
		else if (position ==4){
			moves = new String[4];
			moves[0] = swapChars(currentConfig,4,1);
			moves[1] = swapChars(currentConfig,4,3);
			moves[2] = swapChars(currentConfig,4,5);
			moves[3] = swapChars(currentConfig,4,7);
		}
		else if (position ==5){
			moves = new String[3];
			moves[0] = swapChars(currentConfig,5,2);
			moves[1] = swapChars(currentConfig,5,4);
			moves[2] = swapChars(currentConfig,5,8);
		}
		else if (position ==6){
			moves = new String[2];
			moves[0] = swapChars(currentConfig,6,3);
			moves[1] = swapChars(currentConfig,6,7);
		}
		else if (position ==7){
			moves = new String[3];
			moves[0] = swapChars(currentConfig,7,6);
			moves[1] = swapChars(currentConfig,7,4);
			moves[2] = swapChars(currentConfig,7,8);
		}
		else if (position ==8){
			moves = new String[2];
			moves[0] = swapChars(currentConfig,8,5);
			moves[1] = swapChars(currentConfig,8,7);
		}
		return moves;
	}
	private static String swapChars(String str, int lIdx, int rIdx) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }
	
}
