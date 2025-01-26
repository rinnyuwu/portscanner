# Port Scanner 🔍

> **Warning:** This program is intended for educational purposes only. Please ensure you have permission from the network owner before using it

[![GitHub license](https://img.shields.io/badge/license-GPL--3.0-blue.svg)](https://opensource.org/licenses/GPL-3.0)
[![Java](https://img.shields.io/badge/Java-%3E%3D8-red.svg)](https://www.java.com)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/yourusername/port-scanner/actions)

---

## 📋 Overview

The **Port Scanner** is a simple yet powerful tool written in **Java** that helps you scan a range of ports on a specified IP address or domain. It allows you to identify which ports are open or closed, providing useful insights for network security analysis

---

## 🔑 Features

- **User-Friendly Interface**: Interactive prompts guide you through the scanning process for easy usage
- **Customizable Port Range**: Scan any port range between 0 and 65535
- **Parallel Scanning**: Speed up your scans using multi-threading for faster results
- **Results Saving**: Save your scan results to a text file for future reference
- **Clear Reporting**: See which ports are open or closed with easy-to-read results

---

## 🚀 Getting Started

### Prerequisites

Before you begin, make sure you have the following installed:

- **Java Development Kit (JDK)** version 8 or higher
- **An IDE or text editor** of your choice (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rinnyuwu/portscanner.git
   cd port-scanner
   ```
2. **Compile the Java program**:
   ```bash
   javac PortScanner.java
   ```
3. **Run the program**:
   ```bash
   java PortScanner
   ```

---

## ⚙️ Usage

1. Launch the program and carefully read the warning message
2. Confirm that you will use the program responsibly by entering `yes`
3. Enter the **IP address or domain** that you wish to scan
4. Define the **starting and ending ports** for the scan (port range: 0-65535)
5. Review the chosen scan parameters and confirm
6. The program will begin scanning and display the results when completed
7. Optionally, save the scan results to a file

---

## 📖 Example

```bash
⚠ Hey, just a heads up! Only use this program if you have permission from the network owner
Do you confirm you won’t use it for malicious purposes? (yes/no): yes
Enter the IP or domain to scan: example.com
Enter the starting port (0-65535): 20
Enter the ending port (0-65535): 80

Starting scan on example.com from port 20 to 80...

Scan complete:
Open ports: [22, 80]
Closed ports: [21, 23, 25, ...]

Do you want to save the results to a file? (yes/no): yes
Results successfully saved to file
```

---

## 📝 License

This project is licensed under the **GNU General Public License v3.0** - see the [LICENSE](https://github.com/rinnyuwu/portscanner/blob/main/LICENSE) file for details

---

## 🛠️ Built With

[![Java](https://img.shields.io/badge/Java-%3E%3D8-red.svg)](https://www.java.com)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
