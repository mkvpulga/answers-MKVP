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
		List<GrapeComponent> tempComp = new ArrayList<>();	
		 for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getVariety().equals(w.getComponents().get(i).getVariety())){                    
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                    if(tempComp.isEmpty()){
			tempComp.add(w.getComponents().get(i));
                    }
                }

		 for(int j=0; j < tempComp.size(); j++){
                    System.out.println(tempComp.get(j).getPercentage() + "% - " + tempComp.get(j).getVariety());		
                }
	}

	private static void printYearBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> tempComp = new ArrayList<>();	
		 for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getYear() == w.getComponents().get(i).getYear()){                    
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                    if(tempComp.isEmpty()){
			tempComp.add(w.getComponents().get(i));
                    }
                }

		 for(int j=0; j < tempComp.size(); j++){
                    System.out.println(tempComp.get(j).getPercentage() + "% - " + tempComp.get(j).getYear());		
                }
	}
	
	private static void printRegionBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> tempComp = new ArrayList<>();	
		 for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getRegion().equals(w.getComponents().get(i).getRegion())){                    
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                    if(tempComp.isEmpty()){
			tempComp.add(w.getComponents().get(i));
                    }
                }

		 for(int j=0; j < tempComp.size(); j++){
                    System.out.println(tempComp.get(j).getPercentage() + "% - " + tempComp.get(j).getYear());		
                }
	}
	
	private static void printYearAndVarietyBreakdown(Wine w) {
		// TODO: implement me
		List<GrapeComponent> tempComp = new ArrayList<>();	
		 for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getVariety().equals(w.getComponents().get(i).getVariety()) && tempComp.get(j).getYear() == w.getComponents().get(i).getYear()){                    
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                    if(tempComp.isEmpty()){
			tempComp.add(w.getComponents().get(i));
                    }
                }

		 for(int j=0; j < tempComp.size(); j++){
                    System.out.println(tempComp.get(j).getPercentage() + "% - " + tempComp.get(j).getYear() + " - " + tempComp.get(j).getVariety());		
                }
	}

}
