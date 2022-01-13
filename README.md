# eagl-application
Simple Webapp orchestrating the connection to BIRD and integration of AI services



## Setting up

### Generate private key
For a working SAML authentication, you need to provide a private key for signing the metadata transfered to your IDP. 
Install OpenSSL and run the following commands: 

```
openssl genrsa -out testing.key 2048
openssl pkcs8 -topk8 -nocrypt -in testing.key -outform PEM -out testing.key.pem 
```

The generated key files should be placed within the folder `src/main/resources`. Configure the path in the 
application.yaml accordingly.   /