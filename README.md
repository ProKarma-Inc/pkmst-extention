# pkmst-extention

Pkmst extension Primary responsibility is to provide the custer with out of the box gatewayfeatures that , if needed
can be executed from within the Microservices , instead of relying on gateways like APIGEE , APIC connect etc.

Extensions todday are primarily interceptors. Each interceptor extends HandlerInterceptorAdapter.
Type of interceptor that are available out of the box are

 # Audit Interceptor : 
 This a audit interceptor which extends the HandlerInterceptorAdapter to
 calculate the time taken by searchbyids request. 
 
 # Body Intercepter :
  This a Body interceptor which extends the HandlerInterceptorAdapter to
  intercept the request and check if any request body is present inside the
   request then it should be of proper contentType.
   
# CorrelationInterceptor  :
 This a audit interceptor which extends the HandlerInterceptorAdapter.It
 generates a UUID in the first API/service and pass it to all other
 APIs/services in the call tree for tracking purpose.
 
 # Global Exception Handlker :
 This is a global exception handler to handle the exceptions which are not
 caught
 
 # RateLimitInterceptor  :
 This a Rate Limit interceptor which extends the HandlerInterceptorAdapter to
  Limit the requests created by a client. Deafult limit to 10/min.
  there is not a canonical way to implement rate-limiting (in Java). It should
  be implemented in gateway
  
  # SanitizerHandler  :
  Every string object coming into your app will go through this code. The
   Handler cleaner will remove tags like <script>, <div>, etc. It also removes
  Everything inside those tags.

  
  # TraceabilityInterceptor :
  This a audit interceptor which extends the HandlerInterceptorAdapter.An id is
  passed in from client and will be unique with an application context. The id
  will be passed into the backend and return to the consumer for transaction tracing.
  
  
  \Veyr Simple to  USe in your exxiting code base
Just add below POM dependency 

  <dependency>
      <groupId>com.prokarma</groupId>
      <artifactId>pkmst-extension</artifactId>
      <version>1.0</version>
  </dependency>
  
  Happy Development
