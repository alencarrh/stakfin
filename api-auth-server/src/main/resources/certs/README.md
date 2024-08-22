openssl genrsa -out keypar.pem 2048
openssl rsa -in keypar.pem -pubout -out public.pem
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypar.pem -out private.pem