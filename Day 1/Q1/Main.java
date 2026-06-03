abstract class SpaceVessel {
    protected short shipId;
    protected boolean operationalStatus;
    protected char fleetClassification;
    public SpaceVessel(short shipId, boolean operationalStatus,char fleetClassification) {
        this.shipId = shipId;
        this.operationalStatus = operationalStatus;
        this.fleetClassification = fleetClassification;
    }
}
class MiningShip extends SpaceVessel {
    private float[][] cargoHold;
    public MiningShip(short shipId, boolean operationalStatus,char fleetClassification, float[][] cargoHold) {
        super(shipId, operationalStatus, fleetClassification);
        this.cargoHold = cargoHold;
    }
    public float calculateTotalOreWeight() {
        float total = 0;
        for (int i = 0; i < cargoHold.length; i++) {
            for (int j = 0; j < cargoHold[i].length; j++) {
                total += cargoHold[i][j];
            }
        }
        return total;
    }
    public float findHeaviestContainer() {
        float maxWeight = cargoHold[0][0];
        for (int i = 0; i < cargoHold.length; i++) {
            for (int j = 0; j < cargoHold[i].length; j++) {
                if (cargoHold[i][j] > maxWeight) {
                    maxWeight = cargoHold[i][j];
                }
            }
        }
        return maxWeight;
    }
}
public class Main {
    public static void main(String[] args) {
        float[][] cargo = {
            {1200.5f, 3400.0f, 2500.75f},
            {5000.0f, 4500.25f, 3800.5f}
        };
        SpaceVessel[] fleet = new SpaceVessel[1];
        fleet[0] = new MiningShip((short)1001,true,'A',cargo);
        MiningShip ship = (MiningShip) fleet[0];
        System.out.println("Total Ore Weight: " + ship.calculateTotalOreWeight() + " kg");
        System.out.println("Heaviest Container: " + ship.findHeaviestContainer() + " kg");
    }
}
