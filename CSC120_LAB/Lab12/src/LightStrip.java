import java.util.ArrayList;
//=================================================================================================
public class LightStrip {
    //---------------------------------------------------------------------------------------------
    private ArrayList<Light> lights = new ArrayList<>();
    double totalLumens;
    double totalHeatOutput;
    int flourescentCount;
    //---------------------------------------------------------------------------------------------
    public LightStrip {
        this.totalLumens = totalLumens;
        this.totalHeatOutput = totalHeatOutput;
        this.flourescentCount = flourescentCount;
    }
    //---------------------------------------------------------------------------------------------
    public void display() {

//----Display all lights and calculate totals
        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            System.out.println(i + ": " + light.toString());

            totalLumens += light.getLumens();
            if (light.isFlourescent()) {
                flourescentCount++;
            } else {
                totalHeatOutput += light.heatOutput();
            }
        }

//----Display totals
        System.out.println("Total lumens = " + totalLumens);
        System.out.println("Flourescent  = " + flourescentCount);
        System.out.println("Heat output  = " + totalHeatOutput);
    }
    //---------------------------------------------------------------------------------------------
    public void addLight(Light light) {
        lights.add(light);
    }
    //---------------------------------------------------------------------------------------------
    public void removeLight(int index) {
        lights.remove(index);
    }
//-------------------------------------------------------------------------------------------------
}
//=================================================================================================