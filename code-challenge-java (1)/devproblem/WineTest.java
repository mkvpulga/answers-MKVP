package devproblem;


public class WineTest {

	public static void main(String[] args) {

		Wine w = new Wine("11YVCHAR001", 1000);
		w.setDescription("2011 Yarra Valley Chardonnay");
		w.setTankCode("T25-01");
		w.setProductState("Ready for bottling");
		w.setOwnerName("YV Wines Pty Ltd");
		
		
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay", "Macedon"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir", "Macedon"));
		
		printYearBreakdown(w);
		printVarietyBreakdown(w);
		printRegionBreakdown(w);
		printYearAndVarietyBreakdown(w);
		
	}

	private static void printVarietyBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> temp = new ArrayList<GrapeComponent>();
		for (GrapeComponent wine_component : w.getComponents()){	
			for (GrapeComponent component : temp){
				if(component.getVariety().equals(wine_component.getVariety())){
					component.getPercentage() += wine_component.getPercentage();
				} else{
					temp.add(wine_component);
				}
			}
		}

		for (GrapeComponent component : temp){
			System.out.println(component.getPercentage() + "% - " + component.getYear());		
		}
	}

	private static void printYearBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> temp = new ArrayList<GrapeComponent>();
		for (GrapeComponent wine_component : w.getComponents()){	
			for (GrapeComponent component : temp){
				if(component.getYear().equals(wine_component.getYear())){
					component.getPercentage() += wine_component.getPercentage();
				} else{
					temp.add(wine_component);
				}
			}
		}

		for (GrapeComponent component : temp){
			System.out.println(component.getPercentage() + "% - " + component.getYear());		
		}
	}
	
	private static void printRegionBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> temp = new ArrayList<GrapeComponent>();
		for (GrapeComponent wine_component : w.getComponents()){	
			for (GrapeComponent component : temp){
				if(component.getRegion().equals(wine_component.getRegion())){
					component.getPercentage() += wine_component.getPercentage();
				} else{
					temp.add(wine_component);
				}
			}
		}

		for (GrapeComponent component : temp){
			System.out.println(component.getPercentage() + "% - " + component.getYear());		
		}
	}
	
	private static void printYearAndVarietyBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> temp = new ArrayList<GrapeComponent>();
		for (GrapeComponent wine_component : w.getComponents()){	
			for (GrapeComponent component : temp){
				if(component.getYear().equals(wine_component.getYear()) && component.getVariety().equals(wine_component.getVariety())){
					component.getPercentage() += wine_component.getPercentage();
				} else{
					temp.add(wine_component);
				}
			}
		}

		for (GrapeComponent component : temp){
			System.out.println(component.getPercentage() + "% - " + component.getYear() + " - " + component.getVariety());		
		}
	}

}
