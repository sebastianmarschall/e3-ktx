# Kotlin extensions for Virgil EThree Kit

[![](https://jitpack.io/v/com.sebastianmarschall/e3-ktx.svg)](https://jitpack.io/#com.sebastianmarschall/e3-ktx)

## EThree + Kotlin Coroutines

Easily suspend EThree functions.


```kotlin
val e3 = EThree(id, tokenCallback, context)

// register
e3.register().await()

// unregister
e3.unregister().await()

// find user(s)
val card = e3.findUser(id).await()
val result = e3.findUsers(ids).await()

// restore key
restorePrivateKey(password).await()

// backup private key
backupPrivateKey(password).await()

// reset private key backup
resetPrivateKeyBackup().await()
```
## Download

Add the jitpack maven repository to your top level .gradle file:

```groovy
allprojects {
    repositories {
        ...
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

Now, add the dependeny to your application level .gradle file:
```groovy
dependencies {
    ...
    implementation 'com.sebastianmarschall:e3-ktx:1.0.0'
}
```
