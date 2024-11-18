import java.util.ArrayList;
//=================================================================================================
public class LightStrip {
    //---------------------------------------------------------------------------------------------
    private ArrayList<Light> lights = new ArrayList<>();
    //---------------------------------------------------------------------------------------------
    public void display() {
        double totalLumens = 0.0;
        double totalHeatOutput = 0.0;
        int fluorescentCount = 0;

//----Display all lights and calculate totals
        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            System.out.println(i + ": " + light.toString());

            totalLumens += light.getLumens();
            if (light.isFlourescent()) {
                fluorescentCount++;
            } else {
                totalHeatOutput += light.heatOutput();
            }
        }

//----Display totals
        System.out.println("Total lumens = " + totalLumens);
        System.out.println("Flourescent  = " + fluorescentCount);
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