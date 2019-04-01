# Requirements
  ----------------

wget https://services.gradle.org/distributions/gradle-5.0-bin.zip -P /tmp

sudo unzip -d /opt/gradle /tmp/gradle-*.zip

sudo nano /etc/profile.d/gradle.sh

#### add:

```
export GRADLE_HOME=/opt/gradle/gradle-5.0
export PATH=${GRADLE_HOME}/bin:${PATH}
```



# Getting started
  ----------------

gradle idea

gradle build

gradle :appRun

#### debug: 

gradle :appRunDebug
