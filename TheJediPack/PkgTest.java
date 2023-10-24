package CoolPack;
/*
The following program demonstrates Package,
displaying the packages about which the
program currently is aware.
 */
public class PkgTest {
    public static void main(String... args) {
        Package[] pkgs = Package.getPackages();
        for (Package pkg : pkgs)
            System.out.println(
                    pkg.getName() + " " +
                            pkg.getImplementationTitle() + " " +
                            pkg.getImplementationVendor() + " " +
                            pkg.getImplementationVersion()
            );
    }
}
