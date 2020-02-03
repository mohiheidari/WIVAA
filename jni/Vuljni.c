
#include <jni.h>
#include <string.h>
#include "Vuljni.h"

#define VENDORKEY   "wivaahardcodepass"
#define CODE        "code"
#define CODESIZEMAX 20

JNIEXPORT jint JNICALL Java_com_vulnerable_wivaa_VulJni_access(JNIEnv * env, jobject jobj, jstring jkey) {

    const char * key = (*env)->GetStringUTFChars(env, jkey, 0);

    return ((strncmp(VENDORKEY, key, strlen(VENDORKEY)))?0:1);
}

JNIEXPORT jint JNICALL Java_com_vulnerable_wivaa_VulJni_initiateLaunchSequence(JNIEnv * env, jobject jobj, jstring jcode) {

    const char * pcode = (*env)->GetStringUTFChars(env, jcode, 0);

    int ret = 0;
    char code[CODESIZEMAX];

    strcpy(code, pcode);

    // Replace the first character, if it is '!' to '.' because the boss said so ;)
    if (code[0] == '!') {
        code[0] = '.';
    }
    ret = strncmp(CODE, code, sizeof(CODE) - 1);
    if (ret == 0) {
        // Correct code entered
        // Launching in T - 10....
        ret = 1;
    }
    else {
        ret = 0;
        // Incorrect code. Access Denied!
    }
    return ret;
}

jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    return JNI_VERSION_1_6;
}
