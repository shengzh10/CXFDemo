# CXFDemo

## CxfServer

1. run on port 8081
2. provide web service: hello, this will return 'hello, {input}'
3. web service url: http://localhost:8081/cxf/cxfServices?wsdl

## CxfClient

1. run on port 8082
2. client call service on CxfServer
3. call http://localhost:8082/main will access the service and get 'hello, test2' in console