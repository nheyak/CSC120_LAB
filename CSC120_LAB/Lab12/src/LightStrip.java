import java.util.ArrayList;
//=================================================================================================
public class LightStrip {
    //---------------------------------------------------------------------------------------------
    private ArrayList<Light> lights;
    double totalLumens;
    double totalHeatOutput;
    int flourescentCount;

    //---------------------------------------------------------------------------------------------
    public LightStrip() { //Constructor
        this.totalLumens = 0;
        this.totalHeatOutput = 0;
        this.flourescentCount = 0;

        lights  = new ArrayList<>();
    }
    //---------------------------------------------------------------------------------------------
    public void display() {

//----Display totals
        System.out.println("Total lumens = " + getTotalLumens());
        System.out.println("Flourescent  = " + getFlourescentCount());
        System.out.println("Heat output  = " + getTotalHeat());
    }
    //---------------------------------------------------------------------------------------------
    public double getTotalLumens() {
        totalLumens = 0;

        for (int i = 0; i < lights.size(); i++) {
            totalLumens += lights.get(i).getLumens();
        }

        return totalLumens;
    }
    //---------------------------------------------------------------------------------------------
    public double getTotalHeat() {
        totalHeatOutput = 0;

        for (int i = 0; i < lights.size(); i++) {
            totalHeatOutput += lights.get(i).heatOutput();
        }

        return totalHeatOutput;
    }
    //---------------------------------------------------------------------------------------------
    public int getFlourescentCount() {
        flourescentCount = 0;

        for (int i = 0; i < lights.size(); i++) {
            if (lights.get(i).isFlourescent()) {
                flourescentCount ++;
            }
        }

        return flourescentCount;
    }
    //---------------------------------------------------------------------------------------------
    public void addLight(Light light) {
        lights.add(light);
    }
    //---------------------------------------------------------------------------------------------
    public void removeLight(int index) {

        if (index < 0 || index >= lights.size() || lights.get(index) == null) {
            System.out.println("ERROR: No light at that index");
        } else {
            lights.remove(index);
        }
    }
//-------------------------------------------------------------------------------------------------
}
//=================================================================================================