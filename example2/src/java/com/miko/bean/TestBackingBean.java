/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miko.bean;

/**
 *
 * @author PULGAMV
 */
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import com.miko.model.GrapeComponent;
import com.miko.model.Wine;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean(name = "testBackingBean")
@ApplicationScoped
public class TestBackingBean {
    
    public Wine[] w = new Wine[]{initTest1(), initTest2(), initTest3()};
    public List<Wine> wineList = Arrays.asList(w);
    public Wine selectedWine;
    public String filterMode;
    public List<GrapeComponent> compToShow = new ArrayList<>();
    
    public Wine initTest1() {
    Wine w = new Wine("11YVCHAR001", 1000);
   
		w.setDescription("2011 Yarra Valley Chardonnay");
		w.setTankCode("T25-01");
		w.setProductState("Ready for bottling");
		w.setOwnerName("YV Wines Pty Ltd");
		
		
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay", "Macedon"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir", "Macedon"));

return w;
    }
    
    public Wine initTest2() {
    Wine w = new Wine("11YVCHAR002", 5077);
   
		w.setTankCode("T25-06");
		w.setOwnerName("YV Wines P/L and Vintage Kerr Joint Venture");
		
		
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay", "Macedon"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir", "Macedon"));

return w;
    }
    
    public Wine initTest3() {
    Wine w = new Wine("15MPPN002-VK", 100000);
   
		w.setDescription("2015 Mornington Peninsula Pinot Noir - Vintage Kerr special batch");
		w.setTankCode("T100-03");
		w.setProductState("Filtered");
		w.setOwnerName("Vintage Kerr");
		
		
		w.getComponents().add(new GrapeComponent(60D, 2015, "Pinot Noir", "Mornington"));
                w.getComponents().add(new GrapeComponent(10D, 2014, "Pinot Noir", "Mornington"));
                w.getComponents().add(new GrapeComponent(10D, 2015, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2014, "Pinot Noir", "Yarra Valley"));
                w.getComponents().add(new GrapeComponent(5D, 2013, "Cabernet", "Heathcote"));
		w.getComponents().add(new GrapeComponent(3D, 2015, "Merlot", "Yarra Valley"));
                w.getComponents().add(new GrapeComponent(2D, 2015, "Pinot Noir", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(2D, 2015, "Zinfandel", "Macedon"));
		w.getComponents().add(new GrapeComponent(2D, 2014, "Malbec", "Port Phillip"));		
                w.getComponents().add(new GrapeComponent(1D, 2015, "Shiraz", "Mornington"));
		
		
                
                return w;
    }
    
     @PostConstruct
    public void postConstruct() {
        filterMode = "";
       compToShow.clear();
       selectedWine = null;
  
        
    }
    
     
     
      public String backToList() {       
       
        return "/list.xhtml?faces-redirect=true";
    }
      
      public String filter(){
           compToShow.clear();
                
            if (filterMode.equals("Variety")){
              System.out.println("Variety");
              printVarietyBreakdown(selectedWine);
               
          } else if (filterMode.equals("Year")){
              System.out.println("Year");
              printYearBreakdown(selectedWine);
             
          } else if (filterMode.equals("Region")){
              System.out.println("Region");
              printRegionBreakdown(selectedWine);
             
          } else if (filterMode.equals("Year and Variety")){
              System.out.println("Year and Variety");
              printYearAndVarietyBreakdown(selectedWine);
             
          } 
          filterMode = "";
           return "/view.xhtml?faces-redirect=true";
}
      
      public void printVarietyBreakdown(Wine w) {
          // TODO: implement me
          List<GrapeComponent> tempComp = new ArrayList<>();
                for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getVariety().equals(w.getComponents().get(i).getVariety())){
                             System.out.println(tempComp.get(j).getVariety() + " = " + w.getComponents().get(i).getVariety());
                          
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            System.out.println(w.getComponents().get(i).getVariety());
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                                        if(tempComp.isEmpty()){
                                             
                        tempComp.add(w.getComponents().get(i));
                    }
                                        System.out.println("next record");
                }

                
                compToShow.addAll(tempComp);
                System.out.println(compToShow.size());
	}
      
        public void printYearBreakdown(Wine w) {
          
		// TODO: implement me
                
              List<GrapeComponent> tempComp = new ArrayList<>();
                for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getYear() == w.getComponents().get(i).getYear()){
                             System.out.println(tempComp.get(j).getYear() + " = " + w.getComponents().get(i).getYear());
                          
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            System.out.println(w.getComponents().get(i).getYear());
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                                        if(tempComp.isEmpty()){
                                             
                        tempComp.add(w.getComponents().get(i));
                    }
                                        System.out.println("next record");
                }

                
                compToShow.addAll(tempComp);
                System.out.println(compToShow.size());
	}
        
        public void printRegionBreakdown(Wine w) {
          
		// TODO: implement me
                
              List<GrapeComponent> tempComp = new ArrayList<>();
                for(int i=0; i < w.getComponents().size(); i++){

                    for(int j=0; j < tempComp.size(); j++){
                         if(tempComp.get(j).getRegion().equals(w.getComponents().get(i).getRegion())){
                             System.out.println(tempComp.get(j).getRegion() + " = " + w.getComponents().get(i).getRegion());
                          
                           tempComp.get(j).setPercentage(tempComp.get(j).getPercentage() + w.getComponents().get(i).getPercentage());
                            break;
                            } else{
                             if((j+1) == tempComp.size()){
                            System.out.println(w.getComponents().get(i).getRegion());
                            tempComp.add(w.getComponents().get(i));
                            break;
                            
                         }
                        
                             
                         }
                         
                              
                    }
                    
                                        if(tempComp.isEmpty()){
                                             
                        tempComp.add(w.getComponents().get(i));
                    }
                                        System.out.println("next record");
                }

                
                compToShow.addAll(tempComp);
                System.out.println(compToShow.size());
                
	}
        
        public void printYearAndVarietyBreakdown(Wine w) {
          
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
                                        System.out.println("next record");
                }

                
                compToShow.addAll(tempComp);
                System.out.println(compToShow.size());
	}
        
      public void updateWineDetails() {
          for(int i=0; i < wineList.size(); i++){
              if(wineList.get(i).equals(selectedWine)){
                  wineList.get(i).setDescription(selectedWine.getDescription());
                  wineList.get(i).setProductState(selectedWine.getProductState());
                 
              }
          }
          
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Wine table has been modified."));

    }
      
    public List<Wine> getWineList() {
        return wineList;
    }

    public void setWineList(List<Wine> wineList) {
        this.wineList = wineList;
    }

    public Wine getSelectedWine() {
        return selectedWine;
    }

    public void setSelectedWine(Wine selectedWine) {
        this.selectedWine = selectedWine;
    }

    public String getFilterMode() {
        return filterMode;
    }

    public void setFilterMode(String filterMode) {
        this.filterMode = filterMode;
    }

    public List<GrapeComponent> getCompToShow() {
        return compToShow;
    }

    public void setCompToShow(List<GrapeComponent> compToShow) {
        this.compToShow = compToShow;
    }
   
   
    
    
    
    
}
