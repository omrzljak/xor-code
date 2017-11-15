# xor-code
A simple java class / tool to encode or decode XOR values using '_' key. The same encoding is used by Websphere Application Server
for encoding passwords in config files.
Note : encoding is not encryption, it is a weak encryption algorithm even with longer keys. So this tool can't be used successful 
for securing passwords and other sensible content.

## usage 

### build 
``` mvn clean install```
### run
``` java -cp target/ com.osmanmrzljak.tools.xorcoding.App encode some_secrete```

## Alternative
You can use online tool http://strelitzia.net/wasXORdecoder/wasXORdecoder.html , but be careful posting password online is never safe.