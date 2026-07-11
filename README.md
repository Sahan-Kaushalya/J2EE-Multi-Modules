# J2EE Multi-Modules Enterprise Application

A comprehensive Maven-based J2EE / Jakarta EE multi-module enterprise application demonstrating clean architecture separation, enterprise component interactions, and modular design patterns.

---

## 🏗️ Architecture & Modules

The project is structured into multiple decoupled modules, each handling a specific layer of the enterprise application:

*   **`ecomm-cdi`**: Contains the core business logic utilizing Contexts and Dependency Injection (CDI).
*   **`ecomm-user`**: Handles user management, authentication, and core identity logic.
*   **`ecomm-web`**: The web presentation tier (Servlets, JSPs, or JSF) that interacts with the backend services.
*   **`ecomm-client-app` & `client-app-demo`**: Standalone enterprise application client modules demonstrating remote EJB invocations and component lookups.

---

## 🚀 Features

*   **Modular Architecture:** Structured with a parent POM to manage dependencies and build configurations efficiently across all sub-modules.
*   **Enterprise JavaBeans (EJB):** Demonstrates the use of `@Stateless` session beans for robust business logic.
*   **Dependency Injection:** Implements CDI for loose coupling between components.
*   **Client-Server Separation:** Features dedicated client application modules to simulate real-world enterprise integration scenarios.

---

## 🛠️ Tech Stack & Prerequisites

*   **Language:** Java (JDK 17)
*   **Specification:** J2EE / Jakarta EE 10
*   **Build Tool:** Maven 3.x
*   **Target Application Server:** GlassFish, Payara, or WildFly

---

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone [https://github.com/Sahan-Kaushalya/J2EE-Multi-Modules.git](https://github.com/Sahan-Kaushalya/J2EE-Multi-Modules.git)
cd J2EE-Multi-Modules
```

### 2.Build the Project

Run the Maven clean install command from the root directory to build all modules and generate the artifacts (WAR/EAR/JARs):
```bash
mvn clean install
```
### 3.Deployment

1. Start your compatible application server (e.g., GlassFish).
2. Deploy the generated target artifacts from the build output.
3. Run the client application modules to test remote communication.
