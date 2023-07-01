# hlperetz/pop

An early stage, pure Clojure implementation of Socrata Query Language (SoQL).

## Rationale

There are existing SDKs for Java and Scala. The Java SDK is a bespoke wrapper around an HTTP client with typical Java pitfalls (mutable data structures, overspecified types, etc.) This library proposes a simpler interface. 