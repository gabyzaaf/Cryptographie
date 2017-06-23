# this file will give you some example how to Hash with (SHA256)


1. You can hash from a String like this : 
```java
		try {
			Sha sha256 = new Sha();
			sha256.createTheHashFromString("texte a hasher");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```

2. You can hash from a file, you need to specifie the absolute path : 

```java
		try {
			Sha sha256 = new Sha();
			sha256.createTheHashFromFile("/var/file2.hash");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```

