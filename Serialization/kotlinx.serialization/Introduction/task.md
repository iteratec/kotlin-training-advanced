# Introduction

kotlinx.serialization is a multi-format and cross-platform framework for data serialization.

## Usecase

The kotlinx.serialization framework is primarily designed to streamline the process of converting Kotlin objects into a format that can be easily stored, transmitted, or shared across different platforms and systems.
It simplifies the integration of data interchange between components written in Kotlin and external systems.
It is suited for environments like web applications, mobile apps, microservices or serverless functions.

## Features

### Annotation Based

kotlinx.serialization leverages Kotlin's annotation system.
By annotating Kotlin classes and properties with specific serialization annotations, developers can customize the serialization behavior according to their requirements.

### Reflection-Free Architecture

By leveraging plugins, kotlinx.serialization eliminates the reliance on runtime reflection.
The usage of annotations instructs the Kotlin Serialization plugin to automatically generate and hook up a serializer for this class at compile time.
The result is a faster serialization and deserialization processes at runtime.
This approach not only enhances performance but also mitigates potential compatibility issues across different platforms and environments.

### Support for Multiple Formats

The framework supports serialization to and from popular data interchange formats such as JSON, XML, Properties and ProtoBuf.

> However, currently only the JSON format is considered stable.

### Multiplatform Integration

As an official Kotlin library maintained by JetBrains, it seamlessly integrates with other Kotlin frameworks and libraries.
It complements the Kotlin ecosystem effortlessly
- Backend development with e.g. Ktor
- Frontend development with Kotlin/JS 
- Android app development with Kotlin Multiplatform

## Resources

* https://github.com/Kotlin/kotlinx.serialization
* https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md
