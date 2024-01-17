public class Main {
    public static void main(String[] args) {
        System.out.println("*** TESTING PART A: constructors and getter ***");
        HorseBarn barn1 = new HorseBarn(5);
        Horse[] horses1 = barn1.getStalls();
        for (Horse h : horses1) {
            System.out.println(h);
        }
        Horse h1 = new Horse("Abe", 1100);
        Horse h2 = new Horse("Barb", 1200);
        Horse h3 = new Horse("Cathy", 1300);
        Horse[] horses = { h1, h2, null, h3 };
        HorseBarn barn2 = new HorseBarn(horses);
        Horse[] horses2 = barn2.getStalls();
        for (Horse h : horses2) {
            if (h != null) {
                System.out.println(h.horseInfo());
            } else {
                System.out.println(h);
            }
        }
        System.out.println("\n*** TESTING PART B: horseBarnInfo ***");
        System.out.println(barn1.horseBarnInfo());
        System.out.println(barn2.horseBarnInfo());

        System.out.println("\n*** TESTING PART C: placeHorse ***");
        HorseBarn sweetHome = new HorseBarn(7);
        sweetHome.placeHorse(new Horse("Trigger", 1340), 0);
        sweetHome.placeHorse(new Horse("Silver", 1210), 2);
        sweetHome.placeHorse(new Horse("Lady", 1575), 3);
        sweetHome.placeHorse(new Horse("Patches", 1350), 5);
        sweetHome.placeHorse(new Horse("Duke", 1410), 6);
        System.out.println(sweetHome.horseBarnInfo());

        System.out.println("\n*** TESTING PART D: findHorseStall ***");
        test("Trigger", 0, sweetHome);
        test("Silver", 2, sweetHome);
        test("Lady", 3, sweetHome);
        test("Patches", 5, sweetHome);
        test("Duke", 6, sweetHome);
        test("Coco", -1, sweetHome);

        System.out.println("\n*** TESTING PART E: consolidate ***");
        HorseBarn barn = new HorseBarn(7);
        barn.placeHorse(new Horse("Trigger", 1340), 0);
        barn.placeHorse(new Horse("Silver", 1210), 2);
        barn.placeHorse(new Horse("Patches", 1350), 5);
        barn.placeHorse(new Horse("Duke", 1410), 6);

        System.out.println("Barn before consolidating:");
        System.out.println(barn.horseBarnInfo());
        barn.consolidate();
        System.out.println("Barn after consolidating:");
        System.out.println(barn.horseBarnInfo());

        test("Trigger", 0, barn);
        test("Silver", 1, barn);
        test("Patches", 2, barn);
        test("Duke", 3, barn);
        test("Coco", -1, barn);

    }

    public static void test(String name, int correctIdx, HorseBarn barn) {
        System.out.print("Index of " + name + " should be " + correctIdx + " and is " + barn.findHorseStall(name));
        if (barn.findHorseStall(name) == correctIdx) {
            System.out.println(" -- pass");
        } else {
            System.out.println(" -- FAIL!");
        }
    }

}
