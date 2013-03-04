
public class Bonuses {

	public int[] getDivision(int[] points) {
		
		int bonusPercentages[] = new int[points.length];
		float pointsTotal = 0;
		for (int i=0; i<points.length; i++) {
			pointsTotal+=points[i];
		}
		
		double totalRemainders = 0;
		int totalRemaindersRounded = 0;
		
		for (int i=0; i<points.length; i++) {
			totalRemainders += ((points[i] / pointsTotal) * 100 - (int) Math.floor((points[i] / pointsTotal) * 100));
			bonusPercentages[i] = (int) Math.floor((points[i] / pointsTotal) * 100);
		}
		
		totalRemaindersRounded = (int) totalRemainders;
		
		if (isAllEqual(bonusPercentages)) 
			for (int i=0; i<totalRemaindersRounded; i++) {
				bonusPercentages[i]++;
			}
		else
			for (int i=0; i<totalRemaindersRounded; i++) {
				bonusPercentages[(points.length-1) - i]++;
			}
		
		return bonusPercentages;
	}
	
    public static boolean isAllEqual(int[] a) {
        for(int i=1; i<a.length; i++){
            if(a[0] != a[i]){
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		/*{1,2,3,4,5} Returns: { 6,  13,  20,  27,  34 }*/
		new Bonuses().getDivision(new int[] {1,2,3,4,5});
		/*{5,5,5,5,5,5} Returns: { 17,  17,  17,  17,  16,  16 }*/
		new Bonuses().getDivision(new int[] {5,5,5,5,5,5});
	}

	
}
