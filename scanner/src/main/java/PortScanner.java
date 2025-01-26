import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PortScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("⚠ Hey, just a heads up! Only use this program if you have permission from the network owner");
        System.out.print("Do you confirm you won’t use it for malicious purposes? (yes/no): ");
        if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            System.out.println("The program is done");
            return;
        }

        String target = getTarget(scanner);
        int[] portRange = getPortRange(scanner);

        System.out.println("You've selected the following options:");
        System.out.println("IP/domain: " + target);
        System.out.println("Port range: " + portRange[0] + "-" + portRange[1]);
        System.out.print("Correct? (yes/no): ");
        if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            System.out.println("The program is done");
            return;
        }

        System.out.println("Starting scan " + target + " from port " + portRange[0] + " to " + portRange[1] + "...");
        scanPorts(target, portRange[0], portRange[1], scanner);
    }

    private static String getTarget(Scanner scanner) {
        System.out.print("Enter the IP or domain to scan: ");
        return scanner.nextLine().trim();
    }

    private static int[] getPortRange(Scanner scanner) {
        int startPort, endPort;
        while (true) {
            System.out.print("Enter the starting port (0-65535): ");
            startPort = getIntInput(scanner);

            System.out.print("Enter the ending port (0-65535): ");
            endPort = getIntInput(scanner);

            if (startPort < 0 || startPort > 65535 || endPort < 0 || endPort > 65535) {
                System.out.println("Error: ports must be in the range from 0 to 65535");
                continue;
            }

            if (startPort > endPort) {
                System.out.println("Error: the starting port cannot be greater than the ending port");
                continue;
            }
            break;
        }
        return new int[]{startPort, endPort};
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Error! Enter a number: ");
            }
        }
    }

    private static void scanPorts(String target, int startPort, int endPort, Scanner scanner) {
        List<Integer> openPorts = new ArrayList<>();
        List<Integer> closedPorts = new ArrayList<>();

        IntStream.rangeClosed(startPort, endPort).parallel().forEach(port -> {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(target, port), 1000);
                synchronized (openPorts) {
                    openPorts.add(port);
                }
            } catch (IOException ignored) {
                synchronized (closedPorts) {
                    closedPorts.add(port);
                }
            }
        });

        System.out.println("Scan complete");
        System.out.println("Open ports: " + openPorts);
        System.out.println("Closed ports: " + closedPorts);

        System.out.print("Do you want to save the results to a file? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            saveResultsToFile(target, openPorts, closedPorts);
        }
    }

    private static void saveResultsToFile(String target, List<Integer> openPorts, List<Integer> closedPorts) {
        try (FileWriter writer = new FileWriter(target.replaceAll("[^a-zA-Z0-9]", "_") + "_port_scan_results.txt")) {
            writer.write("Scan results for: " + target + "\n");
            writer.write("Open ports: " + openPorts + "\n");
            writer.write("Closed ports: " + closedPorts + "\n");
            System.out.println("Results successfully saved to file");
        } catch (IOException e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }
}