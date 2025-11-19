# Google Guice
- Udemy: [Dependency Injection by Google Guice](https://www.udemy.com/course/dependency-injection-by-google-guice)
- YouTube: [Dependency Injection by Google Guice](https://www.youtube.com/playlist?list=PLp0ed20U4R4jknb4xYdhx3yJn5RhWECxn)

## Dependents and Dependency
_Class A_ is dependent on _Class B_ if _Class A_ has to do some logic and to do that logic it depends on _Class B_. 
- _Class A_ -> Dependent
- _Class B_ -> Dependency

## Problems
Consider the below code snippet:
```java
interface DrawShape { void draw(); }

class DrawSquare implements DrawShape { @Override public void draw() { /*code*/ } }

class SquareRequest { // <- Dependent
    DrawSquare d = new DrawSquare(); // <- Dependency
    public void makeRequest() { d.draw(); }
}
```
On user input to draw a square, instantiate _SquareRequest_ and call _makeRequest_ method.
```java
class Main { 
    public static void main(String[] args) {
        SquareRequest request = new SquareRequest();
        request.makeRequest();
  }
}
```
In the above example, _SquareRequest_ is a dependent and _DrawSquare_ is a dependency.

### What are all problems in the above example?
- Tightly Coupled
  - Here, _SquareRequest_ is tightly coupled with _DrawSquare_. _SquareRequest_ just knows about _DrawSquare_
    and is only capable of calling methods of _DrawSquare_. _SquareRequest_ doesn't know anything about subtypes
    of _DrawSquare_. For example, if there is a class called _DrawBigSquare_ that extends _DrawSquare_, and, inside
    that, it has a better implementation of drawing a square. To use _DrawBigSquare_, the _SquareRequest_ is to
    be modified to instantiate _DrawBigSquare_ instead of _DrawSquare_. A loosely coupled code would be a type of
    code where no such modifications are required.
- Breaks _Single Responsibility Principle_
  - Here _SquareRequest_ is doing multiple things. It's primary responsibility is to delegate the call to
    _draw_ method. Apart from that, it is also instantiates the _DrawSquare_.
- Not good for Unit test
  - Since _DrawSquare_ is instantiated inside _SquareRequest_, it is difficult to unit test.

## Solution
Consider the below code snippet (A better version):
```java
class SquareRequest { // <- Dependent
    private final DrawShape shape; // <- Dependency
    
    public SquareRequest(DrawShape shape) { this.shape = shape; }
  
    public void makeRequest() { d.draw(); }
}
```
On user input to draw a square, instantiate _DrawShape_ with the desired shape (e.g., _DrawSquare_ or _DrawBigSquare_),
pass that as an argument to _SquareRequest_ and call _makeRequest_ method.
```java
class Main { 
    public static void main(String[] args) {
        DrawShape shape = new DrawSqaure();
        SquareRequest request = new SquareRequest(shape);
        request.makeRequest();
    }
}
```
The whole purpose is just to obtain _SquareRequest_ but still _DrawShape_ is instantiated. :( 

`HERE, GOOGLE GUICE CAN HELP` - Google Guice is available so manual object creation can be skipped. That responsibility
is delegated to Google Guice.

```java
class Main { 
    public static void main(String[] args) {
        SquareRequest request /* code to instantiate SquareRequest with Guice */;
        request.makeRequest();
    }
}
```

## Dependency Injection
The mechanism where dependencies are outsourced to some external framework (e.g., Google Guice) and are not
managed by the application, then the mechanism of injecting/providing dependencies is called dependency injection.

## How Guice builds object?
When, say _TypeA_ is requested, it does two things:
- Consults binding to resolve the concrete type
- Build object of that type

If _TypeA_ is an interface, then, a binding for it should exist:
```java
class DemoModule extends AbstractModule {
    @Override protected void configure(){
        bind(TypeA.class).to(ConcreteImplOfTypeA.class);
    }
}
```

If _TypeA_ is a concrete implementation, then:
- Case 1:
  - No bindings
- Case 2:
  - `bind(TypeA.class).to(SubClassOfTypeA.class);`

## Guice Object Graph
Example: `SquareRequest request = injector.getInstance(SquareRequest.class);`
- Guice sees that an instance of _SquareRequest_ class is requested.
- Guice checks the _ShapeModule_ class, but, since no binding for _SquareRequest_ class is added, and, the 
  _SquareRequest_ class is a concrete class, Guice invokes the _SquareRequest_ class constructor.
- The _SquareRequest_ class depends on _DrawShape_ class. Guice sees that an instance of _DrawShape_ is required here.
  Guice checks the _ShapeModule_ class, and, it sees that _DrawShape_ is bound to _DrawSquare_ class. Thus, Guice
  invokes the _DrawSquare_ class constructor.
- The _DrawSquare_ class depends on a _String_ and an _Integer_ class annotated with _@ColorValue_ and _@EdgeValue_
  respectively. Guice checks the _ShapeModule_ class, and, it sees that _@ColorValue_ is bound to value "Red" and
  _@EdgeValue_ is bound to value 40. Thus, these two values are provided to create a _DrawSquare_ class.

All together, to instantiate _SquareRequest_ class, Guice instantiates all dependencies of _SquareRequest_ class.

## Guice Singleton
Example: `bind(DrawShape.class).to(DrawSquare.class).in(Scopes.SINGLETON);`
- Whenever an instance of _DrawShape_ is requested in application, give them a _DrawSquare_ instance. Make
sure there's only one instance of _DrawSquare_ in the whole application (i.e., Reuse _DrawSquare_ instance
if already exists).

## Guice Object Graph - Method Injection
Example: `SquareRequest request = injector.getInstance(SquareRequest.class);`
- Guice sees that an instance of _SquareRequest_ class is requested.
- Guice checks the _ShapeModule_ class, but, since no binding for _SquareRequest_ class is added, and, the
  _SquareRequest_ class is a concrete class, Guice invokes the _SquareRequest_ class's no-args constructor.
- Guice also sees that _@Inject_ is required for _setDrawShape_ method. Guice sees that an instance of
  _DrawShape_ is required here. Guice checks the _ShapeModule_ class, and, it sees that _DrawShape_ is bound
  to _DrawSquare_ class. Thus, Guice invokes the _DrawSquare_ class's no-args constructor.

## Guice Object Graph - Field Injection
Example: `SquareRequest request = injector.getInstance(SquareRequest.class);`
- Guice sees that an instance of _SquareRequest_ class is requested.
- Guice checks the _ShapeModule_ class, but, since no binding for _SquareRequest_ class is added, and, the
  _SquareRequest_ class is a concrete class, Guice invokes the _SquareRequest_ class's no-args constructor.
- Guice also sees that _@Inject_ is required for _shape_ field. Guice sees that an instance of
  _DrawShape_ is required here. Guice checks the _ShapeModule_ class, and, it sees that _DrawShape_ is bound
  to _DrawSquare_ class. Thus, Guice invokes the _DrawSquare_ class's no-args constructor.

## Guice Support For Child Classes
Consider the below code snippet:
```java
public @interface Square { }

public @interface Circle { }

interface DrawShape {}

class DrawSquare implements DrawShape {}

class DrawCircle implements DrawShape {}

class SquareRequest { public constructor(@Square DrawShape shape) {} }

class CircleRequest { public constructor(@Circle DrawShape shape) {} }

class ShapeModule extends AbstractModule { 
    @Override protected void configure() {
        bind(DrawShape.class).annotatedWith(Square.class).to(DrawSquare.class);
        bind(DrawShape.class).annotatedWith(Circle.class).to(DrawCircle.class);
    }
}
```
Example: `CircleRequest request = injector.getInstance(CircleRequest.class);`
- Guice sees that an instance of _CircleRequest_ class is requested.
- Guice checks the _ShapeModule_ class, but, since no binding for _CircleRequest_ class is added, and, the
  _CircleRequest_ class is a concrete class, Guice invokes the _CircleRequest_ class constructor.
- The _CircleRequest_ class depends on _DrawShape_ class. Guice sees that an instance of _DrawShape_
  is required here that has _@Circle_ annotation binding. Guice checks the _ShapeModule_ class, and, it sees
  that _DrawShape_ with _@Circle_ annotation is bound to _DrawCircle_ class. Thus, Guice invokes the
  _DrawCircle_ class constructor.

## Guice Support For Child Classes - Named Annotation
Consider the below code snippet:
```java
interface DrawShape {}

class DrawSquare implements DrawShape {}

class DrawCircle implements DrawShape {}

class SquareRequest { public constructor(@Named("Square") DrawShape shape) {} }

class CircleRequest { public constructor(@Named("Circle") DrawShape shape) {} }

class ShapeModule extends AbstractModule { 
    @Override protected void configure() {
        bind(DrawShape.class).annotatedWith(Names.named("Square")).to(DrawSquare.class);
        bind(DrawShape.class).annotatedWith(Names.named("Circle")).to(DrawCircle.class);
    }
}
```

## Guice Support For Third-party Classes - @Provides
A third-party library provides an implementation of _DrawSquare_ class which cannot be altered. (Since it's a
third-party library implementation)

Consider the below code snippet:
```java
public interface DrawShape{ void draw(); }

public class DrawSquare implements DrawShape { 
    private final String color;
    private final Integer edge;
    
    public DrawSquare(String color, Integer edge) {
        this.color = color;
        this.edge = edge;
    }
    
    @Override public void draw() {
        System.out.println("Drawing square of color: " + color + " and edge: " + edge + "!");
    }
}
```
To provide an implementation for _DrawSquare_, Guice provides _@Provides_ annotation. Below code snippet shows how
_DrawSquare_ is hooked.
```java
public class ShapeModule extends AbstractModule {
    @Provides public DrawShape provideDrawSquare(){ return new DrawSquare("Red", 40); }
}
```
Example: `SquareRequest request = injector.getInstance(SquareRequest.class);`
- Guice sees that an instance of _SquareRequest_ class is requested.
- Guice checks the _ShapeModule_ class, but, since no binding for _SquareRequest_ class is added, and, the
  _SquareRequest_ class is a concrete class, Guice invokes the _SquareRequest_ class constructor.
- The _SquareRequest_ class depends on _DrawShape_ class. Guice sees that an instance of _DrawShape_
  is required here. Guice checks the _ShapeModule_ class, and, it sees that there is a _provideDrawSquare_ method
  that has the implementation of how to provide a _DrawShape_ class.

Guice can be used to inject constants "Red" and 40. Below code snippet shows how to inject constants with _@Provides_
and Guice.
```java
public @interface DefaultSquareColor {}

public @interface DefaultSquareEdge {}

public class ShapeModule extends AbstractModule {
    @Override protected void configure() {
        bind(String.class).annotatedWith(DefaultSquareColor.class).toInstance("Red");
        bind(Integer.class).annotatedWith(DefaultSquareEdge.class).toInstance(40);
    }
    
    @Provides public DrawShape provideDrawSquare(@DefaultSquareColor String color, @DefaultSquareEdge Integer edge) {
        return new DrawSquare(color, edge); 
    }
}
```

In the above example, if _DrawShape_ is a heavy implementation and to ensure only ONE implementation exists throughout
the application, it can be annotated with _@Singleton_ as shown below:

```java
public @interface DefaultSquareColor {}

public @interface DefaultSquareEdge {}

public class ShapeModule extends AbstractModule {
    @Override protected void configure() {
        bind(String.class).annotatedWith(DefaultSquareColor.class).toInstance("Red");
        bind(Integer.class).annotatedWith(DefaultSquareEdge.class).toInstance(40);
    }
    
    @Provides
    @Singleton
    public DrawShape provideDrawSquare(@DefaultSquareColor String color, @DefaultSquareEdge Integer edge) {
        return new DrawSquare(color, edge); 
    }
}
```

## Guice Support For Third-party Classes - Provider Interface
A third-party library provides an implementation of _DrawSquare_ class which cannot be altered. (Since it's a
third-party library implementation)

Consider the below code snippet:
```java
public interface DrawShape{ void draw(); }

public class DrawSquare implements DrawShape {
    @Override public void draw() {
        System.out.println("Drawing square!");
    }
}
```
To provide an implementation for _DrawSquare_, Guice provides _Provider_ interface that can be implemented. Below code
snippet shows how _DrawSquare_ is instantiated and used.
```java
public class ShapeModule extends AbstractModule {
    @Override protected void configure() {
        bind(DrawShape.class).toProvider(DrawSquareProvider.class);
    }
}

public class DrawSquareProvider implements Provider<DrawSquare> {
    @Override public DrawSquare get() { return new DrawSquare(); }
}
```
Example: `SquareRequest request = injector.getInstance(SquareRequest.class);`
- Guice sees that an instance of _SquareRequest_ class is requested.
- Guice checks the _ShapeModule_ class, but, since no binding for _SquareRequest_ class is added, and, the
  _SquareRequest_ class is a concrete class, Guice invokes the _SquareRequest_ class constructor.
- The _SquareRequest_ class depends on _DrawShape_ class. Guice sees that an instance of _DrawShape_
  is required here. Guice checks the _ShapeModule_ class, and, it sees that there is a _DrawSquareProvider_ class
  that has the implementation of how to provide a _DrawShape_ class.

## Guice Provider instance
```java
public class SquareRequest { 
    Provider<DrawShape> shape;

    @Inject
    public SquareRequest(Provider<DrawShape> shape) {
        System.out.println("Instantiating SquareRequest class");
        this.shape = shape;
    }

    public void makeRequest() {
        System.out.println("Delegating call from " + this.getClass().getName() + " to " + shape.getClass().getName());
        shape.get().draw();
    }

    public void makeRequest(int count) {
        for (int i = 0; i < count; ++i) {
            makeRequest();
        }
    }
}
```
- In this context, the _Provider<DrawShape>_ is used to give the _SquareRequest_ class on-demand, deferred access to
  _DrawShape_ instances instead of injecting a single, pre-constructed one. When Guice injects a `Provider<T>`, it doesn’t
  immediately create the `T` object; instead, it supplies a lightweight factory that can produce new instances whenever
  `get()` is called. This is especially useful when a fresh or lazily created object each time is needed, when object
  creation is expensive, or when the dependency might not always be needed. In _SquareRequest_, using a
  _Provider<DrawShape>_ allows each call to _makeRequest()_ to obtain a new _DrawShape_ object from Guice, ensuring that
  any scoped bindings or runtime configurations are respected. It also avoids creating _DrawShape_ at _SquareRequest_
  construction time, which can be beneficial if the _DrawShape_ depends on runtime state or should only exist during a
  specific operation.

## Just-In-Time Bindings
`SquareRequest request = injector.getInstance(SquareRequest.class);`
- When the injector needs an instance of a type, it needs a binding. The bindings in modules are called explicit
  bindings, and the injector uses them whenever they're available. If a type is needed but there isn't an explicit
  binding, the injector will attempt to create a Just-In-Time binding. These are also known as JIT bindings or
  implicit bindings. For example, there is no binding for _SquareRequest_, but, the injector will create a JIT binding.

## Built-in Bindings
```java
@Inject
    public SquareRequest(Provider<DrawSquare> shape) {
        System.out.println("Instantiating SquareRequest class");
        this.shape = shape;
    }
```
- Guice has built-in binding for _Provider_, intended to save some boilerplate. The binding automatically sets the
  _Provider_. This way, a separate implementation is not required explicitly.
