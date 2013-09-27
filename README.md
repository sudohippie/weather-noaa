# NOAA Weather API [![Build Status](https://travis-ci.org/sudohippie/weather-noaa.png)](https://travis-ci.org/sudohippie/weather-noaa)

## Overview

This API enables access to NOAA's weather data in an object oriented way using Java. Currently NOAA exposes two types of web services to access weather data, namely REST and SOAP. This project enables access to NOAA weather data via both these web services.

This project contains two important object types which help establish interaction with NOAA web services. These components are:

* Services
* Methods

###  Services
Service objects, represent the NOAA web services to which you will make requests for data requests. Currently,  NOAA supports two types of web services which are represented as:

1. NOAASOAPService.java - For the SOAP web service
2. NOAARESTService.java - For the REST web service

### Methods
Method objects encapsulate details regarding the request you would like to make to the NOAA service. Again since there are who types of service supported by NOAA, methods are classified in to REST and SOAP methods and are abstracted via the two methods:

1. NOAASOAPMethod.java
2. NOAARESTMethod.java

These methods are associated to their corresponding service types by default with connection information as specified on the NOAA service documentation. However, this can be changed as necessary.

Constructing and making a request to a web service is based on the command design pattern. A single class called NOAAWeather.java acts as the invoker of the commands.

## Examples

### Download using SOAP

```java
// Construct SOAP method for download max temperature data
NOAAMethod method = new NDFDgen();

// Add SOAP method arguments
method.addArgument("latitude", "35.4");
method.addArgument("longitude", "-97.6");
method.addArgument("product", "time-series");
method.addArgument("startTime", "2013-09-20T00:00");
method.addArgument("endTime", "2013-09-20T12:00");
method.addArgument("Unit", "e");
method.addArgument("weatherParameters", "maxt=true");

// Construct the invoker
NOAAWeather weather = new NOAAWeather();

// Request for data :)
String data = weather.query(method);

System.out.println(data);
```

### Download using REST
```java

// Construct a generic REST method
NOAAMethod method = new GenericRESTMethod();

// Add the REST query string arguments
method.addArgument("lat", "47.6201");
method.addArgument("lon", "-122.141");
method.addArgument("product", "time-series");
method.addArgument("begin", "2013-09-19T10:00");
method.addArgument("end", "2013-09-20T10:00");
method.addArgument("Unit", "e");
method.addArgument("maxt", "maxt");

// Construct the invoker
NOAAWeather weather = new NOAAWeather();

// Request for data :)
String data = weather.query(method);

System.out.println(data);
```


