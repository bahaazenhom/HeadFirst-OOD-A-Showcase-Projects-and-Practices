package GameSystemFramework;

public class Testing {
    public static void testType(Unit unit, String type, String expectedOutputType) {
        System.out.println("\nTesting setting/getting the type property.");
        unit.setType(type);
        String outputType = unit.getType();
        if (expectedOutputType.equals(outputType)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputType + " didn’t match " +
                    expectedOutputType);
        }
    }
    public static void testUnitSpecificProperty(Unit unit, String propertyName,
                                                Object inputValue, Object expectedOutputValue) throws Exception {
        System.out.println("\nTesting setting/getting a unit-specific property.");
        unit.setProperty(propertyName, inputValue);
        Object outputValue = unit.getProperty(propertyName);
        if (expectedOutputValue.equals(outputValue)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputValue + " didn’t match " +
                    expectedOutputValue);
        }
    }
    public static void testChangeProperty(Unit unit, String propertyName,
                                          Object inputValue, Object expectedOutputValue) throws Exception {
        System.out.println("\nTesting changing an existing property’s value.");
        unit.setProperty(propertyName, inputValue);
        Object outputValue = unit.getProperty(propertyName);
        if (expectedOutputValue.equals(outputValue)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputValue + " didn’t match " +
                    expectedOutputValue);
        }
    }
    public static void testNonExistentProperty(Unit unit, String propertyName) throws Exception {
        System.out.println("\nTesting getting a non-existent property’s value.");
        try {
            Object outputValue = unit.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Test passed");
            return;
        }
        System.out.println("Test failed.");
    }
    public static void main(String[] args) throws Exception {
        Unit unit = new Unit(1000);
        testType(unit, "infantry", "infantry");
        testUnitSpecificProperty(unit, "hitPoints", 25, 25);
        testChangeProperty(unit, "hitPoints", 25, 25);
        testNonExistentProperty(unit, "strength");

    }
}
