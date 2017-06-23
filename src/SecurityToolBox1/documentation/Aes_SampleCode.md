# This file will give you some example how to encrypt and decrypt with AES.

1. How to encrypt a secret key : 

```java
		try {
			AES aes = new AES();
			String messageEncrypted = aes.encrypt("le message a chiffrer", "la clee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```


2. How to decrypt a message from a String  : 

```java
		try {
			AES aes = new AES();
			String messageDecrypted = aes.decrypt("hashe message", "secret key", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```

3. How to decrypt a message from a file : 

```java
	try {
			AES aes = new AES();
			String messageDecrypted = aes.decrypt(null, "secret key", "/var/message.hash");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```

