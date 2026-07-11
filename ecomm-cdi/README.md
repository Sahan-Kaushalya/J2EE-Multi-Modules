# E-commerce CDI & EJB Application

This document explains the core concepts and annotations used in this project related to Java EE, Contexts and Dependency Injection (CDI), and Enterprise JavaBeans (EJB).

## Table of Contents
1. [CDI Scopes](#cdi-scopes)
2. [EJB Annotations](#ejb-annotations)
3. [CDI Qualifiers](#cdi-qualifiers)
4. [CDI Events and Observers](#cdi-events-and-observers)
5. [Dependency Injection](#dependency-injection)

---

## 1. CDI Scopes

Scopes define the lifecycle and visibility of a bean instance. The CDI container automatically manages when a bean is created and destroyed based on its scope.

### `@Dependent`
*   **File:** `MyService.java`, `EmailNotifier.java`, `SMSNotifier.java`
*   **Theory:** This is the default scope in CDI if no other scope is specified. A `@Dependent` bean's lifecycle is tied entirely to the bean that injects it. When the parent bean is created, a *new* instance of the dependent bean is created. When the parent bean is destroyed, the dependent bean is also destroyed. They do not have a standalone lifecycle.

### `@ApplicationScoped`
*   **File:** `Logger.java`
*   **Theory:** Beans with this annotation have their lifecycle tied to the web application itself. Only **one** instance of this bean is created for the entire application, and it is shared across all users and all sessions. It is similar to a singleton but managed by the CDI container. It is ideal for application-wide caches, configuration managers, or stateless utility classes (like a logger).

### `@RequestScoped` (Commented/Used previously)
*   **Theory:** The bean's lifecycle is tied to a single HTTP request. A new instance is created when an HTTP request begins, and it is destroyed when the request is completed. Useful for holding temporary data related to a single user interaction.

### `@SessionScoped` (Commented/Used previously)
*   **Theory:** The bean's lifecycle is tied to a user's HTTP session. A new instance is created for each distinct user and is kept alive as long as their session is active.
*   **Important Note (Passivation & Serializable):** Because application servers may need to save memory, they can serialize inactive HTTP sessions to disk (a process called **Passivation**) and restore them later (**Activation**). Any `@SessionScoped` bean *must* implement the `java.io.Serializable` interface so the server can safely write its state to disk. If it doesn't, a `NotSerializableException` (or a passivation capability error) will occur.

---

## 2. EJB Annotations

Enterprise JavaBeans (EJB) are used for writing business logic in Java EE, providing built-in features like transaction management and concurrency.

### `@Singleton`
*   **File:** `AppSettingSessionBean.java`
*   **Theory:** This is an EJB annotation indicating that only **one instance** of this session bean will be instantiated per application per JVM. It is often used for sharing state across the application, executing startup tasks, or caching data. Unlike CDI's `@ApplicationScoped`, EJBs provide built-in concurrency management (locking) to ensure thread safety when multiple clients access the singleton simultaneously.

### `@PostConstruct` (Commented out in `AppSettingSessionBean.java`)
*   **Theory:** This lifecycle callback annotation is placed on a method that needs to be executed *after* dependency injection is complete to perform any initialization. Since we use `@Inject` for dependencies, we rely on the container to initialize them, removing the need for manual instantiation (`new`) inside a `@PostConstruct` method.

---

## 3. CDI Qualifiers

Qualifiers are custom annotations used to resolve ambiguous dependencies. If an interface has multiple implementations, the container doesn't know which one to inject. Qualifiers solve this by explicitly tagging implementations and injection points.

### `@Qualifier`, `@Retention(RUNTIME)`, `@Target(...)`
*   **Files:** `Email.java`, `SMS.java`, `Console.java` (Custom Annotations in `lk.kaushalya.ecomm.annotation`)
*   **Theory:**
    *   `@Qualifier`: Marks the annotation as a CDI qualifier.
    *   `@Retention(RetentionPolicy.RUNTIME)`: Ensures the annotation is available at runtime so the CDI container can read it via reflection.
    *   `@Target({FIELD, METHOD, TYPE})`: Specifies where this annotation can be used (e.g., on class declarations (`TYPE`), injected fields (`FIELD`), or methods (`METHOD`)).

### Usage of Qualifiers
*   **Files:** `EmailNotifier.java` (tagged with `@Email`), `SMSNotifier.java` (tagged with `@SMS`), `AppSettingSessionBean.java` (injects `@Email`).
*   **Theory:** `NotificationService` has two implementations (`EmailNotifier` and `SMSNotifier`). By annotating `EmailNotifier` with `@Email`, we tell the container "This is the Email version". In `AppSettingSessionBean.java`, when we `@Inject @Email NotificationService`, the container explicitly knows to provide the `EmailNotifier` implementation, avoiding an ambiguous dependency error.

---

## 4. CDI Events and Observers

CDI provides a loosely coupled, publish-subscribe event mechanism. Beans can fire events, and other beans can listen (observe) for them without knowing about each other.

### `Event<T>` (Firing Events)
*   **File:** `AppSettingSessionBean.java`
*   **Theory:** The `Event` interface is used to fire events. By calling `logEvent.fire("message")`, the bean broadcasts this string payload to any interested observers. Notice that this event injection point is also qualified with `@Console`.

### `@Observes` (Receiving Events)
*   **File:** `Logger.java`
*   **Theory:** The `@Observes` annotation marks a method parameter as an event listener. When an event of the matching type (and matching qualifiers) is fired, the CDI container automatically invokes this method.
    *   `log(@Observes String message)`: Listens for *any* unqualified `String` events.
    *   `consoleLog(@Observes @Console String message)`: Listens *only* for `String` events fired with the `@Console` qualifier. This allows fine-grained routing of events.

---

## 5. Dependency Injection

### `@Inject`
*   **File:** `AppSettingSessionBean.java`
*   **Theory:** This is the core annotation of CDI (and standard Java dependency injection). It tells the container to automatically resolve and inject an appropriate instance of a bean into this field at runtime. It removes the need for the developer to manually instantiate objects using the `new` keyword, promoting loose coupling and easier testing.
