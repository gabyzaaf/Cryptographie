# This file will give you some example how to encrypt and decrypt with RSA.


1. How to encrypt a message : 

```java
			try {
				RSA rsa = new RSA(1024);
				String messageChiffre = rsa.encrypt("Message a chiffrer");
			} catch (RsaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
```

2. How to decrypt a message : 

```java
			try {
				RSA rsa = new RSA(1024);
				String message = rsa.decrypt("message chiffre");
			} catch (RsaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
```