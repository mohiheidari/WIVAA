#ifndef APP_VULJNI_H
#define APP_VULJNI_H

JNIEXPORT jint JNICALL Java_com_vulnerable_wivaa_VulJni_access(JNIEnv * env,
                                                             jobject jobj,
                                                             jstring key);

JNIEXPORT jint JNICALL Java_com_vulnerable_wivaa_VulJni_initiateLaunchSequence(JNIEnv * env,
                                                                             jobject jobj,
                                                                             jstring jcode);

#endif